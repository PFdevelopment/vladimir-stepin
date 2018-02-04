package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class InitPage extends MainPage {

    public InitPage(AppiumDriver driver) {
        super(driver);
    }

    // Testing activities

    // Method swipes to password setting
    public InitPage swipeTillLogin() throws Exception {
        driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);

        swipeHorizontal(driver, 0.9, 0.2, 0.8, 500);
        Thread.sleep(200);
        swipeHorizontal(driver, 0.9, 0.01, 0.8, 500);
        Thread.sleep(200);
        swipeHorizontal(driver, 0.9, 0.001, 0.8, 500);
        Thread.sleep(200);
        swipeHorizontal(driver, 0.9, 0.2, 0.8, 200);

        return new InitPage(driver);
    }




}
