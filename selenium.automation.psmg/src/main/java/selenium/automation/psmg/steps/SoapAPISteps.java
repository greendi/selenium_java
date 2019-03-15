package selenium.automation.psmg.steps;

import java.util.Arrays;

import org.junit.Assert;

import automation.common.cucumber.ScenarioContext;
import automation.webServices.SoapAPI;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.restassured.response.Response;
import selenium.automation.psmg.model.Context;
import selenium.automation.psmg.model.SoapAPITemplates;
import selenium.automation.psmg.model.SoapAPITestData;

public class SoapAPISteps {
	@Given("^the user request data from a SOAP API request$")
	public void the_user_request_data_from_a_SOAP_API_request() throws Throwable {

		Response responseSoapKeyValue = SoapAPI.runKeyValue(SoapAPITemplates.soapTemplate,
				SoapAPITestData.countryData(), SoapAPITestData.SOAP_EXAMPLE_URL, SoapAPITestData.headersData());
		ScenarioContext.getInstance().setValue(Context.RESPONSESOAPKEYVALUE, responseSoapKeyValue);

		Response responseSoapValue = SoapAPI.runValue(SoapAPITemplates.soapTemplate1, Arrays.asList("UnitedStates"),
				SoapAPITestData.SOAP_EXAMPLE_URL, SoapAPITestData.headersData());
		ScenarioContext.getInstance().setValue(Context.RESPONSESOAPVALUE, responseSoapValue);
	}

	@Then("^the user validates data from a SOAP API request$")
	public void the_user_validates_data_from_a_SOAP_API_request() throws Throwable {
		Assert.assertTrue("Holiday Code incorrect!",
				SoapAPI.checkResponseValue(
						(Response) ScenarioContext.getInstance().getValue(Context.RESPONSESOAPKEYVALUE),
						"Envelope.Body.GetHolidaysAvailableResponse.GetHolidaysAvailableResult.HolidayCode[0].Code",
						"NEW-YEARS-DAY-ACTUAL"));

		Assert.assertTrue("Holiday Code incorrect!",
				SoapAPI.checkResponseValue((Response) ScenarioContext.getInstance().getValue(Context.RESPONSESOAPVALUE),
						"Envelope.Body.GetHolidaysAvailableResponse.GetHolidaysAvailableResult.HolidayCode[0].Code",
						"NEW-YEARS-DAY-ACTUAL"));

		System.out.println("---------------------Response Key Value:--------------------");
		((Response) ScenarioContext.getInstance().getValue(Context.RESPONSESOAPKEYVALUE)).getBody().prettyPrint();

		System.out.println("--------------------Response Value:--------------------");
		((Response) ScenarioContext.getInstance().getValue(Context.RESPONSESOAPVALUE)).getBody().prettyPrint();
	}
}
