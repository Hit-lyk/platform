package com.company.platform.screen.workguidinfo;

import io.jmix.ui.screen.*;
import com.company.platform.entity.WorkGuidInfo;

@UiController("WorkGuidInfo.browse")
@UiDescriptor("work-guid-info-browse.xml")
@LookupComponent("workGuidInfoesTable")
public class WorkGuidInfoBrowse extends StandardLookup<WorkGuidInfo> {
}