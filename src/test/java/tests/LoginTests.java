/*
 * Copyright (c) 2023. Java Web Test Automation project.
 * Homework assessment.
 * Created by Azat Ann.
 */
package tests;
import config.BaseTest;
import io.github.bonigarcia.seljup.SeleniumJupiter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;

import static utils.PropertiesManager.properties;

@ExtendWith(SeleniumJupiter.class)
class LoginTests extends BaseTest {
    private final String email =  properties.getString("userEmail");
    private final String password =  properties.getString("userPassword");

    public LoginTests(WebDriver driver) {
        super(driver);
    }

    @Test
    void loginPositiveTest() {
        securedPage = basePage.loginAs(email, password);
        Assertions.assertTrue(securedPage.accountTitle().isDisplayed());
        String productValue = "Red Duck";
        securedPage.searchProduct(productValue);
    }
}
