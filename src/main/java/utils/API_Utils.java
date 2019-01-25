package utils;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.util.Random;

public class API_Utils {
    public static String getRandomNumber(String data) {
        Random random = new Random();
        int bound = 1000000000;
        int randomInteger = random.nextInt(bound);
        int integerFromString = Integer.parseInt(data);
        int intNumber = randomInteger + integerFromString;
        return Integer.toString(intNumber);
    }

    public static JsonPath rawToJson(Response response) {
        String resp = response.asString();
        return new JsonPath(resp);
    }
}
