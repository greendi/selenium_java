package selenium.automation.psmg.steps;

import automation.common.ConfigFileReader;
import automation.common.Driver;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import selenium.automation.psmg.pages.DashboardPage;



public class DashboardSteps {

    public DashboardPage DashboardPage = new DashboardPage();
    public ConfigFileReader ConfigFileReader = new ConfigFileReader();

    @Given("^the authentication page is accessed$")
    public void the_authentication_page_is_accessed() throws Throwable {

        Driver.startBrowser(ConfigFileReader.getConfigValue("URL"));

        DashboardPage.getValidators().validateLogoIsVisible();
        DashboardPage.selectSignInButton();
    }

    @Given("^the products page is displayed$")
    public void the_products_page_is_displayed() throws Throwable {
        Driver.startBrowser(ConfigFileReader.getConfigValue("URL"));
        DashboardPage.getValidators().validateLogoIsVisible();
    }

    @When("^the user selects a product$")
    public void the_user_selects_a_product() throws Throwable {
        DashboardPage.productSelection();
    }

    @Then("^the product's details are displayed$")
    public void the_product_s_details_are_displayed() throws Throwable {
        DashboardPage.getProductDetails();
        DashboardPage.getValidators().validateProductTitle();
    }

}
