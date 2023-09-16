package com.company.platform.screen.produceinfo;

import io.jmix.ui.screen.*;
import com.company.platform.entity.ProduceInfo;

@UiController("ProduceInfo.edit")
@UiDescriptor("produce-info-edit.xml")
@EditedEntityContainer("produceInfoDc")
public class ProduceInfoEdit extends StandardEditor<ProduceInfo> {
}