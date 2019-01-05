package com.example.roshan.filter;

public class TypeBean {
    private String Type;
    private boolean typeCheck;
    public TypeBean() {
    }

    public TypeBean(String type, boolean typeCheck) {
        Type = type;
        this.typeCheck = typeCheck;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public boolean isTypeCheck() {
        return typeCheck;
    }

    public void setTypeCheck(boolean typeCheck) {
        this.typeCheck = typeCheck;
    }
}
