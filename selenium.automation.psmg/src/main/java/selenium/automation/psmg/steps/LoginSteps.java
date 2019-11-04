package selenium.automation.psmg.steps;

import automation.common.ConfigFileReader;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import selenium.automation.psmg.pages.LoginPage;

public class LoginSteps {

    public LoginPage LoginPage = new LoginPage();
    public ConfigFileReader ConfigFileReader = new ConfigFileReader();

    @When("^the user introduces a valid email$")
    public void the_user_introduces_a_valid_email() throws Throwable {
        LoginPage.LoginUserEmail(ConfigFileReader.getConfigValue("email_login"));
    }

    @And("^a valid pass$")
    public void a_valid_pass() throws Throwable {
       LoginPage.LoginUserPass(ConfigFileReader.getConfigValue("pass_login"));
    }


}
