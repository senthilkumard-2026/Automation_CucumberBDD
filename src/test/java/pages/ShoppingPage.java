package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.DriverManager;

public class ShoppingPage {

	WebDriver driver;

	public ShoppingPage() {

		driver = DriverManager.getDriver();
		PageFactory.initElements(driver, this);

	}

	// Locators

	@FindBy(xpath = "//span[text()='Shopping cart']")
	WebElement shoppingCart;

	@FindBy(xpath = "//span[@class='product-subtotal']")
	WebElement totalPrice;

	@FindBy(xpath = "//div[@class='bar-notification success']//p")
	WebElement confirmationMessage;

	// Methods

	public void openURL(String url) {

		driver.get(url);
	}

	public void selectCategory(String category) {
		driver.findElement(By.linkText(category)).click();
	}

	public void addProduct(String product) {

		String xpath = "//a[text()='" + product
				+ "']/ancestor::div[@class='product-item']//input[@value='Add to cart']";

		driver.findElement(By.xpath(xpath)).click();
	}

	public String getConfirmationMessage() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		WebElement message = wait.until(ExpectedConditions.visibilityOf(confirmationMessage));

		return message.getText();
	}

	public void openCart() {

		shoppingCart.click();
	}

	public boolean verifyProduct(String product) throws InterruptedException {

		return driver.findElement(By.linkText(product)).isDisplayed();
	}

	public String getTotalPrice() {

		return totalPrice.getText();
	}

}
