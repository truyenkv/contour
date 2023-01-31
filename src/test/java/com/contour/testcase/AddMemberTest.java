package com.contour.testcase;

import com.contour.core.AbstractTest;
import com.contour.utilities.LoadConfig;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AddMemberTest extends AbstractTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(AddMemberTest.class);
    private WebDriver driver;

    @BeforeEach
    public void beforeMethod(){
        driver = getDriver();
    }

    @AfterEach
    public void afterMethod(){
        closeBrowser(driver);
    }

    @Test
    @Tag("1")
    public void verifyAdNewMember(){
        LOGGER.info("Verify Add New Member");
        System.out.printf(LoadConfig.CONFIG.getPropertyByEnv("url"));
        LOGGER.info("Complete test");
    }
}
