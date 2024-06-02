package io.cucumber.pages;

import io.cucumber.locators.web.PageLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.NoSuchElementException;

import java.time.Duration;

public class DetailProductPage {
    private WebDriver driver;
    private PageLocators locators;
    private WebDriverWait wait;

    public DetailProductPage(WebDriver driver) {
        this.driver = driver;
        this.locators = new PageLocators(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Method to click on the Sauce Labs Backpack image
    public void clickSauceLabsBackpackImage() {
        locators.sauceLabsBackpackImage.click();
    }

    public void clickAddToCartButton() {
        locators.addToCartButtonDetailProduct.click();
    }

    public void clickRemoveButton() {
        wait.until(ExpectedConditions.elementToBeClickable(locators.removeButtonDetailProduct)).click();
    }

    public void clickCartIcon() {
        locators.cartIcon.click();
    }

    public boolean isProductAddedToCart() {
        return locators.removeButtonDetailProduct.isDisplayed();
    }

    public boolean addToCartDisplayed() {
        return locators.addToCartButtonDetailProduct.isDisplayed();
    }

    public String getAddToCartButtonText() {
        return locators.addToCartButtonDetailProduct.getText();
    }

    public String getRemoveButtonText() {
        return locators.removeButtonDetailProduct.getText();
    }

    public int getActualCartItemCount() {
        String itemCountText = locators.cartItemCountElement.getText();
        return Integer.parseInt(itemCountText);
    }

    public boolean isCartBadgeNotPresent() {
        try {
            return !locators.shoppingCartBadge.isDisplayed();
        } catch (NoSuchElementException e) {
            return true; 
        }
    }

    public String getCartBadgeText() {
        try {
            return locators.cartBadge.getText();
        } catch (Exception e) {
            System.out.println("Elemen cartBadge tidak ditemukan.");
            return "";
        }
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
    
    public boolean isCartPageDisplayed() {
        return driver.getCurrentUrl().contains("cart.html");
    }

}
