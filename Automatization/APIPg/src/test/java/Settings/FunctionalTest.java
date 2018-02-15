package Settings;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;


public class FunctionalTest {
    public static String port;
    protected String id = "abcat0010000";
    @BeforeClass
    public static void setup() {
        port = System.getProperty("server.port");

        if (port == null) {
            RestAssured.port = Integer.valueOf(3030);
        } else {
            RestAssured.port = Integer.valueOf(port);
        }

        String basePath = System.getProperty("server.base");

        if (basePath == null) {
            basePath = "/";
        }

        RestAssured.basePath = basePath;

        String baseHost = System.getProperty("server.host");

        if (baseHost == null) {
            baseHost = "http://localhost";
        }

        RestAssured.baseURI = baseHost;
    }

}
