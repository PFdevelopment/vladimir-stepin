package scenarious;

import pages.AddExpensesPage;
import pages.CheckExpensesPage;
import pages.InitPage;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.PasswordPage;

public class AppiumTest extends DeviceSetup {

    @BeforeClass
    public void setUp() throws Exception {
        prepareAndroidDeviceForAppium();
    }

    @AfterClass
    public void tearDown() throws Exception {
        driver.quit();
    }

    @Test(priority = 1)
    public void falseLoginTest() throws InterruptedException, Exception {
        new InitPage(driver).swipeTillLogin();
    }

    @Test(priority = 2)
    public void enterPassword() throws InterruptedException, Exception {
        new PasswordPage(driver).setPassword();
    }

    @Test(priority = 3)
    public void addExpenses() throws InterruptedException, Exception {
        new AddExpensesPage(driver).addExpense();
    }

    @Test(priority = 4)
    public void checkExpenses() throws InterruptedException, Exception {
        new CheckExpensesPage(driver).checkExpenses();
    }

}
