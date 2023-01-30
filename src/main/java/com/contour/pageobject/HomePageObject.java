package com.contour.pageobject;

import com.contour.core.AbstractPage;
import org.openqa.selenium.WebDriver;

public class HomePageObject extends AbstractPage {
    private WebDriver driver;

    public HomePageObject(WebDriver driver) {
        this.driver = driver;
    }
}
