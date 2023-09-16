package com.company.platform.screen.sensorinfo;

import io.jmix.ui.screen.*;
import com.company.platform.entity.SensorInfo;

@UiController("SensorInfo.browse")
@UiDescriptor("sensor-info-browse.xml")
@LookupComponent("sensorInfoesTable")
public class SensorInfoBrowse extends StandardLookup<SensorInfo> {
}