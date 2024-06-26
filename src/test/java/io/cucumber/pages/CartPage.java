package io.cucumber.pages;

import io.cucumber.locators.web.PageLocators;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private PageLocators locators;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));  // Set explicit wait for 10 seconds
        this.locators = new PageLocators(driver);  // Initialize Page Locators
    }

    public boolean isProductPresent() {
        try {
            return locators.removeButton.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void clickContinueShoppingButton() {
        locators.continueShoppingButton.click();
    }

    public void clickCheckoutButton(){
        locators.checkoutButton.click();
    }

    public void clickCancelButton(){
        wait.until(ExpectedConditions.elementToBeClickable(locators.cancelButton));
        locators.cancelButton.click();
    }

    public boolean isSauceLabsBackpackInCart() {
        try {
            return locators.sauceLabsBackpackCartItem.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

}
