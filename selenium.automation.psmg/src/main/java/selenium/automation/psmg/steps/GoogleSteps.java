package selenium.automation.psmg.steps;

import automation.common.ConfigFileReader;
import automation.common.Driver;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import selenium.automation.psmg.pages.GooglePage;

public class GoogleSteps {

    public GooglePage GooglePage = new GooglePage();
    public ConfigFileReader ConfigFileReader = new ConfigFileReader();

    @Given("^a web browser is on the Google page$")
    public void a_web_browser_is_on_the_Google_page() throws Throwable {
        Driver.startBrowser(ConfigFileReader.getConfigValue("googleURL"));
        GooglePage.getValidators().validateSearchBar();
        GooglePage.selectSearch();
        System.out.println("search bar was found");
    }

    @When("^the search phrase \"([^\"]*)\" is entered$")
    public void the_search_phrase_is_entered(String phrase) throws Throwable {
        GooglePage.enterInput(phrase);
        System.out.println(phrase+" was entered");
    }

    @Then("^results for \"([^\"]*)\" are shown$")
    public void results_for_are_shown(String phrase) throws Throwable {
       GooglePage.getValidators().validateResult();
        System.out.println(phrase+" is present");
        GooglePage.results(phrase);
    }

    @And("^the related results include \"([^\"]*)\"$")
    public void the_related_results_include(String arg1) throws Throwable {
    }
}
