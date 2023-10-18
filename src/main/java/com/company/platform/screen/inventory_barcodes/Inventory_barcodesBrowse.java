package com.company.platform.screen.inventory_barcodes;

import io.jmix.ui.screen.*;
import com.company.platform.entity.Inventory_barcodes;

@UiController("Inventory_barcodes.browse")
@UiDescriptor("inventory_barcodes-browse.xml")
@LookupComponent("inventory_barcodesesTable")
public class Inventory_barcodesBrowse extends StandardLookup<Inventory_barcodes> {
}