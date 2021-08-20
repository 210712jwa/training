package com.revature.page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class GoogleHomepageTraditionalVersion {

	private WebDriver driver;

	private WebElement searchInput;
	private WebElement searchButton;
	// etc...

	public GoogleHomepageTraditionalVersion(WebDriver driver) {
		this.driver = driver;

		this.searchInput = this.driver.findElement(By.name("q"));
		this.searchButton = this.driver.findElement(By.name("btnK"));
	}

	public void search(String searchKeywords) {

		searchInput.sendKeys("java");
		searchInput.sendKeys(Keys.ENTER);

		// If I wanted to simulate holding down the SHIFT key and typing in java -> JAVA
		// and pressing enter
		// I can utilize Selenium Action(s) to do a bunch of operations in a flexible
		// manner
//		Actions builder = new Actions(driver);
//		Action holdShiftTypeInSearchAndPressEnter = builder.keyDown(Keys.SHIFT).sendKeys(searchKeywords).sendKeys(Keys.ENTER).build();
//		holdShiftTypeInSearchAndPressEnter.perform();
//		this.searchButton.click();
	}

}
