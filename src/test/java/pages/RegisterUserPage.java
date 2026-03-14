package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import utils.DriverManager;

public class RegisterUserPage {

	WebDriver driver;

	public RegisterUserPage() {
		driver = DriverManager.getDriver();
		PageFactory.initElements(driver, this);
	}

	// Locators

	@FindBy(xpath = "//a[text()=' Signup / Login']")
	WebElement singUpButtonLink;

	@FindBy(xpath = "//div[@class='signup-form']//h2[text()='New User Signup!']")
	WebElement NewSignUpTitle;

	@FindBy(xpath = "//input[@placeholder='Name']")
	WebElement signupName;

	@FindBy(xpath = "//input[@placeholder='Email Address' and @data-qa='signup-email']")
	WebElement signupEmail;

	@FindBy(xpath = "//button[@data-qa='signup-button']")
	WebElement signupButton;

	@FindBy(xpath = "//h2[@class='title text-center']//b[text()='Enter Account Information']")
	WebElement enterAccountInfoMsg;

	@FindBy(xpath = "//a[text()=' Home']")
	WebElement HomePageLink;
	
	// Methods

	public void openUrl(String url) {
		driver.get(url);
	}

	public void clickSignupLink() {
		singUpButtonLink.click();
	}

	public void verifyHomePageVisible() {
		HomePageLink.isDisplayed();
	}

	public String verifyNewSignupMessage() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		WebElement message = wait.until(ExpectedConditions.visibilityOf(NewSignUpTitle));

		return message.getText();
	}

	public void enterSignupName(String name) {
		signupName.sendKeys(name);
	}

	public void enterSignupEmail(String mail) {
		signupEmail.sendKeys(mail);
	}

	public void clickSignUpButton() {
		signupButton.click();
	}

	public String verifyEnterAccInfoMessage() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		WebElement message = wait.until(ExpectedConditions.visibilityOf(enterAccountInfoMsg));

		return message.getText();
	}

}
