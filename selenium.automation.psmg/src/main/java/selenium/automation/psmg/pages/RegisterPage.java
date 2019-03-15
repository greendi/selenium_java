package selenium.automation.psmg.pages;

import selenium.automation.psmg.selectors.RegisterSelectors;
import selenium.automation.psmg.validators.RegisterValidators;

public class RegisterPage {
	private RegisterSelectors selectors;
	private RegisterValidators validators;

	public void createAccount(String email) {
		selectors.email().sendKeys(email);
		selectors.submit().click();
	}

	public RegisterPage() {
		this.selectors = new RegisterSelectors();
		this.validators = new RegisterValidators();
	}

	public RegisterSelectors getSelectors() {
		return selectors;
	}

	public void setSelectors(RegisterSelectors selectors) {
		this.selectors = selectors;
	}

	public RegisterValidators getValidators() {
		return validators;
	}

	public void setValidators(RegisterValidators validators) {
		this.validators = validators;
	}
}


