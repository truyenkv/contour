package com.contour.testcase;

import com.contour.core.AbstractTest;
import com.contour.model.MemberModel;
import com.contour.pageobject.AddMemberPageObject;
import com.contour.pageobject.HomePageObject;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AddMemberTest extends AbstractTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(AddMemberTest.class);
    private WebDriver driver;
    private MemberModel memberModel;
    private HomePageObject homePageObject;
    private AddMemberPageObject addMemberPageObject;

    @BeforeEach
    public void beforeMethod() {
        LOGGER.info("Create new driver");
        driver = getDriver();
        memberModel = MemberModel.createNewMember();
        homePageObject = new HomePageObject(driver);
    }

    @Test
    public void verifyAddNewMemberSuccessful() {
        addMemberPageObject = homePageObject.clickOnAddMemberMenu();
        addMemberPageObject.inputMemberInfo(memberModel);
        addMemberPageObject.checkOnAgreeCheckBox();
        addMemberPageObject.clickOnSubmitButton();
        addMemberPageObject.validateAddMemberSuccessful();
    }

    @Test
    public void verifyMemberDisplayOnHomePageAfterAdding() {
        addMemberPageObject = homePageObject.clickOnAddMemberMenu();
        addMemberPageObject.inputMemberInfo(memberModel);
        addMemberPageObject.checkOnAgreeCheckBox();
        addMemberPageObject.clickOnSubmitButton();
        String memberID = addMemberPageObject.getIdOfNewMember();
        homePageObject = addMemberPageObject.clickOnHomeMenu();
        homePageObject.validateNewMemberIsDisplayOnTable(memberID, memberModel);
    }

    @AfterEach
    public void afterMethod() {
        LOGGER.info("Close the driver");
        closeBrowser(driver);
    }
}
