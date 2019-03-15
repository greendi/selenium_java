package selenium.automation.psmg.model;

import java.util.HashMap;
import java.util.Map;

public class SoapAPITestData {

	// SOAP EXAMPLE REQUESTS
	public static String SOAP_EXAMPLE_URL = "http://www.holidaywebservice.com//HolidayService_v2/HolidayService2.asmx?wsdl";

	public static Map<String, String> countryData() {
		Map<String, String> countryMap = new HashMap<>();
		countryMap.put("countryCode", "UnitedStates");
		return countryMap;
	}

	public static Map<String, String> headersData() {
		Map<String, String> headersMap = new HashMap<>();
		headersMap.put("Content-Type", "text/xml");
		return headersMap;
	}
}
