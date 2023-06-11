package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import utils.Repo_Reader;

//Class to navigate to Landing page of Mercury Tours
public class Landing_Page {
	WebDriver driver;
	Repo_Reader repo;
	By copy = By.className("footer");
	By register=By.linkText("REGISTER");
	By sign_on=By.linkText("SIGN-ON");
	By flights=By.linkText("Flights");
	
	public Landing_Page(WebDriver driver) {
		this.driver = driver;
	}

	//method to click  on register link
	public void click_Register() {
		driver.findElement(register).click();
	}
	
	//method to click sign on link
	public void click_Sign_On() {
	
	driver.findElement(sign_on).click();
	}
	
	//method to click flights link
	public void click_Flights() {
		driver.findElement(By.linkText("Flights")).click();
	}
	
	// method to get title
	public void getTitle() {
		String title = driver.getTitle();
		Assert.assertEquals(title, "Welcome: Mercury Tours");
		//System.out.println(title);
	}

	// method to get copyrights string
	public void getCopyRightsMsg() {
		String copyrightsMsg = driver.findElement(copy).getText();
		Assert.assertEquals(copyrightsMsg, "© 2005, Mercury Interactive (v. 011003-1.01-058)");

	}

}
