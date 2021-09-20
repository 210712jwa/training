package com.revature.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

// This is an example of the PAGE OBJECT MODEL design pattern (POM)
// It allow us to create an object representation of a page and keep our Selenium automation framework organized and neat
public class FacebookLoginPage {

	private WebDriver driver;
	
	public FacebookLoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement username() {
		return this.driver.findElement(By.cssSelector("*[name='email']"));
	}
	
	public WebElement password() {
		return this.driver.findElement(By.id("passContainer")).findElement(By.tagName("input"));
	}
	
	public WebElement loginButton() {
		return this.driver.findElement(By.name("login"));
	}
	
	public WebElement h2Header() {
		return this.driver.findElement(By.xpath("//*[contains(text(), 'Connect with')]"));
	}
	
	public WebElement incorrectPassword() {
		return this.driver.findElement(By.xpath("//div[contains(text(), 'The password you')]"));
	}
	
}
