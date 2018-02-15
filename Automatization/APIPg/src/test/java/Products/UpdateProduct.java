package Products;

import Settings.FunctionalTest;
import UtilityClasses.Product;
import UtilityClasses.ReadWrite;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.hamcrest.CoreMatchers;

public class UpdateProduct extends FunctionalTest {
    public void updateProduct() {
        Product product = new Product();
        product.setName("Updated Product");
        product.setType("Mobile Phone");
        product.setUpc("1234567");
        product.setPrice(13999.99);
        product.setDescription("New model of phone.");
        product.setModel("M450");

        String fileName = "product_id.txt";
        String id = ReadWrite.read(fileName);

        Response response = RestAssured.given().pathParam("id", id).contentType(ContentType.JSON).body(product).when().log().all().put("products/{id}");

        response.then().statusCode(200);

        response.then().assertThat().body(CoreMatchers.containsString("Updated Product"));
    }
}
