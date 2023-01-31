package com.contour.pageobject;

import com.contour.core.AbstractPage;
import com.contour.model.MemberModel;
import com.contour.pageui.CommonPageUI;
import org.openqa.selenium.WebDriver;

import static com.contour.constant.MenuEnum.ADD_MEMBER;

public class HomePageObject extends AbstractPage {
    private WebDriver driver;

    public HomePageObject(WebDriver driver) {
        this.driver = driver;
    }

    public AddMemberPageObject clickOnAddMemberMenu() {
        waitForElementClickable(driver, CommonPageUI.MENU, ADD_MEMBER.getName());
        clickElementWithValue(driver, CommonPageUI.MENU, ADD_MEMBER.getName());
        return PageObjectManager.addMemberPageObject(driver);
    }

    public void validateNewMemberIsDisplayOnTable(String memberID, MemberModel memberModel) {

    }
}
