package com.company.platform.screen.product_inventory;

import com.company.platform.entity.Inventory_barcodes;
import io.jmix.core.DataManager;
import io.jmix.ui.component.FileStorageUploadField;
import io.jmix.ui.component.SingleFileUploadField;
import io.jmix.ui.screen.*;
import com.company.platform.entity.Product_Inventory;
import io.jmix.ui.upload.TemporaryStorage;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

@UiController("Product_Inventory.edit")
@UiDescriptor("product_inventory-edit.xml")
@EditedEntityContainer("product_InventoryDc")
public class Product_InventoryEdit extends StandardEditor<Product_Inventory> {
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
                Product_Inventory tabelEnity = new Product_Inventory();
                DataFormatter formatter = new DataFormatter();

                Cell item_code = row.getCell(0);
                item_code.setCellType(CellType.STRING);
                Cell cell_item_name = row.getCell(1);
                String cellStr_item_name = formatter.formatCellValue(cell_item_name);
                Cell cell_warehouse = row.getCell(2);
                String cellStr_warehouse = formatter.formatCellValue(cell_warehouse);
                Cell cell_reservoir_area = row.getCell(3);
                String cellStr_reservoir_area = formatter.formatCellValue(cell_reservoir_area);
                Cell cell_shelf_code = row.getCell(4);
                String cellStr_shelf_code = formatter.formatCellValue(cell_shelf_code);

                Cell cell_bin_locaton = row.getCell(5);
                cell_bin_locaton.setCellType(CellType.STRING);
                Cell cell_quantity = row.getCell(6);
                cell_quantity.setCellType(CellType.STRING);
                Cell cell_unit= row.getCell(7);
                String cellStr_unit = formatter.formatCellValue(cell_unit);
                Cell cell_factory = row.getCell(8);
                cell_factory.setCellType(CellType.STRING);


                tabelEnity.setId(UUID.randomUUID().toString());
                tabelEnity.setItem_code(String.valueOf(item_code));
                tabelEnity.setItem_name(String.valueOf(cellStr_item_name));
                tabelEnity.setWarehouse(String.valueOf(cellStr_warehouse));
                tabelEnity.setReservoir_area(String.valueOf(cellStr_reservoir_area));
                tabelEnity.setShelf_code(String.valueOf(cellStr_shelf_code));
                tabelEnity.setBin_locaton(String.valueOf(cell_bin_locaton));
                tabelEnity.setQuantity(String.valueOf(cell_quantity));

                tabelEnity.setWeight(String.valueOf(cellStr_unit));
                tabelEnity.setFactory(String.valueOf(cell_factory));


                dataManager.save(tabelEnity);
//
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}