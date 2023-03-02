/*
 * Copyright (c) 2023. Java Web Test Automation project.
 * Homework assessment.
 * Created by Azat Ann.
 */
package tests;

import config.BaseTest;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import pageobjects.ProductPage;

class ProductPageTest extends BaseTest {
    public ProductPageTest(WebDriver driver) {
        super(driver);
    }
    @Test
    void searchProduct(){
        String productValue = "Red Duck";
        ProductPage productPage = new ProductPage();
        productPage.searchProduct(productValue);
    }
}
