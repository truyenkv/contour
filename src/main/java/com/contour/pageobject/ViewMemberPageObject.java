package com.contour.pageobject;

import com.contour.core.AbstractPage;
import com.contour.model.MemberModel;
import com.contour.pageui.CommonPageUI;
import com.contour.pageui.ViewMemberPageUI;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.assertj.core.api.Assertions.assertThat;

public class ViewMemberPageObject extends AbstractPage {
    private static final Logger LOGGER = LoggerFactory.getLogger(ViewMemberPageObject.class);
    private WebDriver driver;

    public ViewMemberPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void searchMemberByID(String memberID) {
        LOGGER.info("Search member by {}", memberID);
        waitForElementVisible(driver, CommonPageUI.SEARCH_FIELD);
        inputText(driver, CommonPageUI.SEARCH_FIELD, memberID);
        clickToElement(driver, CommonPageUI.SEARCH_BUTTON);
    }

    public void validateViewMemberDisplayCorrectly(MemberModel memberModel) {
        LOGGER.info("Validate view member correctly");
        assertThat(memberModel).extracting("firstName", "lastName", "title", "company", "phoneNumber", "web", "email")
                .containsExactly(
                        getElementText(driver, ViewMemberPageUI.FIRST_NAME_FIELD),
                        getElementText(driver, ViewMemberPageUI.LAST_NAME_FIELD),
                        getElementText(driver, ViewMemberPageUI.TITLE_FIELD),
                        getElementText(driver, ViewMemberPageUI.COMPANY_FIELD),
                        getElementText(driver, ViewMemberPageUI.PHONE_FIELD),
                        getElementText(driver, ViewMemberPageUI.WEBSITE_FIELD),
                        getElementText(driver, ViewMemberPageUI.EMAIL_FIELD)
                );
    }
}
