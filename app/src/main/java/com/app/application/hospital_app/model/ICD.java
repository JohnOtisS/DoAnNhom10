package com.app.application.hospital_app.model;

public class ICD {
    private long id;
    private String description;
    private String tenBenh;
    private String nhomBenh;

    public ICD(long id, String description, String tenBenh, String nhomBenh) {
        this.id = id;
        this.description = description;
        this.tenBenh = tenBenh;
        this.nhomBenh = nhomBenh;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTenBenh() {
        return tenBenh;
    }

    public void setTenBenh(String tenBenh) {
        this.tenBenh = tenBenh;
    }

    public String getNhomBenh() {
        return nhomBenh;
    }

    public void setNhomBenh(String nhomBenh) {
        this.nhomBenh = nhomBenh;
    }
}
