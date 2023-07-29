package com.company.platform.screen.productdisassemblyprocessdefine;

import io.jmix.ui.screen.*;
import com.company.platform.entity.ProductDisassemblyProcessDefine;

@UiController("ProductDisassemblyProcessDefine.edit")
@UiDescriptor("product-disassembly-process-define-edit.xml")
@EditedEntityContainer("productDisassemblyProcessDefineDc")
public class ProductDisassemblyProcessDefineEdit extends StandardEditor<ProductDisassemblyProcessDefine> {
}