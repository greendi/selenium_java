package selenium.automation.psmg.steps;

import automation.common.ConfigFileReader;
import automation.common.Driver;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import selenium.automation.psmg.pages.MiniLandingPage;

public class MiniSteps {

    public MiniLandingPage MiniLandingPage = new MiniLandingPage();
    public automation.common.ConfigFileReader ConfigFileReader = new ConfigFileReader();

    @Given("^the landing page is displayed$")
    public void the_landing_page_is_displayed() throws Throwable {
        Driver.startBrowser(ConfigFileReader.getConfigValue("MiniURL"));

        MiniLandingPage.getValidators().validateLogoIsVisible();
        MiniLandingPage.closeBanner();
        MiniLandingPage.acceptCookies();
        MiniLandingPage.loginButton();
    }

    @When("^the user introduces valid credentials$")
    public void theUserIntroducesValidCredentials() throws Throwable {
        MiniLandingPage.chooseLoginBtn();
        MiniLandingPage.miniEmail(ConfigFileReader.getConfigValue("mini_email"));
        MiniLandingPage.miniPass(ConfigFileReader.getConfigValue("mini_pass"));
        MiniLandingPage.submitLogin();
        Thread.sleep(5000);
    }

    @Then("^the user should be logged in$")
    public void theUserShouldBeLoggedIn() throws Throwable {
        MiniLandingPage.getSelectors().username();
    }
}
