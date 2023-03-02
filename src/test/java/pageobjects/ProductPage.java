/*
 * Copyright (c) 2023. Java Web Test Automation project.
 * Homework assessment.
 * Created by Azat Ann.
 */
package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductPage extends BasePage{

    private final By logotypeLocator = By.xpath("logotype-wrapper");
    private final By searchBoxLocator = By.xpath("//*[@class='input-wrapper']");
    private final By rubberDucksCatLocator = By.xpath("//*[@id='site-menu-wrapper']//a[text()='Rubber Ducks']");
    private final By subCategoryLocator = By.xpath("//*[@class='category-2']//*[text()='Subcategory']");
    private final By accountLocator = By.xpath("//div[@class='content']//*[text()='Account']");
    private final By logoutBtnLocator = By.xpath("//div[@class='content']//*[text()='Logout']");
    private final By customerServiceLocator = By.xpath("//div[@class='content']//*[text()='Customer Service']");
    private final By titleAcmeLocator = By.xpath("//*[@title='ACME Corp.']");
    private final  By mostPopularProducts = (By) driver.findElements(By.id("box-most-popular"));
    private final List<WebElement> campaigns = driver.findElements(By.id("box-campaigns"));
    private final List<WebElement> latestProducts = driver.findElements(By.id("box-latest-products"));

    public ProductPage() {
        super(driver);
    }

    public List<WebElement> popularProducts(){
        return (List<WebElement>) driver.findElement(mostPopularProducts);
    }

    public WebElement logotype(){
        return driver.findElement(logotypeLocator);
    }
    public WebElement searchBox(){
        return driver.findElement(searchBoxLocator);
    }
    public WebElement productCat(){
        return driver.findElement(rubberDucksCatLocator);
    }
    public WebElement subCategory(){
        return driver.findElement(subCategoryLocator);
    }
    public WebElement account(){
        return driver.findElement(accountLocator);
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
        logoutBtn().click();
    }
    public void popularProd(){
        actions.moveToElement((WebElement) popularProducts()).clickAndHold().click();
    }

}
