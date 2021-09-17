package com.revature.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

// This is an example of the PAGE OBJECT MODEL design pattern (POM)
// It allow us to create an object representation of a page and keep our Selenium automation framework organized and neat
public class FacebookLoginPage {

	private WebDriver driver;
	
	private WebElement usernameInput;
	private WebElement passwordInput;
	private WebElement loginButton;
	private WebElement h2Header;
	private WebElement incorrectPasswordElement;
	
	public FacebookLoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement username() {
		if (this.usernameInput == null) {
			this.usernameInput = this.driver.findElement(By.cssSelector("*[name='email']"));
		}
		
		return this.usernameInput;
	}
	
	public WebElement password() {
		if (this.passwordInput == null) {
			this.passwordInput = this.driver.findElement(By.id("passContainer")).findElement(By.tagName("input"));
		}
		
		return this.passwordInput;
	}
	
	public WebElement loginButton() {
		if (this.loginButton == null) {
			this.loginButton = this.driver.findElement(By.name("login"));
		}
		
		return this.loginButton;
	}
	
	public WebElement h2Header() {
		if (this.h2Header == null) {
			this.h2Header = this.driver.findElement(By.xpath("//*[contains(text(), 'Connect with')]"));
		}
		
		return this.h2Header;
	}
	
	public WebElement incorrectPassword() {
		if (this.incorrectPasswordElement == null) {
			this.incorrectPasswordElement = this.driver.findElement(By.xpath("//div[contains(text(), 'The password you')]"));
		}
		
		return this.incorrectPasswordElement;
	}
	
}
