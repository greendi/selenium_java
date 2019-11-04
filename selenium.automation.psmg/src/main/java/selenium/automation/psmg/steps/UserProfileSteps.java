package selenium.automation.psmg.steps;

        import automation.common.ConfigFileReader;
        import automation.common.Driver;
        import cucumber.api.java.en.Given;
        import cucumber.api.java.en.Then;
        import cucumber.api.java.en.When;
        import selenium.automation.psmg.pages.DashboardPage;
        import selenium.automation.psmg.pages.LoginPage;
        import selenium.automation.psmg.pages.UserProfilePage;


public class UserProfileSteps {

    public UserProfilePage UserProfilePage = new UserProfilePage();
    public DashboardPage DashboardPage = new DashboardPage();
    public automation.common.ConfigFileReader ConfigFileReader = new ConfigFileReader();
    public LoginPage LoginPage = new LoginPage();

    @Then("^the \"([^\"]*)\" page is displayed$")
    public void the_page_is_displayed(String authenticated) throws Throwable {
        UserProfilePage.getValidators().userProfileIsDisplayed(authenticated);

    }

    @Given("^the user is logged in$")
    public void the_user_is_logged_in() throws Throwable {
        Driver.startBrowser(ConfigFileReader.getConfigValue("URL"));

        DashboardPage.getValidators().validateLogoIsVisible();
        DashboardPage.selectSignInButton();
        LoginPage.LoginUserEmail(ConfigFileReader.getConfigValue("email_login"));
        LoginPage.LoginUserPass(ConfigFileReader.getConfigValue("pass_login"));
    }

    @When("^the user signs out$")
    public void the_user_signs_out() throws Throwable {
        UserProfilePage.getValidators().logoutUser();
    }


    @Then("^the user is logged out$")
    public void theUserIsLoggedOut() throws Throwable {
        DashboardPage.getValidators().validateLogoIsVisible();
    }
}
