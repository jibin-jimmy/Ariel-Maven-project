import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.mindtree.PageObject.AddtoCartPage;
import com.mindtree.PageObject.HomePage;
import com.mindtree.PageObject.ProductPage;
import com.mindtree.ReusableComponents.WebdriverHelper;
import com.mindtree.Runner.Application;
import com.mindtree.UIstore.ProductPageLocators;
import com.mindtree.Utility.ExcelReader;
import com.mindtree.Utility.ExtentReport;
import com.mindtree.Utility.Log;
@Listeners(com.mindtree.Utility.Listener.class)
public class ApplicationTest {
	
	static Logger log = Logger.getLogger(Application.class);
	Log logger = new Log();
	public static ExtentReport extent;
	public static WebDriver driver;
	public static int i = 0;

	WebdriverHelper helper = new WebdriverHelper();
	HomePage home = new HomePage();
	ProductPage product = new ProductPage();
	AddtoCartPage AddtoCart = new AddtoCartPage();
	ExcelReader excel = new ExcelReader();
	ExtentReport eReport = new ExtentReport();

	@BeforeSuite
	public void beforeSuites() {
		
		extent.createReport();
	}
	@BeforeMethod
	public void initializeChrome(Method m) {
		try {
			driver = helper.startchrome();
			logger.info("Chrome driver started Successfully");
			helper.navigatetohome(driver);
			helper.maxmizewindow(driver);
			
			
			extent.beforeMethodextent(m.getName());
		} catch (Exception e) {
			logger.error("Chrome Not able to Launch");
		}
	}

	@Test(priority = 1)
	public void DetergentSearch() {
		try {

			home.searchBox();
			home.sendData();
			home.clickSearch();
			String productname = helper.gettingString(ProductPageLocators.ProductName);
			if (productname.equalsIgnoreCase(excel.getData(0, 1, 1))) {
				System.out.println("Product searched is found");
			} else {
				System.out.println("Not verified");
			}
			product.clickProduct();
			helper.implicitlywait(driver);
			helper.Scrolldown();
			AddtoCart.ItemSearched();
			logger.info("Program executed Successfully");
			helper.implicitlywait(driver);
			extent.pass("Successfully serached the first product", driver);
		} catch (Exception e) {
			logger.error("Not able to start chrome");
			logger.warn("Check for the Home page Locators");
			logger.warn("Product name comparison not Done");
			logger.warn("Not Able to select Item");
		}

	}

	@Test(priority = 2)
	public void HomepageSearch() throws IOException {

		try {
			home.Homemenu();
			helper.Scrolldown2();
			product.packetClick();
			helper.Scrolldown();
			AddtoCart.packetSearched();
			extent.pass("Successfully serached the second product", driver);
		} catch (InterruptedException e) {
			logger.warn("Some Functions are not Working");
		}

	}
	
	
	@Test(priority=3)
	public void directSelect()
	{
		try {

			home.homePageIcon();
			home.homePageProduct();
			helper.Scrolldown();
			AddtoCart.finalProductSearched();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@AfterMethod
	public void close() throws IOException {
		extent.afterMethodExtent();
		driver.close();
		driver.quit();

	}

	@AfterSuite
	public void closeDriver() {
		extent.afterTestExtent();
		
	}
}

}
