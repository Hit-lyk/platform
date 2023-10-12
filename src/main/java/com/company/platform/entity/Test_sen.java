package com.company.platform.entity;

import io.jmix.core.metamodel.annotation.JmixEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@JmixEntity
@Table(name = "TEST_SEN")
@Entity
public class Test_sen {
    @Column(name = "ID", nullable = false)
    @Id
    private String id;

    @Column(name = "SN", nullable = false)
    @NotNull
    private String sn;

    @Column(name = "RECORD_TIME", nullable = false)
    @NotNull
    private String record_time;

    @Column(name = "TEMP", nullable = false)
    @NotNull
    private Float temp;

    @Column(name = "HUMIDITY", nullable = false)
    @NotNull
    private Float humidity;

    public Float getHumidity() {
        return humidity;
    }

    public void setHumidity(Float humidity) {
        this.humidity = humidity;
    }

    public Float getTemp() {
        return temp;
    }

    public void setTemp(Float temp) {
        this.temp = temp;
    }

    public String getRecord_time() {
        return record_time;
    }

    public void setRecord_time(String record_time) {
        this.record_time = record_time;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}