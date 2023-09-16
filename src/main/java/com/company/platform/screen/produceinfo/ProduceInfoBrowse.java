package com.company.platform.screen.produceinfo;

import io.jmix.ui.screen.*;
import com.company.platform.entity.ProduceInfo;

@UiController("ProduceInfo.browse")
@UiDescriptor("produce-info-browse.xml")
@LookupComponent("produceInfoesTable")
public class ProduceInfoBrowse extends StandardLookup<ProduceInfo> {
}