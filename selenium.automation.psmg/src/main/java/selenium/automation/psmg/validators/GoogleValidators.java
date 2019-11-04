package selenium.automation.psmg.validators;

import automation.common.Driver;
import org.junit.Assert;
import selenium.automation.psmg.selectors.GoogleSelectors;

public class GoogleValidators {
    private GoogleSelectors selectors;

    public void validateSearchBar() {
        Assert.assertTrue("It's not there?", selectors.searchBar().getAssertion().isVisible(null));
    }

    public void validateResult() {
        Assert.assertTrue("Results are there", selectors.inputPresent().getAssertion().isVisible(null));
    }


    public GoogleValidators() {
        this.selectors = new GoogleSelectors();
    }
    public GoogleSelectors getSelectors() {
        return selectors;
    }

    public void setSelectors(GoogleSelectors selectors) {
        this.selectors = selectors;
    }
}
