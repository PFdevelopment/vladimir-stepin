package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CheckExpensesPage extends MainPage {

    WebElement toolBar = driver.findElement(By.id("toolbar"));
    WebElement allExpenses;
    List<WebElement> keyboard = driver.findElements(By.id("frame_layout"));
    WebElement getButton;
    WebElement money;
    WebElement btnDefault;

    public CheckExpensesPage(AppiumDriver driver) {
        super(driver);
    }

    public CheckExpensesPage checkExpenses() throws InterruptedException, Exception {
        // Click the toolbar
        toolBar.click();

        // Enter password
        for(int index = 0; index < 4; index++) {
            keyboard.get(1).click();
        }

        Thread.sleep(2500);

        swipeHorizontal(driver, 0.9, 0.2, 0.8, 100);
        swipeHorizontal(driver, 0.9, 0.2, 0.8, 100);
        swipeHorizontal(driver, 0.9, 0.2, 0.8, 200);

        Thread.sleep(3000);

        allExpenses = driver.findElement(By.id("all"));

        allExpenses.click();

        money = driver.findElement(By.id("money"));
        getButton = driver.findElement(By.id("button1"));

        money.click();

        btnDefault = driver.findElement(By.id("buttonDefaultPositive"));
        btnDefault.click();

        getButton.click();


        return new CheckExpensesPage(driver);
    }
}
