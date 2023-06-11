package testCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

import browser.LaunchBrowser;
import pages.Sign_On_Page;
import utils.Repo_Reader;

// class to verify user sign on
public class Verifying_User_Sign_On {
	LaunchBrowser lb;
	WebDriver driver;
	Repo_Reader repo;
	Sign_On_Page sp;
	
	//method to test sign on functionality with valid data
	
	@Test
	public void enter_Details() throws Exception {
		lb = new LaunchBrowser();
		driver= lb.tbrowser();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Reporter.log("Browser Opened");
		//Thread.sleep(3000);
		repo = new Repo_Reader();
		String url = repo.getURL();
		driver.get(url);
		Reporter.log("Mercury Tours site is Launched");
		sp = new Sign_On_Page(driver);
		sp.user_Details();
		Reporter.log("Verified user sign on");
		System.out.println("User Sign in is verified");
		driver.close();
	}


}
