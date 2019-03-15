package selenium.automation.psmg.steps;

import automation.common.Driver;
import automation.common.Report;
import automation.common.cucumber.ScenarioContext;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class TestBase {

	@Before
	public void before(Scenario scenario) {
		String scenarioId = scenario.getId();
		String featureFileName = scenarioId.split(";")[0];

		ScenarioContext.getInstance().setScenarioName(scenario.getName());
		ScenarioContext.getInstance().setFeatureFileName(featureFileName);
	}

	@After
	public void thisIsAfter(Scenario scenario) throws Exception {
		if (Driver.isBrowserOpen() == true) {
			if (scenario.isFailed())		
				Report.createErrorReport(Driver.browser);
			Driver.stopBrowser();
		}
		ScenarioContext.getInstance().clear();
	}
}
