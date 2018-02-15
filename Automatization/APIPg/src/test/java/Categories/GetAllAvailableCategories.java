package Categories;

import Settings.FunctionalTest;
import UtilityClasses.ReadWrite;
import io.restassured.RestAssured;
import io.restassured.config.LogConfig;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.hamcrest.CoreMatchers;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Date;

public class GetAllAvailableCategories extends FunctionalTest {
    // Displays all available categories and checks the status of response
    public void test_getAllAvailableCategories() {
        // Text LOG activating
        PrintStream logFile;
        try {
            logFile = new PrintStream(new File("log.txt"));
            RestAssured.config = RestAssured.config().logConfig(new LogConfig().defaultStream(logFile));
        } catch (IOException e) {
            e.getMessage();
        }
        // Retrieve the body of the response
        Response response = RestAssured.given().when().log().all().get("categories");
        ResponseBody responseBody = response.getBody();

        // Checks the response code
        response.then().statusCode(200);

        // Checks that the response contains id
        response.then().assertThat().body("data.id", CoreMatchers.hasItem(id));

    }
}
