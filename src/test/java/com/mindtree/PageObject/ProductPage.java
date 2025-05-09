package com.mindtree.PageObject;

import org.openqa.selenium.WebDriver;

import com.mindtree.ReusableComponents.WebdriverHelper;
import com.mindtree.UIstore.ProductPageLocators;
import com.mindtree.Utility.ExcelReader;

public class ProductPage {

	public static WebDriver driver;
	WebdriverHelper helper = new WebdriverHelper();
	ProductPageLocators homeloc = new ProductPageLocators();
	ExcelReader excel = new ExcelReader();

	public void clickProduct() {

		try {
			WebdriverHelper.click(ProductPageLocators.SearchedProduct);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void packetClick() {
		try {
			WebdriverHelper.click(ProductPageLocators.packetclick);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	
}