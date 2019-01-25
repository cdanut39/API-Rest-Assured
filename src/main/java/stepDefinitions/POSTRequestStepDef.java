package stepDefinitions;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.asserts.SoftAssert;
import utils.API_Utils;
import utils.Constants;
import utils.Data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;


public class POSTRequestStepDef {
    //Objects declaration
    Response response;
    RequestSpecification requestSpecification;

    @Given("^User sets the following headers$")
    public void user_uses_the_following_headers(DataTable arg1) {

        //convert the Cucumber DataTable type into a list of maps with key of type String and value of type String
        List<Map<String, String>> data = arg1.asMaps(String.class, String.class);

        //set the header and log it
        requestSpecification = given().header(data.get(0).get("Key"), data.get(0).get("Value"));
    }

    @And("^User sets the following payload$")
    public void user_sets_the_following_payload(DataTable arg1) {


        List<Map<String, String>> data = arg1.asMaps(String.class, String.class);

        //create a HashMap object to set parameters for payload
        HashMap<String, Object> jsonObject = new HashMap<String, Object>();

        jsonObject.put("name", "" + data.get(0).get("name"));
        //use getRandomNumber method to generate always a new ISBN, so a new book is added in the library for each successful POST request
        jsonObject.put("isbn", "" + API_Utils.getRandomNumber(data.get(0).get("isbn")));
        jsonObject.put("aisle", "" + data.get(0).get("aisle"));
        jsonObject.put("author", "" + data.get(0).get("author"));

        //add the body to the request
        requestSpecification.body(jsonObject);
    }

    @When("^User sends POST request$")
    public void user_sends_POST_request() {
        //perform the POST request using the resource path from Constants class
        response = requestSpecification.when().post(Constants.POST_RESOURCE_PATH);
    }

    @Then("^Body should contain the following message \"([^\"]*)\" and status code (\\d+)$")
    public void body_should_contain_the_following_message_and_status_code(String expectedMessage, int expectedStatusCode) {

        //inline validation with the help of RestAssured
        response.then().assertThat().statusCode(expectedStatusCode).body("Msg", equalTo(expectedMessage));

        //validation using SoftAssert from TestNG
        SoftAssert assertion = new SoftAssert();
        System.out.println("======Printing the body of the POST response======");
        response.then().log().body().extract().response();
        System.out.println();
        //convert the raw response into JsonPath using the static method from API_Utils
        JsonPath js = API_Utils.rawToJson(response);

        //store into a String variable the value of the JSON key -->"Msg"
        String actualMsg = js.get("Msg");

        //extract from response body the ID that generated following the POST request
        String Id = js.get("ID");

        //store the id in Data class
        Data.setID(Id);
        int statusCode = response.getStatusCode();

        //validate the response code and the body content
        assertion.assertEquals(statusCode, expectedStatusCode);
        assertion.assertEquals(actualMsg, expectedMessage);
        assertion.assertAll();

    }
}
