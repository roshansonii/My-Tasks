package com.example.roshan.filter;

public class SizeBean {
    private String Color;
    private boolean colorCheck;
    public SizeBean() {
    }

    public SizeBean(String color, boolean colorCheck) {
        Color = color;
        this.colorCheck = colorCheck;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String color) {
        Color = color;
    }

    public boolean isColorCheck() {
        return colorCheck;
    }

    public void setColorCheck(boolean colorCheck) {
        this.colorCheck = colorCheck;
    }

}
