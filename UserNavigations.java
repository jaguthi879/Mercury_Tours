package testCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import browser.LaunchBrowser;
import pages.FlightBooking_Page;
import pages.Landing_Page;
import pages.Registration_Page;
import pages.Sign_On_Page;
import utils.Repo_Reader;

//class to verify navigations
public class UserNavigations {
	LaunchBrowser lb;
	WebDriver driver;
	Repo_Reader repo;
	Landing_Page lp;
	Registration_Page rp;
	Sign_On_Page sp;
	FlightBooking_Page fbp;

	// method to test landing page
	@Test
	public void test_Landing() throws Exception {
		lb = new LaunchBrowser();
		driver= lb.tbrowser();
		repo = new Repo_Reader();
		String url = repo.getURL();
		driver.get(url);
		lp = new Landing_Page(driver);
		lp.getTitle();
		lp.getCopyRightsMsg();
	}

//method to test registration page
	@Test(dependsOnMethods = "test_Landing")
	public void test_Registration() throws Exception {
		rp = new Registration_Page(driver);
		rp.contact_Information();
		rp.enter_User_Details();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.linkText("SIGN-OFF")).click();
	}

//method to test signOn page
	@Test(dependsOnMethods = "test_Registration")
	public void test_SignOn() throws Exception {

		sp = new Sign_On_Page(driver);
		Thread.sleep(3000);
		sp.user_Details();
		//sp.invalid_User_Details();
	}

//method to test flightBooking page
	@Test(dependsOnMethods = "test_SignOn")
	public void test_FlightBooking() throws Exception {
		fbp = new FlightBooking_Page(driver);
		fbp.select_Fields();
		driver.close();
	}
}
