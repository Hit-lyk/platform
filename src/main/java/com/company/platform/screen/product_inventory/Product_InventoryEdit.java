package com.company.platform.screen.product_inventory;

import io.jmix.ui.screen.*;
import com.company.platform.entity.Product_Inventory;

@UiController("Product_Inventory.edit")
@UiDescriptor("product_inventory-edit.xml")
@EditedEntityContainer("product_InventoryDc")
public class Product_InventoryEdit extends StandardEditor<Product_Inventory> {
}