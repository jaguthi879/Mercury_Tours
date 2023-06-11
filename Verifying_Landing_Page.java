package testCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Libraries.Reusable;
import browser.LaunchBrowser;
import pages.Landing_Page;
import utils.Repo_Reader;

//class to verify Landing page
public class Verifying_Landing_Page {
	LaunchBrowser lb;
	WebDriver driver;
	Repo_Reader repo;
	Landing_Page lp;
	Reusable use;
	
	// method to verify title of landing page
	@Test
	public void verifying_Landing_Page() throws Exception {

		lb = new LaunchBrowser();
		driver= lb.tbrowser();
		Reporter.log("Browser Opened");
		repo = new Repo_Reader();
		String URL = repo.getURL();
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Reporter.log("Mercury Tours site is Launched");
		lp = new Landing_Page(driver);
		lp.getTitle();
		lp.getCopyRightsMsg();	
		Reporter.log("Verified Landing page");
		System.out.println("Verified Landing page");
		driver.close();
		Reporter.log("Driver closed");
		
	}	
}
