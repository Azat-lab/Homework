/*
 * Copyright (c) 2023. Java Web Test Automation project.
 * Homework assessment.
 * Created by Azat Ann.
 */
package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class BasePage extends LoadableComponent<BasePage> {
        protected static WebDriver driver;
        protected static Actions actions;
        private String userEmail;
        private String userPassword;

        // The login page contains several HTML elements that will be represented as WebElements.
        // The locators for these elements should only be defined once.
        protected By usernameLocator = By.name("email");
        protected By passwordLocator = By.name("password");
        protected By loginButtonLocator = By.name("login");

        //link create new customer.
        protected By createNewCustomerLocator = By.xpath("//*[text()='New customers click here']");
        private final By loginTitle = By.id("box-account-login");


        private By searchFieldLocator = By.xpath("//*[@name='query']");

        public WebElement searchField() {
                return driver.findElement(searchFieldLocator);
        }

        public WebElement loginTitle() {
                return driver.findElement(loginTitle);
        }

        public WebElement createCustomer(){
                return driver.findElement(createNewCustomerLocator);
        }

        public BasePage(WebDriver driver) {
                this.driver = driver;
                if (!driver.getCurrentUrl().contains("stqa"))
                {
                     throw new IllegalStateException("This is not Sign In Page," +
                                " current page is: " + driver.getCurrentUrl());
                }

                PageFactory.initElements(driver, this);
        }

        public BasePage typeUsername(String username) {
                // This is the only place that "knows" how to enter a username
                WebElement userField = driver.findElement(usernameLocator);
                clearAndType(userField, username);

                // Return the current page object as this action doesn't navigate to a page represented by another PageObject
                return this;
        }

        // The login page allows the user to type their password into the password field
        public BasePage typePassword(String password) {
                // This is the only place that "knows" how to enter a password
                WebElement passwordField = driver.findElement(passwordLocator);
                clearAndType(passwordField, password);

                // Return the current page object as this action doesn't navigate to a page represented by another PageObject
                return this;
        }

        // The login page allows the user to submit the login form
        public SecuredPage submitLogin() {
                // This is the only place that submits the login form and expects the destination to be the home page.
                // A separate method should be created for the instance of clicking login whilst expecting a login failure.
                driver.findElement(loginButtonLocator).click();

                // Return a new page object representing the destination. Should the login page ever
                // go somewhere else (for example, a legal disclaimer) then changing the method signature
                // for this method will mean that all tests that rely on this behaviour won't compile.
                return new SecuredPage(driver, new BasePage(driver) , userEmail, userPassword);
        }

        // The login page allows the user to submit the login form knowing that an invalid username and / or password were entered
        public BasePage submitLoginExpectingFailure() {
                // This is the only place that submits the login form and expects the destination to be the login page due to login failure.
                driver.findElement(loginButtonLocator).submit();

                // Return a new page object representing the destination. Should the user ever be navigated to the home page after submiting a login with credentials
                // expected to fail login, the script will fail when it attempts to instantiate the LoginPage PageObject.
                return new BasePage(driver);
        }

        public CreateAccountPage submitCreateBtn(){
                driver.findElement(createNewCustomerLocator).click();
                return new CreateAccountPage();
        }

        /*public CreateAccountPage submitCreateBtn(){
                driver.findElement(createNewCustomerLocator).click();

        }*/

        // Conceptually, the login page offers the user the service of being able to "log into"
        // the application using a username and password.
        public SecuredPage loginAs(String username, String password) {
                // The PageObject methods that enter username, password & submit login have already defined and should not be repeated here.
                typeUsername(username);
                typePassword(password);
                return submitLogin();
        }

        private void clearAndType(WebElement field, String text) {
                field.clear();
                field.sendKeys(text);
        }

        @Override
        protected void load() {
                driver.get("https://litecart.stqa.ru/en/");
                }

        @Override
        protected void isLoaded() throws Error {
                String url = driver.getCurrentUrl();
                assertTrue(url.contains("stqa"));
        }

}
