package selenium.automation.psmg.model;

import java.util.HashMap;
import java.util.Map;

public class RestAPITestData {
	
	//RESTAPI EXAMPLE REQUESTS
	public static String POST_EXAMPLE_URL = "https://jsonplaceholder.typicode.com/posts";
	public static String GET_EXAMPLE_URL = "https://jsonplaceholder.typicode.com/posts/1";
	
	public static Map<String, String> customerData() {
		Map<String, String> customerMap = new HashMap<>();
		customerMap.put("firstName", "John");
		customerMap.put("lastName", "Doe");
		customerMap.put("phone", "+400765539652");
		customerMap.put("userName", "johnd");
		customerMap.put("password", "P@ssw0rd00");
		return customerMap;
	}
	
	public static Map<String, String> customerDataValidateCorrect() {
		Map<String, String> customerMap = new HashMap<>();
		customerMap.put("firstName", "John");
		customerMap.put("lastName", "Doe");
		customerMap.put("phone", "+400765539652");
		customerMap.put("userName", "johnd");
		customerMap.put("password", "P@ssw0rd00");
		return customerMap;
	}
	
	public static Map<String, String> customerDataValidateWrong() {
		Map<String, String> customerMap = new HashMap<>();
		customerMap.put("firstName", "JohnX");
		customerMap.put("lastName", "DoeX");
		customerMap.put("phone", "+400765539652X");
		customerMap.put("userName", "johndX");
		customerMap.put("password", "P@ssw0rd00X");
		return customerMap;
	}
	
	public static Map<String, String> headersData() {
		Map<String, String> headersMap = new HashMap<>();
		headersMap.put("Content-Type", "application/json; charset=UTF-8");
		headersMap.put("X-clien-id", "someClient");
		return headersMap;
	}

}
