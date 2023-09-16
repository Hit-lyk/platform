package com.company.platform.screen.sensorinfo;

import io.jmix.ui.screen.*;
import com.company.platform.entity.SensorInfo;

@UiController("SensorInfo.edit")
@UiDescriptor("sensor-info-edit.xml")
@EditedEntityContainer("sensorInfoDc")
public class SensorInfoEdit extends StandardEditor<SensorInfo> {
}