package com.contour.pageobject;

import com.contour.core.AbstractPage;
import com.contour.model.MemberModel;
import com.contour.pageui.AddMemberPageUI;
import com.contour.pageui.CommonPageUI;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.contour.constant.MenuEnum.HOME;
import static com.contour.constant.MenuEnum.SEARCH_MEMBER;
import static com.contour.constant.SystemMessage.ADD_USER_SUCCESS_TOAST_MESSAGE;
import static org.assertj.core.api.Assertions.assertThat;

public class AddMemberPageObject extends AbstractPage {
    private static final Logger LOGGER = LoggerFactory.getLogger(AddMemberPageObject.class);
    private WebDriver driver;

    public AddMemberPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void inputMemberInfo(MemberModel memberModel) {
        inputFirstName(memberModel.getFirstName());
        inputLastName(memberModel.getLastName());
        inputTitle(memberModel.getTitle());
        inputCompany(memberModel.getCompany());
        inputPhone(memberModel.getPhoneNumber());
        inputWebSite(memberModel.getWeb());
        inputEmail(memberModel.getEmail());
    }

    public void inputFirstName(String name) {
        LOGGER.info("Input fist name");
        waitForElementVisible(driver, CommonPageUI.FIRST_NAME_FIELD);
        inputText(driver, CommonPageUI.FIRST_NAME_FIELD, name);
    }

    public void inputLastName(String lastName) {
        LOGGER.info("Input last name");
        waitForElementVisible(driver, CommonPageUI.LAST_NAME_FIELD);
        inputText(driver, CommonPageUI.LAST_NAME_FIELD, lastName);
    }

    public void inputTitle(String title) {
        LOGGER.info("Input title");
        waitForElementVisible(driver, CommonPageUI.TITLE_FIELD);
        inputText(driver, CommonPageUI.TITLE_FIELD, title);
    }

    public void inputCompany(String company) {
        LOGGER.info("Input company");
        waitForElementVisible(driver, CommonPageUI.COMPANY_FIELD);
        inputText(driver, CommonPageUI.COMPANY_FIELD, company);
    }

    public void inputPhone(String phone) {
        LOGGER.info("Input phone");
        waitForElementVisible(driver, CommonPageUI.PHONE_FIELD);
        inputText(driver, CommonPageUI.PHONE_FIELD, phone);
    }

    public void inputWebSite(String web) {
        LOGGER.info("Input web site");
        waitForElementVisible(driver, CommonPageUI.WEBSITE_FIELD);
        inputText(driver, CommonPageUI.WEBSITE_FIELD, web);
    }

    public void inputEmail(String email) {
        LOGGER.info("Input email");
        waitForElementVisible(driver, CommonPageUI.EMAIL_FIELD);
        inputText(driver, CommonPageUI.EMAIL_FIELD, email);
    }

    public void checkOnAgreeCheckBox() {
        LOGGER.info("Click on I agree checkbox");
        waitForElementVisible(driver, AddMemberPageUI.AGREE_CHECKBOX);
        checkTheCheckBox(driver, AddMemberPageUI.AGREE_CHECKBOX);
    }

    public void clickOnSubmitButton() {
        LOGGER.info("Click on submit button");
        waitForElementClickable(driver, AddMemberPageUI.SUBMIT_BUTTON);
        clickToElement(driver, AddMemberPageUI.SUBMIT_BUTTON);
    }

    private String getToastSucessMessage() {
        waitForElementVisible(driver, AddMemberPageUI.TOAST_SUCCESS_MESSAGE);
        return getElementText(driver, AddMemberPageUI.TOAST_SUCCESS_MESSAGE);
    }

    public void validateAddMemberSuccessful() {
        LOGGER.info("Validate the Toast message display correctly");
        assertThat(getToastSucessMessage()).contains(ADD_USER_SUCCESS_TOAST_MESSAGE);
    }

    public String getIdOfNewMember() {
        LOGGER.info("Get Index");
        String test = getToastSucessMessage();
        return test.substring(test.lastIndexOf(" ")).trim();
    }

    public HomePageObject clickOnHomeMenu() {
        LOGGER.info("Click on Home menu from Add Member page");
        waitForElementClickable(driver, CommonPageUI.MENU, HOME.getName());
        clickDynamicElement(driver, CommonPageUI.MENU, HOME.getName());
        return PageObjectManager.homePageObject(driver);
    }

    public SearchMemberPageObject clickOnSearchMemberMenu() {
        LOGGER.info("Click on Search Member menu from Add Member page");
        waitForElementClickable(driver, CommonPageUI.MENU, SEARCH_MEMBER.getName());
        clickDynamicElement(driver, CommonPageUI.MENU, SEARCH_MEMBER.getName());
        return PageObjectManager.searchMemberPageObject(driver);
    }
}
