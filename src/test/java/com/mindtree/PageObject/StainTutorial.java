package com.mindtree.PageObject;

import org.openqa.selenium.WebDriver;

import com.mindtree.ReusableComponents.WebdriverHelper;
import com.mindtree.UIstore.StainTutorialLocator;

public class StainTutorial {

	public static WebDriver driver;
	StainTutorialLocator stain = new StainTutorialLocator();
	WebdriverHelper helper = new WebdriverHelper();

	public StainTutorial() {
		// TODO Auto-generated constructor stub
	}

	public void searchStain() {
		try {
			WebdriverHelper.click(StainTutorialLocator.searchStain);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void searchInsideStain() {
		try {
			WebdriverHelper.click(StainTutorialLocator.searchInsideStain);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
//public void clickVideo()
//{
//	try {
//		helper.(stain.clickVideo);
//	} catch (InterruptedException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
}

