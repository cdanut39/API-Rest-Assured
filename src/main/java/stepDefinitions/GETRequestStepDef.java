package stepDefinitions;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.asserts.SoftAssert;
import utils.API_Utils;
import utils.Constants;
import utils.Data;

import static io.restassured.RestAssured.when;

public class GETRequestStepDef extends Data {

    Response response;

    @When("^User wants to get a book by submitting valid id$")
    public void user_wants_to_get_a_book_by_submitting_valid_id() {
        System.out.println("======Sending GET request using the ID: "+Data.getID()+"======");
        //use the ID stored earlier in Data class the access the information about the book
        response = when().get(Constants.GET_RESOURCE_PATH + Data.getID());
    }

    @Then("^Status code should be (\\d+) and isbn should be available$")
    public void status_code_should_be_and_isbn_should_be_available(int statusCode) {
        SoftAssert assertion = new SoftAssert();
        System.out.println("======Printing the body of the GET response======");
        response.then().log().body().extract().response();
        JsonPath js = API_Utils.rawToJson(response);
        String isbn = js.get("[0].isbn");
        assertion.assertEquals(response.getStatusCode(), statusCode);
        assertion.assertNotNull(isbn);
        assertion.assertAll();
    }
}
