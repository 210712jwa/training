package com.revature.demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.revature.page.GoogleHomepagePageFactoryVersion;

public class Example {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\BachTran\\Desktop\\chromedriver\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.get("http://google.com");
		
		// We use findElement to find elements from the web browser
		// It takes in a "locator object" (By)
		// The locators available for Selenium are the following:
		// 	1. By.className
		// 	2. By.id
		//  3. By.name
		//	4. By.tagName
		//	5. By.linkText
		//  6. By.partialLinkText
		// 	7. By.css
		//  8. By.xpath
		GoogleHomepagePageFactoryVersion homepage = new GoogleHomepagePageFactoryVersion(driver);
		homepage.search("java");

		Thread.sleep(5000);
		driver.quit();
	}

}
