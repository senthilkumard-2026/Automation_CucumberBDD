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

	@When("User fills account details")
	public void user_fills_account_details() {
		registerPage.fillAccountDetails("Test@1234", "9", "March", "2000");
	}

	@When("User selects newsletter checkbox")
	public void user_selects_newsletter_checkbox() {
		registerPage.selectNewsLetter();
	}

	@When("User selects special offers checkbox")
	public void user_selects_special_offers_checkbox() {
		registerPage.selectOffers();
	}

	@When("User fills address details")
	public void user_fills_address_details() {
		registerPage.fillAddress("Hitman", "Rohit", "Wankhede", "India", "Maharastra", "Bombay", "600247",
				"9124745247");
	}

	@When("User clicks Create Account button")
	public void user_clicks_create_account_button() {
		registerPage.clickCreateAccount();
	}

	@When("User clicks Continue button")
	public void user_clicks_continue_button() {
		registerPage.clickContinue();
	}

	@When("User clicks Delete Account button")
	public void user_clicks_delete_account_button() {
		registerPage.deleteAccount();
	}

	@Then("User verifies {string} message is visible")
	public void user_verifies_message_is_visible(String accountCreatedMsg) {
		Assert.assertTrue(registerPage.accountCreatedMessage().contains(accountCreatedMsg));
	}

	@Then("User verifies that message {string} is visible")
	public void user_verifies_that_message_is_visible(String loggedAsUserMsg) {
		boolean status = registerPage.verifyLoggedInMessage(loggedAsUserMsg);

		if (status) {
			System.out.println("Logged in message is visible");
		} else {
			System.out.println("Logged in message is not visible");
		}
	}

	@Then("User verifies that {string} is populated")
	public void user_verifies_that_is_populated(String acctDeletedMsg) {
		Assert.assertTrue(registerPage.accountDeletedMessage().contains(acctDeletedMsg));

	}

}
