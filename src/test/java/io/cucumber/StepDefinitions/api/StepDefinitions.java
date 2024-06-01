package io.cucumber.StepDefinitions.api;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;

public class StepDefinitions {
    private static final String BASE_URL = "https://dummyapi.io/data/v1/";
    private String appId;
    private Response response;
    private JSONObject requestBody;
    private String endpoint;

    @Given("the app-id is {string}")
    public void the_app_id_is(String appId) {
        this.appId = appId;
    }

    @And("the Content-Type is {string}")
    public void the_content_type_is(String contentType) {
        given().contentType(ContentType.JSON);
    }

    @When("I send a DELETE request to {string}")
    public void i_send_a_delete_request_to(String endpoint) {
        response = given()
                .header("app-id", appId)
                .when()
                .delete(BASE_URL + endpoint);
    }

    @When("I send a GET request to {string}")
    public void i_send_a_get_request_to(String endpoint) {
        response = given()
                .header("app-id", appId)
                .when()
                .get(BASE_URL + endpoint);
    }

    @When("I send a PUT request to {string}")
    public void i_send_a_put_request_to(String endpoint) {
        this.endpoint = endpoint;
        requestBody = new JSONObject(); // Inisialisasi requestBody di sini
    }

    @When("I update the user {string} to {string}")
    public void i_update_the_user_attribute_to(String attribute, String value) {
        requestBody.put(attribute, value);
        response = given()
                .header("app-id", appId)
                .contentType("application/json")
                .body(requestBody.toString())
                .when()
                .put(BASE_URL + endpoint);
    }
    @Then("the {string} should be {string}")
    public void the_attribute_should_be(String attribute, String value) {
        response.then().assertThat().body(attribute, equalTo(value));
    }

    @Then("the response status code should be {int}")
    public void the_response_status_code_should_be(int statusCode) {
        response.then().assertThat().statusCode(statusCode);
    }

    @Then("the response body should have error {string}")
    public void the_response_body_should_have_error(String error) {
        response.then().assertThat().body("error", equalTo(error));
    }

    @Then("the response body should have data with size {int}")
    public void the_response_body_should_have_data_with_size(int size) {
        response.then().assertThat().body("data", hasSize(size));
    }

    @Then("the response body should have id {string}")
    public void the_response_body_should_have_id(String id) {
        response.then().assertThat().body("id", equalTo(id));
    }
}
