package stepDefinitions;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.RegisterUserPage;

public class AutomationExerciseStepDef {

	RegisterUserPage registerPage = new RegisterUserPage();

	@Given("User navigates into url as {string}")
	public void user_navigates_into_url_as(String url) {
		registerPage.openUrl(url);
	}

	@Given("User verifies the home page is visible successfully")
	public void user_verifies_the_home_page_is_visible_successfully() {
		registerPage.verifyHomePageVisible();
	}

	@When("User clicks the SignupLogin button")
	public void user_clicks_the_button() {
		registerPage.clickSignupLink();
	}

	@When("User verifies {string} is visible")
	public void user_verifies_is_visible(String NewSignupMsg) {
		Assert.assertTrue(registerPage.verifyNewSignupMessage().contains(NewSignupMsg));
	}

	@When("User enters the name and email address")
	public void user_enters_the_name_and_email_address() {
		registerPage.enterSignupName("Hitman");
		registerPage.enterSignupEmail("hitman367@gmail.com");
	}

	@When("User clicks the Signup button")
	public void user_clicks_the_Signup_button() {
		registerPage.clickSignUpButton();
	}

	@Then("User verifies that {string} is visible")
	public void user_verifies_that_is_visible(String enterAccMsg) {
		Assert.assertTrue(registerPage.verifyEnterAccInfoMessage().contains(enterAccMsg));
	}

}
