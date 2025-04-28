package org.fancode.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.fancode.utilities.logging.LoggingUtils;
import org.slf4j.Logger;

public class Hooks {

    private static final Logger logger = LoggingUtils.getLogger(Hooks.class);

    @Before
    public void beforeScenario() {
        logger.info("Starting Scenario Execution...");
    }

    @After
    public void afterScenario() {
        logger.info("Finished Scenario Execution.");
    }
}
