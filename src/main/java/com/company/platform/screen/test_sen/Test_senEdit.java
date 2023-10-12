package com.company.platform.screen.test_sen;

import io.jmix.ui.screen.*;
import com.company.platform.entity.Test_sen;

@UiController("Test_sen.edit")
@UiDescriptor("test_sen-edit.xml")
@EditedEntityContainer("test_senDc")
public class Test_senEdit extends StandardEditor<Test_sen> {
}