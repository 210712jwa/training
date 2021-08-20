package dev.suminski.app.steps;

import dev.suminski.app.runner.Runner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class SurfingTheWikiSteps {

    @Given("The user is on the English Wikipedia homepage")
    public void the_user_is_on_the_english_wikipedia_homepage() {
        Runner.webDriver.get("https://en.wikipedia.org/wiki/Main_Page");
    }
    @When("The user enters {string} into the searchbar")
    public void the_user_enters_into_the_searchbar(String string) {
        Runner.englishWiki.searchbar.sendKeys(string);
    }
    @When("The user clicks the search button")
    public void the_user_clicks_the_search_button() {
        Runner.englishWiki.submitButton.click();
    }
    @Then("The user should be sent to a new page with the title {string}")
    public void the_user_should_be_sent_to_a_new_page(String string) {
        Assert.assertEquals(Runner.webDriver.getTitle(), string);
    }



}
