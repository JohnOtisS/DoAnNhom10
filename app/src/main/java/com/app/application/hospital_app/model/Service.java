package com.app.application.hospital_app.model;

public class Service {
    private long id;
    private String serviceName;

    public Service(long id, String serviceName) {
        this.id = id;
        this.serviceName = serviceName;
    }

    public Service( String serviceName) {
        this.serviceName = serviceName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }
}
