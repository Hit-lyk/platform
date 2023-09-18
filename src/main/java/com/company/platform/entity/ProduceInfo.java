package com.company.platform.entity;

import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.JmixEntity;

import javax.persistence.*;
import java.util.UUID;

@JmixEntity
@Table(name = "PRODUCE_INFO")
@Entity
public class ProduceInfo {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;

    @Column(name = "STATION")
    private Integer station;

    @Column(name = "OPERATE_INFO")
    @Lob
    private String operateInfo;

    public void setStation(StationType station) {
        this.station = station == null ? null : station.getId();
    }

    public StationType getStation() {
        return station == null ? null : StationType.fromId(station);
    }

    public String getOperateInfo() {
        return operateInfo;
    }

    public void setOperateInfo(String operateInfo) {
        this.operateInfo = operateInfo;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}