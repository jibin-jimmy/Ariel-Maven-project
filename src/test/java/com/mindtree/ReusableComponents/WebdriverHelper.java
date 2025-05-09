package com.mindtree.ReusableComponents;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.google.common.io.Files;

public class WebdriverHelper {

    public static WebDriver driver;
    public static ConfigurationReader configfile = new ConfigurationReader();
    public static Actions action;

    public static WebDriver startChrome() {
        System.setProperty(
            configfile.getAllProperties("drivername"),
            configfile.getAllProperties("driverpath")
        );
        driver = new ChromeDriver();
        implicitlyWait();
        maximizeWindow();
        return driver;
    }

    public static void navigateToHome() {
        driver.get(configfile.getAllProperties("url"));
    }

    public static void maximizeWindow() {
        if (driver != null) {
            driver.manage().window().maximize();
        }
    }

    public static void implicitlyWait() {
        int waitTime = Integer.parseInt(configfile.getAllProperties("implicitwaittime"));
        driver.manage().timeouts().implicitlyWait(waitTime, TimeUnit.SECONDS);
    }

    public static WebElement getElement(By selector) {
        try {
            return driver.findElement(selector);
        } catch (NoSuchElementException e) {
            System.out.println("Element not found: " + selector);
            return null;
        }
    }

    public static void click(By selector) throws InterruptedException {
        Thread.sleep(2000);  // Can be replaced with WebDriverWait later
        WebElement element = getElement(selector);
        if (element != null) {
            element.click();
        } else {
            System.out.println("Click failed, element not found: " + selector);
        }
    }

    public static void clearField(WebElement element) {
        if (element != null) {
            element.clear();
        }
    }

    public static void sendKeys(By selector, String value) {
        WebElement element = getElement(selector);
        if (element != null) {
            clearField(element);
            element.sendKeys(value);
        } else {
            System.out.println("SendKeys failed, element not found: " + selector);
        }
    }

    public static String getText(By selector) {
        WebElement element = getElement(selector);
        return (element != null) ? element.getText() : "";
    }

    public static void switchToFrame(String frameName) {
        try {
            driver.switchTo().frame(frameName);
        } catch (NoSuchFrameException e) {
            System.out.println("No such frame: " + frameName);
        }
    }

    public static void scrollDown(int pixels) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0," + pixels + ")");
    }

    public static String takeScreenshot() throws IOException {
        TakesScreenshot scrShot = ((TakesScreenshot) driver);
        File srcFile = scrShot.getScreenshotAs(OutputType.FILE);
        String dest = System.getProperty("user.dir") + "/ScreenShot/" + getTimestamp() + ".jpg";
        Files.copy(srcFile, new File(dest));
        return dest;
    }

    private static String getTimestamp() {
        SimpleDateFormat sd = new SimpleDateFormat("dd_MM_yy_HH_mm_ss_a");
        return sd.format(new Date());
    }

    public static void switchToWindow() {
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
        }
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}
