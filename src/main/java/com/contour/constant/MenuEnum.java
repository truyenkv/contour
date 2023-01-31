package com.contour.constant;

public enum MenuEnum {
    HOME("Home"),
    ADD_MEMBER("Add Member"),
    SEARCH_MEMBER("Search Member"),
    VIEW_MEMBER("View Member");

    private final String name;

    MenuEnum(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }
}
