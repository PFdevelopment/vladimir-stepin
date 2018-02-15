package Categories;

import Settings.FunctionalTest;
import UtilityClasses.ReadWrite;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

public class DeleteCategory extends FunctionalTest {
    public void deleteCategory() throws AssertionError {
        String fileName = "category_id.txt";
        String id = ReadWrite.read(fileName);
        Response response = RestAssured.given().pathParam("id", id).when().log().all().delete("categories/{id}");

        response.then().statusCode(200);
    }
}
