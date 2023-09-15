package com.company.platform.screen.camerainfo;

import io.jmix.ui.screen.*;
import com.company.platform.entity.CameraInfo;

@UiController("CameraInfo.browse")
@UiDescriptor("camera-info-browse.xml")
@LookupComponent("cameraInfoesTable")
public class CameraInfoBrowse extends StandardLookup<CameraInfo> {
}