package dev.suminski.app.poms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EnglishWiki {

    private WebDriver webDriver;

    public EnglishWiki(WebDriver webDriver){
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver,this);
    }

    @FindBy(id="searchInput")
    public WebElement searchbar;

    @FindBy(id = "searchButton")
    public WebElement submitButton;

}
