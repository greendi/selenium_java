package selenium.automation.psmg.pages;

import selenium.automation.psmg.selectors.UserProfileSelectors;
import selenium.automation.psmg.validators.UserProfileValidators;

public class UserProfilePage {
    private UserProfileSelectors selectors;
    private UserProfileValidators validators;

    public void logoutButton(){
        selectors.logoutBtn().click();
    }
    public UserProfilePage() {
        this.selectors = new UserProfileSelectors();
        this.validators = new UserProfileValidators();
    }

    public UserProfileSelectors getSelectors() {
        return selectors;
    }

    public void setSelectors(UserProfileSelectors selectors) {
        this.selectors = selectors;
    }

    public UserProfileValidators getValidators() {
        return validators;
    }

    public void setValidators(UserProfileValidators validators) {
        this.validators = validators;
    }



}
