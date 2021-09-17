package com.revature.app;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Main {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:/webdrivers/chromedriver.exe");
		
		// Sometimes you might need to do additional configuration with the settings when running your ChromeDriver
		// There is an object that you can create called a ChromeOptions object that will contain various settings
		ChromeOptions options = new ChromeOptions();
		// To enable incognito, I could add an argument to this ChromeOptions object
		options.addArguments("--incognito", "--headless");
		// --incognito is an argument to start up the browser in incognito mode
		// --headless is an argument to not have the browser actually pop up on the screen (important when running Selenium tests
		// from headless systems, such as an EC2 instance)
		// What we mean by headless is a computer that doesn't have any monitor/display/graphics card
		
		// To make use of this option, we would actually need to pass it into the ChromeDriver when we instantiate it
		WebDriver driver = new ChromeDriver(options);
		
		// WebDriver is an interface for any type of WebDriver
		// ChromeDriver is a class that implements WebDriver
//		WebDriver driver = new ChromeDriver();
		driver.get("http://facebook.com");
		
		// Examples of the "easy" locators (refer back to the powerpoint for the others)
//		WebElement emailInput = driver.findElement(By.name("email"));
//		WebElement emailInput = driver.findElement(By.id("email"));
		
		// Examples of the "hard" locators (Xpath and CSS selectors)
//		WebElement emailInput = driver.findElement(By.xpath("//*[@name='email']"));
		WebElement emailInput = driver.findElement(By.cssSelector("*[name='email']"));
		
		// This XPath is saying, select an element with a tag name of input that is a child of a div with an id
		// of passContainer
//		WebElement passwordInput = driver.findElement(By.xpath("//div[@id='passContainer']/input"));
		
		// I can chain findElements together to find the child elements that exist within a parent element
		// This example here is equivalent to the xpath example above: "//div[@id='passContainer']/input"
		WebElement passwordInput = driver.findElement(By.id("passContainer")).findElement(By.tagName("input"));
		
		WebElement loginButton = driver.findElement(By.name("login"));
		
		// XPath v. CSS
		// XPath is slower than CSS (but still fast)
		// XPath is apparently about 10 times slower, but they're both so fast, it probably really doesn't matter
		// CSS selectors are faster, but less flexible
		// XPath selectors allow you to traverse from a child element to a parent element, vice versa, etc.
		// XPath allows you to select an element based on the text of that element
//		WebElement h2Header = driver.findElement(By.xpath("//h2[text()='Connect with friends and the world around you on Facebook.']"));
		WebElement h2Header = driver.findElement(By.xpath("//*[contains(text(), 'Connect with')]")); // partial match for the text of an element
		System.out.println(h2Header.getText());
				
		// Type into emailInput
		emailInput.sendKeys("bach_tran@outlook.com");
		// Type into passwordInput
		passwordInput.sendKeys("dfdljklkjlkjfds");
		loginButton.click();
		
		WebElement incorrectPasswordElement = driver.findElement(By.xpath("//div[contains(text(), 'The password you')]"));
		System.out.println(incorrectPasswordElement.getText());
		
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		driver.quit();
	}
	
}
