package pages;

import java.io.*;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import Libraries.Reusable;
import excelUtility.ExcelReader;
import utils.Repo_Reader;
// class to enter  user details in sign on page
public class Sign_On_Page {
	WebDriver driver;
	ExcelReader er;
	Repo_Reader repo;
	Reusable use;
	By signOn= By.linkText("SIGN-ON");
	By userName = By.xpath("//input[@name='userName']");
	By pwd = By.name("password");
	By submit = By.name("submit");
	By signoff= By.linkText("SIGN-OFF");
	By loginmsg= By.xpath("//b[text()=' Thank you for Loggin. ']");
	
	public  Sign_On_Page(WebDriver driver) throws IOException {
		this.driver=driver;
		er = new ExcelReader();
	}
	//method to enter user details 
	public void user_Details() throws Exception {
		use = new Reusable(driver);
		driver.findElement(signOn).click();
		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Thread.sleep(5000);
		repo = new Repo_Reader();
		driver.findElement(userName).sendKeys(repo.getUserName());
		driver.findElement(pwd).sendKeys(repo.getPassword());
		driver.findElement(submit).click();
		use.screenCapture("Valid sign in");
		Thread.sleep(5000);
		String msg = driver.findElement(loginmsg).getText();
		Assert.assertEquals(msg, "Thank you for Loggin.");
		System.out.println("Login successful with valid details");
		driver.findElement(signoff).click();
		
	}
	
	//method to enter invalid user details
	public void invalid_User_Details() throws Exception {
		driver.findElement(signOn).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//Thread.sleep(3000);
		repo = new Repo_Reader();
		driver.findElement(userName).sendKeys(repo.getUserName());
		driver.findElement(pwd).sendKeys(repo.getInvalidpwd());
		driver.findElement(submit).click();
		String msge =driver.findElement(By.xpath("//span")).getText();
		Assert.assertEquals(msge, "Enter your userName and password correct");
		System.out.println(msge);
		System.out.println("login failed as details are invalid");
		use = new Reusable(driver);
		use.screenCapture("Invalid Sign in");
		
	}

}
