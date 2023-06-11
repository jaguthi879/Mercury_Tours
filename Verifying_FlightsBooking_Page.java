package testCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

import browser.LaunchBrowser;
import pages.FlightBooking_Page;
import utils.Repo_Reader;

//class to verify whether the user is able to book a flight
public class Verifying_FlightsBooking_Page {
	LaunchBrowser lb;
	WebDriver driver;
	Repo_Reader repo;
	FlightBooking_Page fbp;
	
	// method to verify flight booking functionality
	@Test
	public void book_Flight() throws Exception {
	lb = new LaunchBrowser();
	driver= lb.tbrowser();
	Reporter.log("Browser Opened");
	repo = new Repo_Reader();
	String URL = repo.getURL();
	driver.get(URL);
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	Reporter.log("Mercury Tours site is Launched");
	fbp = new FlightBooking_Page(driver);
	fbp.select_Fields();
	Reporter.log("Verified flight booking functionality");
	System.out.println("flight booking functionality is verified");
	driver.close();
	Reporter.log("Driver closed");
	}
}
