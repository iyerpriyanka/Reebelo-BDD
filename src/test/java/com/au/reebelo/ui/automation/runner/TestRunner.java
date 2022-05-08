package com.au.reebelo.ui.automation.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/com/au/reebelo/ui/automation/feature",
        glue = {"com/au/reebelo/ui/automation/stepDefinition"},
        plugin = {"pretty",
                "json:target/cucumber-report/cucumber.json",
                "html:target/cucumber-report/cucumber.html"},
        monochrome = true,
        dryRun = false
)
public class TestRunner {
}
