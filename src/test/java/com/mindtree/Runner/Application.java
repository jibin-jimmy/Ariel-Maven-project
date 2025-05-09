package com.mindtree.Runner;

import java.io.IOException;
import java.lang.reflect.Method;
import javax.swing.JFrame;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import com.mindtree.PageObject.AddtoCartPage;
import com.mindtree.PageObject.HomePage;
import com.mindtree.PageObject.ProductPage;
import com.mindtree.PageObject.StainTutorial;
import com.mindtree.ReusableComponents.WebdriverHelper;
import com.mindtree.UIstore.ProductPageLocators;
import com.mindtree.Utility.ExcelReader;
import com.mindtree.Utility.ExtentReport;
import com.mindtree.Utility.Log;

@SuppressWarnings("serial")
@Listeners(com.mindtree.Utility.Listener.class)
public class Application extends JFrame {

    private static final Logger log = LogManager.getLogger(Application.class);
    public static WebDriver driver;

    WebdriverHelper helper = new WebdriverHelper();
    HomePage home = new HomePage();
    ProductPage product = new ProductPage();
    AddtoCartPage addToCart = new AddtoCartPage();
    ExcelReader excel = new ExcelReader();
    StainTutorial stain = new StainTutorial();

    @BeforeSuite
    public void beforeSuite() {
        ExtentReport.createReport();
    }

    @BeforeMethod
    public void setup(Method method) {
        try {
            driver = WebdriverHelper.startChrome();
            Log.info("Chrome driver started successfully");
            WebdriverHelper.navigateToHome();
            WebdriverHelper.maximizeWindow();
            ExtentReport.beforeMethodextent(method.getName());
        } catch (Exception e) {
            Log.error("Failed to launch Chrome");
            e.printStackTrace();
        }
    }

    @Test(priority = 1)
    public void detergentSearch() {
        try {
            home.searchBox();
            home.sendData();
            home.clickSearch();

            String productName = WebdriverHelper.getText(ProductPageLocators.ProductName);
            if (productName.equalsIgnoreCase(excel.getData(0, 1, 1))) {
                System.out.println("Product searched is found");
            } else {
                System.out.println("Product not verified");
            }

            product.clickProduct();
            WebdriverHelper.implicitlyWait();
            WebdriverHelper.scrollDown(300);
            addToCart.ItemSearched();
            Log.info("Detergent search test executed successfully");
            ExtentReport.pass("Successfully searched the first product", driver);
        } catch (Exception e) {
            Log.error("Error in detergentSearch: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Test(priority = 2)
    public void homepageSearch() {
        try {
            home.homeMenu();
            WebdriverHelper.scrollDown(700);
            product.packetClick();
            WebdriverHelper.scrollDown(300);
            addToCart.packetSearched();
            ExtentReport.pass("Successfully searched the second product", driver);
        } catch (Exception e) {
            Log.error("Error in homepageSearch: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Test(priority = 3)
    public void directSelect() {
        try {
            home.homePageIcon();
            home.homePageProduct();
            WebdriverHelper.scrollDown(300);
            addToCart.finalProductSearched();
        } catch (Exception e) {
            Log.error("Error in directSelect: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Test(priority = 4)
    public void homePageStain() {
        try {
            home.homePageStain();
            stain.searchStain();
            WebdriverHelper.scrollDown(300);
            stain.searchInsideStain();
            WebdriverHelper.scrollDown(300);
            WebdriverHelper.takeScreenshot();
        } catch (IOException e) {
            Log.error("Screenshot capture failed");
            e.printStackTrace();
        } catch (Exception e) {
            Log.error("Error in homePageStain: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @AfterMethod
    public void tearDown() {
        try {
            ExtentReport.afterMethodExtent();
            if (driver != null) {
                driver.quit();
            }
        } catch (Exception e) {
            Log.error("Error during teardown");
        }
    }

    @AfterSuite
    public void afterSuite() {
        ExtentReport.afterTestExtent();
    }
}
