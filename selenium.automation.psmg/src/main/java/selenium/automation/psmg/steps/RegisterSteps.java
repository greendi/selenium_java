package selenium.automation.psmg.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import selenium.automation.psmg.pages.RegisterPage;

public class RegisterSteps {

    public RegisterPage RegisterPage = new RegisterPage();

    @When("^the user introduces an invalid email \"([^\"]*)\"$")
    public void the_user_introduces_an_invalid_email(String email) throws Throwable {
        RegisterPage.addAccount(email);
    }

    @Then("^the error message \"([^\"]*)\" is displayed$")
    public void the_error_message_is_displayed(String message) throws Throwable {
        RegisterPage.getValidators().validateInvalidEmail(message);
    }

    @And("^the user introduces a valid unregistered email$")
    public void the_user_introduces_a_valid_unregistered_email() throws Throwable {
        RegisterPage.getValidators().generateRandomEmail();
        //RegisterPage.submitAccount();
    }

    @When("^the user makes valid inputs for all mandatory fields$")
    public void the_user_makes_valid_inputs_for_all_mandatory_fields() throws Throwable {
        RegisterPage.createAccount();
    }
}
