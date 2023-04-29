package com.magento.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

//contains the main method that runs the Selenium tests.
//multiple test classes are usually created, and each test class contains multiple test methods.
@RunWith(Cucumber.class)
@CucumberOptions(

//contains the main method that runs the Selenium tests.
//multiple test classes are usually created, and each test class contains multiple test methods.

        plugin = {"html:target/default-cucumber-reports",
                "json:target/cucumber.json"
        },

        features = "src/test/resources/features",
        tags = "@Smoke",
        glue = "com/magento/stepdef",
        dryRun = false
)
public class Runner{


}