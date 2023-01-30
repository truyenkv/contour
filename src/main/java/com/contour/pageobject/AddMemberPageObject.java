package com.contour.pageobject;

import com.contour.core.AbstractPage;
import org.openqa.selenium.WebDriver;

public class AddMemberPageObject extends AbstractPage {
    private WebDriver driver;

    public AddMemberPageObject(WebDriver driver) {
        this.driver = driver;
    }
}
