package com.app.application.hospital_app.model;

import java.io.Serializable;

public class BN implements Serializable {
    private long id;
    private String numberBHYT;
    private String thoiHanBHYT;
    private String noiDangKy;
    private String hoTen;
    private String dob;
    private int gender;
    private String address;

    public BN(long id, String numberBHYT, String thoiHanBHYT, String noiDangKy, String hoTen, String dob, int gender, String address) {
        this.id = id;
        this.numberBHYT = numberBHYT;
        this.thoiHanBHYT = thoiHanBHYT;
        this.noiDangKy = noiDangKy;
        this.hoTen = hoTen;
        this.dob = dob;
        this.gender = gender;
        this.address = address;
    }

    public BN(String numberBHYT, String thoiHanBHYT, String noiDangKy, String hoTen, String dob, int gender) {
        this.numberBHYT = numberBHYT;
        this.thoiHanBHYT = thoiHanBHYT;
        this.noiDangKy = noiDangKy;
        this.hoTen = hoTen;
        this.dob = dob;
        this.gender = gender;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNumberBHYT() {
        return numberBHYT;
    }

    public void setNumberBHYT(String numberBHYT) {
        this.numberBHYT = numberBHYT;
    }

    public String getThoiHanBHYT() {
        return thoiHanBHYT;
    }

    public void setThoiHanBHYT(String thoiHanBHYT) {
        this.thoiHanBHYT = thoiHanBHYT;
    }

    public String getNoiDangKy() {
        return noiDangKy;
    }

    public void setNoiDangKy(String noiDangKy) {
        this.noiDangKy = noiDangKy;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
