package stepDefinitions;

import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import static org.testng.Assert.*;

public class UserApiSteps {

        private Response response;

        @Given("the base URI is {string}")
        public void the_base_uri_is(String baseUri) {
            RestAssured.baseURI = baseUri;
        }

        @When("I send a GET request to {string}")
        public void i_send_a_get_request_to(String endpoint) {

            response = RestAssured
                    .given()
                    .header("Accept", "application/json")
                    .when()
                    .get(endpoint);

            // Debug (optional but helpful)
            System.out.println("STATUS CODE: " + response.getStatusCode());
            System.out.println("RESPONSE BODY:\n" + response.asPrettyString());
        }

        @Then("the response status code should be {int}")
        public void the_response_status_code_should_be(int statusCode) {
            assertEquals(response.getStatusCode(), statusCode);
        }
    }