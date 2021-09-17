package com.revature.app;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.revature.page.FacebookLoginPage;

public class Main {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:/webdrivers/chromedriver.exe");

		ChromeOptions options = new ChromeOptions();
//		options.addArguments("--incognito", "--headless");
		options.addArguments("--incognito");
		WebDriver driver = new ChromeDriver(options);

		driver.get("http://facebook.com");
		
		FacebookLoginPage loginPage = new FacebookLoginPage(driver);
		
		System.out.println(loginPage.h2Header().getText());
		loginPage.username().sendKeys("bach_tran@outlook.com");
		loginPage.password().sendKeys("asdfsdfsdfdsf");
		loginPage.loginButton().click();
		System.out.println(loginPage.incorrectPassword().getText());
		
		driver.quit();
	}
	
}
