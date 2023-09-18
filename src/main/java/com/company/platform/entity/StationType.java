package com.company.platform.entity;

import io.jmix.core.metamodel.datatype.impl.EnumClass;

import javax.annotation.Nullable;


public enum StationType implements EnumClass<Integer> {

    上料(10),
    预拆解1(20),
    预拆解2(30),
    预拆解3(40),
    预拆解4(50),
    电源线分拣(60),
    塑料金属出料(70),
    泡棉出料(80);

    private final Integer id;

    StationType(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    @Nullable
    public static StationType fromId(Integer id) {
        for (StationType at : StationType.values()) {
            if (at.getId().equals(id)) {
                return at;
            }
        }
        return null;
    }
}