package hybrid;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import java.awt.*;
import java.net.MalformedURLException;
import java.time.Duration;

public class WebView {
    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        AppiumDriver driver = DriverInitialization.initializeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.findElement(AppiumBy.accessibilityId("Views")).click();

        WebElement element = driver.findElement(AppiumBy.id("android:id/list"));
        driver.executeScript("mobile:swipeGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId(),
                "direction", "up",
                "percent", 0.75
        ));

        driver.findElement(AppiumBy.accessibilityId("WebView")).click();
        Thread.sleep(3000);

    }
}
