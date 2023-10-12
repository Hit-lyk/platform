package com.company.platform.screen.test_sen;

import io.jmix.ui.screen.*;
import com.company.platform.entity.Test_sen;

@UiController("Test_sen.browse")
@UiDescriptor("test_sen-browse.xml")
@LookupComponent("test_sensTable")
public class Test_senBrowse extends StandardLookup<Test_sen> {
}