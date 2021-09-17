package com.revature.tests;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.revature.page.FacebookLoginPage;

public class LoginTest {

	private WebDriver driver;
	private FacebookLoginPage loginPage;
	
//  @BeforeMethod
//  public void beforeMethod() {
//	  System.out.println("THIS EXECUTES BEFORE EVERY SINGLE METHOD");
//  }
//
//  @AfterMethod
//  public void afterMethod() {
//	  System.out.println("THIS EXECUTES AFTER EVERY SINGLE METHOD");
//  }

  @BeforeClass
  public void beforeClass() {
	  System.setProperty("webdriver.chrome.driver", "C:/webdrivers/chromedriver.exe");
	  
	  ChromeOptions options = new ChromeOptions();
	  options.addArguments("--incognito");
	  
	  this.driver = new ChromeDriver(options);
	  this.driver.get("http://facebook.com");
	  
	  this.loginPage = new FacebookLoginPage(driver);
  }

  @AfterClass
  public void afterClass() {
	  this.driver.quit();
  }
  
//
//  @BeforeTest
//  public void beforeTest() {
//	  System.out.println("THIS EXECUTES BEFORE EVERY SINGLE TEST");
//  }
//
//  @AfterTest
//  public void afterTest() {
//	  System.out.println("THIS EXECUTES AFTER EVERY SINGLE TEST");
//  }
//
//  @BeforeSuite
//  public void beforeSuite() {
//	  System.out.println("THIS EXECUTES BEFORE THE SUITE RUNS");
//  }
//
//  @AfterSuite
//  public void afterSuite() {
//	  System.out.println("THIS EXECUTES AFTER THE SUITE RUNS");
//  }
  
  @DataProvider(name="loginCredentials")
  public Object[][] myLoginInformationProviderMethod() {
	  return new Object[][] 
			{
		  		{"bach_tran@outlook.com", "asdfkjslkjlksdf"}
		  	};
  }
  
  // These are methods contained in a class, which is contained in a test, which is contained in a test suite
  // methods -> classes -> tests -> suites
  @Test(priority = 1)
  public void test_h2HeaderOnLoginPageIsContainingCorrectText() {
	  String actualH2HeaderText = this.loginPage.h2Header().getText();
	  
	  String expectedH2HeaderText = "Connect with friends and the world around you on Facebook.";
	  
	  assertEquals(actualH2HeaderText, expectedH2HeaderText);
  }
  
  @Test(dependsOnMethods = "test_h2HeaderOnLoginPageIsContainingCorrectText", dataProvider = "loginCredentials")
  public void test_incorrectLogin(String username, String password) {
	  
	  this.driver.get("http://facebook.com");
	  
	  this.loginPage.username().sendKeys(username);
	  this.loginPage.password().sendKeys(password);
	  this.loginPage.loginButton().click();
	  
	  String actualIncorrectPasswordText = this.loginPage.incorrectPassword().getText();
	  String expectedIncorrectPasswordText = "The password you’ve entered is incorrect. Forgot Password?";
	  
	  assertEquals(actualIncorrectPasswordText, expectedIncorrectPasswordText);
  }

}
