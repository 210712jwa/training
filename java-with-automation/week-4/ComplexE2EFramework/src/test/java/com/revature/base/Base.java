package com.revature.base;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.revature.utils.OSChecker;

public abstract class Base {

	public Properties properties;
	public WebDriver driver;
	
	public Base() {
		super();
		
		// Loads the properties from my config.properties file into the Properties object of this Base object
		this.properties = new Properties();
		InputStream is = Base.class.getResourceAsStream("/config.properties");
		
		try {
			this.properties.load(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void initializeDriver() {
		if (this.properties.getProperty("browser").equalsIgnoreCase("chrome")) {
			
			// Check if the ChromeDriver should run in headless mode or not, and have it set to the appropriate setting
			ChromeOptions options = new ChromeOptions();
			if (this.properties.getProperty("headless").equalsIgnoreCase("true")) {
				options.addArguments("--headless");
			}
			
			OSChecker checker = new OSChecker();
			// Check if the OS is Windows
			if (checker.isWindows()) {
				System.out.println("Setting up driver for Windows");
				System.setProperty("webdriver.chrome.driver", "driver/chromedriver_windows.exe");
			} else if (checker.isMac()) {
				System.out.println("Setting up driver for Mac");
				System.setProperty("webdriver.chrome.driver", "driver/chromedriver_mac");
			} else if (checker.isUnix()) {
				System.out.println("Setting up driver for Linux");
				System.setProperty("webdriver.chrome.driver", "driver/chromedriver_linux");
			}
			
			this.driver = new ChromeDriver(options);
		} else if (this.properties.getProperty("browser").equalsIgnoreCase("firefox")) {
			// ...
		} else if (this.properties.getProperty("browser").equalsIgnoreCase("edge")) {
			// ...
		}
	}
	
}
