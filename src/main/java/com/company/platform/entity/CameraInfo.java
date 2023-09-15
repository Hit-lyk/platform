package com.company.platform.entity;

import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@JmixEntity
@Table(name = "CAMERA_INFO")
@Entity
public class CameraInfo {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;

    @Column(name = "IP", length = 16)
    private String ip;

    @Column(name = "PORT")
    private Short port;

    @Column(name = "USERNAME", length = 32)
    private String username;

    @Column(name = "PASSWORD", length = 32)
    private String password;

    @Column(name = "PATH_PLAYBACK")
    private String pathPlayback;

    @Column(name = "GROUP_NO")
    private Short groupNo;

    @InstanceName
    @Column(name = "DESCRIPTION", length = 64)
    private String description;

    public String getPathPlayback() {
        return pathPlayback;
    }

    public void setPathPlayback(String pathPlayback) {
        this.pathPlayback = pathPlayback;
    }

    public Short getGroupNo() {
        return groupNo;
    }

    public void setGroupNo(Short groupNo) {
        this.groupNo = groupNo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Short getPort() {
        return port;
    }

    public void setPort(Short port) {
        this.port = port;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}