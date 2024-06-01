package io.cucumber.locators.web;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebDriver;

public class PageLocators {

    @FindBy(xpath = "//h3[@data-test='error']")
    public WebElement errorMessage;

    // Locators for DashboardPage
    @FindBy(id = "react-burger-menu-btn")
    public WebElement menuIcon;

    @FindBy(id = "inventory_sidebar_link")
    public WebElement AllItemsMenu;

    @FindBy(id = "about_sidebar_link")
    public WebElement aboutMenu;

    @FindBy(id = "logout_sidebar_link")
    public WebElement logoutMenu;

    // Constructor to initialize elements
    public PageLocators(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
