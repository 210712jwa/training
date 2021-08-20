package com.revature.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ViewMyOwnShipsPage extends BasePage {

	public ViewMyOwnShipsPage(WebDriver driver) {
		super(driver);
	}
	
	public WebElement getHeader() {
		return super.getElementOnceVisible(By.xpath("/html/body/h1[1]"));
	}
	
}
