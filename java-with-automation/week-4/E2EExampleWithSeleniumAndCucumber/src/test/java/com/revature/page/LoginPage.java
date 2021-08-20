package com.revature.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	
	private WebDriver driver;
	
//	@FindBy(tagName = "h1")
	private WebElement header;
	
//	@FindBy(id = "username")
	private WebElement usernameInput;
	
//	@FindBy(id = "password")
	private WebElement passwordInput;
	
//	@FindBy(id = "login")
	private WebElement loginButton;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
//		PageFactory.initElements(driver, this);
		WebDriverWait wdw = new WebDriverWait(driver, 5);
		this.header = wdw.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h1")));
		this.usernameInput = wdw.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
		this.passwordInput = wdw.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
		this.loginButton = wdw.until(ExpectedConditions.visibilityOfElementLocated(By.id("login")));
	}
	
	public void login(String username, String password) {
		usernameInput.sendKeys(username);
		passwordInput.sendKeys(password);
		loginButton.click();
	}
	
	public String getHeaderText() {
		return header.getText();
	}
	
	public String checkForInvalidLoginText() {
		WebDriverWait wdw = new WebDriverWait(driver, 5);
		return wdw.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='INVALID LOGIN!']"))).getText();
	}
	
}
