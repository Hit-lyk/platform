package com.company.platform.screen.inventory_barcodes;

import io.jmix.ui.screen.*;
import com.company.platform.entity.Inventory_barcodes;

@UiController("Inventory_barcodes.edit")
@UiDescriptor("inventory_barcodes-edit.xml")
@EditedEntityContainer("inventory_barcodesDc")
public class Inventory_barcodesEdit extends StandardEditor<Inventory_barcodes> {
}