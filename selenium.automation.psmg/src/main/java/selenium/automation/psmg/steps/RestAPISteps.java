package selenium.automation.psmg.steps;

import java.util.List;

import org.junit.Assert;

import automation.common.cucumber.ScenarioContext;
import automation.webServices.RestAPI;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.restassured.response.Response;
import selenium.automation.psmg.model.Context;
import selenium.automation.psmg.model.RestAPITestData;

public class RestAPISteps {
	@Given("^the user request data from a Rest API request$")
	public void the_user_request_data_from_a_Rest_API_request() throws Throwable {

		Response responsePost = RestAPI.runPost(RestAPITestData.customerData(), RestAPITestData.headersData(),
				RestAPITestData.POST_EXAMPLE_URL);
		ScenarioContext.getInstance().setValue(Context.RESPONSEPOST, responsePost);
		System.out.println("POST reponse: ");
		responsePost.getBody().prettyPrint();

		Response responseGet = RestAPI.runGet(RestAPITestData.headersData(), RestAPITestData.GET_EXAMPLE_URL);
		ScenarioContext.getInstance().setValue(Context.RESPONSEGET, responseGet);
		System.out.println("GET response: ");
		responseGet.getBody().prettyPrint();
	}

	@Then("^the user validates data from a Rest API request$")
	public void the_user_validates_data_from_a_Rest_API_request() throws Throwable {

		// Validate POST response
		Assert.assertTrue("Status Code incorrect",
				RestAPI.hasStatusCode((Response) ScenarioContext.getInstance().getValue(Context.RESPONSEPOST), "201"));

		// Validate GET response
		Assert.assertTrue("Status Code incorrect",
				RestAPI.hasStatusCode((Response) ScenarioContext.getInstance().getValue(Context.RESPONSEGET), "200"));

		// Validate POST response values (correct)
		List<String> incorrectFieldsPOST1 = RestAPI.checkResponseValues(
				(Response) ScenarioContext.getInstance().getValue(Context.RESPONSEPOST),
				RestAPITestData.customerDataValidateCorrect());
		Assert.assertTrue("POST1 Request Body fields incorrect" + incorrectFieldsPOST1,
				incorrectFieldsPOST1.size() == 0);

//		//Validate POST response values (wrong)
//		List<String> incorrectFieldsPOST2 = rest.checkResponseValues(
//				(Response) ScenarioContext.getInstance().getValue(Context.RESPONSEPOST),
//				RestAPITestData.customerDataValidateWrong());
//		Assert.assertTrue("POST2 Request Body fields incorrect" + incorrectFieldsPOST2, incorrectFieldsPOST2.size() == 0);

		// Validate only one POST response value (correct)
		Assert.assertTrue("POST Request Body 'firstName' field incorrect", RestAPI.checkResponseValue(
				(Response) ScenarioContext.getInstance().getValue(Context.RESPONSEPOST), "firstName", "John"));
	}
}
