package com.company.platform.entity;

import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.JmixEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@JmixEntity
@Table(name = "WORKSTATION_TABLES")
@Entity
public class Workstation_tables {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;

    @Column(name = "ELECTRICAL_APPLIANCES", nullable = false)
    @NotNull
    private String electrical_appliances;

    @Column(name = "APPLIANCE_MODEL", nullable = false)
    @NotNull
    private String appliance_model;

    @Lob
    @NotNull
    @Column(name = "PROCESS", nullable = false)
    private String process;

    public String getAppliance_model() {
        return appliance_model;
    }

    public void setAppliance_model(String appliance_model) {
        this.appliance_model = appliance_model;
    }

    public void setProcess(String process) {
        this.process = process;
    }

    public String getProcess() {
        return process;
    }

    public String getElectrical_appliances() {
        return electrical_appliances;
    }

    public void setElectrical_appliances(String electrical_appliances) {
        this.electrical_appliances = electrical_appliances;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}