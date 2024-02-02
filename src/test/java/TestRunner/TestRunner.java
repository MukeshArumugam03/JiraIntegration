package TestRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/main/java/features",
        glue = {"stepdefinitions"},
        plugin = { "pretty","html:target/cucumber-html-report.html" })

public class TestRunner {
}
