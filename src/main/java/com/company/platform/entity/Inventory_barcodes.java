package com.company.platform.entity;

import io.jmix.core.metamodel.annotation.JmixEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@JmixEntity
@Table(name = "INVENTORY_BARCODES")
@Entity
public class Inventory_barcodes {
    @Column(name = "ID", nullable = false)
    @Id
    private String id;

    @Column(name = "MODEL")
    private String model;

    @Column(name = "GOOD_DESCRIPTION")
    private String good_description;

    @Column(name = "RESERVOIR_AREA", nullable = false)
    @NotNull
    private String reservoir_area;

    @Column(name = "SHELF_CODE")
    private String shelf_code;

    @Column(name = "BIN_LOCATION")
    private String bin_location;

    @Column(name = "BARCODE_NUMBER", nullable = false)
    @NotNull
    private String barcode_number;

    @Column(name = "BARCODE_NUMBER1")
    private String barcode_number1;

    @Column(name = "INVENTORY_AGE")
    private String inventory_age;

    @Column(name = "INVENTORY_AGE_START")
    private String inventory_age_start;

    @Column(name = "QUANTITY")
    private String quantity;

    @Column(name = "WEIGHT")
    private String weight;

    @Column(name = "UNIT")
    private String unit;

    @Column(name = "OFFLINE_TIME")
    private String offline_time;

    @Column(name = "INBOUND_TIME")
    private String inbound_time;

    @Column(name = "FROZEN_STATE")
    private String frozen_state;

    @Column(name = "OCC_TRACK_NUM")
    private String occ_track_num;

    @Column(name = "SCAN_STATE")
    private String scan_state;

    @Column(name = "PRODUCT_ORDER_NUM")
    private String product_order_num;

    @Column(name = "PRODUCT_LINE")
    private String product_line;

    @Column(name = "FACTORY")
    private String factory;

    @Column(name = "WAREHOUSE")
    private String warehouse;

    @Column(name = "BATCH_NUM")
    private String batch_num;

    @Column(name = "PRODUCT_NUM")
    private String product_num;

    @Column(name = "LOCATION_USAGE")
    private String location_usage;

    @Column(name = "CREATE_")
    private String create;

    @Column(name = "CREATION_TIME")
    private String creation_time;

    public String getBin_location() {
        return bin_location;
    }

    public void setBin_location(String bin_location) {
        this.bin_location = bin_location;
    }

    public String getBarcode_number1() {
        return barcode_number1;
    }

    public void setBarcode_number1(String barcode_number1) {
        this.barcode_number1 = barcode_number1;
    }

    public String getShelf_code() {
        return shelf_code;
    }

    public void setShelf_code(String shelf_code) {
        this.shelf_code = shelf_code;
    }

    public String getCreation_time() {
        return creation_time;
    }

    public void setCreation_time(String creation_time) {
        this.creation_time = creation_time;
    }

    public String getCreate() {
        return create;
    }

    public void setCreate(String create) {
        this.create = create;
    }

    public String getLocation_usage() {
        return location_usage;
    }

    public void setLocation_usage(String location_usage) {
        this.location_usage = location_usage;
    }

    public String getProduct_num() {
        return product_num;
    }

    public void setProduct_num(String product_num) {
        this.product_num = product_num;
    }

    public String getBatch_num() {
        return batch_num;
    }

    public void setBatch_num(String batch_num) {
        this.batch_num = batch_num;
    }

    public String getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(String warehouse) {
        this.warehouse = warehouse;
    }

    public String getFactory() {
        return factory;
    }

    public void setFactory(String factory) {
        this.factory = factory;
    }

    public String getProduct_line() {
        return product_line;
    }

    public void setProduct_line(String product_line) {
        this.product_line = product_line;
    }

    public String getProduct_order_num() {
        return product_order_num;
    }

    public void setProduct_order_num(String product_order_num) {
        this.product_order_num = product_order_num;
    }

    public String getScan_state() {
        return scan_state;
    }

    public void setScan_state(String scan_state) {
        this.scan_state = scan_state;
    }

    public String getOcc_track_num() {
        return occ_track_num;
    }

    public void setOcc_track_num(String occ_track_num) {
        this.occ_track_num = occ_track_num;
    }

    public String getFrozen_state() {
        return frozen_state;
    }

    public void setFrozen_state(String frozen_state) {
        this.frozen_state = frozen_state;
    }

    public String getInbound_time() {
        return inbound_time;
    }

    public void setInbound_time(String inbound_time) {
        this.inbound_time = inbound_time;
    }

    public String getOffline_time() {
        return offline_time;
    }

    public void setOffline_time(String offline_time) {
        this.offline_time = offline_time;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getInventory_age_start() {
        return inventory_age_start;
    }

    public void setInventory_age_start(String inventory_age_start) {
        this.inventory_age_start = inventory_age_start;
    }

    public String getInventory_age() {
        return inventory_age;
    }

    public void setInventory_age(String inventory_age) {
        this.inventory_age = inventory_age;
    }

    public String getBarcode_number() {
        return barcode_number;
    }

    public void setBarcode_number(String barcode_number) {
        this.barcode_number = barcode_number;
    }

    public String getReservoir_area() {
        return reservoir_area;
    }

    public void setReservoir_area(String reservoir_area) {
        this.reservoir_area = reservoir_area;
    }

    public String getGood_description() {
        return good_description;
    }

    public void setGood_description(String good_description) {
        this.good_description = good_description;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}