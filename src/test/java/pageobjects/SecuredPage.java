/*
 * Copyright (c) 2023. Java Web Test Automation project.
 * Homework assessment.
 * Created by Azat Ann.
 */
package pageobjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

import static org.junit.jupiter.api.Assertions.fail;
import static pageobjects.BasePage.actions;

public class SecuredPage extends LoadableComponent<SecuredPage> {

    private final WebDriver driver;
    private final LoadableComponent<?> parent;
    private final String username;
    private final String password;
    private final By accountTitle = By.id("box-account");

    //public By purpleDuck1 = By.xpath("//div[@id='box-most-popular1']//*[@alt='Purple Duck']");

    private final By logotypeLocator = By.id("logotype-wrapper");
    private final By searchBoxLocator = By.xpath("//input[@name='query']");
    private final By rubberDucksCatLocator = By.xpath("//*[@id='site-menu-wrapper']//a[text()='Rubber Ducks']");
    private final By subCategoryLocator = By.xpath("//*[@class='category-2']//*[text()='Subcategory']");
    private final By logoutBtnLocator = By.xpath("//div[@class='content']//*[text()='Logout']");
    private final By customerServiceLocator = By.xpath("//div[@class='content']//*[text()='Customer Service']");
    private final By titleAcmeLocator = By.xpath("//*[@title='ACME Corp.']");

    public WebElement searchBox(){
        return driver.findElement(searchBoxLocator);
    }
    public WebElement productCat(){
        return driver.findElement(rubberDucksCatLocator);
    }
    public WebElement subCategory(){
        return driver.findElement(subCategoryLocator);
    }

    public WebElement logoutBtn(){
        return driver.findElement(logoutBtnLocator);
    }
    public WebElement customerService(){
        return driver.findElement(customerServiceLocator);
    }
    public WebElement titleAcme(){
        return driver.findElement(titleAcmeLocator);
    }

    public SecuredPage(WebDriver driver, LoadableComponent<?> parent, String username, String password) {

        this.driver = driver;
        this.parent = parent;
        this.username = username;
        this.password = password;

        // This call sets the WebElement fields.
        PageFactory.initElements(driver, this);
    }

    public WebElement accountTitle() { return driver.findElement(accountTitle);}

    public void searchProduct(String productValue){
        searchBox().sendKeys(productValue, Keys.ENTER);
    }
    public void productCatBtn(){
        actions.moveToElement(productCat()).click(subCategory());

    }
    public void customer(){
        customerService().click();
    }
    public void logout(){
        actions.moveToElement(logoutBtn()).click();
    }


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
