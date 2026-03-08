package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import hooks.HooksFile;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DemoWebShop {

	WebDriver driver = HooksFile.driver;
	WebDriverWait wait = HooksFile.wait;
	JavascriptExecutor js = HooksFile.js;
	String url = HooksFile.url;

	private String actualProductName;

	@Given("User can navigate intp demo webshop url")
	public void user_can_navigate_intp_demo_webshop_url() {
		driver.get(url);
	}

	@When("User selects the category as Books")
	public void user_selects_the_category_as_books() {
		WebElement selectCategory = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Books']")));
		selectCategory.click();
	}

	@When("User added the cart book as Computing and Internet")
	public void user_added_the_cart_book_as_computing_and_internet() {
		WebElement itemName = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Computing and Internet']")));
		actualProductName = itemName.getText();
		js.executeScript("arguments[0].scrollIntoView(true);", itemName);
		WebElement addToCartBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"//a[text()='Computing and Internet']//parent::h2//following-sibling::div[@class='add-info']/child::div[@class='buttons']//input")));
		addToCartBtn.click();
	}

	@Then("Verify the confirmation message after addeed to cart")
	public void verify_the_confirmation_message_after_addeed_to_cart() {
		WebElement ConfirmMsg = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//p[text()='The product has been added to your ']")));
		String verifyTextMsg = ConfirmMsg.getText();
		Assert.assertEquals(verifyTextMsg, "The product has been added to your");
	}

	@When("User navigates into shopping cart")
	public void user_navigates_into_shopping_cart() {
		WebElement shoppingCartBtn = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='shopping cart']")));
		shoppingCartBtn.click();
	}

	@Then("Verify the item is present in the shopping cart")
	public void verify_the_item_is_present_in_the_shopping_cart() {
		WebElement prdNamefrCart = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//td[@class='product']/child::a[@class='product-name']")));
		Assert.assertEquals(prdNamefrCart, actualProductName);
	}

	@Then("Print the total price shown in the shopping cart")
	public void print_the_total_price_shown_in_the_shopping_cart() {
		WebElement TotalPriceFromCart = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='product-price order-total']")));
		String TotalPriceFromCartText = TotalPriceFromCart.getText();
		System.out.println(TotalPriceFromCartText);
	}

}
