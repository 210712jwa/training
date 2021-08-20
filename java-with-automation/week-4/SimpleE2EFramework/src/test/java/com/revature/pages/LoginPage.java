package com.revature.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	public WebElement getUsernameInput() {
		return super.getElementOnceVisible(By.id("username"));
	}
	
	public WebElement getPasswordInput() {
		return super.getElementOnceVisible(By.id("password"));
	}
	
	public WebElement getLoginButton() {
		return super.getElementOnceVisible(By.id("login"));
	}
	
	public WebElement getHeader() {
		return super.getElementOnceVisible(By.tagName("h1"));
	}
	
	public WebElement getInvalidLoginElement() {
		return super.getElementOnceVisible(By.xpath("//p[text()='INVALID LOGIN!']"));
	}
	
}
