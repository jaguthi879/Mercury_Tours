package utils;

import java.io.*;
import java.util.*;

// class to read objects from repository
public class Repo_Reader {
	Properties prop;

	public Repo_Reader() throws IOException {
		String path = System.getProperty("user.dir");
		File file = new File(path + "/ObjectRepository/object.properties");
		FileInputStream fStream = new FileInputStream(file);
		prop = new Properties();
		prop.load(fStream);
	}

	// method to get chrome key from object repository
	public String getChromeKey() {
		return prop.getProperty("ChromeKey");
	}

	// method to get Chrome path from object repository
	public String getChromePath() {
		return prop.getProperty("ChromePath");
	}

	// method to get gecko key from object repository
	public String getGeckoKey() {
		return prop.getProperty("GeckoKey");
	}

	// method to get Chrome path from object repository
	public String getGeckoPath() {
		return prop.getProperty("GeckoPath");
	}

	// method to get url from object repository
	public String getURL() {
		return prop.getProperty("URL");
	}

	// method to get excel path from object repository
	public String getExcelPath() {
		return prop.getProperty("ExcelPath");
	}

	// method to get username from object repository
	public String getUserName() {
		return prop.getProperty("userName");
	}

	// method to get password from object repository
	public String getPassword() {
		return prop.getProperty("password");
	}

	// method to get invalid password
	public String getInvalidpwd() {
		return prop.getProperty("invalid_Pwd");
	}

}
