package com.company.platform.screen.inventory_barcodes;

import com.company.platform.entity.Disassemble_transfer_details;
import io.jmix.core.DataManager;
import io.jmix.ui.component.FileStorageUploadField;
import io.jmix.ui.component.SingleFileUploadField;
import io.jmix.ui.screen.*;
import com.company.platform.entity.Inventory_barcodes;
import io.jmix.ui.upload.TemporaryStorage;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

@UiController("Inventory_barcodes.browse")
@UiDescriptor("inventory_barcodes-browse.xml")
@LookupComponent("inventory_barcodesesTable")
public class Inventory_barcodesBrowse extends StandardLookup<Inventory_barcodes> {
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
                Inventory_barcodes tabelEnity = new Inventory_barcodes();
                DataFormatter formatter = new DataFormatter();

                Cell cell_model = row.getCell(0);
                cell_model.setCellType(CellType.STRING);
                Cell cell_good_description = row.getCell(1);
                String cellStr_good_description = formatter.formatCellValue(cell_good_description);
                Cell cell_reservoir_area = row.getCell(2);
                String cellStr_reservoir_area = formatter.formatCellValue(cell_reservoir_area);
                Cell cell_shelf_code = row.getCell(3);
                String cellStr_shelf_code = formatter.formatCellValue(cell_shelf_code);
                Cell cell_bin_location = row.getCell(4);
                cell_bin_location.setCellType(CellType.STRING);
                Cell cell_barcode_number = row.getCell(5);
                cell_barcode_number.setCellType(CellType.STRING);
                Cell cell_barcode_number1 = row.getCell(6);
                cell_barcode_number1.setCellType(CellType.STRING);

                Cell cell_inventory_age = row.getCell(7);
                cell_inventory_age.setCellType(CellType.STRING);
                Cell cell_inventory_age_start = row.getCell(8);
                cell_inventory_age_start.setCellType(CellType.STRING);
                Cell cell_quantity = row.getCell(9);
                cell_quantity.setCellType(CellType.STRING);
                Cell cell_weight = row.getCell(10);
                cell_weight.setCellType(CellType.STRING);

                Cell cell_unit = row.getCell(11);
                String cellStr_unit = formatter.formatCellValue(cell_unit);
                Cell cell_offline_time = row.getCell(12);
                String cellStr_offline_time = formatter.formatCellValue(cell_offline_time);
                Cell cell_inbound_time = row.getCell(13);
                String cellStr_inbound_time = formatter.formatCellValue(cell_inbound_time);
                Cell cell_frozen_state = row.getCell(14);
                String cellStr_frozen_state = formatter.formatCellValue(cell_frozen_state);
                Cell cell_occ_track_num = row.getCell(15);
                String cellStr_occ_track_num = formatter.formatCellValue(cell_occ_track_num);
                Cell cell_scan_state = row.getCell(16);
                String cellStr_scan_state = formatter.formatCellValue(cell_scan_state);

                Cell cell_product_order_num = row.getCell(17);
                cell_product_order_num.setCellType(CellType.STRING);
                Cell cell_product_line = row.getCell(18);
                String cellStr_product_line = formatter.formatCellValue(cell_product_line);
                Cell cell_factory = row.getCell(19);
                cell_factory.setCellType(CellType.STRING);
                Cell cell_warehouse = row.getCell(20);
                String cellStr_warehouse = formatter.formatCellValue(cell_warehouse);
                Cell cell_batch_num = row.getCell(21);
                cell_batch_num.setCellType(CellType.STRING);
                Cell cell_product_num = row.getCell(22);
                cell_product_num.setCellType(CellType.STRING);

                Cell cell_location_usage = row.getCell(23);
                String cellStr_location_usage = formatter.formatCellValue(cell_location_usage);
                Cell cell_create = row.getCell(24);
                String cellStr_create = formatter.formatCellValue(cell_create);
                Cell cell_creation_time = row.getCell(25);
                String cellStr_creation_time = formatter.formatCellValue(cell_creation_time);


                tabelEnity.setId(UUID.randomUUID().toString());
                tabelEnity.setModel(String.valueOf(cell_model));
                tabelEnity.setGood_description(String.valueOf(cellStr_good_description));
                tabelEnity.setReservoir_area(String.valueOf(cellStr_reservoir_area));
                tabelEnity.setShelf_code(String.valueOf(cellStr_shelf_code));
                tabelEnity.setBin_location(String.valueOf(cell_bin_location));
                tabelEnity.setBarcode_number(String.valueOf(cell_barcode_number));
                tabelEnity.setBarcode_number1(String.valueOf(cell_barcode_number1));

                tabelEnity.setInventory_age(String.valueOf(cell_inventory_age));
                tabelEnity.setInventory_age_start(String.valueOf(cell_inventory_age_start));
                tabelEnity.setQuantity(String.valueOf(cell_quantity));
                tabelEnity.setWeight(String.valueOf(cell_weight));
                tabelEnity.setUnit(String.valueOf(cellStr_unit));
                tabelEnity.setOffline_time(String.valueOf(cellStr_offline_time));
                tabelEnity.setInbound_time(String.valueOf(cellStr_inbound_time));
                tabelEnity.setFrozen_state(String.valueOf(cellStr_frozen_state));
                tabelEnity.setOcc_track_num(String.valueOf(cellStr_occ_track_num));

                tabelEnity.setScan_state(String.valueOf(cellStr_scan_state));
                tabelEnity.setProduct_num(String.valueOf(cell_product_order_num));
                tabelEnity.setProduct_line(String.valueOf(cellStr_product_line));
                tabelEnity.setFactory(String.valueOf(cell_factory));
                tabelEnity.setWarehouse(String.valueOf(cellStr_warehouse));
                tabelEnity.setBatch_num(String.valueOf(cell_batch_num));

                tabelEnity.setFactory(String.valueOf(cell_product_num));
                tabelEnity.setFactory(String.valueOf(cellStr_location_usage));
                tabelEnity.setFactory(String.valueOf(cellStr_create));
                tabelEnity.setFactory(String.valueOf(cellStr_creation_time));

                dataManager.save(tabelEnity);
//
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

}