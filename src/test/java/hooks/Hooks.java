package hooks;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import utils.DriverManager;

public class Hooks {

	@Before
	public void setUp() {
		DriverManager.getDriver();
		System.out.println("Browser launched");
	}

	@After
	public void tearDown() {

		if (DriverManager.driver != null) {
			DriverManager.driver.quit();
		}
	}
}
