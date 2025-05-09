package com.mindtree.PageObject;



import com.mindtree.ReusableComponents.WebdriverHelper;
import com.mindtree.UIstore.HomePageLocators;
import com.mindtree.Utility.ExcelReader;
import com.mindtree.Utility.Log;

public class HomePage {

    HomePageLocators locators = new HomePageLocators();
    ExcelReader excel = new ExcelReader();
    

    public void searchBox() {
        try {
            WebdriverHelper.click(locators.searchbox);
        } catch (InterruptedException e) {
            Log.error("Not able to click on search box.");
            e.printStackTrace();
        }
    }


    public void sendData() {
        String data = excel.getData(0, 1, 0);
        WebdriverHelper.sendKeys(locators.searchbox, data);
    }

    public void clickSearch() {
        try {
            WebdriverHelper.click(locators.searchboxClick);
        } catch (InterruptedException e) {
            Log.error("Search button click failed.");
        }
    }

    public void homeMenu() {
        try {
            WebdriverHelper.click(locators.searchmenuClick);
        } catch (InterruptedException e) {
            Log.error("Home menu click failed.");
        }
    }

    public void homePageIcon() {
        try {
            WebdriverHelper.click(locators.searchHomeIcon);
        } catch (InterruptedException e) {
            Log.error("Homepage icon click failed.");
        }
    }

    public void homePageProduct() {
        try {
            WebdriverHelper.click(locators.searchHomePageProduct);
        } catch (InterruptedException e) {
            Log.error("Homepage product click failed.");
        }
    }

    public void homePageStain() {
        try {
            WebdriverHelper.click(locators.searchHomeStain);
        } catch (InterruptedException e) {
            Log.error("Homepage stain click failed.");
        }
    }
}
