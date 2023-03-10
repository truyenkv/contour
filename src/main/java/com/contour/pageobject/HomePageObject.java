package com.contour.pageobject;

import com.contour.core.AbstractPage;
import com.contour.model.MemberModel;
import com.contour.pageui.CommonPageUI;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.contour.constant.MenuEnum.ADD_MEMBER;
import static org.assertj.core.api.Assertions.assertThat;

public class HomePageObject extends AbstractPage {
    private static final Logger LOGGER = LoggerFactory.getLogger(HomePageObject.class);
    private WebDriver driver;

    public HomePageObject(WebDriver driver) {
        this.driver = driver;
    }

    public AddMemberPageObject clickOnAddMemberMenu() {
        LOGGER.info("Click on Add Member from Home page");
        waitForElementClickable(driver, CommonPageUI.MENU, ADD_MEMBER.getName());
        clickDynamicElement(driver, CommonPageUI.MENU, ADD_MEMBER.getName());
        return PageObjectManager.addMemberPageObject(driver);
    }

    public void validateNewMemberIsDisplayOnTable(String memberID, MemberModel memberModel) {
        LOGGER.info("Validate the new member is displayed on Home page");
        int rowNum = finds(driver, CommonPageUI.TABLE_ROWS).size();
        for (int i = 1; i < rowNum; i++) {
            if (getDynamicText(driver, CommonPageUI.ID_COLUMN, String.valueOf(i)).equals(memberID)) {
                String index = String.valueOf(i);
                assertThat(getDynamicText(driver, CommonPageUI.MEMBER_NAME_COLUMN, index)).isEqualTo(memberModel.getFirstName() + " " + memberModel.getLastName());
                assertThat(getDynamicText(driver, CommonPageUI.TITLE_COLUMN, index)).isEqualTo(memberModel.getTitle());
                assertThat(getDynamicText(driver, CommonPageUI.COMPANY_COLUMN, index)).isEqualTo(memberModel.getCompany());
                assertThat(getDynamicText(driver, CommonPageUI.EMAIL_ADDRESS_COLUMN, index)).isEqualTo(memberModel.getEmail());
            }
        }
    }
}
