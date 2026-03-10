package stepDefinitions;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.ShoppingPage;

public class ShoppingSteps {
	
	ShoppingPage page = new ShoppingPage();
	
	
	@Given("User navigates into {string}")
	public void user_navigates_into(String url) {
		page.openURL(url);
	}
	
	@When("User selects category {string}")
	public void user_selects_category(String category) {
	   page.selectCategory(category);
	}
	
	@When("User adds product {string} to cart")
	public void user_adds_product_to_cart(String prtName) {
	   page.addProduct(prtName);
	}
	@Then("user verifies confirmation message {string}")
	public void user_verifies_confirmation_message(String expectedMessage) {
		 Assert.assertTrue(page.getConfirmationMessage().contains(expectedMessage));
	}
	
	@When("user navigates into shopping cart")
	public void user_navigates_into_shopping_cart() {
	    page.openCart();
	}
	@Then("user verifies item {string} is present in cart")
	public void user_verifies_item_is_present_in_cart(String prtName) throws InterruptedException {
		Assert.assertTrue(page.verifyProduct(prtName));
	}
	@Then("User logs total price")
	public void user_logs_total_price() {
		System.out.println("Total Price: "+page.getTotalPrice());
	}

}
