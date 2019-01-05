package com.example.roshan.filter;

import android.graphics.Typeface;

public class BrandBean {
    private String brand;
    private boolean isCheck;

    public BrandBean() {
    }

    public BrandBean(String brand, boolean isCheck) {
        this.brand = brand;
        this.isCheck = isCheck;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public boolean isCheck() {
        return isCheck;
    }

    public void setCheck(boolean check) {
        isCheck = check;
    }
}
