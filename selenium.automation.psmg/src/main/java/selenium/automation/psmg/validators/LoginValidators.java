package selenium.automation.psmg.validators;

import selenium.automation.psmg.selectors.LoginSelectors;

public class LoginValidators {
    private LoginSelectors selectors;


    public LoginValidators() {
        this.selectors = new LoginSelectors();
    }

    public LoginSelectors getSelectors() {
        return selectors;
    }

    public void setSelectors(LoginSelectors selectors) {
        this.selectors = selectors;
    }
}

