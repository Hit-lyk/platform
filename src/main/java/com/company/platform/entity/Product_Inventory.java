package com.company.platform.entity;

import io.jmix.core.metamodel.annotation.JmixEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@JmixEntity
@Table(name = "PRODUCT_INVENTORY")
@Entity
public class Product_Inventory {
    @Column(name = "ID", nullable = false)
    @Id
    private String id;

    @Column(name = "ITEM_CODE", nullable = false)
    @NotNull
    private String item_code;

    @Column(name = "ITEM_NAME", nullable = false)
    @NotNull
    private String item_name;

    @Column(name = "WAREHOUSE", nullable = false)
    @NotNull
    private String warehouse;

    @Column(name = "RESERVOIR_AREA", nullable = false)
    @NotNull
    private String reservoir_area;

    @Column(name = "SHELF_CODE", nullable = false)
    @NotNull
    private String shelf_code;

    @Column(name = "BIN_LOCATON", nullable = false)
    @NotNull
    private String bin_locaton;

    @Column(name = "QUANTITY", nullable = false)
    @NotNull
    private String quantity;

    @Column(name = "WEIGHT", nullable = false)
    @NotNull
    private String weight;

    @Column(name = "UNIT", nullable = false)
    @NotNull
    private String unit;

    @Column(name = "FACTORY", nullable = false)
    @NotNull
    private String factory;

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getFactory() {
        return factory;
    }

    public void setFactory(String factory) {
        this.factory = factory;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getBin_locaton() {
        return bin_locaton;
    }

    public void setBin_locaton(String bin_locaton) {
        this.bin_locaton = bin_locaton;
    }

    public String getShelf_code() {
        return shelf_code;
    }

    public void setShelf_code(String shelf_code) {
        this.shelf_code = shelf_code;
    }

    public String getReservoir_area() {
        return reservoir_area;
    }

    public void setReservoir_area(String reservoir_area) {
        this.reservoir_area = reservoir_area;
    }

    public String getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(String warehouse) {
        this.warehouse = warehouse;
    }

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public String getItem_code() {
        return item_code;
    }

    public void setItem_code(String item_code) {
        this.item_code = item_code;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}