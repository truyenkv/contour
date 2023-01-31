package com.contour.pageobject;

import com.contour.core.AbstractPage;
import com.contour.model.MemberModel;
import com.contour.pageui.AddMemberPageUI;
import com.contour.pageui.CommonPageUI;
import org.openqa.selenium.WebDriver;

import static com.contour.constant.MenuEnum.HOME;
import static com.contour.constant.SystemMessage.ADD_USER_SUCCESS_TOAST_MESSAGE;
import static org.assertj.core.api.Assertions.assertThat;

public class AddMemberPageObject extends AbstractPage {
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
        waitForElementVisible(driver, CommonPageUI.FIRST_NAME_FIELD);
        inputText(driver, CommonPageUI.FIRST_NAME_FIELD, name);
    }

    public void inputLastName(String lastName) {
        waitForElementVisible(driver, CommonPageUI.LAST_NAME_FIELD);
        inputText(driver, CommonPageUI.LAST_NAME_FIELD, lastName);
    }

    public void inputTitle(String title) {
        waitForElementVisible(driver, CommonPageUI.TITLE_FIELD);
        inputText(driver, CommonPageUI.TITLE_FIELD, title);
    }

    public void inputCompany(String company) {
        waitForElementVisible(driver, CommonPageUI.COMPANY_FIELD);
        inputText(driver, CommonPageUI.COMPANY_FIELD, company);
    }

    public void inputPhone(String phone) {
        waitForElementVisible(driver, CommonPageUI.PHONE_FIELD);
        inputText(driver, CommonPageUI.PHONE_FIELD, phone);
    }

    public void inputWebSite(String web) {
        waitForElementVisible(driver, CommonPageUI.WEBSITE_FIELD);
        inputText(driver, CommonPageUI.WEBSITE_FIELD, web);
    }

    public void inputEmail(String email) {
        waitForElementVisible(driver, CommonPageUI.EMAIL_FIELD);
        inputText(driver, CommonPageUI.EMAIL_FIELD, email);
    }

    public void checkOnAgreeCheckBox() {
        waitForElementVisible(driver, AddMemberPageUI.AGREE_CHECKBOX);
        checkTheCheckBox(driver, AddMemberPageUI.AGREE_CHECKBOX);
    }

    public void clickOnSubmitButton() {
        waitForElementClickable(driver, AddMemberPageUI.SUBMIT_BUTTON);
        clickToElement(driver, AddMemberPageUI.SUBMIT_BUTTON);
    }

    private String getToastSucessMessage() {
        waitForElementVisible(driver, AddMemberPageUI.TOAST_SUCCESS_MESSAGE);
        return getElementText(driver, AddMemberPageUI.TOAST_SUCCESS_MESSAGE);
    }

    public void validateAddMemberSuccessful() {
        assertThat(getToastSucessMessage()).contains(ADD_USER_SUCCESS_TOAST_MESSAGE);
    }

    public String getIdOfNewMember() {
        String test = getToastSucessMessage();
        return test.substring(test.lastIndexOf(" ")).trim();
    }

    public HomePageObject clickOnHomeMenu() {
        waitForElementClickable(driver, CommonPageUI.MENU, HOME.getName());
        clickDynamicElement(driver, CommonPageUI.MENU, HOME.getName());
        return PageObjectManager.homePageObject(driver);
    }
}
