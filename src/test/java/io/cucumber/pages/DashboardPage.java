package io.cucumber.pages;

import io.cucumber.locators.web.PageLocators;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DashboardPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private PageLocators locators;

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));  // Set explicit wait for 10 seconds
        this.locators = new PageLocators(driver);  // Initialize Page Locators
    }

    public void clickShoppingCart() {
        locators.shoppingCartButton.click();
    }

    public void clickAddToCartButton() {
        locators.addToCartBackpackButton.click();
    }

    public void clickSauceLabsBackpackImage() {
        locators.sauceLabsBackpackImage.click();
    }

    public boolean isAddToCartButtonDisplayed() {
        return locators.addToCartButton.isDisplayed();
    }

    public boolean isCartButtonEmpty() {
        return locators.CartEmptyButton.isDisplayed();
    }

    public boolean isRemoveButtonDisplayed() {
        return locators.removeButton.isDisplayed();
    }

    public String getCartBadgeText() {
        return locators.cartBadge.getText();
    }

    public void clickRemoveButton() {
        locators.removeButton.click();
    }
}
