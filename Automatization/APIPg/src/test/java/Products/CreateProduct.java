package Products;

import Settings.FunctionalTest;
import UtilityClasses.Product;
import UtilityClasses.ReadWrite;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.hamcrest.CoreMatchers;

public class CreateProduct extends FunctionalTest {
   public void createProduct() {
       Product product = new Product();

       product.setName("New Product");
       product.setType("Mobile Phone");
       product.setUpc("1234567");
       product.setPrice(999.99);
       product.setDescription("New model of phone.");
       product.setModel("M450");

       Response response = RestAssured.given().contentType(ContentType.JSON).body(product).when().log().all().post("products");

       ResponseBody responseBody = response.getBody();

       String textOfBody = responseBody.asString();

       String fileName = "product_id.txt";

       ReadWrite.write(fileName, textOfBody);

       response.then().statusCode(201);

       response.then().assertThat().body(CoreMatchers.containsString("New Product"));

   }

}
