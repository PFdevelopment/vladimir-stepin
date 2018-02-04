package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AddExpensesPage extends MainPage{
    List<WebElement> elements = driver.findElements(By.id("frame_layout"));
    List<WebElement> tags = driver.findElements(By.className("android.widget.LinearLayout"));


    public AddExpensesPage(AppiumDriver driver) {
        super(driver);
    }

    public AddExpensesPage addExpense() throws InterruptedException {
        // Enter amount of money spent
        for(int index = 1; index < 3; index++) {
            elements.get(index).click();
        }

        // Add the category
        tags.get(9).click();

        elements.get(11).click();

        return new AddExpensesPage(driver);
    }


}
