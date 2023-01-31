package com.contour.pageobject;

import com.contour.core.AbstractPage;
import com.contour.pageui.CommonPageUI;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.assertj.core.api.Assertions.assertThat;

public class SearchMemberPageObject extends AbstractPage {
    private static final Logger LOGGER = LoggerFactory.getLogger(SearchMemberPageObject.class);
    private WebDriver driver;

    public SearchMemberPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void searchMemberByValue(String value) {
        LOGGER.info("Search member by {}", value);
        waitForElementVisible(driver, CommonPageUI.SEARCH_FIELD);
        inputText(driver, CommonPageUI.SEARCH_FIELD, value);
        clickToElement(driver, CommonPageUI.SEARCH_BUTTON);
    }

    public void validateMemberNameInResultCorrectly(String name) {
        LOGGER.info("Validate the list of member contain {}", name);
        int row = finds(driver, CommonPageUI.TABLE_ROWS).size();
        assertThat(row).isGreaterThanOrEqualTo(1);
        for (int i = 1; i < row + 1; i++) {
            assertThat(getDynamicText(driver, CommonPageUI.MEMBER_NAME_COLUMN, String.valueOf(i))).contains(name);
        }
    }
}
