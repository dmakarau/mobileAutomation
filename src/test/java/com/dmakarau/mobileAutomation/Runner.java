package com.dmakarau.mobileAutomation;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features="src/test/java/com/dmakarau/mobileAutomation/resourses/features/login.feature",
        plugin = {"json:target/cucumber_json/cucumber.json"}
)
public class Runner {
}
