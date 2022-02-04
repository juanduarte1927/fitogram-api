
package com.fitogram.org;

import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.thucydides.core.util.EnvironmentVariables;

public class TestEnvironments {
    private final EnvironmentVariables environmentVariables;

    public TestEnvironments(EnvironmentVariables environmentVariables) {
        this.environmentVariables = environmentVariables;
    }

    public String getRestBaseUrl() {
        return EnvironmentSpecificConfiguration.from(environmentVariables)
            .getProperty("rest.base.url");
    }

    public String getHostForHeaders() {
        return EnvironmentSpecificConfiguration.from(environmentVariables)
            .getProperty("rest.base.host");
    }

    public String getCacheForHeaders() {
        return EnvironmentSpecificConfiguration.from(environmentVariables)
            .getProperty("rest.base.cache");
    }
}
