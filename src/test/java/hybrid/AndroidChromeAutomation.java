package hybrid;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.Set;

public class AndroidChromeAutomation {
    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        AppiumDriver driver = DriverInitialization.initializeBrowserDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://tesla.com");

        Set<String> contextHandles = ((AndroidDriver) driver).getContextHandles();
        for (String handle : contextHandles) {
            System.out.println(handle);
        }

        ((AndroidDriver) driver).context(contextHandles.toArray()[1].toString());

        driver.findElement(AppiumBy.xpath("//button[@aria-label='Back']")).click();
        driver.findElement(AppiumBy.xpath("//button[@id='dx-nav-item--vehicles']")).click();
        driver.findElement(AppiumBy.xpath("(//a[@aria-label='Order'])[1]")).click();
        driver.findElement(AppiumBy.xpath("//button[text()='Order Now']")).click();
        driver.findElement(AppiumBy.xpath("//button[@title=\"Order with Card\"]")).click();
        Thread.sleep(5000);
        driver.findElement(AppiumBy.xpath("//button[@title=\"Order with Card\"]")).click();
        driver.findElement(AppiumBy.xpath("//input[@id='FIRST_NAME']")).sendKeys("Artem");

        //Thread.sleep(60000);
    }

}
