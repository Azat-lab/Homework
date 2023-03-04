/*
 * Copyright (c) 2023. Java Web Test Automation project.
 * Homework assessment.
 * Created by Azat Ann.
 */

package config;

import io.github.bonigarcia.seljup.SeleniumJupiter;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageobjects.BasePage;
import pageobjects.CreateAccountPage;
import pageobjects.SecuredPage;

import java.time.Duration;

import static utils.PropertiesManager.properties;

@ExtendWith(SeleniumJupiter.class)
public class BaseTest {
    private static final int TIMEOUT = Integer.parseInt( properties.getString("timeout"));
    private static final String URL =  properties.getString("url");
    public static ChromeDriver driver;
    public static BasePage basePage;
    public static SecuredPage securedPage;
    public static CreateAccountPage createAccountPage;
    //public static ProductPage productPage;

    public BaseTest(WebDriver driver) {
        BaseTest.driver = (ChromeDriver) driver;
    }

    @BeforeAll
    public static void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TIMEOUT));
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(TIMEOUT));
        driver.get(URL);
        basePage = new BasePage(driver);
    }

    @AfterAll
    public static void finishTest() {
        driver.quit();
    }
}