package selenium.automation.psmg.pages;

import automation.common.cucumber.ScenarioContext;
import selenium.automation.psmg.model.Context;
import selenium.automation.psmg.selectors.DashboardSelectors;
import selenium.automation.psmg.validators.DashboardValidators;

public class DashboardPage {
	private DashboardSelectors selectors;
	private DashboardValidators validators;

	public void selectSignInButton() {
		selectors.signInButton().click();
	}

	public void productSelection() {
		selectors.productName().hover();
		System.out.println("product title: "+selectors.productName().getText());
		ScenarioContext.getInstance().setValue(Context.PRODUCTVALUE, selectors.productName().getText());
		System.out.println("stored product title: "+ScenarioContext.getInstance().getValue(Context.PRODUCTVALUE));
		selectors.moreBtn().click();
	}

	public void getProductDetails() {
		System.out.println("product details: "+selectors.productDetails().getText());
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
