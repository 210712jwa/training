package com.revature.app;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Main {

	public static void main(String[] args) {
//		implicitWaitExample();
//		explicitWaitExample();
		fluentWaitExample();
	}
	
	public static void implicitWaitExample() {
		System.setProperty("webdriver.chrome.driver", "C:/webdrivers/chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		// For any element that is not immediately available when we call findElement
		// The implicit wait will kick in
		// This implicit wait is configured to wait for up to 5 seconds
		// Anything beyond that will result in our usual NoSuchElementException
		// If Selenium finds the element before 10 seconds, it will not wait
		// the full 10 seconds
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// Our implicit wait will apply to any code that comes after this configuration
		// for this particular WebDriver object
		
		// Implicit waits are called implicit, because we are not explicitly specifying
		// what element we are waiting on to appear on the page
		// Implicit waits are easy to set up, but are essentially a "black box" that you cannot look inside of
		// That is the main drawback of implicit waits
		
		driver.get("http://localhost:5500");
		
		// To drive home the point, can we tell in the code below that we are specifically waiting on
		// the p tag? NO!!!
		WebElement buttonElement = driver.findElement(By.id("btn"));
		buttonElement.click();
		
		WebElement pElement = driver.findElement(By.tagName("p"));
		System.out.println(pElement.getText());
		
		// However, we can through the use of explicit waits
		
		driver.quit();
	}
	
	public static void explicitWaitExample() {
		System.setProperty("webdriver.chrome.driver", "C:/webdrivers/chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://localhost:5500");
		
		WebElement buttonElement = driver.findElement(By.id("btn"));
		buttonElement.click();
		
		// Explicit wait
		
		// WebDriverWait object gives us functionality for performing an explicit wait
		WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
		
		// Wait until the p tag element appears (for a maximum of 10 seconds)
		// If not found, gives a TimeoutException
//		webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("p")));
//		WebElement pElement = driver.findElement(By.tagName("p"));
		
		// This is the same as the above, but more condensed, because the until method returns 
		// The WebElement we are waiting on once it is available
		WebElement pElement = webDriverWait
				.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("p")));
		// Explicit wait checks every 500 milliseconds to see if the element is available
		
		System.out.println(pElement.getText());
		
		driver.quit();
	}
	
	public static void fluentWaitExample() {
		System.setProperty("webdriver.chrome.driver", "C:/webdrivers/chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://localhost:5500");
		
		WebElement buttonElement = driver.findElement(By.id("btn"));
		buttonElement.click();
		
		Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
									.withTimeout(Duration.ofSeconds(10))
									.pollingEvery(Duration.ofMillis(50))
									.ignoring(NoSuchElementException.class);
		
		WebElement pElement = fluentWait.until((dr) -> {
			System.out.println("Polling for p tag");
			return dr.findElement(By.tagName("p"));
		});
		
		System.out.println(pElement.getText());
		
		driver.quit();
	}
	
}
