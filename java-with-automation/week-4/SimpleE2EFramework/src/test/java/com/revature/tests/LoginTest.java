package com.revature.tests;

import static org.testng.Assert.assertEquals;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.revature.base.Base;
import com.revature.pages.LoginPage;
import com.revature.pages.ViewMyOwnShipsPage;

public class LoginTest extends Base {

	private static Logger logger = LoggerFactory.getLogger(LoginTest.class);
	
	private LoginPage loginPage;
	private ViewMyOwnShipsPage viewMyOwnShipsPage;
	
	public LoginTest() {
		super();
	}
	
	@BeforeClass
	public void logInitial() {
		
		logger.info("STARTING: LoginTest class");
	}
	
	@BeforeMethod
	public void setUp() {
		super.initializeDriver();
		loginPage = new LoginPage(super.driver);
		viewMyOwnShipsPage = new ViewMyOwnShipsPage(super.driver);
		super.driver.get("http://localhost:5500/index.html");
	}
	
	@Test
	public void login_withValidCredentials() {		
		loginPage.getUsernameInput().sendKeys("bach12345");
		loginPage.getPasswordInput().sendKeys("12345");
		loginPage.getLoginButton().click();
		
		String headerText = viewMyOwnShipsPage.getHeader().getText();
		
		assertEquals(headerText, "View My Own Ships Page");
	}
	
	@Test
	public void login_withInvalidCredentials() {
		loginPage.getUsernameInput().sendKeys("kjl;kjasd;lkfjl;kjl;kdf");
		loginPage.getPasswordInput().sendKeys("sdfsfsdfsdf");
		loginPage.getLoginButton().click();
		
		String text = loginPage.getInvalidLoginElement().getText();
		
		assertEquals(text, "INVALID LOGIN!");
	}
	
	@AfterMethod
	public void tearDown() {
		super.driver.quit();
	}
	
	@AfterClass
	public void logFinal() {
		logger.info("ENDING: LoginTest class");
	}
	
}
