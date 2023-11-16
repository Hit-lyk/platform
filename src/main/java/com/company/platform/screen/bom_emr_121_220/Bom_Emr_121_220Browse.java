package com.company.platform.screen.bom_emr_121_220;

import com.company.platform.entity.Bom_Emr_120d;
import io.jmix.core.DataManager;
import io.jmix.ui.component.FileStorageUploadField;
import io.jmix.ui.component.SingleFileUploadField;
import io.jmix.ui.screen.*;
import com.company.platform.entity.Bom_Emr_121_220;
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

@UiController("Bom_Emr_121_220.browse")
@UiDescriptor("bom_emr_121_220-browse.xml")
@LookupComponent("bom_Emr_121_220sTable")
public class Bom_Emr_121_220Browse extends StandardLookup<Bom_Emr_121_220> {
    @Autowired
    private FileStorageUploadField upload_Test;
    @Autowired
    private TemporaryStorage temporaryStorage;
    @Autowired
    private DataManager dataManager;
    @Subscribe("upload_Test")
    public void onUploadTestFileUploadSucceed(final SingleFileUploadField.FileUploadSucceedEvent event) {
        UUID id = upload_Test.getFileId();
        File file = temporaryStorage.getFile(upload_Test.getFileId());

        try {
            InputStream inputStream = new FileInputStream(file);
            Workbook workBook = new XSSFWorkbook(inputStream);
            Sheet sheet0 = workBook.getSheetAt(0);

            int rownum = sheet0.getPhysicalNumberOfRows();
            for(int i=1; i<rownum; i++)//第一行为标题
            {
                Row row = sheet0.getRow(i);

//                Cell cell = row.getCell(0);
                Bom_Emr_121_220 tabelEnity = new Bom_Emr_121_220();
                DataFormatter formatter = new DataFormatter();

                Cell cell_material_code = row.getCell(0);
                cell_material_code.setCellType(CellType.STRING);
                Cell cell_item_name = row.getCell(1);
                Cell cell_bom_component = row.getCell(2);
                cell_bom_component.setCellType(CellType.STRING);
                Cell cell_component_desc = row.getCell(3);
                Cell cell_component_cons_quant = row.getCell(4);
                Cell cell_unit = row.getCell(5);
                Cell cell_component_price = row.getCell(6);
                Cell cell_amount_of_money = row.getCell(7);
                Cell cell_proportion = row.getCell(8);

//                String cellStr_m_code = formatter.formatCellValue(cell_material_code);
                String cellStr_cell_item_name = formatter.formatCellValue(cell_item_name);
//                String cellStr_bom_component = formatter.formatCellValue(cell_bom_component);
                String cellStr_component_desc = formatter.formatCellValue(cell_component_desc);
                String cellStr_unit = formatter.formatCellValue(cell_unit);

                tabelEnity.setId(UUID.randomUUID().toString());
                tabelEnity.setMaterial_code(String.valueOf(cell_material_code));
                tabelEnity.setItem_name(cellStr_cell_item_name);
                tabelEnity.setBom_component(String.valueOf(cell_bom_component));
                tabelEnity.setComponent_desc(cellStr_component_desc);
                tabelEnity.setComponent_cons_quant(String.valueOf((float)cell_component_cons_quant.getNumericCellValue()));
                tabelEnity.setUnit(cellStr_unit);
                tabelEnity.setComponent_price(String.valueOf((float)cell_component_price.getNumericCellValue()));
                tabelEnity.setAmount_of_money(String.valueOf((float)cell_amount_of_money.getNumericCellValue()));
                tabelEnity.setProportion(String.valueOf((float)cell_proportion.getNumericCellValue()));

                dataManager.save(tabelEnity);
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