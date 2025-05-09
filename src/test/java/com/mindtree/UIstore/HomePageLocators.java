package com.mindtree.UIstore;

import org.openqa.selenium.By;

public class HomePageLocators {

	public static final By searchbox = By.xpath("//button[@id=\"search-toggle\"]");

	public static final By searchboxClick = By
			.xpath("//a[@id='phdesktopheader_0_phdesktopheadermiddle_1_anchrSearch']");

	public static final By searchmenuClick = By.xpath("//a[@title='Shop Products']");
	
	public static final By searchHomePageProduct=By.xpath("(//a[@title='SHOP NOW'])[1]");
	
	public static final By searchHomeIcon=By.xpath("(//img[@title='Ariel'])[1]");
	
	public static final By searchHomeStain=By.xpath("//a[@title='How to wash clothes']");
	
	

}
