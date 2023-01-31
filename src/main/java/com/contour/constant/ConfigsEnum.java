package com.contour.constant;

public enum ConfigsEnum {
    URL("url"),
    ENV("env"),
    BROWSER("browser");

    private final String name;

    ConfigsEnum(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }
}
