package com.company.platform.entity;

import io.jmix.core.metamodel.annotation.JmixEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@JmixEntity
@Table(name = "MSE_TRANSFER_RECORDS")
@Entity
public class Mse_Transfer_Records {
    @Column(name = "ID", nullable = false)
    @Id
    private String id;

    @Column(name = "BARCODE", nullable = false)
    @NotNull
    private String barcode;

    @Column(name = "PRODUCTION_ORDER_NUMBER", nullable = false)
    @NotNull
    private String production_order_number;

    @Column(name = "FACTORY", nullable = false)
    @NotNull
    private String factory;

    @Column(name = "QUANTITY", nullable = false)
    @NotNull
    private String quantity;

    @Column(name = "TRAY")
    private String tray;

    @Column(name = "BATCH_NUMBER", nullable = false)
    @NotNull
    private String batch_number;

    @Column(name = "OFFLINE_TIME", nullable = false)
    @NotNull
    private String offline_time;

    @Column(name = "OPERATOR", nullable = false)
    @NotNull
    private String operator;

    @Column(name = "MATERIAL_CODE", nullable = false)
    @NotNull
    private String material_code;

    @Column(name = "MATERIAL_DESCRIPTION", nullable = false)
    @NotNull
    private String material_description;

    @Column(name = "DISASSEMBLY_LINE_NAME", nullable = false)
    @NotNull
    private String disassembly_line_name;

    @Column(name = "SUPPLIER", nullable = false)
    @NotNull
    private String supplier;

    @Column(name = "TRANSMISSION_TIME", nullable = false)
    @NotNull
    private String transmission_time;

    @Column(name = "WAREHOUSE_OR_NOT", nullable = false)
    @NotNull
    private String warehouse_or_not;

    public String getWarehouse_or_not() {
        return warehouse_or_not;
    }

    public void setWarehouse_or_not(String warehouse_or_not) {
        this.warehouse_or_not = warehouse_or_not;
    }

    public String getTransmission_time() {
        return transmission_time;
    }

    public void setTransmission_time(String transmission_time) {
        this.transmission_time = transmission_time;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public String getDisassembly_line_name() {
        return disassembly_line_name;
    }

    public void setDisassembly_line_name(String disassembly_line_name) {
        this.disassembly_line_name = disassembly_line_name;
    }

    public String getMaterial_code() {
        return material_code;
    }

    public void setMaterial_code(String material_code) {
        this.material_code = material_code;
    }

    public String getMaterial_description() {
        return material_description;
    }

    public void setMaterial_description(String material_description) {
        this.material_description = material_description;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getOffline_time() {
        return offline_time;
    }

    public void setOffline_time(String offline_time) {
        this.offline_time = offline_time;
    }

    public String getBatch_number() {
        return batch_number;
    }

    public void setBatch_number(String batch_number) {
        this.batch_number = batch_number;
    }

    public String getTray() {
        return tray;
    }

    public void setTray(String tray) {
        this.tray = tray;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getFactory() {
        return factory;
    }

    public void setFactory(String factory) {
        this.factory = factory;
    }

    public String getProduction_order_number() {
        return production_order_number;
    }

    public void setProduction_order_number(String production_order_number) {
        this.production_order_number = production_order_number;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}