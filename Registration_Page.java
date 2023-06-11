package pages;

import java.io.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import Libraries.Reusable;
import excelUtility.ExcelReader;


//class to enter user details in registration page
public class Registration_Page {
	WebDriver driver;
	ExcelReader eread;
	Reusable use;
	By register =By.linkText("REGISTER");
	By fname=By.name("firstName");
	By lname=By.name("lastName");
	By phone=By.name("phone");
	By email =By.id("userName");
	By address1=By.cssSelector("input[name='address1']");
	By  city= By.name("city");
	By state= By.name("state");
	By pin= By.name("postalCode");
	By uname =By.id("email");
	By pwd = By.name("password");
	By cpwd= By.name("confirmPassword");
	By submit = By.name("submit");
	
	
	public Registration_Page(WebDriver driver) throws IOException{
		this.driver=driver;
		eread = new ExcelReader();
	}
		
	public void contact_Information() {
		driver.findElement(register).click();
		driver.findElement(fname).sendKeys(eread.getData(0, 0, 0));
		driver.findElement(lname).sendKeys(eread.getData(0, 1, 0));
	}
	//method to enter user details in registration page 
	public void enter_User_Details() throws Exception {
		use = new Reusable(driver);
		driver.findElement(address1).sendKeys(eread.getData(0, 4, 0));
		driver.findElement(city).sendKeys(eread.getData(0, 5, 0));
		driver.findElement(phone).sendKeys(eread.getData(0, 2, 0));
		driver.findElement(email).sendKeys(eread.getData(0, 3, 0));
		
		driver.findElement(state).sendKeys(eread.getData(0, 6, 0));
		driver.findElement(pin).sendKeys(eread.getData(0, 7, 0));
		Select dropdown= new Select(driver.findElement(By.name("country")));
		dropdown.selectByVisibleText("INDIA");
		driver.findElement(uname).sendKeys(eread.getData(0, 3, 0));
		driver.findElement(pwd).sendKeys(eread.getData(0, 8, 0));
		driver.findElement(cpwd).sendKeys(eread.getData(0, 8, 0));
		driver.findElement(submit).click();
		use.screenCapture("Valid Registration");
	}
	//method to enter  invalid user details in registration page 
		public void enter_Invalid_User_Details() throws Exception {
			driver.findElement(register).click();
			driver.findElement(fname).sendKeys(eread.getData(0, 0, 1));
			driver.findElement(lname).sendKeys(eread.getData(0, 1, 1));
		}
	
	
	
}
