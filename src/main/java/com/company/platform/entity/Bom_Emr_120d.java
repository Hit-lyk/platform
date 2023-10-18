package com.company.platform.entity;

import io.jmix.core.metamodel.annotation.JmixEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@JmixEntity
@Table(name = "BOM_EMR_120D")
@Entity
public class Bom_Emr_120d {
    @Column(name = "ID", nullable = false)
    @Id
    private String id;

    @Column(name = "MATERIAL_CODE", nullable = false)
    @NotNull
    private String material_code;

    @Column(name = "ITEM_NAME", nullable = false)
    @NotNull
    private String item_name;

    @Column(name = "BOM_COMPONENT", nullable = false)
    @NotNull
    private String bom_component;

    @Column(name = "COMPONENT_DESC", nullable = false)
    @NotNull
    private String component_desc;

    @Column(name = "COMPONENT_CONS_QUANT", nullable = false)
    @NotNull
    private String component_cons_quant;

    @Column(name = "UNIT", nullable = false)
    @NotNull
    private String unit;

    @Column(name = "COMPONENT_PRICE", nullable = false)
    @NotNull
    private String component_price;

    @Column(name = "AMOUNT_OF_MONEY", nullable = false)
    @NotNull
    private String amount_of_money;

    @Column(name = "PROPORTION", nullable = false)
    @NotNull
    private String proportion;

    public String getProportion() {
        return proportion;
    }

    public void setProportion(String proportion) {
        this.proportion = proportion;
    }

    public String getAmount_of_money() {
        return amount_of_money;
    }

    public void setAmount_of_money(String amount_of_money) {
        this.amount_of_money = amount_of_money;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getComponent_price() {
        return component_price;
    }

    public void setComponent_price(String component_price) {
        this.component_price = component_price;
    }

    public String getComponent_cons_quant() {
        return component_cons_quant;
    }

    public void setComponent_cons_quant(String component_cons_quant) {
        this.component_cons_quant = component_cons_quant;
    }

    public String getComponent_desc() {
        return component_desc;
    }

    public void setComponent_desc(String component_desc) {
        this.component_desc = component_desc;
    }

    public String getBom_component() {
        return bom_component;
    }

    public void setBom_component(String bom_component) {
        this.bom_component = bom_component;
    }

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public String getMaterial_code() {
        return material_code;
    }

    public void setMaterial_code(String material_code) {
        this.material_code = material_code;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}