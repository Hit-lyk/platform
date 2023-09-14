package com.company.platform.screen.workguidinfo;

import io.jmix.ui.screen.*;
import com.company.platform.entity.WorkGuidInfo;

@UiController("WorkGuidInfo.edit")
@UiDescriptor("work-guid-info-edit.xml")
@EditedEntityContainer("workGuidInfoDc")
public class WorkGuidInfoEdit extends StandardEditor<WorkGuidInfo> {
}