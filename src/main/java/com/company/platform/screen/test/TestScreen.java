package com.company.platform.screen.test;

import io.jmix.ui.screen.Screen;
import io.jmix.ui.screen.UiController;
import io.jmix.ui.screen.UiDescriptor;

@UiController("TestScreen")
@UiDescriptor("Test-screen.xml")
public class TestScreen extends Screen {
    // 上料 EPS包材, 废杂物, 玻璃, 挂吨包
    // 预拆解1 电源线、废杂料（防潮板）、挂吨包
    // 预拆解2 杂铁（车轱辘）、杂铁（螺丝）、挂吨包
    // 预拆解3 铰链盖板、塑料外壳、杂铁（加强筋）、密封条、挂吨包
    // 预拆解4 压缩机、电容、铜管、温控器、电路板、压缩机摆放
    // 电源线分拣 电源线、铜、挂吨包
    // 塑料金属出料 破碎铁、破碎塑料、破碎铝（含铜）、挂吨包
    // 泡棉出料 泡棉、装框

}