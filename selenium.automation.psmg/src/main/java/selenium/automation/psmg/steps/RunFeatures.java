package selenium.automation.psmg.steps;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/main/java/selenium/automation/psmg/features", glue = {
		"selenium.automation.psmg.steps" }, plugin = { "html:target/cucumber-test-results-report" }, format = {"json:target/cucumber.json"})
public class RunFeatures {
}
