package com.contour.core;

import com.contour.constant.BrowserEnum;
import com.contour.constant.ConfigsEnum;
import com.contour.utilities.LoadConfig;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.contour.constant.ConfigsEnum.BROWSER;

public class AbstractTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(AbstractTest.class);
    private WebDriver driver;
    private BrowserEnum browserEnum;
    public static String browserEnv = System.getProperty(BROWSER.getName());

    protected WebDriver getDriver() {
        if (browserEnv != null) {
            browserEnum = BrowserEnum.valueOf(browserEnv.toUpperCase());
        } else {
            browserEnum = BrowserEnum.CHROME;
        }

        switch (browserEnum) {
            case CHROME:
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case MICROSOFT_EDGE:
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            default:
                LOGGER.error("Invalid browser");

        }
        String site = LoadConfig.CONFIG.getPropertyByEnv(ConfigsEnum.URL.getName());

        driver.manage().window().maximize();
        driver.get(site);
        return driver;
    }

    protected void closeBrowser(WebDriver driver) {
        if (driver != null) {
            driver.quit();
        }
    }
}
