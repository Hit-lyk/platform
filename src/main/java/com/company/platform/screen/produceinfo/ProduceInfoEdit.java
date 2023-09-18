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
    private VBoxLayout preTakeApart1;
    @Autowired
    private VBoxLayout preTakeApart2;
    @Autowired
    private VBoxLayout preTakeApart3;
    @Autowired
    private VBoxLayout preTakeApart4;
    @Autowired
    private VBoxLayout powerLineSorting;
    @Autowired
    private VBoxLayout plasticMetalDischarge;
    @Autowired
    private VBoxLayout foamDischarge;
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
    @Autowired
    private TextField powerlineCount;
    @Autowired
    private TextField powerlineNote;
    @Autowired
    private TextField mpbCount;
    @Autowired
    private TextField mpbNote;
    @Autowired
    private TextField ta1TonbagCount;
    @Autowired
    private TextField ta1TonbagNote;
    @Autowired
    private TextField wheelCount;
    @Autowired
    private TextField wheelNote;
    @Autowired
    private TextField screwCount;
    @Autowired
    private TextField screwNote;
    @Autowired
    private TextField ta2TonbagCount;
    @Autowired
    private TextField ta2TonbagNote;
    @Autowired
    private TextField hcpCount;
    @Autowired
    private TextField hcpNote;
    @Autowired
    private TextField plasticCount;
    @Autowired
    private TextField plasticNote;
    @Autowired
    private TextField ribsCount;
    @Autowired
    private TextField ribsNote;
    @Autowired
    private TextField stripCount;
    @Autowired
    private TextField stripNote;
    @Autowired
    private TextField ta3TonbagCount;
    @Autowired
    private TextField ta3TonbagNote;
    @Autowired
    private TextField compressorCount;
    @Autowired
    private TextField compressorNote;
    @Autowired
    private TextField capacitanceCount;
    @Autowired
    private TextField capacitanceNote;
    @Autowired
    private TextField tubeCount;
    @Autowired
    private TextField tubeNote;
    @Autowired
    private TextField ksdCount;
    @Autowired
    private TextField ksdNote;
    @Autowired
    private TextField circuitCount;
    @Autowired
    private TextField circuitNote;
    @Autowired
    private TextField cpCount;
    @Autowired
    private TextField cpNote;
    @Autowired
    private TextField powerlineSortCount;
    @Autowired
    private TextField powerlineSortNote;
    @Autowired
    private TextField copperCount;
    @Autowired
    private TextField copperNote;
    @Autowired
    private TextField plsTonbagCount;
    @Autowired
    private TextField plsTonbagNote;
    @Autowired
    private TextField ironCount;
    @Autowired
    private TextField ironNote;
    @Autowired
    private TextField crushPlasticCount;
    @Autowired
    private TextField crushPlasticNote;
    @Autowired
    private TextField caccCount;
    @Autowired
    private TextField caccNote;
    @Autowired
    private TextField pmdTonbagCount;
    @Autowired
    private TextField pmdTonbagNote;
    @Autowired
    private TextField foamCount;
    @Autowired
    private TextField foamNote;
    @Autowired
    private TextField frameCount;
    @Autowired
    private TextField frameNote;

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
        preTakeApart1.setVisible(false);
        preTakeApart2.setVisible(false);
        preTakeApart3.setVisible(false);
        preTakeApart4.setVisible(false);
        powerLineSorting.setVisible(false);
        plasticMetalDischarge.setVisible(false);
        foamDischarge.setVisible(false);

        switch (event.getValue().getId()){
            case 10:feeding.setVisible(true);break;
            case 20:preTakeApart1.setVisible(true);break;
            case 30:preTakeApart2.setVisible(true);break;
            case 40:preTakeApart3.setVisible(true);break;
            case 50:preTakeApart4.setVisible(true);break;
            case 60:powerLineSorting.setVisible(true);break;
            case 70:plasticMetalDischarge.setVisible(true);break;
            case 80:foamDischarge.setVisible(true);break;
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
                epsNote.setValue(jsonEps.get("description"));

                JSONObject jsonGob = (JSONObject)jsonItems.get(1);
                gobCount.setValue(jsonGob.get("count"));
                gobNote.setValue(jsonGob.get("description"));

                JSONObject jsonGlass = (JSONObject)jsonItems.get(2);
                glassCount.setValue(jsonGlass.get("count"));
                glassNote.setValue(jsonGlass.get("description"));

                JSONObject jsonTonbag = (JSONObject)jsonItems.get(3);
                feedingTonbagCount.setValue(jsonTonbag.get("count"));
                feedingTonbagNote.setValue(jsonTonbag.get("description"));
            }break;
            case 20:{
                JSONObject jsonPowerLine = (JSONObject)jsonItems.get(0);
                powerlineCount.setValue(jsonPowerLine.get("count"));
                powerlineNote.setValue(jsonPowerLine.get("description"));

                JSONObject jsonMpb = (JSONObject)jsonItems.get(1);
                mpbCount.setValue(jsonMpb.get("count"));
                mpbNote.setValue(jsonMpb.get("description"));

                JSONObject jsonTonbag = (JSONObject)jsonItems.get(2);
                ta1TonbagCount.setValue(jsonTonbag.get("count"));
                ta1TonbagNote.setValue(jsonTonbag.get("description"));
            }break;
            case 30:{
                JSONObject jsonWheel = (JSONObject)jsonItems.get(0);
                wheelCount.setValue(jsonWheel.get("count"));
                wheelNote.setValue(jsonWheel.get("description"));

                JSONObject jsonScrew = (JSONObject)jsonItems.get(1);
                screwCount.setValue(jsonScrew.get("count"));
                screwNote.setValue(jsonScrew.get("description"));

                JSONObject jsonTonbag = (JSONObject)jsonItems.get(2);
                ta2TonbagCount.setValue(jsonTonbag.get("count"));
                ta2TonbagNote.setValue(jsonTonbag.get("description"));
            }break;
            case 40:{
                JSONObject jsonHcp = (JSONObject)jsonItems.get(0);
                hcpCount.setValue(jsonHcp.get("count"));
                hcpNote.setValue(jsonHcp.get("description"));

                JSONObject jsonPlastic = (JSONObject)jsonItems.get(1);
                plasticCount.setValue(jsonPlastic.get("count"));
                plasticNote.setValue(jsonPlastic.get("description"));

                JSONObject jsonRibs = (JSONObject)jsonItems.get(2);
                ribsCount.setValue(jsonRibs.get("count"));
                ribsNote.setValue(jsonRibs.get("description"));

                JSONObject jsonStrip = (JSONObject)jsonItems.get(3);
                stripCount.setValue(jsonStrip.get("count"));
                stripNote.setValue(jsonStrip.get("description"));

                JSONObject jsonTonbag = (JSONObject)jsonItems.get(4);
                ta3TonbagCount.setValue(jsonTonbag.get("count"));
                ta3TonbagNote.setValue(jsonTonbag.get("description"));
            }break;
            case 50:{
                JSONObject jsonCompressor = (JSONObject)jsonItems.get(0);
                compressorCount.setValue(jsonCompressor.get("count"));
                compressorNote.setValue(jsonCompressor.get("description"));

                JSONObject jsonCapacitance = (JSONObject)jsonItems.get(1);
                capacitanceCount.setValue(jsonCapacitance.get("count"));
                capacitanceNote.setValue(jsonCapacitance.get("description"));

                JSONObject jsonTube = (JSONObject)jsonItems.get(2);
                tubeCount.setValue(jsonTube.get("count"));
                tubeNote.setValue(jsonTube.get("description"));

                JSONObject jsonKsd = (JSONObject)jsonItems.get(3);
                ksdCount.setValue(jsonKsd.get("count"));
                ksdNote.setValue(jsonKsd.get("description"));

                JSONObject jsonCircuit = (JSONObject)jsonItems.get(4);
                circuitCount.setValue(jsonCircuit.get("count"));
                circuitNote.setValue(jsonCircuit.get("description"));

                JSONObject jsonCP = (JSONObject)jsonItems.get(5);
                cpCount.setValue(jsonCP.get("count"));
                cpNote.setValue(jsonCP.get("description"));
            }break;
            case 60:{
                JSONObject jsonPowerLine = (JSONObject)jsonItems.get(0);
                powerlineSortCount.setValue(jsonPowerLine.get("count"));
                powerlineSortNote.setValue(jsonPowerLine.get("description"));

                JSONObject jsonCopper = (JSONObject)jsonItems.get(1);
                copperCount.setValue(jsonCopper.get("count"));
                copperNote.setValue(jsonCopper.get("description"));

                JSONObject jsonTonbag = (JSONObject)jsonItems.get(2);
                plsTonbagCount.setValue(jsonTonbag.get("count"));
                plsTonbagNote.setValue(jsonTonbag.get("description"));
            }break;
            case 70:{
                JSONObject jsonIron = (JSONObject)jsonItems.get(0);
                ironCount.setValue(jsonIron.get("count"));
                ironNote.setValue(jsonIron.get("description"));

                JSONObject jsonGob = (JSONObject)jsonItems.get(1);
                crushPlasticCount.setValue(jsonGob.get("count"));
                crushPlasticNote.setValue(jsonGob.get("description"));

                JSONObject jsonCacc = (JSONObject)jsonItems.get(2);
                caccCount.setValue(jsonCacc.get("count"));
                caccNote.setValue(jsonCacc.get("description"));

                JSONObject jsonTonbag = (JSONObject)jsonItems.get(3);
                pmdTonbagCount.setValue(jsonTonbag.get("count"));
                pmdTonbagNote.setValue(jsonTonbag.get("description"));
            }break;
            case 80:{
                JSONObject jsonFoam = (JSONObject)jsonItems.get(0);
                foamCount.setValue(jsonFoam.get("count"));
                foamNote.setValue(jsonFoam.get("description"));

                JSONObject jsonFrame = (JSONObject)jsonItems.get(1);
                frameCount.setValue(jsonFrame.get("count"));
                frameNote.setValue(jsonFrame.get("description"));
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
            case 20:{
                JSONObject jsonPowerLine = new JSONObject();
                jsonPowerLine.put("name", "电源线");
                jsonPowerLine.put("count", powerlineCount.getValue());
                jsonPowerLine.put("description", powerlineNote.getValue());
                jsonItems.add(jsonPowerLine);

                JSONObject jsonMpb = new JSONObject();
                jsonMpb.put("name", "废杂料（防潮板）");
                jsonMpb.put("count", mpbCount.getValue());
                jsonMpb.put("description", mpbNote.getValue());
                jsonItems.add(jsonMpb);

                JSONObject jsonTonbag = new JSONObject();
                jsonTonbag.put("name", "挂吨包");
                jsonTonbag.put("count", ta1TonbagCount.getValue());
                jsonTonbag.put("description", ta1TonbagNote.getValue());
                jsonItems.add(jsonTonbag);

                operateInfoField.setValue(jsonItems.toJSONString());
            }break;
            case 30:{
                JSONObject jsonWheel = new JSONObject();
                jsonWheel.put("name", "杂铁（车轱辘）");
                jsonWheel.put("count", wheelCount.getValue());
                jsonWheel.put("description", wheelNote.getValue());
                jsonItems.add(jsonWheel);

                JSONObject jsonScrewb = new JSONObject();
                jsonScrewb.put("name", "杂铁（螺丝）");
                jsonScrewb.put("count", screwCount.getValue());
                jsonScrewb.put("description", screwNote.getValue());
                jsonItems.add(jsonScrewb);

                JSONObject jsonTonbag = new JSONObject();
                jsonTonbag.put("name", "挂吨包");
                jsonTonbag.put("count", ta2TonbagCount.getValue());
                jsonTonbag.put("description", ta2TonbagNote.getValue());
                jsonItems.add(jsonTonbag);

                operateInfoField.setValue(jsonItems.toJSONString());
            }break;
            case 40:{
                JSONObject jsonHcp = new JSONObject();
                jsonHcp.put("name", "铰链盖板");
                jsonHcp.put("count", hcpCount.getValue());
                jsonHcp.put("description", hcpNote.getValue());
                jsonItems.add(jsonHcp);

                JSONObject jsonPlastic = new JSONObject();
                jsonPlastic.put("name", "塑料外壳");
                jsonPlastic.put("count", plasticCount.getValue());
                jsonPlastic.put("description", plasticNote.getValue());
                jsonItems.add(jsonPlastic);

                JSONObject jsonRibs = new JSONObject();
                jsonRibs.put("name", "杂铁（加强筋）");
                jsonRibs.put("count", ribsCount.getValue());
                jsonRibs.put("description", ribsNote.getValue());
                jsonItems.add(jsonRibs);

                JSONObject jsonStrip = new JSONObject();
                jsonStrip.put("name", "密封条");
                jsonStrip.put("count", stripCount.getValue());
                jsonStrip.put("description", stripNote.getValue());
                jsonItems.add(jsonStrip);

                JSONObject jsonTonbag = new JSONObject();
                jsonTonbag.put("name", "挂吨包");
                jsonTonbag.put("count", ta3TonbagCount.getValue());
                jsonTonbag.put("description", ta3TonbagNote.getValue());
                jsonItems.add(jsonTonbag);

                operateInfoField.setValue(jsonItems.toJSONString());
            }break;
            case 50:{
                JSONObject jsonCompressor = new JSONObject();
                jsonCompressor.put("name", "压缩机");
                jsonCompressor.put("count", compressorCount.getValue());
                jsonCompressor.put("description", compressorNote.getValue());
                jsonItems.add(jsonCompressor);

                JSONObject jsonCapacitance = new JSONObject();
                jsonCapacitance.put("name", "电容");
                jsonCapacitance.put("count", capacitanceCount.getValue());
                jsonCapacitance.put("description", capacitanceNote.getValue());
                jsonItems.add(jsonCapacitance);

                JSONObject jsonTube = new JSONObject();
                jsonTube.put("name", "铜管");
                jsonTube.put("count", tubeCount.getValue());
                jsonTube.put("description", tubeNote.getValue());
                jsonItems.add(jsonTube);

                JSONObject jsonKsd = new JSONObject();
                jsonKsd.put("name", "温控器");
                jsonKsd.put("count", ksdCount.getValue());
                jsonKsd.put("description", ksdNote.getValue());
                jsonItems.add(jsonKsd);

                JSONObject jsonCircuit = new JSONObject();
                jsonCircuit.put("name", "电路板");
                jsonCircuit.put("count", circuitCount.getValue());
                jsonCircuit.put("description", circuitNote.getValue());
                jsonItems.add(jsonCircuit);

                JSONObject jsonCP = new JSONObject();
                jsonCP.put("name", "压缩机摆放");
                jsonCP.put("count", cpCount.getValue());
                jsonCP.put("description", cpNote.getValue());
                jsonItems.add(jsonCircuit);

                operateInfoField.setValue(jsonItems.toJSONString());
            }break;
            case 60:{
                JSONObject jsonPowerLine = new JSONObject();
                jsonPowerLine.put("name", "电源线");
                jsonPowerLine.put("count", powerlineSortCount.getValue());
                jsonPowerLine.put("description", powerlineSortNote.getValue());
                jsonItems.add(jsonPowerLine);

                JSONObject jsonCopper = new JSONObject();
                jsonCopper.put("name", "铜");
                jsonCopper.put("count", copperCount.getValue());
                jsonCopper.put("description", copperNote.getValue());
                jsonItems.add(jsonCopper);

                JSONObject jsonTonbag = new JSONObject();
                jsonTonbag.put("name", "挂吨包");
                jsonTonbag.put("count", plsTonbagCount.getValue());
                jsonTonbag.put("description", plsTonbagNote.getValue());
                jsonItems.add(jsonTonbag);

                operateInfoField.setValue(jsonItems.toJSONString());
            }break;
            case 70:{
                JSONObject jsonIron = new JSONObject();
                jsonIron.put("name", "破碎铁");
                jsonIron.put("count", ironCount.getValue());
                jsonIron.put("description", ironNote.getValue());
                jsonItems.add(jsonIron);

                JSONObject jsonCrushPlastic = new JSONObject();
                jsonCrushPlastic.put("name", "破碎塑料");
                jsonCrushPlastic.put("count", crushPlasticCount.getValue());
                jsonCrushPlastic.put("description", crushPlasticNote.getValue());
                jsonItems.add(jsonCrushPlastic);

                JSONObject jsonCacc = new JSONObject();
                jsonCacc.put("name", "破碎铝（含铜）");
                jsonCacc.put("count", caccCount.getValue());
                jsonCacc.put("description", caccNote.getValue());
                jsonItems.add(jsonCacc);

                JSONObject jsonTonbag = new JSONObject();
                jsonTonbag.put("name", "挂吨包");
                jsonTonbag.put("count", pmdTonbagCount.getValue());
                jsonTonbag.put("description", pmdTonbagNote.getValue());
                jsonItems.add(jsonTonbag);

                operateInfoField.setValue(jsonItems.toJSONString());
            }break;
            case 80:{
                JSONObject jsonFoam = new JSONObject();
                jsonFoam.put("name", "泡棉");
                jsonFoam.put("count", foamCount.getValue());
                jsonFoam.put("description", foamNote.getValue());
                jsonItems.add(jsonFoam);

                JSONObject jsonFrame = new JSONObject();
                jsonFrame.put("name", "废杂物");
                jsonFrame.put("count", frameCount.getValue());
                jsonFrame.put("description", frameNote.getValue());
                jsonItems.add(jsonFrame);

                operateInfoField.setValue(jsonItems.toJSONString());
            }break;
        }
    }
}