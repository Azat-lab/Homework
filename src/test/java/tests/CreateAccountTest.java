/*
 * Copyright (c) 2023. Java Web Test Automation project.
 * Homework assessment.
 * Created by Azat Ann.
 */

package tests;

import config.BaseTest;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import pageobjects.CreateAccountPage;


class CreateAccountTest extends BaseTest {
    public CreateAccountTest(WebDriver driver) {
        super(driver);
    }

    @Test
    void createAccountTicket(){
        createAccountPage = basePage.submitCreateBtn();
        String taxIdLocator = "123456789";
        String companyLocator = "Polymorph com";
        String firstName = "Arti";
        String lastName = "Ann";
        String address = "Platonava 34";
        String addressTwo = "Nemiga 66";
        String postcode = "445566";
        String city = "Minsk";
        String country = "Belarus";
        String inputEmail = "taxi@gmail.com";
        String inputPhone = "+375252552525";
        String desiredPassword = "123456";
        String confirmPassword = "123456";
        CreateAccountPage createAccountPage = new CreateAccountPage();
        createAccountPage.createAccount(taxIdLocator, companyLocator, firstName, lastName,
                address, addressTwo, postcode, city, country, inputEmail, inputPhone,
                desiredPassword, confirmPassword);



    }
}
