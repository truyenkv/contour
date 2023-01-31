package com.contour.testcase.searchmember;

import com.contour.core.AbstractTest;
import com.contour.model.MemberModel;
import com.contour.pageobject.AddMemberPageObject;
import com.contour.pageobject.HomePageObject;
import com.contour.pageobject.SearchMemberPageObject;
import com.contour.pageobject.ViewMemberPageObject;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class VerifySearchAndViewMemberTest extends AbstractTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(VerifySearchAndViewMemberTest.class);
    private WebDriver driver;
    private MemberModel memberModel;
    private HomePageObject homePageObject;
    private AddMemberPageObject addMemberPageObject;
    private SearchMemberPageObject searchMemberPageObject;
    private ViewMemberPageObject viewMemberPageObject;

    @BeforeEach
    public void beforeMethod() {
        LOGGER.info("Create new driver");
        driver = getDriver();
        memberModel = MemberModel.createNewMember();
        homePageObject = new HomePageObject(driver);
    }

    @Test
    public void verifySearchMemberByFirstNameAfterAddingSuccessful() {
        LOGGER.info("Verify User search member by name after adding successful");
        addMemberPageObject = homePageObject.clickOnAddMemberMenu();
        addMemberPageObject.inputMemberInfo(memberModel);
        addMemberPageObject.checkOnAgreeCheckBox();
        addMemberPageObject.clickOnSubmitButton();
        searchMemberPageObject = addMemberPageObject.clickOnSearchMemberMenu();
        searchMemberPageObject.searchMemberByValue(memberModel.getFirstName());
        searchMemberPageObject.validateMemberNameInResultCorrectly(memberModel.getFirstName());
    }

    @Test
    @Tag("smoke")
    public void verifySearchMemberByFullNameAfterAddingSuccessful() {
        LOGGER.info("Verify User search member by full name after adding successful");
        String fullName = memberModel.getFirstName() + " " + memberModel.getLastName();
        addMemberPageObject = homePageObject.clickOnAddMemberMenu();
        addMemberPageObject.inputMemberInfo(memberModel);
        addMemberPageObject.checkOnAgreeCheckBox();
        addMemberPageObject.clickOnSubmitButton();
        searchMemberPageObject = addMemberPageObject.clickOnSearchMemberMenu();
        searchMemberPageObject.searchMemberByValue(fullName);
        searchMemberPageObject.validateMemberNameInResultCorrectly(fullName);
    }

    @Test
    public void verifySearchMemberByTitleAfterAddingSuccessful() {
        LOGGER.info("Verify User search member by title after adding successful");
        //TODO: implement later
    }

    @Test
    public void verifyViewMemberByIIDAfterAddingSuccessful() {
        LOGGER.info("Verify User view member by id after adding successful");
        addMemberPageObject = homePageObject.clickOnAddMemberMenu();
        addMemberPageObject.inputMemberInfo(memberModel);
        addMemberPageObject.checkOnAgreeCheckBox();
        addMemberPageObject.clickOnSubmitButton();
        String memberID = addMemberPageObject.getIdOfNewMember();
        viewMemberPageObject = addMemberPageObject.clickOnViewMemberMenu();
        viewMemberPageObject.searchMemberByID(memberID);
        viewMemberPageObject.validateViewMemberDisplayCorrectly(memberModel);
    }

    @AfterEach
    public void afterMethod() {
        LOGGER.info("Close the driver");
        closeBrowser(driver);
    }
}
