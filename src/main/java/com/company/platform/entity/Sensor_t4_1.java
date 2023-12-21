package com.company.platform.entity;

import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.JmixEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@JmixEntity
@Table(name = "SENSOR_T4_1")
@Entity
public class Sensor_t4_1 {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;

    @Column(name = "SN", nullable = false)
    @NotNull
    private String sn;

    @Column(name = "TEMP", nullable = false)
    @NotNull
    private String temp;

    @Column(name = "HUMDITY", nullable = false)
    @NotNull
    private String humdity;

    @Column(name = "PM25", nullable = false)
    @NotNull
    private String pm25;

    @Column(name = "PM10", nullable = false)
    @NotNull
    private String pm10;

    @Column(name = "PM1", nullable = false)
    @NotNull
    private String pm1;

    @Column(name = "RECORD_TIME", nullable = false)
    @NotNull
    private String record_time;

    public String getRecord_time() {
        return record_time;
    }

    public void setRecord_time(String record_time) {
        this.record_time = record_time;
    }

    public String getPm1() {
        return pm1;
    }

    public void setPm1(String pm1) {
        this.pm1 = pm1;
    }

    public String getPm10() {
        return pm10;
    }

    public void setPm10(String pm10) {
        this.pm10 = pm10;
    }

    public String getPm25() {
        return pm25;
    }

    public void setPm25(String pm25) {
        this.pm25 = pm25;
    }

    public String getHumdity() {
        return humdity;
    }

    public void setHumdity(String humdity) {
        this.humdity = humdity;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}