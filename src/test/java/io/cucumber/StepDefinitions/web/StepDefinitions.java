package io.cucumber.StepDefinitions.web;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.pages.DashboardPage;
import io.cucumber.pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

public class StepDefinitions {

    private WebDriver driver;
    private LoginPage loginPage;
    private DashboardPage dashboardPage;

    @Given("I am on the login page")
    public void i_am_on_the_login_page() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        loginPage = new LoginPage(driver);
    }

    @Given("the user is logged in to the application with username {string} and password {string}")
    public void the_user_is_logged_in_to_the_application(String username, String password) {
        i_am_on_the_login_page();
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickLoginButton();
        dashboardPage = new DashboardPage(driver);
    }

    @Given("the user is on the dashboard page")
    public void the_user_is_on_the_dashboard_page() {
        // Covered in previous step
    }

    @When("I do not enter username and password")
    public void i_do_not_enter_username_and_password() {
        // No action needed as we are not entering anything
    }

    @Then("I should see a username is required error message")
    public void i_should_see_a_username_is_required_error_message() {
        String expectedErrorMessage = "You need Username & Password!";
        String actualErrorMessage = loginPage.getErrorMessage();
        assertEquals(expectedErrorMessage, actualErrorMessage);
    }

    @When("I enter registered username with incorrect password")
    public void i_enter_registered_username_with_incorrect_password() {
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("incorrectPassword");
        loginPage.clickLoginButton();
    }

    @Then("I should see an error message for incorrect password")
    public void i_should_see_an_error_message_for_incorrect_password() {
        String expectedErrorMessage = "Username and password do not match any user in this service!";
        String actualErrorMessage = loginPage.getErrorMessage();
        assertEquals(expectedErrorMessage, actualErrorMessage);
    }

    @When("I enter {string} and {string}")
    public void i_enter_username_and_password(String username, String password) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
    }

    @When("I click the login button")
    public void i_click_the_login_button() {
        loginPage.clickLoginButton();
    }

    @Then("I should be redirected to the dashboard page")
    public void i_should_be_redirected_to_the_dashboard_page() {
        String currentUrl = driver.getCurrentUrl();
        assert currentUrl.contains("inventory");
    }

    @Then("I should see the error message {string}")
    public void i_should_see_the_error_message(String expectedErrorMessage) {
        String actualErrorMessage = loginPage.getErrorMessage();
        assertEquals(expectedErrorMessage, actualErrorMessage);
    }

    @When("the user clicks the menu icon on the top left corner of the dashboard")
    public void the_user_clicks_the_menu_icon_on_the_top_left_corner_of_the_dashboard() {
        dashboardPage.clickMenuIcon();
    }

    @And("the user clicks the All Items menu")
    public void the_user_clicks_the_all_items_menu() {
        dashboardPage.clickAllItemsMenu();
    }

    @And("the user clicks the About menu")
    public void the_user_clicks_the_about_menu() {
        dashboardPage.clickAboutMenu();
    }

    @When("the user clicks the Logout menu")
    public void the_user_clicks_the_Logout_menu() {
        dashboardPage.clickLogoutMenu();
    }

    @Then("the user should be redirected to the {string} page")
    public void the_user_should_be_redirected_to_the(String pagename) {
        String currentUrl = driver.getCurrentUrl();
        String expectedUrl;

        // Menentukan URL yang diharapkan berdasarkan nama halaman
        switch (pagename.toLowerCase()) {
            case "login":
                expectedUrl = "https://www.saucedemo.com/";
                break;
            case "inventory":
                expectedUrl = "https://www.saucedemo.com/inventory.html";
                break;
            case "about":
                expectedUrl = "https://saucelabs.com/";
                break;
            default:
                throw new IllegalArgumentException("Invalid page name: " + pagename);
        }

        assertEquals(expectedUrl, currentUrl);
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
