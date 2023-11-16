package com.company.platform.screen.disassemble_transfer_details;

import com.company.platform.entity.Bom_Emr_120d;
import io.jmix.core.DataManager;
import io.jmix.ui.component.FileStorageUploadField;
import io.jmix.ui.component.SingleFileUploadField;
import io.jmix.ui.screen.*;
import com.company.platform.entity.Disassemble_transfer_details;
import io.jmix.ui.upload.TemporaryStorage;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.UUID;

@UiController("Disassemble_transfer_details.browse")
@UiDescriptor("disassemble_transfer_details-browse.xml")
@LookupComponent("disassemble_transfer_detailsesTable")
public class Disassemble_transfer_detailsBrowse extends StandardLookup<Disassemble_transfer_details> {
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
                Disassemble_transfer_details tabelEnity = new Disassemble_transfer_details();
                DataFormatter formatter = new DataFormatter();

                Cell cell_factory = row.getCell(0);
                cell_factory.setCellType(CellType.STRING);
                Cell cell_outbound = row.getCell(1);
                cell_outbound.setCellType(CellType.STRING);
                Cell cell_barcodes = row.getCell(2);
                cell_barcodes.setCellType(CellType.STRING);
                Cell cell_weight = row.getCell(3);
//                String cellStr_cell_weight= formatter.formatCellValue(cell_weight);
                Cell cell_scan_time = row.getCell(4);
                String cellStr_scan_time = formatter.formatCellValue(cell_scan_time);
                Cell cell_product_type = row.getCell(5);
                String cellStr_product = formatter.formatCellValue(cell_product_type);
                Cell cell_product_model = row.getCell(6);
                cell_product_model.setCellType(CellType.STRING);
                Cell cell_product_description = row.getCell(7);
                String cellStr_product_description = formatter.formatCellValue(cell_product_description);
                Cell cell_ware_house = row.getCell(8);
                String cellStr_ware_house = formatter.formatCellValue(cell_ware_house);
                Cell cell_reservoir_area = row.getCell(9);
                String cellStr_reservoir_area = formatter.formatCellValue(cell_reservoir_area);
                Cell cell_bin_location = row.getCell(10);
                String cellStr_bin_location= formatter.formatCellValue(cell_bin_location);
                Cell cell_product_state = row.getCell(11);
                String cellStr_product_state= formatter.formatCellValue(cell_product_state);
                Cell cell_bill_number = row.getCell(12);
                String cellStr_bill_number= formatter.formatCellValue(cell_bill_number);
                Cell cell_delivery_note = row.getCell(13);
                String cellStr_delivery_note= formatter.formatCellValue(cell_delivery_note);
                Cell cell_order_line_items= row.getCell(14);
                String cellStr_order_line_items= formatter.formatCellValue(cell_order_line_items);
                Cell cell_scanner= row.getCell(15);
                String cellStr_scanner = formatter.formatCellValue(cell_scanner);


                tabelEnity.setId(UUID.randomUUID().toString());
                tabelEnity.setFactory(String.valueOf(cell_factory));
                tabelEnity.setOutbound_tracking_number(String.valueOf(cell_outbound));
                tabelEnity.setFinished_barcodes(String.valueOf(cell_barcodes));
                tabelEnity.setWeight(String.valueOf((float)cell_weight.getNumericCellValue()));
                tabelEnity.setScan_time(cellStr_scan_time);
                tabelEnity.setProduct_type(cellStr_product);
                tabelEnity.setProduct_model(String.valueOf(cell_product_model));
                tabelEnity.setProduct_description(String.valueOf(cellStr_product_description));
                tabelEnity.setWare_house(String.valueOf(cellStr_ware_house));
                tabelEnity.setReservoir_area(String.valueOf(cellStr_reservoir_area));
                tabelEnity.setBin_location(String.valueOf(cellStr_bin_location));
                tabelEnity.setProduct_state(String.valueOf(cellStr_product_state));
                tabelEnity.setBill_number(String.valueOf(cellStr_bill_number));
                tabelEnity.setDelivery_note(String.valueOf(cellStr_delivery_note));
                tabelEnity.setOrder_line_items(String.valueOf(cellStr_order_line_items));
                tabelEnity.setScanner(String.valueOf(cellStr_scanner));


                dataManager.save(tabelEnity);
//
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

}