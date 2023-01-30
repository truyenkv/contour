package com.contour.pageui;

public class CommonPageUI {
    /**
     * Define the common element of system
     */

    //Common field
    public static final String FIRST_NAME_FIELD = "//input[@id='first_name']";
    public static final String LAST_NAME_FIELD = "//input[@id='last_name']";
    public static final String TITLE_FIELD = "//input[@id='title']";
    public static final String PHONE_FIELD = "//input[@id='phone']";
    public static final String WEBSITE_FIELD = "//input[@id='phone']";
    public static final String EMAIL_FIELD = "//input[@id='email']";

    //Common button
    public static final String SEARCH_FIELD = "//input[@id='default-search']";
    public static final String SEARCH_BUTTON = "//button[@type='submit']";

    //Common table element
    public static final String TABLE_ROWS_TITLE = "//table/thead/tr";
    public static final String TABLE_ROWS = "//table/tbody/tr";
    public static final String ID_COLUMN = "//table/tbody/tr[%s]/td[1]";
    public static final String MEMBER_NAME_COLUMN = "//table/tbody/tr[%s]/td[2]";
    public static final String TITLE_COLUMN = "//table/tbody/tr[%s]/td[3]";
    public static final String COMPANY_COLUMN = "//table/tbody/tr[%s]/td[4]";
    public static final String EMAIL_ADDRESS_COLUMN = "//table/tbody/tr[%s]/td[5]";
}
