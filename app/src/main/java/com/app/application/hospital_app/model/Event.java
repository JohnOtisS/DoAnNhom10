package com.app.application.hospital_app.model;

public class Event {
    private long id;
    private String tenDichVu;
    private String tenNguoiDat;
    private String thoiGianKham;

    public Event(long id, String tenDichVu, String tenNguoiDat, String thoiGianKham) {
        this.id = id;
        this.tenDichVu = tenDichVu;
        this.tenNguoiDat = tenNguoiDat;
        this.thoiGianKham = thoiGianKham;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTenDichVu() {
        return tenDichVu;
    }

    public void setTenDichVu(String tenDichVu) {
        this.tenDichVu = tenDichVu;
    }

    public String getTenNguoiDat() {
        return tenNguoiDat;
    }

    public void setTenNguoiDat(String tenNguoiDat) {
        this.tenNguoiDat = tenNguoiDat;
    }

    public String getThoiGianKham() {
        return thoiGianKham;
    }

    public void setThoiGianKham(String thoiGianKham) {
        this.thoiGianKham = thoiGianKham;
    }
}
