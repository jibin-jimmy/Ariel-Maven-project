package com.mindtree.ReusableComponents;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigurationReader {

    private Properties properties;

    public ConfigurationReader() {
        properties = new Properties();
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("properties/config.properties")) {
            if (input == null) {
                throw new RuntimeException("config.properties not found in classpath under properties/");
            }
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load config.properties: " + e.getMessage());
        }
    }

    public String getAllProperties(String propertyName) {
        String value = properties.getProperty(propertyName);
        if (value != null) {
            System.out.println(value);
            return value;
        } else {
            throw new RuntimeException(propertyName + " not specified in config.properties");
        }
    }
}
