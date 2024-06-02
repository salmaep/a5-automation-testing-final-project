package io.cucumber.pages;

import io.cucumber.locators.web.PageLocators;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutPage {
    private WebDriver driver;
    private PageLocators locators;
    private WebDriverWait wait;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        this.locators = new PageLocators(driver);  // Initialize Page Locators
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(1));
    }

    public void enterFirstName(String firstname) {
        locators.firstNameField.sendKeys(firstname);
    }

    public void enterLastName(String lastname) {
        locators.lastNameField.sendKeys(lastname);
    }

    public String getCartQuantity() {
        wait.until(ExpectedConditions.visibilityOf(locators.cartQuantity));
        return locators.cartQuantity.getText();
    }

    public String getItemName() {
        wait.until(ExpectedConditions.visibilityOf(locators.itemName));
        return locators.itemName.getText();
    }

    public String getPaymentInformation() {
        wait.until(ExpectedConditions.visibilityOf(locators.paymentInformation));
        return locators.paymentInformation.getText();
    }

    public String getShippingInformation() {
        wait.until(ExpectedConditions.visibilityOf(locators.shippingInformation));
        return locators.shippingInformation.getText();
    }

    public String getPriceTotal() {
        wait.until(ExpectedConditions.visibilityOf(locators.priceTotal));
        return locators.priceTotal.getText();
    }

    public void clickContinueButton() {
        locators.continueButton.click();
    }

    public void enterPostalCode(String postalcode) {
        locators.postalCodeField.sendKeys(postalcode);
    }
}
