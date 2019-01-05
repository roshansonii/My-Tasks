package com.example.roshan.filter;

public class ColorBean {
    private String color;
    private boolean colorCheck;
    public ColorBean() {
    }

    public ColorBean(String color, boolean colorCheck) {
        this.color = color;
        this.colorCheck = colorCheck;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isColorCheck() {
        return colorCheck;
    }

    public void setColorCheck(boolean colorCheck) {
        this.colorCheck = colorCheck;
    }
}
