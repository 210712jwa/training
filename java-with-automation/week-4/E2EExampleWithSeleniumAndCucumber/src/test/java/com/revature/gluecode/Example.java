package com.revature.gluecode;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.revature.page.LoginPage;
import com.revature.page.ViewMyOwnShipsPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Example {
	
	private WebDriver driver;
	private LoginPage loginPage;
	private ViewMyOwnShipsPage viewMyOwnShipsPage;
	
	@Given("We have a WebDriver instantiated and configured")
	public void we_have_a_web_driver_instantiated_and_configured() {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\BachTran\\Desktop\\chromedriver\\chromedriver.exe");
	    this.driver = new ChromeDriver();
	    
	    // Implicit wait
//	    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	    
	    // Implicit waits are easier to use, you just set it up once and then forget about it
	    
	    // But, implicit waits are a "black box", which means we really can't see what is actually being waited on.
	    // Explicit waits allow for programmers to see exactly which elements you really want to be waiting on
	    // So typically, explicit waits are actually preferable to implicit waits
	}
	
	@Then("The WebDriver should be closed")
	public void the_web_driver_should_be_closed() {
	    this.driver.quit();
	}
	
	@Given("User is at the login page")
	public void user_is_at_the_login_page() {
		driver.get("http://localhost:5500/index.html");
		
		this.loginPage = new LoginPage(this.driver);
	    
	    assertEquals("Login", loginPage.getHeaderText());
	}

	@When("User enters a valid username and valid password")
	public void user_enters_a_valid_username_and_valid_password() {
		this.loginPage.login("bach12345", "12345");
	}

	@Then("User should see a landing page with the header View My Own Ships Page")
	public void user_should_see_a_landing_page_with_the_header_view_my_own_ships_page() {
		viewMyOwnShipsPage = new ViewMyOwnShipsPage(driver);
	    assertEquals("View My Own Ships Page", viewMyOwnShipsPage.getHeaderText());
	}

	@When("User enters incorrect credentials")
	public void user_enters_incorrect_credentials() {
	    this.loginPage.login("invalidusername", "invalidpassword");
	}
	
	@Then("User should see the text INVALID LOGIN!")
	public void user_should_see_the_text_invalid_login() {
	    String text = this.loginPage.checkForInvalidLoginText();
	    assertEquals("INVALID LOGIN!", text);
	}
	
}
