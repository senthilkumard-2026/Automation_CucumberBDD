package hooks;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import utils.DriverManager;

public class Hooks {

	WebDriver driver;

	@Before
	public void setUp() {
		driver = DriverManager.getDriver();
		System.out.println("Browser launched");
	}

	@After
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}

}
