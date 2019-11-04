package selenium.automation.psmg.pages;

import selenium.automation.psmg.selectors.LoginSelectors;
import selenium.automation.psmg.validators.LoginValidators;

public class LoginPage {
    public void LoginUserEmail(String email_login) {
        selectors.email_login().sendKeys(email_login);
    }

    public void LoginUserPass (String pass_login) {
        selectors.pass_login().sendKeys(pass_login);
        selectors.submit_login().click();
    }

    public LoginPage() {
        this.selectors = new LoginSelectors();
        this.validators = new LoginValidators();
    }

    public LoginSelectors getSelectors() {
        return selectors;
    }

    public void setSelectors(LoginSelectors selectors) {
        this.selectors = selectors;
    }

    public LoginValidators getValidators() {
        return validators;
    }

    public void setValidators(LoginValidators validators) {
        this.validators = validators;
    }

    private LoginSelectors selectors;
    private LoginValidators validators;

}
