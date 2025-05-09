package com.mindtree.Utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenShot {

	public static SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH-mm-ss");
	public static String filename = formatter.format(java.util.Calendar.getInstance().getTime());
	public static File Src;
	public static File Dest;
	public String Screenshot(WebDriver driver) throws IOException {
		String filepath = System.getProperty("user.dir") + "//Screenshot//" + filename + ".png";
		TakesScreenshot scrnshot = ((TakesScreenshot) driver);
		Src = scrnshot.getScreenshotAs(OutputType.FILE);
		Dest = new File(filepath);
		FileUtils.copyFile(Src, Dest);
		return filepath;
	}

}
