package testCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

import browser.LaunchBrowser;
import pages.Registration_Page;
import utils.Repo_Reader;

// class to verify whether user  is able to  register
public class Verifying_User_Registration {
	LaunchBrowser lb;
	WebDriver driver;
	Registration_Page rp;
	Repo_Reader repo;
	
	//method to test registration functionality
	@Test
	public void verifying_Registration () throws Exception {
		lb = new LaunchBrowser();
		driver= lb.tbrowser();
		Reporter.log("Browser Opened");
		repo = new Repo_Reader();
		String URL = repo.getURL();
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Reporter.log("Mercury Tours site is Launched");
		rp = new Registration_Page(driver);
		rp.contact_Information();
		rp.enter_User_Details();
		Reporter.log("Verified Registration Functionality");
		rp.enter_Invalid_User_Details();
		rp.enter_User_Details();
		System.out.println("registration  successful");
		driver.close();
		Reporter.log("Driver closed");
	
	}
	
}
