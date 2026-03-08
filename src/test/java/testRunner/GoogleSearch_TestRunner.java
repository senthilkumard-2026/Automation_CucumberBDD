package testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions
(
		features = {"src/test/resources/features/Google_Search.feature"}, 
        glue = {"stepDefinitions","hooks"}, 
        dryRun = true, 
        monochrome = true,
        tags = "@Smoke",
        plugin = {"pretty","html:target/cucumber-html-report.html"})
public class GoogleSearch_TestRunner extends AbstractTestNGCucumberTests {

}
