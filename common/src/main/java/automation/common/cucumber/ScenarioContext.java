package automation.common.cucumber;

import java.util.HashMap;
import java.util.Map;

public class ScenarioContext {

	private static ScenarioContext context;
	private Map<String, Object> values;
	private String name;
	private String feature;
	private boolean isFailed;

	private ScenarioContext() {
		values = new HashMap<>();
	}

	public static ScenarioContext getInstance() {
		if (context == null) {
			context = new ScenarioContext();
		}
		return context;
	}

	public void setValue(Object key, Object value) {
		values.put(key.toString(), value);
	}

	public Object getValue(Object key) {
		return values.get(key.toString());
	}

	public Boolean isContains(Object key) {
		return values.containsKey(key.toString());
	}

	public String getScenarioName() {
		return name;
	}

	public void setScenarioName(String name) {
		this.name = name;
	}

	public String getFeatureFileName() {
		return feature;
	}

	public void setFeatureFileName(String feature) {
		this.feature = feature;
	}

	public boolean isFailed() {
		return isFailed;
	}

	public void setFailed(boolean isFailed) {
		this.isFailed = isFailed;
	}
	
	public void clear() {
		context = new ScenarioContext();
	}
}
