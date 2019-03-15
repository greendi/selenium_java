package selenium.automation.psmg.validators;

import org.junit.Assert;
import selenium.automation.psmg.selectors.DashboardSelectors;
import selenium.automation.psmg.selectors.RegisterSelectors;

public class DashboardValidators {
    private DashboardSelectors selectors;

    public void validateLogoIsVisible() {
        Assert.assertTrue("Dashboard Logo is not visible", selectors.logo().getAssertion().isVisible(null));
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
