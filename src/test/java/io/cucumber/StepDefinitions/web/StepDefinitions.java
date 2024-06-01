package io.cucumber.StepDefinitions.web;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.pages.CartPage;
import io.cucumber.pages.DashboardPage;
import io.cucumber.pages.LoginPage;
import io.cucumber.pages.MenuPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Assert;

import static org.junit.Assert.assertEquals;

public class StepDefinitions {

    private WebDriver driver;
    private LoginPage loginPage;
    private DashboardPage dashboardPage;
    private MenuPage menuPage;
    private CartPage cartPage;

    public String getExpectedUrl(String pagename) {
        switch (pagename.toLowerCase()) {
            case "login":
                return "https://www.saucedemo.com/";
            case "about":
                return "https://saucelabs.com/";
            case "dashboard":
                return "https://www.saucedemo.com/inventory.html";
            case "cart":
                return "https://www.saucedemo.com/cart.html";
            case "checkout":
                return "https://www.saucedemo.com/checkout-step-one.html";
            case "checkout-step-one":
                return "https://www.saucedemo.com/checkout-step-one.html";
            case "checkout overview":
                return "https://www.saucedemo.com/checkout-step-two.html";
            default:
                throw new IllegalArgumentException("Invalid page name: " + pagename);
        }
    }

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
        menuPage = new MenuPage(driver);
    }

    @Given("the user is on the {string} page")
    public void the_user_is_on_the_defined_page(String pagename) {
        String currentUrl = driver.getCurrentUrl();
        String expectedUrl = getExpectedUrl(pagename);
        assertEquals(expectedUrl, currentUrl);
    }

    @Then("the user should be redirected to the {string} page")
    public void the_user_should_be_redirected_to_the(String pagename) {
        String currentUrl = driver.getCurrentUrl();
        String expectedUrl = getExpectedUrl(pagename);
        assertEquals(expectedUrl, currentUrl);
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
        menuPage.clickMenuIcon();
    }

    @And("the user clicks the All Items menu")
    public void the_user_clicks_the_all_items_menu() {
        menuPage.clickAllItemsMenu();
    }

    @And("the user clicks the About menu")
    public void the_user_clicks_the_about_menu() {
        menuPage.clickAboutMenu();
    }

    @When("the user clicks the Logout menu")
    public void the_user_clicks_the_Logout_menu() {
        menuPage.clickLogoutMenu();
    }

    @Given("the user clicks on the Add to Cart button for Sauce Labs Backpack")
    public void the_user_clicks_on_the_add_to_cart_button_for_sauce_labs_backpack() {
        dashboardPage.clickAddToCartButton();
    }


    @When("the user clicks the {string} button on the {string} page")
    public void theUserClicksTheButtonOnThePage(String namebutton, String namepage) {
        String expectedUrl = getExpectedUrl(namepage);
        String currentUrl = driver.getCurrentUrl();
        assertEquals(expectedUrl, currentUrl);
        cartPage = new CartPage(driver);

        if (namebutton.equalsIgnoreCase("shopping cart")) {
            dashboardPage.clickShoppingCart();
        } else if (namebutton.equalsIgnoreCase("checkout")) {
            cartPage.clickCheckoutButton();
        } else if (namebutton.equalsIgnoreCase("cancel")) {
            cartPage.clickCancelButton();
        }
        else {
            throw new IllegalArgumentException("Invalid button name: " + namebutton);
        }
    }

    @And("the user does not fill in all fields on the checkout page")
    public void theUserDoesNotFillInAllFieldsOnTheCheckoutPage() {
    }

    // TEST
    @Given("the user is logged in")
    public void the_user_is_logged_in() {
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");

        loginPage = new LoginPage(driver);
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLoginButton();
    }

    @And("the user is on the Dashboard page")
    public void the_user_is_on_the_dashboard_page() {
        dashboardPage = new DashboardPage(driver);
        Assert.assertTrue(driver.getCurrentUrl().contains("inventory.html"));
    }

    @And("the 'Add to Cart' button is displayed for 'Sauce Labs Backpack'")
    public void the_add_to_cart_button_is_displayed_for_sauce_labs_backpack() {
        Assert.assertTrue(dashboardPage.isAddToCartButtonDisplayed());
    }

    @When("the user clicks on the 'Add to Cart' button for 'Sauce Labs Backpack'")
    public void the_user_clicks_on_add_to_cart_button_for_sauce_labs_backpack() {
        dashboardPage.clickAddToCartButton();
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
