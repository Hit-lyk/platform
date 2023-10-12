package com.company.platform.entity;

import io.jmix.core.metamodel.annotation.JmixEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@JmixEntity
@Table(name = "DISASSEMBLE_TRANSFER_DETAILS")
@Entity
public class Disassemble_transfer_details {
    @Column(name = "ID", nullable = false)
    @Id
    private String id;

    @Column(name = "FACTORY", nullable = false)
    @NotNull
    private String factory;

    @Column(name = "OUTBOUND_TRACKING_NUMBER", nullable = false)
    @NotNull
    private String outbound_tracking_number;

    @Column(name = "FINISHED_BARCODES", nullable = false)
    @NotNull
    private String finished_barcodes;

    @Column(name = "WEIGHT", nullable = false)
    @NotNull
    private String weight;

    @Column(name = "SCAN_TIME", nullable = false)
    @NotNull
    private String scan_time;

    @Column(name = "PRODUCT_TYPE", nullable = false)
    @NotNull
    private String product_type;

    @Column(name = "PRODUCT_MODEL", nullable = false)
    @NotNull
    private String product_model;

    @Column(name = "PRODUCT_DESCRIPTION", nullable = false)
    @NotNull
    private String product_description;

    @Column(name = "WARE_HOUSE", nullable = false)
    @NotNull
    private String ware_house;

    @Column(name = "RESERVOIR_AREA", nullable = false)
    @NotNull
    private String reservoir_area;

    @Column(name = "BIN_LOCATION", nullable = false)
    @NotNull
    private String bin_location;

    @Column(name = "PRODUCT_STATE", nullable = false)
    @NotNull
    private String product_state;

    @Column(name = "BILL_NUMBER", nullable = false)
    @NotNull
    private String bill_number;

    @Column(name = "DELIVERY_NOTE", nullable = false)
    @NotNull
    private String delivery_note;

    @Column(name = "ORDER_LINE_ITEMS", nullable = false)
    @NotNull
    private String order_line_items;

    @Column(name = "SCANNER", nullable = false)
    @NotNull
    private String scanner;

    public String getScanner() {
        return scanner;
    }

    public void setScanner(String scanner) {
        this.scanner = scanner;
    }

    public String getOrder_line_items() {
        return order_line_items;
    }

    public void setOrder_line_items(String order_line_items) {
        this.order_line_items = order_line_items;
    }

    public String getDelivery_note() {
        return delivery_note;
    }

    public void setDelivery_note(String delivery_note) {
        this.delivery_note = delivery_note;
    }

    public String getBill_number() {
        return bill_number;
    }

    public void setBill_number(String bill_number) {
        this.bill_number = bill_number;
    }

    public String getProduct_state() {
        return product_state;
    }

    public void setProduct_state(String product_state) {
        this.product_state = product_state;
    }

    public String getBin_location() {
        return bin_location;
    }

    public void setBin_location(String bin_location) {
        this.bin_location = bin_location;
    }

    public String getReservoir_area() {
        return reservoir_area;
    }

    public void setReservoir_area(String reservoir_area) {
        this.reservoir_area = reservoir_area;
    }

    public String getWare_house() {
        return ware_house;
    }

    public void setWare_house(String ware_house) {
        this.ware_house = ware_house;
    }

    public String getProduct_description() {
        return product_description;
    }

    public void setProduct_description(String product_description) {
        this.product_description = product_description;
    }

    public String getProduct_model() {
        return product_model;
    }

    public void setProduct_model(String product_model) {
        this.product_model = product_model;
    }

    public String getProduct_type() {
        return product_type;
    }

    public void setProduct_type(String product_type) {
        this.product_type = product_type;
    }

    public String getScan_time() {
        return scan_time;
    }

    public void setScan_time(String scan_time) {
        this.scan_time = scan_time;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getFinished_barcodes() {
        return finished_barcodes;
    }

    public void setFinished_barcodes(String finished_barcodes) {
        this.finished_barcodes = finished_barcodes;
    }

    public String getOutbound_tracking_number() {
        return outbound_tracking_number;
    }

    public void setOutbound_tracking_number(String outbound_tracking_number) {
        this.outbound_tracking_number = outbound_tracking_number;
    }

    public String getFactory() {
        return factory;
    }

    public void setFactory(String factory) {
        this.factory = factory;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}