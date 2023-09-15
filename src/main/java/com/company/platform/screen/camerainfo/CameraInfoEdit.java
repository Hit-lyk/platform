package com.company.platform.screen.camerainfo;

import io.jmix.ui.screen.*;
import com.company.platform.entity.CameraInfo;

@UiController("CameraInfo.edit")
@UiDescriptor("camera-info-edit.xml")
@EditedEntityContainer("cameraInfoDc")
public class CameraInfoEdit extends StandardEditor<CameraInfo> {
}