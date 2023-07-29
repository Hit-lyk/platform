package com.company.platform.screen.productdisassemblyprocessdefine;

import io.jmix.ui.screen.*;
import com.company.platform.entity.ProductDisassemblyProcessDefine;

@UiController("ProductDisassemblyProcessDefine.browse")
@UiDescriptor("product-disassembly-process-define-browse.xml")
@LookupComponent("productDisassemblyProcessDefinesTable")
public class ProductDisassemblyProcessDefineBrowse extends StandardLookup<ProductDisassemblyProcessDefine> {
}