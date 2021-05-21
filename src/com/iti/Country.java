package com.iti;

public class Country {
    private String name;
    private int code;

    @Override
    public String toString() {
        return "Country's name is " + name +" ,and code: " + code + ".";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
