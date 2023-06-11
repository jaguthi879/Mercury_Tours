package browser;

import java.io.*;
import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import utils.Repo_Reader;

//class to launch browser
public class LaunchBrowser {
	
		WebDriver driver;
		Repo_Reader repo;
		
		
		//method to launch chrome browser
		public WebDriver chromeBrowser() throws IOException {
			repo= new Repo_Reader();
			System.setProperty(repo.getChromeKey(), repo.getChromePath());
			driver= new ChromeDriver();
			return driver;
		}
		
		//method to launch firefox browser
		public WebDriver fireFoxBrowser() throws IOException {
			repo= new Repo_Reader();
			System.setProperty(repo.getGeckoKey(), repo.getGeckoPath());
			driver= new FirefoxDriver();
			return driver;
		}
		public WebDriver tbrowser() throws Exception {
			System.out.println("Choose Browser \n 1.chrome \n 2. Firefox");
			Scanner sc = new Scanner(System.in);
			int opt= sc.nextInt();
			
			switch(opt) {
			case 1:
				driver=chromeBrowser();
				
				break;
			case 2:
				driver =fireFoxBrowser();
				break;
				default:
					System.out.println("enter valid number");
			}
			System.out.println("browser launched successfully");
		return driver;
		
		}
}
	
