package testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions
(
		features = {"src/test/resources/features/DemoWebShop.feature"}, 
        glue = {"stepDefinitions","hooks"}, 
        dryRun = false, 
        monochrome = true,
        plugin = {"pretty","html:target/cucumber-html-report.html"})
public class DemoWebShop_Runner extends AbstractTestNGCucumberTests{

}
