package hybrid;

import io.appium.java_client.AppiumDriver;

import java.net.MalformedURLException;
import java.time.Duration;

public class AndroidChromeAutomation {
    public static void main(String[] args) throws MalformedURLException {
        AppiumDriver driver = DriverInitialization.initializeBrowserDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://tesla.com");
    }

}
