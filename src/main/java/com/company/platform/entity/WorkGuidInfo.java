package com.company.platform.entity;

import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@JmixEntity
@Table(name = "WORK_GUID_INFO")
@Entity
public class WorkGuidInfo {
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

    @InstanceName
    @Column(name = "FILE_NO")
    private String fileNo;

    @Column(name = "WORK_SAFETY")
    private String work_safety;

    @Column(name = "BEFORE_WORK")
    private String before_work;

    @Column(name = "AFTER_WORK")
    private String after_work;

    @Lob
    @Column(name = "STEP_STD")
    private String step_std;

    @Column(name = "MINEFIELD")
    private String minefield;

    @Column(name = "AFTER_MINE")
    private String after_mine;

    @Column(name = "DEVICE_TOOLS")
    private String device_tools;

    public String getAppliance_model() {
        return appliance_model;
    }

    public void setAppliance_model(String appliance_model) {
        this.appliance_model = appliance_model;
    }

    public String getElectrical_appliances() {
        return electrical_appliances;
    }

    public void setElectrical_appliances(String electrical_appliances) {
        this.electrical_appliances = electrical_appliances;
    }

    public String getFileNo() {
        return fileNo;
    }

    public void setFileNo(String fileNo) {
        this.fileNo = fileNo;
    }

    public String getDevice_tools() {
        return device_tools;
    }

    public void setDevice_tools(String device_tools) {
        this.device_tools = device_tools;
    }

    public String getAfter_mine() {
        return after_mine;
    }

    public void setAfter_mine(String after_mine) {
        this.after_mine = after_mine;
    }

    public String getMinefield() {
        return minefield;
    }

    public void setMinefield(String minefield) {
        this.minefield = minefield;
    }

    public String getStep_std() {
        return step_std;
    }

    public void setStep_std(String step_std) {
        this.step_std = step_std;
    }

    public String getAfter_work() {
        return after_work;
    }

    public void setAfter_work(String after_work) {
        this.after_work = after_work;
    }

    public String getBefore_work() {
        return before_work;
    }

    public void setBefore_work(String before_work) {
        this.before_work = before_work;
    }

    public String getWork_safety() {
        return work_safety;
    }

    public void setWork_safety(String work_safety) {
        this.work_safety = work_safety;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}