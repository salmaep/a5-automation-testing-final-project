package io.cucumber.locators.web;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebDriver;

public class PageLocators {
    // Locators for LoginPage
    @FindBy(xpath = "//input[@id='user-name']")
    public WebElement usernameField;

    @FindBy(xpath = "//input[@id='password']")
    public WebElement passwordField;

    @FindBy(xpath = "//input[@id='login-button']")
    public WebElement loginButton;

    @FindBy(xpath = "//h3[@data-test='error']")
    public WebElement errorMessage;

    @FindBy(xpath = "//button[@id='react-burger-menu-btn']")
    public WebElement menuIcon;

    @FindBy(xpath = "//a[@id='logout_sidebar_link']")
    public WebElement logoutMenu;

    @FindBy(id = "inventory_sidebar_link")
    public WebElement AllItemsMenu;

    @FindBy(id = "about_sidebar_link")
    public WebElement aboutMenu;

    // Find element in dashboard page
    @FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-backpack']")
    public WebElement addToCartBackpackButton;

    @FindBy(xpath = "//a[@class='shopping_cart_link']")
    public WebElement shoppingCartButton;

    // Find element in cart page
    @FindBy(xpath = "//button[@data-test='checkout']")
    public WebElement checkoutButton;

    // Find element in checkout information page
    @FindBy(id = "cancel")
    public WebElement cancelButton;

    @FindBy(xpath = "//input[@id='first-name']")
    public WebElement firstNameField;

    @FindBy(xpath = "//input[@id='last-name']")
    public WebElement lastNameField;

    @FindBy(xpath = "//input[@id='postal-code']")
    public WebElement postalCodeField;

    @FindBy(xpath = "//h3[@data-test='error']")
    public WebElement errorMessageCheckout;

    // Find element in checkout overview
    @FindBy(xpath = "//div[@data-test='item-quantity']")
    public WebElement cartQuantity;

    @FindBy(xpath = "//div[@data-test='inventory-item-name']")
    public WebElement itemName;

    @FindBy(xpath = "//div[@data-test='payment-info-value']")
    public WebElement paymentInformation;

    @FindBy(xpath = "//div[@data-test='shipping-info-value']")
    public WebElement shippingInformation;

    @FindBy(xpath = "//div[@data-test='total-label']")
    public WebElement priceTotal;

    @FindBy(id = "continue")
    public WebElement continueButton;

    // Constructor to initialize elements
    public PageLocators(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
