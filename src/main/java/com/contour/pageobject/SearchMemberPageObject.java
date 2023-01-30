package com.contour.pageobject;

import com.contour.core.AbstractPage;
import org.openqa.selenium.WebDriver;

public class SearchMemberPageObject extends AbstractPage {
    private WebDriver driver;

    public SearchMemberPageObject(WebDriver driver) {
        this.driver = driver;
    }
}
