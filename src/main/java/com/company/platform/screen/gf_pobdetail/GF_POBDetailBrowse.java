package com.company.platform.screen.gf_pobdetail;

import io.jmix.ui.screen.*;
import com.company.platform.entity.GF_POBDetail;

@UiController("GF_POBDetail.browse")
@UiDescriptor("gf_pob-detail-browse.xml")
@LookupComponent("gF_POBDetailsTable")
public class GF_POBDetailBrowse extends StandardLookup<GF_POBDetail> {
}