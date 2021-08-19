package dev.suminski.app.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ExampleSteps {

    // This format is provided by Tidy Gherkin (google extension)

    @Given("^start$")
    public void start() {
        System.out.println("this is the start");
    }

    @When("^Middle$")
    public void middle() {
        System.out.println("This is the middle");
    }

    @Then("^end$")
    public void end() {
        System.out.println("this is the end");
    }
}
