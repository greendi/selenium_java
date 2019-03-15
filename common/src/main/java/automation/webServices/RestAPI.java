package automation.webServices;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.codec.binary.StringUtils;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestAPI {

	public static Response runPost(Map<String, String> body, Map<String, String> header, String url) {
		RestAssured.baseURI = url;
		RequestSpecification request = RestAssured.given();
		if (header != null) {
			request.headers(header);
		}
		if (body != null) {
			request.body(body);
		}
		return request.post();
	}

	public static Response runPostWithoutBody(Map<String, String> header, String url) {
		return runPost(null, header, url);
	}

	public static Response runGet(Map<String, String> header, String url) {
		RestAssured.baseURI = url;
		RequestSpecification request = RestAssured.given();
		if (header != null) {
			request.headers(header);
		}
		return request.get();
	}
	
	public static boolean hasStatusCode(Response response, String statusCode) {
		return response.getStatusCode() == Integer.parseInt(statusCode);
	}
	
	public static boolean checkResponseValue(Response response, String key, String expectedValue) {
		JsonPath jsonPathEvaluator = response.jsonPath();
		return StringUtils.equals(jsonPathEvaluator.getString(key), expectedValue);
	}
	
	public static List<String> checkResponseValues(Response response, Map<String, String> expectedValues) {
		JsonPath jsonPathEvaluator = response.jsonPath();
		List<String> result =  expectedValues.keySet().stream().filter(key -> !expectedValues.get(key).equals(jsonPathEvaluator.get(key))).collect(Collectors.toList());
		return result;
	}

}
