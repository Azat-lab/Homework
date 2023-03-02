/*
 * Copyright (c) 2023. Java Web Test Automation project.
 * Homework assessment.
 * Created by Azat Ann.
 */
package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

import static org.junit.jupiter.api.Assertions.fail;

public class SecuredPage extends LoadableComponent<SecuredPage> {

    private final WebDriver driver;
    private final LoadableComponent<?> parent;
    private final String username;
    private final String password;
    public By accountTitle = By.id("box-account");

    public By purpleDuck1 = By.xpath("//div[@id='box-most-popular1']//*[@alt='Purple Duck']");

    public SecuredPage(WebDriver driver, LoadableComponent<?> parent, String username, String password) {

        this.driver = driver;
        this.parent = parent;
        this.username = username;
        this.password = password;

        // This call sets the WebElement fields.
        PageFactory.initElements(driver, this);
    }

    public WebElement accountTitle() { return driver.findElement(accountTitle);}

    public WebElement duck1() {
        return  driver.findElement(purpleDuck1);
    };

    @Override
    protected void load() {
        parent.get();
        String originalUrl = driver.getCurrentUrl();
        driver.findElement(By.name("email")).sendKeys(username);
        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys(password);
        passwordField.submit();

        // Now return to the original URL
        driver.get(originalUrl);
    }

    @Override
    protected void isLoaded() throws Error {
        // If you're signed in, you have the option of picking a different login.
        // Let's check for the presence of that.

        try {
            driver.findElement(By.className("notice success"));
        } catch (NoSuchElementException e) {
            fail("Cannot locate a login notice success message.");
        }
    }
}
