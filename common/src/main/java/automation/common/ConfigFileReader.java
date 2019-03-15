package automation.common;

import java.io.BufferedReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {
	private Properties properties;
	private final String propertyFilePath = System.getenv("CONFIG_DIR");

	public ConfigFileReader() {
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(propertyFilePath));
			properties = new Properties();
			try {
				properties.load(reader);
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Property file not found at " + propertyFilePath);
		}
	}

	public String getConfigValue(String key) {
		String value = properties.getProperty(key);
		if (value != null)
			return value;
		else
			throw new RuntimeException(key + "not specified in Configuration.properties file");
	}
}
