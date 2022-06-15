package com.spartaglobal.moviesapi;


import static io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;
import org.springframework.test.context.ActiveProfiles;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("com/spartaglobal/moviesapi/steps")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "com.spartaglobal.moviesapi.steps")
public class RunCucumberTest {
}
