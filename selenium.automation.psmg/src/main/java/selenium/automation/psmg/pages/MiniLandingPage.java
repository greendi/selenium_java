package selenium.automation.psmg.pages;

import automation.common.ConfigFileReader;
import selenium.automation.psmg.selectors.MiniSelectors;
import selenium.automation.psmg.validators.MiniValidators;

public class MiniLandingPage {
    private MiniSelectors selectors;
    private MiniValidators validators;

    public void closeBanner() {
        selectors.banner().click();
    }

    public void acceptCookies() {
        selectors.cookies().click();
    }

    public void loginButton() {
        selectors.loginBtn().getWait().isClickable(null);
        selectors.loginBtn().click();
        System.out.println("Button was found");
    }

    public void chooseLoginBtn() {
        selectors.chooseLoginBtn().getWait().isClickable(null);
        selectors.chooseLoginBtn().click();
    }

    public void miniEmail(String email) {
        selectors.miniEmail().sendKeys(email);
    }

    public void miniPass(String pass) {
        selectors.miniPass().sendKeys(pass);
    }

    public void submitLogin() {
        selectors.submitLogin().getWait().isClickable(null);
        selectors.submitLogin().click();
    }

    public MiniLandingPage() {
        this.selectors = new MiniSelectors();
        this.validators = new MiniValidators();
    }

    public MiniSelectors getSelectors() {
        return selectors;
    }

    public void setSelectors(MiniSelectors selectors) {
        this.selectors = selectors;
    }

    public MiniValidators getValidators() {
        return validators;
    }

    public void setValidators(MiniValidators validators) {
        this.validators = validators;
    }

}
