package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import core.Base;

public class RegisterPageObject extends Base {
	public RegisterPageObject() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[normalize-space()='Register']")
	private WebElement register;

	@FindBy(xpath = "//input[@id='input-firstname']")
	private WebElement firstName;

	@FindBy(xpath = "//input[@id='input-lastname']")
	private WebElement lastName;

	@FindBy(xpath = "//input[@id='input-email']")
	private WebElement email;

	@FindBy(xpath = "//input[@id='input-telephone']")
	private WebElement telePhone;

	@FindBy(xpath = "//input[@id='input-password']")
	private WebElement password;

	@FindBy(xpath = "//input[@id='input-confirm']")
	private WebElement confirmPassword;

	@FindBy(xpath = "//label[normalize-space()='Yes']")
	private WebElement subscribeYes;

	@FindBy(xpath = "//label[normalize-space()='No']")
	private WebElement subscribeNo;

	@FindBy(xpath = "//input[@name='agree']")
	private WebElement privacyPolicy;

	@FindBy(xpath = "//input[@value='Continue']")
	private WebElement continueButton;

	@FindBy(xpath = "//h1[text()='Your Account Has Been Created!']")
	private WebElement successMessage;

	public void clickOnRegister() {
		register.click();
	}

	public void enterFirstName(String fname) {
		firstName.sendKeys(fname);
	}

	public void enterLastName(String lname) {
		lastName.sendKeys(lname);
	}

	public void enterEmail(String e_mail) {
		email.sendKeys(e_mail);
	}

	public void enterPhone(String phoneNumber) {
		telePhone.sendKeys(phoneNumber);
	}

	public void enterPassword(String pass) {
		password.sendKeys(pass);
	}

	public void enterConfirmPassword(String confirmPass) {
		confirmPassword.sendKeys(confirmPass);
	}

	public void subscription(String value) {
		if (value.equalsIgnoreCase("yes") && !subscribeYes.isSelected()) {
			subscribeYes.click();
		} else if (value.equalsIgnoreCase("no") && !subscribeNo.isSelected()) {
			subscribeNo.click();
		}

	}

	public void clickOnPrivacyPolicy() {
		if (!privacyPolicy.isSelected()) 
			privacyPolicy.click();
		
	}

	public void clickOnContinueButton() {
		continueButton.click();
	}

	public String getSuccessMessage() {
		return successMessage.getText();
	}
}
