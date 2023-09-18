package com.company.platform.screen.produceinfo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.company.platform.entity.StationType;
import io.jmix.ui.component.*;
import io.jmix.ui.model.InstanceContainer;
import io.jmix.ui.screen.*;
import com.company.platform.entity.ProduceInfo;
import org.springframework.beans.factory.annotation.Autowired;

@UiController("ProduceInfo.edit")
@UiDescriptor("produce-info-edit.xml")
@EditedEntityContainer("produceInfoDc")
public class ProduceInfoEdit extends StandardEditor<ProduceInfo> {
    @Autowired
    private VBoxLayout feeding;
    @Autowired
    private TextArea operateInfoField;
    @Autowired
    private TextField epsCount;
    @Autowired
    private TextField epsNote;
    @Autowired
    private TextField gobCount;
    @Autowired
    private TextField gobNote;
    @Autowired
    private TextField glassCount;
    @Autowired
    private TextField glassNote;
    @Autowired
    private TextField feedingTonbagCount;
    @Autowired
    private TextField feedingTonbagNote;

    private Integer stationType;
    @Subscribe
    public void onInitEntity(final InitEntityEvent<ProduceInfo> event) {
        ProduceInfo produceInfo = event.getEntity();
        produceInfo.setStation(StationType.上料);
    }

    @Subscribe("stationField")
    public void onStationFieldValueChange(final HasValue.ValueChangeEvent<StationType> event) {
        stationType = event.getValue().getId();

        feeding.setVisible(false);

        switch (event.getValue().getId()){
            case 10:{
                feeding.setVisible(true);
            }break;
            case 20:{

            }break;
        }
    }

    @Subscribe(id = "produceInfoDc", target = Target.DATA_CONTAINER)
    public void onProduceInfoDcItemChange(final InstanceContainer.ItemChangeEvent<ProduceInfo> event) {
        if(event.getItem().getOperateInfo()==null)
            return;

        JSONArray jsonItems = JSON.parseArray(event.getItem().getOperateInfo());
        switch (event.getItem().getStation().getId()){
            case 10:{
                JSONObject jsonEps = (JSONObject)jsonItems.get(0);
                epsCount.setValue(jsonEps.get("count"));
            }break;
        }
    }

    @Subscribe
    public void onBeforeCommitChanges(final BeforeCommitChangesEvent event) {
        JSONArray jsonItems = new JSONArray();
        switch (stationType)
        {
            case 10:{
                JSONObject jsonEps = new JSONObject();
                jsonEps.put("name", "EPS包材");
                jsonEps.put("count", epsCount.getValue());
                jsonEps.put("description", epsNote.getValue());
                jsonItems.add(jsonEps);

                JSONObject jsonGob = new JSONObject();
                jsonGob.put("name", "废杂物");
                jsonGob.put("count", gobCount.getValue());
                jsonGob.put("description", gobNote.getValue());
                jsonItems.add(jsonGob);

                JSONObject jsonGlass = new JSONObject();
                jsonGlass.put("name", "玻璃");
                jsonGlass.put("count", glassCount.getValue());
                jsonGlass.put("description", glassNote.getValue());
                jsonItems.add(jsonGlass);

                JSONObject jsonTonbag = new JSONObject();
                jsonTonbag.put("name", "挂吨包");
                jsonTonbag.put("count", feedingTonbagCount.getValue());
                jsonTonbag.put("description", feedingTonbagNote.getValue());
                jsonItems.add(jsonTonbag);

                operateInfoField.setValue(jsonItems.toJSONString());
            }break;
        }
    }
}