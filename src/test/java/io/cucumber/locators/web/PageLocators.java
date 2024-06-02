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

    @FindBy(id = "finish")
    public WebElement finishButton;

    // Find element in checkout complete
    @FindBy(xpath = "//h2[@class='complete-header']")
    public WebElement completeHeader;

    @FindBy(xpath = "//div[@class='complete-text']")
    public WebElement completeText;

    @FindBy(id = "back-to-products")
    public WebElement backToHomeButton;

    @FindBy(className = "inventory_details_name")
    public WebElement productName;

    @FindBy(className = "inventory_details_desc")
    public WebElement productDescription;

    @FindBy(className = "inventory_details_price")
    public WebElement productPrice;

    @FindBy(className = "btn_inventory")
    public WebElement addToCartButton;

    @FindBy(xpath = "//button[@id='remove-sauce-labs-backpack']")
    public WebElement removeButton;

    @FindBy(className = "shopping_cart_link")
    public WebElement CartEmptyButton;

    @FindBy(className = "shopping_cart_badge")
    public WebElement cartBadge;

    // Find element in cart
    @FindBy(xpath = "//button[@data-test='continue-shopping']")
    public WebElement continueShoppingButton;

    // Locator for Sauce Labs Backpack image
    @FindBy(xpath = "//img[@data-test='inventory-item-sauce-labs-backpack-img']")
    public WebElement sauceLabsBackpackImage;

    @FindBy(xpath = "//button[@class='btn btn_primary btn_small btn_inventory' and @data-test='add-to-cart']\n")
    public WebElement addToCartButtonDetailProduct;

    @FindBy(xpath = "//button[@class='btn btn_secondary btn_small btn_inventory' and @data-test='remove']\n")
    public WebElement removeButtonDetailProduct;

    @FindBy(xpath = "//span[@data-test='shopping-cart-badge']")
    public WebElement cartItemCountElement;

    @FindBy(xpath = "//a[@class='shopping_cart_link' and @data-test='shopping-cart-link']")
    public WebElement cartIcon;

    @FindBy(xpath = "//div[text()='Sauce Labs Backpack']")
    public WebElement sauceLabsBackpackCartItem;

    @FindBy(xpath = "//span[@class='shopping_cart_badge' and @data-test='shopping-cart-badge']")
    public WebElement shoppingCartBadge;

    // Constructor to initialize elements
    public PageLocators(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
