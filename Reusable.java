package Libraries;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import browser.LaunchBrowser;
import utils.Repo_Reader;

//class for Resuable 
public class Reusable {
	LaunchBrowser lb;
	WebDriver driver;
	Repo_Reader repo;
	
	public Reusable(WebDriver driver) {
		this.driver= driver;
	}

	//method to capture a screenshot
	public  void screenCapture(String fileName) throws Exception {
		 File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		 FileUtils.copyFile(screenshot, new File("/home/ubuntu/eclipse-workspace/MercuryTours/Screenshot/"+fileName+".png"));
    } 
}
