package com.core.platform;

import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import java.io.IOException;
import java.util.Properties;

public class PropertyContext extends PropertySourcesPlaceholderConfigurer {
    private Properties allProperties;

    public void loadAllProperties() {
        try {
            allProperties = mergeProperties();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Properties getAllProperties() {
        Properties properties = new Properties();
        properties.putAll(allProperties);
        return properties;
    }
}
