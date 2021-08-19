package dev.suminski.app.runner;

import dev.suminski.app.poms.EnglishWiki;
import dev.suminski.app.poms.PageOne;
import dev.suminski.app.poms.WikiHome;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.util.concurrent.TimeUnit;


@RunWith(Cucumber.class)
@CucumberOptions(features ="classpath:features", glue = "dev/suminski/app/steps")
public class Runner {

    public static WebDriver webDriver;
    public static WikiHome wikiHome;
    public static EnglishWiki englishWiki;
    public static PageOne pageOne;
    public static WebDriverWait wait;

    @BeforeClass
    public static void setup(){
        File file = new File("C:\\Users\\EricSuminski\\Desktop\\WebDrivers\\chromedriver_win32\\chromedriver.exe");
        System.setProperty("webdriver.chrome.driver",file.getAbsolutePath());
        webDriver = new ChromeDriver();
        wikiHome = new WikiHome(webDriver);
        englishWiki = new EnglishWiki(webDriver);
        pageOne = new PageOne(webDriver);
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        wait = new WebDriverWait(Runner.webDriver, 5);
    }

    @AfterClass
    public static void teardown(){
        webDriver.close();
    }

}
