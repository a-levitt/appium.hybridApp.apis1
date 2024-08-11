package hybrid;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import java.awt.*;
import java.net.MalformedURLException;
import java.time.Duration;
import java.util.Arrays;
import java.util.Set;

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

        //System.out.println(driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"This page is a Second Selenium sandbox\"]")).getText());

        Set<String> contextHandles = ((AndroidDriver) driver).getContextHandles();
        for (String handle : contextHandles) {
            System.out.println(handle);
        }

        ((AndroidDriver) driver).context("WEBVIEW");
        // May not work because getContextHandles() often get not all contextHandles:
        //((AndroidDriver) driver).context(contextHandles.toArray()[1].toString());

        String header = driver.findElement(AppiumBy.xpath("//h1[text()='This page is a Selenium sandbox']")).getText();
        System.out.println(header);
        WebElement field = driver.findElement(AppiumBy.xpath("//input[@id=\"i_am_a_textbox\"]"));
        field.clear();
        field.sendKeys("alevitt");

        ((AndroidDriver) driver).context("NATIVE_APP");
        //((AndroidDriver) driver).context(contextHandles.toArray()[0].toString());

        Thread.sleep(5000);
    }
}
