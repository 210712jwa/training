package dev.suminski.app.poms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WikiHome {

    private WebDriver webDriver;

    public WikiHome(WebDriver webDriver){
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver,this);
    }

    @FindBy(id = "js-link-box-en")
    public WebElement englishLink;

    @FindBy(css = "div[lang='es']")
    public WebElement spanishLink;

    //this is the general format for xpath element_path[@attribute="value of attribute"]
    @FindBy(xpath = "/html/body/div[2]/div[8]/a[@data-slogan=\"L'enciclopedia libera\"]")
    public WebElement italianLink;
}
