package com.contour.pageui;

public class CommonPageUI {
    /**
     * Define the common element of system
     */

    //Common button
    public static final String SEARCH_FIELD = "//input[@id='default-search']";
    public static final String SEARCH_BUTTON = "//button[@type='submit']";

    //Common table element
    public static final String TABLE_ROWS = "//table/tbody/tr";
    public static final String ID_COLUMN = "//table/tbody/tr[%s]/td[1]";
    public static final String MEMBER_NAME_COLUMN = "//table/tbody/tr[%s]/td[2]";
    public static final String TITLE_COLUMN = "//table/tbody/tr[%s]/td[3]";
    public static final String COMPANY_COLUMN = "//table/tbody/tr[%s]/td[4]";
    public static final String EMAIL_ADDRESS_COLUMN = "//table/tbody/tr[%s]/td[5]";

    //Menu
    public static final String MENU = "//*[contains(text(), '%s')]";
}
