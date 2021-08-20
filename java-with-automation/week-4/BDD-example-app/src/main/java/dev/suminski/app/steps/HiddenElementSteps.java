package dev.suminski.app.steps;

import dev.suminski.app.runner.Runner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HiddenElementSteps {

    @Given("The user is on the webpage that has a hidden button")
    public void the_user_is_on_the_webpage_that_has_a_hidden_button() {

        Runner.webDriver.get("src\\main\\resources\\page1.html");
    }
    @When("The user clicks the hidden button")
    public void the_user_clicks_the_hidden_button() {
        Runner.wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button")));
        Runner.pageOne.button.click();
    }
    @Then("The user should be on the second page")
    public void the_user_should_be_on_the_second_page() {
        Assert.assertEquals(Runner.webDriver.getTitle(),"Second Page");
    }

}
