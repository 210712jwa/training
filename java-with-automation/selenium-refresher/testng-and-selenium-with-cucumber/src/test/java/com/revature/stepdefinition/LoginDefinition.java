package com.revature.stepdefinition;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.revature.page.FacebookLoginPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginDefinition {

	private FacebookLoginPage loginPage;
	private WebDriver driver;
	
	@Given("User is at the login page")
	public void user_is_at_the_login_page() {
		System.setProperty("webdriver.chrome.driver", "C:/webdrivers/chromedriver.exe");
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--incognito");
		
		this.driver = new ChromeDriver(options);
		this.loginPage = new FacebookLoginPage(driver);
		
		driver.get("https://www.facebook.com/");
	}

	@Then("Header should be present with the text {string}")
	public void header_should_be_present_with_the_text(String string) {
		String actualH2HeaderText = this.loginPage.h2Header().getText();
		
		String expectedH2HeaderText = string;
		
		assertEquals(actualH2HeaderText, expectedH2HeaderText);
		
		this.driver.quit();
	}

	@When("User enters username {string}")
	public void user_enters_username(String string) {
		 this.loginPage.username().sendKeys(string);
	}

	@When("User enters password {string}")
	public void user_enters_password(String string) {
		 this.loginPage.password().sendKeys(string);
	}

	@When("User presses the login button")
	public void user_presses_the_login_button() {
		this.loginPage.loginButton().click();
	}

	@Then("User should see text for incorrect password")
	public void user_should_see_text_for_incorrect_password() {
	    String actualIncorrectPasswordText = this.loginPage.incorrectPassword().getText();
	    
	    String expectedIncorrectPasswordText = "The password you’ve entered is incorrect. Forgot Password?";
	    
	    assertEquals(actualIncorrectPasswordText, expectedIncorrectPasswordText);
	    
	    this.driver.quit();
	}
	
}
