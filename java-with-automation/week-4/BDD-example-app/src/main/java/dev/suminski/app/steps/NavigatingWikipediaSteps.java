package dev.suminski.app.steps;

import dev.suminski.app.runner.Runner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class NavigatingWikipediaSteps {

    @Given("I am on the main Wikipedia page")
    public void i_am_on_the_main_wikipedia_page() {
        Runner.webDriver.get("https://www.wikipedia.org/");
    }
    @When("I click on the English Wiki link")
    public void i_click_on_the_english_wiki_link() {
        Runner.wikiHome.englishLink.click();
    }
    @Then("I should be on the English Wiki homepage")
    public void i_should_be_on_the_english_wiki_homepage() {
        Assert.assertEquals(Runner.webDriver.getTitle(),"Wikipedia, the free encyclopedia");
    }

    @When("I click on the Spanish Wiki link")
    public void i_click_on_the_spanish_wiki_link() {
        Runner.wikiHome.spanishLink.click();
    }
    @Then("I should be on the Spanish Wiki homepage")
    public void i_should_be_on_the_spanish_wiki_homepage() {
        Assert.assertEquals(Runner.webDriver.getTitle(),"Wikipedia, la enciclopedia libre");
    }

    @When("I click on the Italian Wiki link")
    public void i_click_on_the_italian_wiki_link() {
        Runner.wikiHome.italianLink.click();
    }
    @Then("I should be on the Italian Wiki homepage")
    public void i_should_be_on_the_italian_wiki_homepage() {
        Assert.assertEquals(Runner.webDriver.getTitle(),"Wikipedia, l'enciclopedia libera");
    }



}
