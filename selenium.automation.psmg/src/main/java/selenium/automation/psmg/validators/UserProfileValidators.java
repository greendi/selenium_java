package selenium.automation.psmg.validators;

import automation.common.ConfigFileReader;
import org.junit.Assert;
import selenium.automation.psmg.selectors.UserProfileSelectors;

public class UserProfileValidators {
    private UserProfileSelectors selectors;
    public automation.common.ConfigFileReader ConfigFileReader = new ConfigFileReader();

    public void userProfileIsDisplayed(String authenticated) {
        selectors.userProfile().getWait().isVisible(null);
        System.out.println(selectors.userProfile().getText());
        Assert.assertTrue(selectors.userProfile().getText().contains(authenticated));
    }

    public void loginUser() {

    }
    public void logoutUser() {
        selectors.logoutBtn().click();
    }

    public UserProfileValidators() {
        this.selectors = new UserProfileSelectors();
    }

    public UserProfileSelectors getSelectors() {
        return selectors;
    }

    public void setSelectors (UserProfileSelectors selectors){
        this.selectors = selectors;
    }


}
