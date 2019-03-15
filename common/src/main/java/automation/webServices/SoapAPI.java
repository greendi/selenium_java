package automation.webServices;

import java.text.MessageFormat;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.codec.binary.StringUtils;

import io.restassured.RestAssured;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class SoapAPI {

	public static Response runKeyValue(String template, Map<String, String> paramsMap, String url, Map<String, String> header) {
		String paramsTemplate = "<hs:%s>%s</hs:%s>";
		String res = paramsMap.keySet().stream().map(key -> String.format(paramsTemplate, key, paramsMap.get(key), key))
				.collect(Collectors.joining("\n"));

		String body = String.format(template, res);
		RestAssured.baseURI = url;
		RequestSpecification request = RestAssured.given();
		request.headers(header);
		request.body(body);
		return request.post();
	}
	
	public static Response runValue(String template, List<String> values, String url, Map<String, String> header) {
		MessageFormat messageFormat = new MessageFormat(template);
		String body = messageFormat.format(values.toArray());
		RestAssured.baseURI = url;
		RequestSpecification request = RestAssured.given();
		request.headers(header);
		request.body(body);
		return request.post();
	}

	public static boolean checkResponseValue(Response response, String key, String expectedValue) {
		XmlPath xmlPathEvaluator = response.getBody().xmlPath();
		return StringUtils.equals(xmlPathEvaluator.getString(key), expectedValue);
	}
	
	public static String replaceXmlValue(String template, List<String> values) {
		MessageFormat messageFormat = new MessageFormat(template);
		String body = messageFormat.format(values.toArray());
		return body;
	}
}
