package com.company.platform.screen.test_sen;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import io.jmix.core.DataManager;
import io.jmix.ui.component.FileStorageUploadField;
import io.jmix.ui.component.LayoutClickNotifier;
import io.jmix.ui.component.SingleFileUploadField;
import io.jmix.ui.screen.*;
import com.company.platform.entity.Test_sen;
import io.jmix.ui.upload.TemporaryStorage;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.util.UUID;


@UiController("Test_sen.browse")
@UiDescriptor("test_sen-browse.xml")
@LookupComponent("test_sensTable")
public class Test_senBrowse extends StandardLookup<Test_sen> {
    @Autowired
    private FileStorageUploadField uploadTest;
    @Autowired
    private TemporaryStorage temporaryStorage;
    @Autowired
    private DataManager dataManager;
    @Subscribe("uploadTest")
    public void onUploadTestFileUploadSucceed(final SingleFileUploadField.FileUploadSucceedEvent event) {
        UUID id = uploadTest.getFileId();
        File file = temporaryStorage.getFile(uploadTest.getFileId());

        try {
            InputStream inputStream = new FileInputStream(file);
            Workbook workBook = new XSSFWorkbook(inputStream);
            Sheet sheet0 = workBook.getSheetAt(0);

            int rownum = sheet0.getPhysicalNumberOfRows();
            for(int i=1; i<rownum; i++)//第一行为标题
            {
                Row row = sheet0.getRow(i);

//                Cell cell = row.getCell(0);
                Test_sen testEnity = new Test_sen();
                DataFormatter formatter = new DataFormatter();

                Cell cellSn = row.getCell(1);
                Cell cellHumidity = row.getCell(4);
                Cell cellTemp = row.getCell(3);
                Cell cellRecord_time = row.getCell(2);
                String cellStrSn = formatter.formatCellValue(cellSn);
                String cellStrRT = formatter.formatCellValue(cellRecord_time);
                testEnity.setId(UUID.randomUUID().toString());
                testEnity.setHumidity((float)cellHumidity.getNumericCellValue());
                testEnity.setSn(cellStrSn);
                testEnity.setTemp((float)cellTemp.getNumericCellValue());
                testEnity.setRecord_time(cellStrRT);
                dataManager.save(testEnity);
//
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public Object getCellFormatValue(Cell cell){
        Object cellValue = null;
        if(cell!=null){
            //判断cell类型
            switch(cell.getCellType()){
                case NUMERIC:{
                    Object inputValue = null;// 单元格值
                    Long longVal = Math.round(cell.getNumericCellValue());
                    Double doubleVal = cell.getNumericCellValue();
                    if(Double.parseDouble(longVal + ".0") == doubleVal){   //判断是否含有小数位.0
                        inputValue = longVal;
                    }
                    else{
                        inputValue = doubleVal;
                    }
                    DecimalFormat df = new DecimalFormat("#.####");    //格式化为四位小数，按自己需求选择；
                    cellValue= String.valueOf(df.format(inputValue));      //返回String类型
                    break;
                }
                case FORMULA:{
                    //判断cell是否为日期格式
                    if(DateUtil.isCellDateFormatted(cell)){
                        //转换为日期格式YYYY-mm-dd
                        cellValue = cell.getDateCellValue();
                    }else{
                        //数字
                        cellValue = String.valueOf(cell.getNumericCellValue());
                    }
                    break;
                }
                case STRING:{
                    cellValue = cell.getRichStringCellValue().getString();
                    break;
                }
                default:
                    cellValue = "";
            }
        }else{
            cellValue = "";
        }
        return cellValue;
    }
}
