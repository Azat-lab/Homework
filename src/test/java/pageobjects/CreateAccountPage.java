/*
 * Copyright (c) 2023. Java Web Test Automation project.
 * Homework assessment.
 * Created by Azat Ann.
 */
package pageobjects;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;


public class CreateAccountPage extends BasePage {

    private final By inputTaxIdLocator = By.xpath("//input[@name='tax_id']");
    private final By inputCompanyLocator = By.xpath("//input[@name='company']");
    private final By inputFirstNameLocator = By.xpath("//input[@name='firstname']");
    private final By inputLastNameLocator = By.xpath("//input[@name='lastname']");
    private final By inputAddress1Locator = By.xpath("//input[@name='address1']");
    private final By inputAddress2Locator = By.xpath("//input[@name='address2']");
    private final By inputPostcodeLocator = By.xpath("//input[@name='postcode']");
    private final By inputCityLocator = By.xpath("//input[@name='city']");

    private final By inputCountryLocator = By.xpath("//input[@class='select2-search__field']");

    private final By selectArrowLocator = By.xpath("//span[@class='select2-selection__arrow']");
    private final By selectCountryResultLocator = By.id("select2-country_code-fl-result-4x60-BY");
    private final By inputEmailLocator = By.xpath("//input[@name='email']");
    private final By inputPhoneNumberLocator = By.xpath("//input[@name='phone']");
    private final By inputDesiredPasswordLocator = By.xpath("//input[@name='password']");
    private final By inputConfirmPasswordLocator = By.xpath("//input[@name='confirmed_password']");
    private final By createBtnLocator = By.xpath("//button[@name='create_account']");
   // private final By accountTitle = By.id("create-account");

    public CreateAccountPage() {
        super(BasePage.driver);
    }

    public WebElement inputCountry(){
        return driver.findElement(inputCountryLocator);
    }
    public WebElement selectArrow(){
        return driver.findElement(selectArrowLocator);
    }

    public WebElement taxIdLocator(){
        return driver.findElement(inputTaxIdLocator);
    }
    public WebElement companyLocator(){
        return driver.findElement(inputCompanyLocator);
    }
    public WebElement firstName(){
        return  driver.findElement(inputFirstNameLocator);
    }
    public WebElement lastName(){
        return driver.findElement(inputLastNameLocator);
    }
    public WebElement address(){
        return driver.findElement(inputAddress1Locator);
    }
    public WebElement addressTwo(){
        return driver.findElement(inputAddress2Locator);
    }
    public WebElement postcodeLocator(){
        return  driver.findElement(inputPostcodeLocator);
    }
    public WebElement cityLocator(){
        return driver.findElement(inputCityLocator);
    }
    public WebElement inputEmail(){
        return driver.findElement(inputEmailLocator);
    }
    public WebElement inputPhone(){
        return driver.findElement(inputPhoneNumberLocator);
    }
    public WebElement inputDesiredPassword(){return  driver.findElement(inputDesiredPasswordLocator);}
    public WebElement inputConfirmPassword(){
        return driver.findElement(inputConfirmPasswordLocator);
    }
    public WebElement submitBtn(){ return driver.findElement(createBtnLocator);}


    public void createAccount(String taxValue, String companyValue, String nameValue, String lastnameValue,
                              String addressValue, String anotherAddressValue, String postcodeValue,
                              String cityValue, String countryValue, String emailValue, String phoneValue,
                              String desiredValue, String confirmValue){
        taxIdLocator().sendKeys(taxValue);
        companyLocator().sendKeys(companyValue);
        firstName().sendKeys(nameValue);
        lastName().sendKeys(lastnameValue);
        address().sendKeys(addressValue);
        addressTwo().sendKeys(anotherAddressValue);
        postcodeLocator().sendKeys(postcodeValue);
        cityLocator().sendKeys(cityValue);
        selectArrow().click();
        inputCountry().sendKeys(countryValue, Keys.ENTER);
        inputEmail().sendKeys(emailValue);
        inputPhone().sendKeys(phoneValue);
        inputDesiredPassword().sendKeys(desiredValue);
        inputConfirmPassword().sendKeys(confirmValue);
        submitBtn().click();

    }
    }

