package Categories;

import Settings.FunctionalTest;
import UtilityClasses.Category;
import UtilityClasses.ReadWrite;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.hamcrest.CoreMatchers;

import java.util.Map;
import java.util.HashMap;

public class UpdateCategory extends FunctionalTest {
    public void updateCategory() {
        String fileName = "category_id.txt";
        String id = ReadWrite.read(fileName);
        Map<String, String> category = new HashMap<String, String>();
        category.put("name", "Updated Category");
        category.put("id", id);

        Response response = RestAssured.given().pathParam("id", 1234).contentType(ContentType.JSON).body(category).when().log().all().put("categories/{id}");

        response.then().statusCode(200);

        response.then().assertThat().body(CoreMatchers.containsString("Updated Category"));
    }
}
