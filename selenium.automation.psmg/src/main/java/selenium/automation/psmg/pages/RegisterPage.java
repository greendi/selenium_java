package selenium.automation.psmg.pages;

import selenium.automation.psmg.selectors.RegisterSelectors;
import selenium.automation.psmg.validators.RegisterValidators;

public class RegisterPage {
	private RegisterSelectors selectors;
	private RegisterValidators validators;

	public void addAccount(String email) {
		selectors.email().sendKeys(email);
		selectors.submit().click();
	}

	public void createAccount () throws InterruptedException {
		selectors.firstName().sendKeys("Diana");
		selectors.lastName().sendKeys("Te");
		selectors.passRegister().sendKeys("password1");
		selectors.address().sendKeys("Street 11");
		selectors.city().sendKeys("Washington");
		selectors.zip().sendKeys("12345");
		selectors.state().getWait().isClickable(null);
		selectors.state().sendKeysFocus("Alabama");
		selectors.mobilePhone().sendKeys("555-123524");
		selectors.registerBtn().click();
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


