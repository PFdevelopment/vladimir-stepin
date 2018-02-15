package TestExecutor;
import Categories.*;
import HealthCheck.HealthCheck;
import Products.*;
import Services.*;
import Stores.*;
import Settings.FunctionalTest;
import UtilityClasses.ReadWrite;
import io.restassured.RestAssured;
import io.restassured.config.LogConfig;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import Version.CurrentVersion;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Date;

public class TestExec extends FunctionalTest
{
    private static final Logger LOGGER = LogManager.getLogger(TestExec.class.getName());
    // Getting all available categories
    @Test(priority = 1)
    public void getAllAvalaibleCats() {
        try{
            new GetAllAvailableCategories().test_getAllAvailableCategories();
        } catch (AssertionError error) {
            LOGGER.error("*** \nGet All Available Categories Test Failed. Error message: " + "\n" + error.getMessage() + "\n ***");
            Assert.fail("Test failed.");
        }

    }
    // Getting an explicit category
    @Test(priority = 2)
    public void getExplicitCat() {
        try{
            new GetExplicitCategory().test_getExplicitCategory();
        } catch (AssertionError error) {
            LOGGER.error("*** \nGet Explicit Category  Test Failed. Error message: " + "\n" + error.getMessage() + "\n ***");
            Assert.fail("Test failed.");
        }
    }

    // Checking the erratic request
    @Test(priority = 3)
    public void getInvalidCat() {
        try{
            new GetInvalidCategory().test_getInvalidCategory();
        } catch (AssertionError error) {
            LOGGER.error("*** \nGet Category with Wrong ID Test Failed. Error message: " + "\n" + error.getMessage() + "\n ***");
            Assert.fail("Test failed.");
        }
    }

    // Checks creating of new category
    @Test(priority = 4)
    public void createCat() {
        try{
            new CreateCategory().createCategory();
        } catch (AssertionError error) {
            LOGGER.error("*** \nCreate Category Test Failed. Error message: " + "\n" + error.getMessage() + "\n ***");
            Assert.fail("Test failed.");
        }

    }

    // Updating category
    @Test(priority = 5)
    public void updateCat() {
        try{
            new UpdateCategory().updateCategory();
        } catch (AssertionError error) {
            LOGGER.error("*** \nUpdate Category Test Failed. Error message: " + "\n" + error.getMessage() + "\n ***");
            Assert.fail("Test failed.");
        }
        new UpdateCategory().updateCategory();
    }

    // Deleting category
    @Test(priority = 6)
    public void deleteCat() {
        try{
            new DeleteCategory().deleteCategory();
        } catch (AssertionError error) {
            LOGGER.error("*** \nDelete Category Test Failed. Error message: " + "\n" + error.getMessage() + "\n ***");
            Assert.fail("Test failed.");
        }
    }

    // All available stores
    @Test(priority = 7)
    public void getAllAvailableStores() {
        try{
            new GetAllAvailableStores().getAllAvailableStores();
        } catch (AssertionError error) {
            LOGGER.error("*** \nGet All Available Stores Test Failed. Error message: " + "\n" + error.getMessage() + "\n ***");
            Assert.fail("Test failed.");
        }
    }

    // Create store
    @Test(priority = 8)
    public void createStore() {
        try{
            new CreateStore().createStore();
        } catch (AssertionError error) {
            LOGGER.error("*** \nCreate Store Test Failed. Error message: " + "\n" + error.getMessage() + "\n ***");
            Assert.fail("Test failed.");
        }

    }

    // Get exact store
    @Test(priority = 9)
    public void getExplicitStore() {
        try{
            new GetExplicitStore().getExplicitStore();
        } catch (AssertionError error) {
            LOGGER.error("*** \nGet Explicit Store Test Failed. Error message: " + "\n" + error.getMessage() + "\n ***");
            Assert.fail("Test failed.");
        }
    }

    // Update store
    @Test(priority = 10)
    public void updateStore() {
        try{
            new UpdateStore().updateStore();
        } catch (AssertionError error) {
            LOGGER.error("*** \nUpdate Store Test Failed. Error message: " + "\n" + error.getMessage() + "\n ***");
            Assert.fail("Test failed.");
        }
    }

    // Delete store
    @Test(priority = 11)
    public void deleteStore() {
        try{
            new DeleteStore().deleteStore();
        } catch (AssertionError error) {
            LOGGER.error("*** \nDelete Store Test Failed. Error message: " + "\n" + error.getMessage() + "\n ***");
            Assert.fail("Test failed.");
        }
    }

    // Get wrong store
    @Test(priority = 12)
    public void getInvalidStore() {
        try{
            new GetInvalidStore().getInvalidStore();
        } catch (AssertionError error) {
            LOGGER.error("*** \nGet Store with Wrong ID Test Failed. Error message: " + "\n" + error.getMessage() + "\n ***");
            Assert.fail("Test failed.");
        }
    }

    // Get all available products
    @Test(priority = 13)
    public void getAllvailableProducts() {
        try{
            new GetAllAvailableProducts().test_getAllAvailableProducts();
        } catch (AssertionError error) {
            LOGGER.error("*** \nGet All Available Products Test Failed. Error message: " + "\n" + error.getMessage() + "\n ***");
            Assert.fail("Test failed.");
        }
    }

    // Create new product
    @Test(priority = 14)
    public void createProduct() {
        try{
            new CreateProduct().createProduct();
        } catch (AssertionError error) {
            LOGGER.error("*** \nCreate Product Test Failed. Error message: " + "\n" + error.getMessage() + "\n ***");
            Assert.fail("Test failed.");
        }
    }

    // Get exact product
    @Test(priority = 15)
    public void getExplicitProduct() {
        try{
            new GetExplicitProduct().getExplicitProduct();
        } catch (AssertionError error) {
            LOGGER.error("*** \nGet Explicit Product Test Failed. Error message: " + "\n" + error.getMessage() + "\n ***");
            Assert.fail("Test failed.");
        }
    }

    // Update product
    @Test(priority = 16)
    public void updateProduct() {
        try{
            new UpdateProduct().updateProduct();
        } catch (AssertionError error) {
            LOGGER.error("*** \nUpdate Product Test Failed. Error message: " + "\n" + error.getMessage() + "\n ***");
            Assert.fail("Test failed.");
        }
    }

    // Delete Product
    @Test(priority = 17)
    public void deleteProduct() {
        try{
            new DeleteProduct().deleteProduct();
        } catch (AssertionError error) {
            LOGGER.error("*** \nDelete Product Test Failed. Error message: " + "\n" + error.getMessage() + "\n ***");
            Assert.fail("Test failed.");
        }
    }

    // Get all available Services
    @Test(priority = 18)
    public void getAllAvailableServices() {
        try{
            new GetAllAvailableServices().getAllAvailableServices();
        } catch (AssertionError error) {
            LOGGER.error("*** \nGet All Available Services Test Failed. Error message: " + "\n" + error.getMessage() + "\n ***");
            Assert.fail("Test failed.");
        }
    }

    // Create service
    @Test(priority = 19)
    public void createService() {
        try{
            new CreateService().createService();
        } catch (AssertionError error) {
            LOGGER.error("*** \nCreate Service Test Failed. Error message: " + "\n" + error.getMessage() + "\n ***");
            Assert.fail("Test failed.");
        }
    }

    // Get exact service
    @Test(priority = 20)
    public void getExplicitService() {
        try{
            new GetExplicitService().getExplicitService();
        } catch (AssertionError error) {
            LOGGER.error("*** \nGet Explicit Service Test Failed. Error message: " + "\n" + error.getMessage() + "\n ***");
            Assert.fail("Test failed.");
        }
    }
    // Update service
    @Test(priority = 21)
    public void updateService() {
        try{
            new UpdateService().updateService();
        } catch (AssertionError error) {
            LOGGER.error("*** \nUpdate Service Test Failed. Error message: " + "\n" + error.getMessage() + "\n ***");
            Assert.fail("Test failed.");
        }
    }

    // Delete service
    @Test(priority = 22)
    public void deleteService() {
        try{
            new DeleteService().deleteService();
        } catch (AssertionError error) {
            LOGGER.error("*** \nDelete Service Test Failed. Error message: " + "\n" + error.getMessage() + "\n ***");
            Assert.fail("Test failed.");
        }
    }

    // Display version
    @Test(priority = 23)
    public void displayVersion() {
        try{
            new CurrentVersion().displayCurrentVersion();
        } catch (AssertionError error) {
            LOGGER.error("*** \nDisplay Version Test Failed. Error message: " + "\n" + error.getMessage() + "\n ***");
            Assert.fail("Test failed.");
        }
    }

    @Test(priority = 24)
    public void healthCheck() {
        try{
            new HealthCheck().healthCheck();
        } catch (AssertionError error) {
            LOGGER.error("*** \nHealth Check Test Failed. Error message: " + "\n" + error.getMessage() + "\n ***");
            Assert.fail("Test failed.");
        }
    }

    @AfterTest
    public void lastStartDate() {
        // Save last start date
        String fileName = "last_start_date.txt";

        try {
            FileWriter fw = new FileWriter(fileName);
            fw.write(new Date().toString());
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
