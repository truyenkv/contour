package com.contour.core;

import com.contour.constant.BrowserEnum;
import com.contour.utilities.LoadConfig;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static com.contour.constant.ConfigsEnum.*;

public class AbstractTest {
    private WebDriver driver;
    public static String browserEnv = System.getProperty(BROWSER.getName());

    protected WebDriver getDriver() {
        BrowserEnum browserEnum = BrowserEnum.valueOf(browserEnv.toUpperCase());
        switch (browserEnum) {
            case FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case CHROME:
            default:
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
        }
        String site = LoadConfig.CONFIG.getPropertyByEnv(URL.getName());

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
