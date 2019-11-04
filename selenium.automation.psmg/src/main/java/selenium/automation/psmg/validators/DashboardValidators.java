package selenium.automation.psmg.validators;

import automation.common.cucumber.ScenarioContext;
import automation.common.selector.SingleElementSelector;
import org.junit.Assert;
import selenium.automation.psmg.model.Context;
import selenium.automation.psmg.pages.DashboardPage;
import selenium.automation.psmg.selectors.DashboardSelectors;

import java.util.HashMap;

public class DashboardValidators {
    private DashboardSelectors selectors;

    public void validateLogoIsVisible() {
        Assert.assertTrue("Dashboard Logo is not visible", selectors.logo().getAssertion().isVisible(null));
    }

    public void validateProductTitle() {
        if(ScenarioContext.getInstance().getValue(Context.PRODUCTVALUE).equals(selectors.productDetails().getText()))
        {
            System.out.println("Test PASSED: title is the same");
        }
    }

    public DashboardValidators() {
        this.selectors = new DashboardSelectors();
    }

    public DashboardSelectors getSelectors() {
        return selectors;
    }

    public void setSelectors(DashboardSelectors selectors) {
        this.selectors = selectors;
    }
}
