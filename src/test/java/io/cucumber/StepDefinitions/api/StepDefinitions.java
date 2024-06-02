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
import static org.hamcrest.Matchers.matchesPattern;

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

    @When("I send a POST request to {string} with the following body:")
    public void i_send_a_post_request_to_with_the_following_body(String endpoint, String requestBody) {
        JSONObject jsonBody = new JSONObject(requestBody);
        this.endpoint = endpoint;
        response = given()
                .header("app-id", appId)
                .contentType(ContentType.JSON)
                .body(jsonBody.toString())
                .when()
                .post(BASE_URL + endpoint);

        System.out.println("Request Body: " + jsonBody.toString());
        System.out.println("Response Body: " + response.getBody().asString());
    }

    @When("I send a DELETE request to {string}")
    public void i_send_a_delete_request_to(String endpoint) {
        response = given()
                .header("app-id", appId)
                .when()
                .delete(BASE_URL + endpoint);

        System.out.println("Response Body: " + response.getBody().asString());
    }

    @When("I send a GET request to {string}")
    public void i_send_a_get_request_to(String endpoint) {
        response = given()
                .header("app-id", appId)
                .when()
                .get(BASE_URL + endpoint);

        System.out.println("Response Body: " + response.getBody().asString());
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

        System.out.println("Request Body: " + requestBody.toString());
        System.out.println("Response Body: " + response.getBody().asString());
    }

    @Then("the {string} should be {string}")
    public void the_attribute_should_be(String attribute, String value) {
        response.then().assertThat().body(attribute, equalTo(value));
    }

    @Then("the response status code should be {int}")
    public void the_response_status_code_should_be(int statusCode) {
        try {
            response.then().assertThat().statusCode(statusCode);
        } catch (AssertionError e) {
            System.out.println("Response Body: " + response.getBody().asString());
            throw e;
        }
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

    @And("the response body should contain the following:")
    public void the_response_body_should_contain_the_following(String expectedResponseBody) {
        JSONObject expectedJsonBody = new JSONObject(expectedResponseBody);
        for (String key : expectedJsonBody.keySet()) {
            if (expectedJsonBody.get(key) instanceof JSONObject) {
                for (String subKey : ((JSONObject) expectedJsonBody.get(key)).keySet()) {
                    response.then().assertThat().body(key + "." + subKey, equalTo(((JSONObject) expectedJsonBody.get(key)).get(subKey)));
                }
            } else {
                response.then().assertThat().body(key, equalTo(expectedJsonBody.get(key)));
            }
        }
    }

    @And("the response body should have valid registerDate and updatedDate")
    public void the_response_body_should_have_valid_registerDate_and_updatedDate() {
        String datePattern = "\\d{4}-\\d{2}-\\d{2}T\\d{2}:\\d{2}:\\d{2}\\.\\d{3}Z";
        response.then().assertThat().body("registerDate", matchesPattern(datePattern));
        response.then().assertThat().body("updatedDate", matchesPattern(datePattern));
    }

    @And("the response body should have a valid id")
    public void the_response_body_should_have_a_valid_id() {
        String idPattern = "[a-f0-9]{24}";
        response.then().assertThat().body("id", matchesPattern(idPattern));
    }
}
