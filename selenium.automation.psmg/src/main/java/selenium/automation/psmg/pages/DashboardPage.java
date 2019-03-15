package selenium.automation.psmg.pages;

import selenium.automation.psmg.selectors.DashboardSelectors;
import selenium.automation.psmg.validators.DashboardValidators;

public class DashboardPage {
	private DashboardSelectors selectors;
	private DashboardValidators validators;

	public void selectRegisterButton() {
		selectors.registerButton().click();
	}

	public DashboardPage() {
		this.selectors = new DashboardSelectors();
		this.validators = new DashboardValidators();
	}

	public DashboardSelectors getSelectors() {
		return selectors;
	}

	public void setSelectors(DashboardSelectors selectors) {
		this.selectors = selectors;
	}

	public DashboardValidators getValidators() {
		return validators;
	}

	public void setValidators(DashboardValidators validators) {
		this.validators = validators;
	}
}
