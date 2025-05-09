package com.mindtree.PageObject;

import org.openqa.selenium.WebDriver;

import com.mindtree.ReusableComponents.WebdriverHelper;
import com.mindtree.UIstore.AddtoCartPageLocators;
import com.mindtree.Utility.ExcelReader;

public class AddtoCartPage {

	WebdriverHelper helper = new WebdriverHelper();
	AddtoCartPageLocators addto = new AddtoCartPageLocators();

	public void ItemSearched() throws InterruptedException {
		helper.click(addto.AddtoCart);
	}

	public void packetSearched() throws InterruptedException {
		helper.click(addto.packetSearched);
	}
	
	public void finalProductSearched() throws InterruptedException
	{
		helper.click(addto.finalProduct);
	}
}
