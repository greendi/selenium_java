package selenium.automation.psmg.validators;

import org.junit.Assert;
import selenium.automation.psmg.selectors.MiniSelectors;

public class MiniValidators {
    private MiniSelectors selectors;

    public void validateLogoIsVisible() {
        Assert.assertTrue("Dashboard Logo is not visible", selectors.logoMini().getAssertion().isVisible(null));
    }

    public MiniValidators() {
        this.selectors = new MiniSelectors();
    }

    public MiniSelectors getSelectors() {
        return selectors;
    }

    public void setSelectors(MiniSelectors selectors) {
        this.selectors = selectors;
    }
}
