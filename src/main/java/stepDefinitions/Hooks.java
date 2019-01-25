package stepDefinitions;

import cucumber.api.java.Before;
import io.restassured.RestAssured;
import utils.Constants;


public class Hooks {

    //"@Before" hook runs at the beginning for every Cucumber scenario
    @Before
    public void initialization(){
        //take the URI provided in Constants class
        RestAssured.baseURI= Constants.BASE_URI;
    }
}
