package stepDefinitions;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.asserts.SoftAssert;
import utils.API_Utils;
import utils.Constants;
import utils.Data;

import static io.restassured.RestAssured.given;

public class DELETERequestStepDef {

    RequestSpecification requestSpecification;
    Response response;

    @When("^User wants to delete a book by submitting valid id$")
    public void user_wants_to_delete_a_book_by_submitting_valid_id() {
        System.out.println("======Sending DELETE request using the following body======");
        //use the same ID generated following the POST request, to remove the book from library
        requestSpecification = given().body("{\"ID\": \"" + Data.getID() + "\"}").log().body();
        response = requestSpecification.when().get(Constants.DELETE_RESOURCE_PATH);
        System.out.println();
    }

    @Then("^Response with status code (\\d+) and message \"([^\"]*)\" should be visible$")
    public void response_with_status_code_and_message(int expectedStatusCode, String expectedMessage) {
        SoftAssert assertion = new SoftAssert();
        System.out.println("======Printing the body of the DELETE response======");
        response.then().log().body().extract().response();
        JsonPath js = API_Utils.rawToJson(response);
        String actualMsg = js.get("msg");
        int statusCode = response.getStatusCode();
        assertion.assertEquals(statusCode, expectedStatusCode);
        assertion.assertEquals(actualMsg, expectedMessage);
        assertion.assertAll();
    }
}
