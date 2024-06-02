package io.cucumber.StepDefinitions.web;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.pages.DashboardPage;
import io.cucumber.pages.LoginPage;
import io.cucumber.pages.DetailProductPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.*;

public class StepDefinitions {

    private WebDriver driver;
    private LoginPage loginPage;
    private DashboardPage dashboardPage;
    private DetailProductPage detailProductPage;

    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        loginPage = new LoginPage(driver);
    }

    @Given("the user is logged in to the application with username {string} and password {string}")
    public void the_user_is_logged_in_to_the_application(String username, String password) {
        the_user_is_on_the_login_page();
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickLoginButton();
        dashboardPage = new DashboardPage(driver);
    }

    @Given("the user is on the dashboard page")
    public void the_user_is_on_the_dashboard_page() {
        // Covered in previous step
    }

    @When("the user does not enter username and password")
    public void the_user_does_not_enter_username_and_password() {
        // No action needed as we are not entering anything
    }

    @Then("the user should see a username is required error message")
    public void the_user_should_see_a_username_is_required_error_message() {
        String expectedErrorMessage = "You need Username & Password!";
        String actualErrorMessage = loginPage.getErrorMessage();
        assertEquals(expectedErrorMessage, actualErrorMessage);
    }

    @When("the user enters registered username with incorrect password")
    public void the_user_enters_registered_username_with_incorrect_password() {
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("incorrectPassword");
        loginPage.clickLoginButton();
    }

    @Then("the user should see an error message for incorrect password")
    public void the_user_should_see_an_error_message_for_incorrect_password() {
        String expectedErrorMessage = "Username and password do not match any user in this service!";
        String actualErrorMessage = loginPage.getErrorMessage();
        assertEquals(expectedErrorMessage, actualErrorMessage);
    }

    @When("the user enters {string} and {string}")
    public void the_user_enters_username_and_password(String username, String password) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
    }

    @When("the user clicks the login button")
    public void the_user_clicks_the_login_button() {
        loginPage.clickLoginButton();
    }

    @Then("the user should be redirected to the dashboard page")
    public void the_user_should_be_redirected_to_the_dashboard_page() {
        String currentUrl = driver.getCurrentUrl();
        assert currentUrl.contains("inventory");
    }

    @Then("the user should see the error message {string}")
    public void the_user_should_see_the_error_message(String expectedErrorMessage) {
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

    @Given("the user is on the product detail page for Sauce Labs Backpack")
    public void the_user_is_on_the_product_detail_page_for_sauce_labs_backpack() {
        the_user_is_logged_in_to_the_application("standard_user", "secret_sauce");
        detailProductPage = new DetailProductPage(driver);
        detailProductPage.clickSauceLabsBackpackImage();
    }

    @When("the user clicks the 'Add to cart' button")
    public void the_user_clicks_the_add_to_cart_button() {
        detailProductPage.clickAddToCartButton();
    }

    @Given("the product should be added to the cart")
    public void the_product_should_be_added_to_the_cart() {
        assertTrue(detailProductPage.isProductAddedToCart());
    }

    @Given("the product is already added to the cart")
    public void the_product_is_already_added_to_the_cart() {
        the_user_clicks_the_add_to_cart_button();
        assertTrue(detailProductPage.isProductAddedToCart());
    }

    @Then("the 'Add to cart' button should change to 'Remove'")
    public void the_add_to_cart_button_should_change_to_remove() {
        assertEquals("Remove", detailProductPage.getRemoveButtonText());
    }

    @Then("the cart should show the correct number of items")
    public void the_cart_should_show_the_correct_number_of_items() {
        int expectedItemCount = detailProductPage.getExpectedCartItemCount();
        assertEquals(expectedItemCount, detailProductPage.getActualCartItemCount());
    }

    @When("the user clicks the 'Remove' button")
    public void the_user_clicks_the_remove_button() {
        detailProductPage.clickRemoveButton();
    }

    @Then("the product should be removed from the cart")
    public void the_product_should_be_removed_from_the_cart() {
        assertFalse(detailProductPage.isProductAddedToCart());
    }

    @Then("the 'Remove' button should change to 'Add to cart'")
    public void the_remove_button_should_change_to_add_to_cart() {
        assertEquals("Add to cart", detailProductPage.getAddToCartButtonText());
    }

    @When("the user press the Cart Icon located at the top right corner")
    public void the_user_press_the_cart_icon_located_at_the_top_right_corner() {
        detailProductPage.clickCartIcon();
    }

    @Then("the system displays the Cart page containing the products the user want to buy")
    public void the_system_displays_the_cart_page_containing_the_products_the_user_want_to_buy() {
        assertTrue(detailProductPage.isCartPageDisplayed());
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
