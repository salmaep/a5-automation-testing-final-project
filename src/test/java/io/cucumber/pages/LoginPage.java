package io.cucumber.pages;

import io.cucumber.locators.web.PageLocators;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;
    private PageLocators locators;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.locators = new PageLocators(driver);  // Initialize Page Locators
    }

    public void enterUsername(String username) {
        locators.usernameField.sendKeys(username);
    }

    public void enterPassword(String password) {
        locators.passwordField.sendKeys(password);
    }

    public void clickLoginButton() {
        locators.loginButton.click();
    }

    public String getErrorMessage() {
        return locators.errorMessage.getText();
    }
}
