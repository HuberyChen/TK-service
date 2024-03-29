package com.core.platform;

import org.springframework.context.annotation.Bean;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import java.io.IOException;
import java.util.Properties;

/**
 * @author hubery.chen
 */
public class DefaultAppConfig {
    @Inject
    private ConfigurableEnvironment environment;

    @Bean
    static PropertyContext propertyContext() throws IOException {
        PropertyContext propertySource = new PropertyContext();
        propertySource.setLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:*.properties"));
        propertySource.loadAllProperties();
        return propertySource;
    }

    @PostConstruct
    void configureEnvironment() throws IOException {
        environment.setIgnoreUnresolvableNestedPlaceholders(true);
        Properties properties = propertyContext().getAllProperties();
        environment.getPropertySources().addLast(new PropertiesPropertySource("properties", properties));
    }
}
