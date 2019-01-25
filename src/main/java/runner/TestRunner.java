package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;


@CucumberOptions(
        features = "src/main/java/features", //path of the features files
        glue = {"stepDefinitions"}, //path of the step definitions files
        dryRun = false, //to check the mapping is proper between features files and step definitions files
        plugin = {"pretty", "html:target/cucumber-reports", "json:target/report.json"} //to generate reports
                )


public class TestRunner extends AbstractTestNGCucumberTests {
}