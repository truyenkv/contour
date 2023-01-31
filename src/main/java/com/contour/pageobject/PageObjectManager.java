package com.contour.pageobject;

import org.openqa.selenium.WebDriver;

public class PageObjectManager{

    public static HomePageObject homePageObject(WebDriver driver){
        return new HomePageObject(driver);
    }
    public static AddMemberPageObject addMemberPageObject(WebDriver driver){
        return new AddMemberPageObject(driver);
    }
    public static SearchMemberPageObject searchMemberPageObject(WebDriver driver){
        return new SearchMemberPageObject(driver);
    }
    public static ViewMemberPageObject viewMemberPageObject(WebDriver driver){
        return new ViewMemberPageObject(driver);
    }
}
