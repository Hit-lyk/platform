package com.company.platform.screen.product_inventory;

import io.jmix.ui.screen.*;
import com.company.platform.entity.Product_Inventory;

@UiController("Product_Inventory.browse")
@UiDescriptor("product_inventory-browse.xml")
@LookupComponent("product_InventoriesTable")
public class Product_InventoryBrowse extends StandardLookup<Product_Inventory> {
}