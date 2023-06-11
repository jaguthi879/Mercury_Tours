package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import Libraries.Reusable;

//class to  select fields to book a flight 
public class FlightBooking_Page {
	WebDriver driver;
	Reusable use;
	By flights=By.linkText("Flights");
	By type=By.xpath("//input[@value='oneway']");
	By Fport =By.name("fromPort");
	By passengerCount=By.name("passCount");
	By FromMonth=By.name("fromMonth");
	By FromDay=By.name("fromDay");
	By ToPort = By.name("toPort");
	By ToMonth=By.name("toMonth");
	By ToDay=By.name("toDay");
	By FClass=By.xpath("//input[@value='Coach']");
	By FName= By.name("airline");
	By FindFlights=By.xpath("//tbody/tr/td/table/tbody/tr[2]/td[2]/a");
	By Home=By.linkText("Home");
	
	public FlightBooking_Page(WebDriver driver) {
		this.driver = driver;
	}

	// method to select fields in booking flights
	public void select_Fields() throws Exception {
		driver.findElement(flights).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(type).click();
		Select passenger = new Select(driver.findElement(passengerCount));
		passenger.selectByValue("2");
		Select from = new Select(driver.findElement(Fport));
		from.selectByVisibleText("Frankfurt");
		Select onMonth = new Select(driver.findElement(FromMonth));
		onMonth.selectByVisibleText("December");
		Select onDate = new Select(driver.findElement(FromDay));
		onDate.selectByVisibleText("22");
		Select to = new Select(driver.findElement(ToPort));
		to.selectByVisibleText("Seattle");
		Select returnMonth = new Select(driver.findElement(ToMonth));
		returnMonth.selectByVisibleText("December");
		Select returnDate = new Select(driver.findElement(ToDay));
		returnDate.selectByVisibleText("31");
		driver.findElement(FClass);
		Select serClass = new Select(driver.findElement(FName));
		serClass.selectByVisibleText("Blue Skies Airlines");
		driver.findElement(FindFlights).click();
		use = new Reusable(driver);
		use.screenCapture("FlightBooking ");
		driver.findElement(Home).click();

	}

}
