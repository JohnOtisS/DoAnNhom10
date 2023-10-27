package com.app.application.hospital_app.model;

public class Calendar {
    private int i;
    private boolean isSelected;
    private long time;
    private String dateFormat;

    public Calendar(int i, boolean isSelected, long time, String dateFormat) {
        this.i = i;
        this.isSelected = isSelected;
        this.time = time;
        this.dateFormat = dateFormat;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public String getDateFormat() {
        return dateFormat;
    }

    public void setDateFormat(String dateFormat) {
        this.dateFormat = dateFormat;
    }
}
