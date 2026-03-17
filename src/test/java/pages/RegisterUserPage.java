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
	WebElement nameField;

	@FindBy(xpath = "//input[@placeholder='Email Address' and @data-qa='signup-email']")
	WebElement emailField;

	@FindBy(xpath = "//button[@data-qa='signup-button']")
	WebElement signupButton;

	@FindBy(xpath = "//h2[@class='title text-center']//b[text()='Enter Account Information']")
	WebElement enterAccountInfoMsg;

	@FindBy(xpath = "//a[text()=' Home']")
	WebElement HomePageLink;

	@FindBy(id = "id_gender1")
	WebElement titleMr;

	@FindBy(id = "id_gender2")
	WebElement titleMrs;

	@FindBy(id = "password")
	WebElement password;

	@FindBy(id = "days")
	WebElement day;

	@FindBy(id = "months")
	WebElement month;

	@FindBy(id = "years")
	WebElement year;

	@FindBy(id = "newsletter")
	WebElement newsletter;

	@FindBy(id = "optin")
	WebElement offers;

	@FindBy(id = "first_name")
	WebElement firstname;

	@FindBy(id = "last_name")
	WebElement lastname;

	@FindBy(id = "address1")
	WebElement address;

	@FindBy(id = "country")
	WebElement country;

	@FindBy(id = "state")
	WebElement state;

	@FindBy(id = "city")
	WebElement city;

	@FindBy(id = "zipcode")
	WebElement zipcode;

	@FindBy(id = "mobile_number")
	WebElement mobilenumber;

	@FindBy(xpath = "//button[text()='Create Account']")
	WebElement createAccount;

	@FindBy(xpath = "//a[text()='Continue']")
	WebElement continueBtn;

	@FindBy(xpath = "//a[text()=' Delete Account']")
	WebElement deleteAccount;

	@FindBy(xpath = "//h2[@data-qa='account-created']//b")
	WebElement accountCrtMsg;

	@FindBy(xpath = "//a[contains(text(),'Logged in as')]")
	WebElement loggedInUser;

	@FindBy(xpath = "//h2[@data-qa='account-deleted']//b")
	WebElement accountDeletedMsg;

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
		nameField.sendKeys(name);
	}

	public void enterSignupEmail(String mail) {
		emailField.sendKeys(mail);
	}

	public void clickSignUpButton() {
		signupButton.click();
	}

	public String verifyEnterAccInfoMessage() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		WebElement message = wait.until(ExpectedConditions.visibilityOf(enterAccountInfoMsg));

		return message.getText();
	}

	public void fillAccountDetails(String pass, String datePas, String monthPas, String yearPas) {
		titleMr.click();
		password.sendKeys(pass);
		day.sendKeys(datePas);
		month.sendKeys(monthPas);
		year.sendKeys(yearPas);

	}

	public void selectNewsLetter() {
		newsletter.click();
	}

	public void selectOffers() {
		offers.click();
	}

	public void fillAddress(String fstName, String lstName, String add, String coun, String st, String cty,
			String zpCode, String mbl) {

		firstname.sendKeys(fstName);
		lastname.sendKeys(lstName);
		address.sendKeys(add);
		country.sendKeys(coun);
		state.sendKeys(st);
		city.sendKeys(cty);
		zipcode.sendKeys(zpCode);
		mobilenumber.sendKeys(mbl);
	}

	public void clickCreateAccount() {
		createAccount.click();
	}

	public void clickContinue() {
		continueBtn.click();
	}

	public void deleteAccount() {
		deleteAccount.click();
	}

	public String accountCreatedMessage() {
		return accountCrtMsg.getText();
	}

	public boolean verifyLoggedInMessage(String message) {

		return loggedInUser.isDisplayed();
	}

	public String accountDeletedMessage() {
		return accountDeletedMsg.getText();
	}

}
