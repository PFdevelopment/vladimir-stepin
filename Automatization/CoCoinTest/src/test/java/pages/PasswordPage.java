package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class PasswordPage extends MainPage {

    // Keyboard
    List<WebElement> elements = driver.findElements(By.id("frame_layout"));

    public PasswordPage(AppiumDriver driver) {
        super(driver);
    }

    // Method enters password
    public PasswordPage setPassword() throws  InterruptedException {

        for(int index = 0; index < 8; index++) {
            elements.get(1).click();
        }




        return  new PasswordPage(driver);
    }

}
