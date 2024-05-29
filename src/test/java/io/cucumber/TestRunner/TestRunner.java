package io.cucumber.TestRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/apiFeatures", "src/test/resources/webFeatures"},
        glue = {"io.cucumber.StepDefinitions.api", "io.cucumber.StepDefinitions.web"},
        plugin = {"pretty", "json:target/cucumber.json", "html:testreport/test-reports.html"}
)
public class TestRunner {
}
