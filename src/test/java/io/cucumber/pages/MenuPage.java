package io.cucumber.pages;

import io.cucumber.locators.web.PageLocators;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MenuPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private PageLocators locators;

    public MenuPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));  // Set explicit wait for 10 seconds
        this.locators = new PageLocators(driver);  // Initialize Page Locators
    }

    public void clickMenuIcon() {
        wait.until(ExpectedConditions.elementToBeClickable(locators.menuIcon));
        locators.menuIcon.click();
    }

    public void clickAllItemsMenu() {
        // Ensure the menu is opened before clicking logout
        wait.until(ExpectedConditions.visibilityOf(locators.AllItemsMenu));
        wait.until(ExpectedConditions.elementToBeClickable(locators.AllItemsMenu));
        locators.AllItemsMenu.click();
    }

    public void clickAboutMenu() {
        // Ensure the menu is opened before clicking logout
        wait.until(ExpectedConditions.visibilityOf(locators.aboutMenu));
        wait.until(ExpectedConditions.elementToBeClickable(locators.aboutMenu));
        locators.aboutMenu.click();
    }

    public void clickLogoutMenu() {
        // Ensure the menu is opened before clicking logout
        wait.until(ExpectedConditions.visibilityOf(locators.logoutMenu));
        wait.until(ExpectedConditions.elementToBeClickable(locators.logoutMenu));
        locators.logoutMenu.click();
    }

}
