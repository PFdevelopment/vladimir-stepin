package Categories;

import Settings.FunctionalTest;
import UtilityClasses.Category;
import UtilityClasses.ReadWrite;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.hamcrest.CoreMatchers;

public class CreateCategory extends FunctionalTest {
    public boolean createCategory() throws AssertionError {
        /* One way
        Map<String, String> category = new HashMap<String, String>();
        category.put("id", "pcdcats1234ss3w3s55");
        category.put("name", "Test Category");
        */
        Category category = new Category();
        category.setId("1234");
        category.setName("Test Category");
        // Getting response from the server
        Response response = RestAssured.given().pathParam("id", 1234).when().log().all().get("categories/{id}");
        ResponseBody responseBody = response.getBody();
        if (responseBody.asString().contains("1234bn")) {
            System.out.println("Error. The category with this id already exists.");
            response.then().statusCode(404);
            response.then().assertThat().body(CoreMatchers.containsString("BadRequest"));
        } else {
            // Checks the status
            response = RestAssured.given().contentType(ContentType.JSON).body(category).when().log().all().post("categories");
            response.then().statusCode(201);
            response.then().assertThat().body(CoreMatchers.containsString("Test Category"));
            responseBody = response.getBody();
            String textOfBody = responseBody.asString();
            String fileName = "category_id.txt";

            ReadWrite.write(fileName, textOfBody);

            response.then().statusCode(201);
        }
        return true;
    }
}
