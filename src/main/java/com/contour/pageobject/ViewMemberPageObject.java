package com.contour.pageobject;

import com.contour.core.AbstractPage;
import org.openqa.selenium.WebDriver;

public class ViewMemberPageObject extends AbstractPage {
    private WebDriver driver;

    public ViewMemberPageObject(WebDriver driver) {
        this.driver = driver;
    }
}
