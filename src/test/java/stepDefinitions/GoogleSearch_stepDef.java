package stepDefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import hooks.HooksFile;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GoogleSearch_stepDef  {

	WebDriver driver = HooksFile.driver;
	WebDriverWait wait = HooksFile.wait;
	String url = HooksFile.url;
	
	@Given("user can able to navigates into google website")
	public void user_can_able_to_navigates_into_google_website() {
		driver.get(url);
	}

	@When("user enters the {string} details in the search box")
	public void user_enters_the_product_details_in_the_search_box(String product_name) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("q")));
		searchBox.sendKeys(product_name, Keys.ENTER);
	}

	@Then("user can successfully see the product {string}")
	public void user_can_successfully_see_the_product_iphone_phones_google_search(String expectedProductResult) {

		String actualPageTitle = driver.getTitle();
		Assert.assertEquals(actualPageTitle, expectedProductResult);
	}

}
