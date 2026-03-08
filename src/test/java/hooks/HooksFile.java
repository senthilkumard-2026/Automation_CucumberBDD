package hooks;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class HooksFile {

	public static WebDriver driver;
	public static WebDriverWait wait;
	public static JavascriptExecutor js;
	public static String url = "https://demowebshop.tricentis.com/";

	@Before
	public void setUp() {
		// If you use WebDriverManager, ensure it's configured before creating
		// ChromeDriver
		// WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();

		// Avoid mixing implicit + explicit; keep implicit at 0
		driver.manage().timeouts().implicitlyWait(Duration.ZERO);
		driver.manage().window().maximize();

		// Create WebDriverWait once per scenario
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		// JavascriptExecutor
		js = (JavascriptExecutor) driver;
	}


@After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
        driver = null;
        wait = null;
        js = null;
    }


}
