package com.revature.testrunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="classpath:features",
		glue="com.revature.gluecode"
)
// We need to specify the directory of where the feature files are located
// Then we can specify the location (based on package notation) of where the "gluecode" files are
// Gluecode = step definitions
public class TestRunner {

}
