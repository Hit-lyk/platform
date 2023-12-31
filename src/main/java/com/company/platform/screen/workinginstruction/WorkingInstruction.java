package com.company.platform.screen.workinginstruction;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.company.platform.entity.ProduceInfo;
import com.company.platform.entity.StationType;
import com.company.platform.entity.WorkGuidInfo;
import com.company.platform.entity.Workstation_tables;
import com.company.platform.state.GraphState;
import io.jmix.core.DataManager;
import io.jmix.ui.component.ComboBox;
import io.jmix.ui.component.HasValue;
import io.jmix.ui.component.Label;
import io.jmix.ui.screen.*;
import io.jmix.ui.widget.JmixComboBox;
import liquibase.pro.packaged.I;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.*;

@UiController("WorkingInstruction")
@UiDescriptor("working-instruction.xml")
public class WorkingInstruction extends Screen {
    @Autowired
    private Label typeContent;
    @Autowired
    private Label contentSGAQXZ;
    @Autowired
    private Label contentBQZB;
    @Autowired
    private Label contentBHSX;
    @Autowired
    private Label contentCZGBJBZ;
    @Autowired
    private Label contentLQSCWT;
    @Autowired
    private Label contentCLHG;
    @Autowired
    private Label contentGZQJ;
    @Autowired
    private Label contentFNO;
    @Autowired
    private Label product_category;
    @Autowired
    private Label current_station;
    @Autowired
    private Label up_station;
    @Autowired
    private Label down_station;

    @Autowired
    private DataManager dataManager;
    @Autowired
    private ComboBox<Integer> comboFileNo2;
    @Autowired
    private ComboBox<Integer> comboFileNo1;


    private List<Workstation_tables> listInfo1;
    private List<WorkGuidInfo> listInfo;
//    private List<WorkGuid_station> listInfo2;
private Integer comIndex;
    Map<String, Integer> itemList = new LinkedHashMap<String, Integer>();

    @Subscribe
    protected void onInit(InitEvent event) {
        listInfo1 = dataManager.load(Workstation_tables.class).all().list();
        for(int i=0; i<listInfo1.size(); i++){
            Workstation_tables infoWorkstation = listInfo1.get(i);
            itemList.put(infoWorkstation.getElectrical_appliances()+"--"+infoWorkstation.getAppliance_model(), i);
        }
        comboFileNo1.setOptionsMap(itemList);
//        listInfo = dataManager.load(WorkGuidInfo.class).all().list();
//        for(int i=0; i<listInfo.size(); i++){
//            WorkGuidInfo infoWorkGuid = listInfo.get(i);
//            itemList.put(infoWorkGuid.getFileNo(), i);
//        }

//        comboFileNo1.setOptionsMap(itemList);

        typeContent.setValue("\u2002\u2002\u2002EMR冰柜\n（不含氟利昂）");
        contentSGAQXZ.setValue("1.戴好防护用具（安全帽，口罩，胶皮手套，护目镜，耳塞，三防鞋，围裙，套袖）\n2.检查安全通道是否畅通，是否有应急措施和物品。");
        contentBQZB.setValue("机：检查设备是否完好\n" +
                "料：将吨包支架放到定置区内，吨包四角挂在吨包支架皮带钩上，吨包底部铺平，保证吨包在支架中成长方体。\n" +
                "环：区域内整洁，无外来人员，物料不遮挡摄像头。");
        contentBHSX.setValue("整理：保持本岗位及周边地面干净，扫描枪归位放置到枪托上。\n" +
                "班后：关闭上料工位屏，断电。");
        contentCZGBJBZ.setValue("操作工步：\n" +
                "一人：\n" +
                "\u2002\u2002\u2002\u20021、一人用手将笼筐插销门打开，将门向两侧打开，推出冰柜，从上料工位屏上取下扫码枪对准箱体二维码进行扫描，待扫码枪发出嘀的一声，扫描主机显示器显示绿色条码，即扫描成功，如显示红色条码，即扫描失败，报班长找对应闸口解决。\n" +
                "一人：\n" +
                "\u2002\u2002\u2002\u20021、用手打开冰柜门，角度大于180°，以观察到是否有杂铁（加强筋）为准。将冰柜内部废杂物（合格证、说明书、塑料袋、除霜板、泡沫及其他垃圾）取出，放置到废杂物吨包袋内，EPS包材放置EPS包材吨包袋中，玻璃放置到玻璃吨包内，杂铁（搁物框）留在冰柜内。\n" +
                "两人：\n" +
                "\u2002\u2002\u2002\u20021、用手将冰柜倾倒在上料辅助输送带上，将冰柜底托起前推，由输送带将冰柜传送至拆解线\n" +
                "\u2002\u2002\u2002\u20022、吨包装至90%以上时，呼叫叉车，将叉车两叉分别伸进吨包两侧支撑带，从吨包支架皮带钩上取下吨包支撑带，叉车叉取货物入库。\n" +
                "\u2002\u2002\u2002\u20024、将新吨包四角挂在吨包支架皮带钩上，吨包底部铺平，保证吨包在支架中成长方体。\n" +
                "\n" +
                "注意事项：\n" +
                "\u2002\u2002\u2002\u20021、冰柜内部除杂铁（搁物框）外，其他均需取出。\n" +
                "\u2002\u2002\u2002\u20022、协助叉车挂吨包时，人体不得正对叉齿。\n" +
                "\u2002\u2002\u2002\u20023、注意人身安全。");
        contentLQSCWT.setValue("1、用扔、摔等方式将产物放入吨包\n" +
                "2、遮挡摄像头\n" +
                "3、物料分类放置错误\n" +
                "4、冰柜内物料未取出");
        contentCLHG.setValue("1、影响基金合规性\n" +
                "2、影响拆解产物价值\n" +
                "3、堵塞冰箱破碎设备，影响拆解效率、降低刀具寿命");
        contentGZQJ.setValue("上料工位屏、扫码枪、吨包支架、吨包");
    }



    @Subscribe("comboFileNo1")
    public void onComboFileNo2ValueChange1(final HasValue.ValueChangeEvent event) {
        comIndex = event.getValue().hashCode();
        Workstation_tables infoWorkstation = listInfo1.get(comIndex);
        Map<String, Integer> itemList2 = new LinkedHashMap<String, Integer>();

        JSONArray jsonItems = JSON.parseArray(infoWorkstation.getProcess());
        for(int i=0; i<jsonItems.size(); i++){
            itemList2.put(jsonItems.get(i).toString(), i);
        }
        comboFileNo2.setOptionsMap(itemList2);
        product_category.setValue(infoWorkstation.getElectrical_appliances());
        typeContent.setValue(infoWorkstation.getAppliance_model());

    }
    @Subscribe("comboFileNo2")
    public void onComboFileNoValueChange2(final HasValue.ValueChangeEvent event) {
        Integer  itemIndex = event.getValue().hashCode();
//        Integer itemIndex = itemList.get(fileNo);
        Workstation_tables workstationItem = listInfo1.get(comIndex);
        Integer testIndex = comboFileNo1.getValue();

        JSONArray jsonItems = JSON.parseArray(workstationItem.getProcess());
        String newValue = "无";
//        JSONObject newJsonItem = new JSONObject();
//        newJsonItem.put("key", newValue);
        jsonItems.add(0, newValue);
        jsonItems.add(newValue);
        current_station.setValue(jsonItems.get(itemIndex+1));
        up_station.setValue(jsonItems.get(itemIndex));
        down_station.setValue(jsonItems.get(itemIndex+2));


    }
}