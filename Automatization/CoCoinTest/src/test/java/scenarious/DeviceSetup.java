package scenarious;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class DeviceSetup {
    protected AppiumDriver driver;
    // Path to projecy
    File classPathRoot = new File(System.getProperty("user.dir"));
    // Path to <project folder>/Apps/CoCoin
    File appDir = new File(classPathRoot, "/apps/CoCoin/");
    // Path to apk
    File app = new File(appDir, "CoCoin.apk");

    // URL
    String url = "http://127.0.0.1:4723/wd/hub";

    protected void prepareAndroidDeviceForAppium() throws MalformedURLException {
        // Creating an object of DesiredCapabilities
        DesiredCapabilities capabilities = new DesiredCapabilities();
        // Version of Appium
        capabilities.setCapability("appiumVersion", "5.0.4");
        // name of OS
        capabilities.setCapability("platformName", "Android");
        // Version of Mobile OS: 5.1
        capabilities.setCapability("platformVersion", "6.0");
        // Name of the device
        capabilities.setCapability("deviceName", "Nexus 6");
        // An absolute path to the APK file
        capabilities.setCapability("app", app.getAbsolutePath());
        // Java package of the APP
        capabilities.setCapability("appPackage", "com.nightonke.cocoin");
        // Start activity name
        capabilities.setCapability("appActivity", "com.nightonke.saver.activity.MainActivity");
        capabilities.setCapability("appWaitActivity", "com.nightonke.saver.activity.ShowActivity");
        //  Constructor to initialize the driver with URL and Capabilities
        capabilities.setCapability("autoGrantPermissions","true");
        driver = new AppiumDriver(new URL(url), capabilities);
    }

}
