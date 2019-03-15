package selenium.automation.psmg.validators;

import org.junit.Assert;
import selenium.automation.psmg.selectors.RegisterSelectors;

public class RegisterValidators {
    private RegisterSelectors selectors;

    public void validateInvalidEmail(String message) {
        selectors.errorMessage().getWait().isVisible(null);
        System.out.println(selectors.errorMessage().getText());
        Assert.assertTrue(selectors.errorMessage().getText().contains(message));
    }

    public RegisterValidators() {
        this.selectors = new RegisterSelectors();
    }

    public RegisterSelectors getSelectors() {
        return selectors;
    }

    public void setSelectors(RegisterSelectors selectors) {
        this.selectors = selectors;
    }
}

