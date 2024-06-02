package io.cucumber.pages;

import io.cucumber.locators.web.PageLocators;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductDetailPage {
    private WebDriver driver;
    private PageLocators locators;

    public ProductDetailPage(WebDriver driver) {
        this.driver = driver;
        locators = new PageLocators(driver);
    }

    public String getProductName() {
        return locators.productName.getText();
    }

    public String getProductDescription() {
        return locators.productDescription.getText();
    }

    public String getProductPrice() {
        return locators.productPrice.getText();
    }

    public boolean isAddToCartButtonDisplayed() {
        return locators.addToCartButton.isDisplayed();
    }
}

