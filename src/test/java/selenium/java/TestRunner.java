package selenium.java;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;

//@RunWith(Cucumber.class)
@CucumberOptions(format={"pretty","json:target/"} , features="/src/test/java/cucumber/features")

public class TestRunner {}