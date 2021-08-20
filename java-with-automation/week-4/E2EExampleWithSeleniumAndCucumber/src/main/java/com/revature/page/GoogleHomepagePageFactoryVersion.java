package com.revature.page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleHomepagePageFactoryVersion {

	private WebDriver driver;

	@FindBy(name = "q")
	private WebElement searchInput;

	@FindBy(name = "btnK")
	private WebElement searchButton;

	public GoogleHomepagePageFactoryVersion(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
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
