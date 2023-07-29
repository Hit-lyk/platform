package com.company.platform.screen.gf_pobmain;

import io.jmix.ui.screen.*;
import com.company.platform.entity.GF_POBMain;

@UiController("GF_POBMain.browse")
@UiDescriptor("gf_pob-main-browse.xml")
@LookupComponent("gF_POBMainsTable")
public class GF_POBMainBrowse extends StandardLookup<GF_POBMain> {
}