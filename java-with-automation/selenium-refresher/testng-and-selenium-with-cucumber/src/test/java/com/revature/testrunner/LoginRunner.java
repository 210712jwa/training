package com.revature.testrunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features="src/test/java/com/revature/features/login.feature",
		glue="com.revature.stepdefinition",
		tags = "@Smoke"
)
public class LoginRunner extends AbstractTestNGCucumberTests {
}
