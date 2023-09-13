package com.company.platform.entity;

import io.jmix.core.annotation.DeletedBy;
import io.jmix.core.annotation.DeletedDate;
import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.JmixEntity;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;


@JmixEntity
@Table(name = "GF_POB_DETAIL")
@Entity(name = "sampler_DateValue")
public class GF_POBDetail {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;

    @Column(name = "ORG_CODE")
    private String orgCode;

    @Column(name = "POB_NUM")
    private String pobNum;

    @Column(name = "PRO_BARCODE")
    private String proBarcode;

    @Column(name = "PRODUCT_CODE")
    private String productCode;

    @Column(name = "PRODUCT_NAME")
    private String productName;

    @Column(name = "PRO_NUM")
    private Integer proNum;

    @Column(name = "PRO_WEIGHT")
    private Double proWeight;

    @Column(name = "WAREHOUSE_NAME")
    private String warehouseName;

    @Column(name = "POB_TYPE")
    private String pobType;

    @Column(name = "POB_TIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date pobTime;

    @Column(name = "POB_TEAM")
    private String pobTeam;

    @Column(name = "DELIVERY_MAN")
    private String deliveryMan;

    @Column(name = "WORK_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date workDate;

    @Column(name = "EXCHANGE_TIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date exchangeTime;

    @Column(name = "VERSION", nullable = false)
    @Version
    private Integer version;

    @CreatedBy
    @Column(name = "CREATED_BY")
    private String createdBy;

    @CreatedDate
    @Column(name = "CREATED_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @LastModifiedBy
    @Column(name = "LAST_MODIFIED_BY")
    private String lastModifiedBy;

    @LastModifiedDate
    @Column(name = "LAST_MODIFIED_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;

    @DeletedBy
    @Column(name = "DELETED_BY")
    private String deletedBy;

    @DeletedDate
    @Column(name = "DELETED_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date deletedDate;

    public Date getExchangeTime() {
        return exchangeTime;
    }

    public void setExchangeTime(Date exchangeTime) {
        this.exchangeTime = exchangeTime;
    }

    public Date getWorkDate() {
        return workDate;
    }

    public void setWorkDate(Date workDate) {
        this.workDate = workDate;
    }

    public String getDeliveryMan() {
        return deliveryMan;
    }

    public void setDeliveryMan(String deliveryMan) {
        this.deliveryMan = deliveryMan;
    }

    public String getPobTeam() {
        return pobTeam;
    }

    public void setPobTeam(String pobTeam) {
        this.pobTeam = pobTeam;
    }

    public Date getPobTime() {
        return pobTime;
    }

    public void setPobTime(Date pobTime) {
        this.pobTime = pobTime;
    }

    public String getPobType() {
        return pobType;
    }

    public void setPobType(String pobType) {
        this.pobType = pobType;
    }

    public String getWarehouseName() {
        return warehouseName;
    }

    public void setWarehouseName(String warehouseName) {
        this.warehouseName = warehouseName;
    }

    public Double getProWeight() {
        return proWeight;
    }

    public void setProWeight(Double proWeight) {
        this.proWeight = proWeight;
    }

    public Integer getProNum() {
        return proNum;
    }

    public void setProNum(Integer proNum) {
        this.proNum = proNum;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProBarcode() {
        return proBarcode;
    }

    public void setProBarcode(String proBarcode) {
        this.proBarcode = proBarcode;
    }

    public String getPobNum() {
        return pobNum;
    }

    public void setPobNum(String pobNum) {
        this.pobNum = pobNum;
    }

    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
    }

    public Date getDeletedDate() {
        return deletedDate;
    }

    public void setDeletedDate(Date deletedDate) {
        this.deletedDate = deletedDate;
    }

    public String getDeletedBy() {
        return deletedBy;
    }

    public void setDeletedBy(String deletedBy) {
        this.deletedBy = deletedBy;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}