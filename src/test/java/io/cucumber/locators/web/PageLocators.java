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

    // Constructor to initialize elements
    public PageLocators(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
