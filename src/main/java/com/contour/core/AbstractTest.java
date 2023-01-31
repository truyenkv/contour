package com.contour.core;

import com.contour.utilities.LoadConfig;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AbstractTest {
    private WebDriver driver;
    public static String browserEnv = System.getProperty("browser");

    protected WebDriver getDriver() {
        Browser browser = Browser.valueOf(browserEnv.toUpperCase());
        switch (browser) {
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
        String site = LoadConfig.CONFIG.getPropertyByEnv("url");

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
