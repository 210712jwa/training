package com.revature.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ViewMyOwnShipsPage {
		
	private WebElement header;
	// ...
	
	public ViewMyOwnShipsPage(WebDriver driver) {
		// Explicit waits
		WebDriverWait wdw = new WebDriverWait(driver, 5);
		this.header = wdw.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/h1[1]")));
	}
	
	public String getHeaderText() {
		return header.getText();
	}
	
}
