package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import core.Base;
import utilities.UtilityClass;

public class RetailPageObject extends Base {

	public RetailPageObject() {
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//a[@title='My Account']")
	//span[normalize-space()='My Account']
	private WebElement myAccount;

	@FindBy(xpath = "//a[text()='Login']")
	private WebElement login;

	@FindBy(id = "input-email")
	private WebElement email;

	@FindBy(id = "input-password")
	private WebElement password;

	@FindBy(xpath = "//input[@value='Login']")
	private WebElement loginButton;

	@FindBy(xpath = "//h2[text()='My Account']")
	private WebElement myAccountText;
//	============== Register Affiliate User Elements====
	@FindBy(xpath = "//a[text()='Register for an affiliate account']")
	private WebElement registerAsAffiliateUserLink;

	@FindBy(xpath = "//input[@id='input-company']")
	private WebElement companyInput;

	@FindBy(xpath = "//input[@id='input-website']")
	private WebElement websiteInput;

	@FindBy(xpath = "//input[@id='input-tax']")
	private WebElement taxIDInput;

	@FindBy(xpath = "//label[normalize-space()='PayPal']")
	private WebElement paymentMethodRadioButtonPayPal;

	@FindBy(xpath = "//input[@id='input-paypal']")
	private WebElement inputPayPalEmailAccount;

	@FindBy(xpath = "//label[normalize-space()='Cheque']")
	private WebElement paymentMethodRadioButtonCheque;

	@FindBy(xpath = "//input[@id='input-cheque']")
	private WebElement inputChequePayeeName;

	@FindBy(xpath = "//input[@name='agree']")
	private WebElement aboutUsRadioButton;

	@FindBy(xpath = "//input[@value='Continue']")
	private WebElement continueButtonAffiliateUser;

	@FindBy(xpath = "//div[text()=' Success: Your account has been successfully updated.']")
	private WebElement successMessageAffiliateUserCreated;
//	================ edit affilite user elements====
	@FindBy(xpath = "//a[normalize-space()='Edit your affiliate information']")
	private WebElement editAffiliateUserInformation;

	@FindBy(xpath = "//label[normalize-space()='Bank Transfer']")
	private WebElement paymentMethodRadioButtonBankTransfer;

	@FindBy(xpath = "//input[@id='input-bank-name']")
	private WebElement inputBankName;

	@FindBy(xpath = "//input[@id='input-bank-branch-number']")
	private WebElement inputBranchNumber;

	@FindBy(xpath = "//input[@id='input-bank-swift-code']")
	private WebElement inputSWIFTCode;

	@FindBy(xpath = "//input[@id='input-bank-account-name']")
	private WebElement inputAccountName;

	@FindBy(xpath = "//input[@id='input-bank-account-number']")
	private WebElement inputAccountNumber;
//	==============edit account info elements============
	@FindBy(xpath = "//a[normalize-space()='Edit your account information']")
	private WebElement editAccountInformationLink;

	@FindBy(xpath = "//input[@id='input-firstname']")
	private WebElement inputFirstName;

	@FindBy(xpath = "//input[@id='input-lastname']")
	private WebElement inputLastName;

	@FindBy(xpath = "//input[@id='input-email']")
	private WebElement inputEmail;

	@FindBy(xpath = "//input[@id='input-telephone']")
	private WebElement inputTelePhone;

	@FindBy(xpath = "//div[text()=' Success: Your account has been successfully updated.']")
	private WebElement successMessageEditAccountInfo;

	public void clickOnMyAccount() {
		myAccount.click();
	}

	public void clickOnLogin() {
		login.click();
	}

	public void enterEmailAndPassword(String emailValue, String passwordValue) {
		email.sendKeys(emailValue);
		password.sendKeys(passwordValue);

	}

	public void clickOnLoginButton() {
		loginButton.click();

	}

	public boolean myAccountTextIsPresent() {
		if (myAccountText.isDisplayed()) {
			return true;
		} else {
			return false;
		}
	}

//	================= Affiliate User Methods ========== 
	public void clickOnRegisterAsAffiliateAccountLink() {
		registerAsAffiliateUserLink.click();
	}

	public void enterCompanyName(String companyName) {
		companyInput.sendKeys(companyName);
	}

	public void enterwebsite(String websiteName) {
		websiteInput.sendKeys(websiteName);
	}

	public void enterTaxID(String taxID) {
		taxIDInput.sendKeys(taxID);
	}

	public void selectPaymentMethod(String paymentMethod, String chequePayeOrPaypalEmail) {
		if (paymentMethod.equals("cheque")) {
			paymentMethodRadioButtonCheque.click();
			if (inputChequePayeeName.isEnabled() && inputChequePayeeName.isDisplayed()) {
				inputChequePayeeName.sendKeys(chequePayeOrPaypalEmail);
			}
		}

		else if (paymentMethod.equals("paypal")) {
			paymentMethodRadioButtonPayPal.click();
			if (inputPayPalEmailAccount.isEnabled() && inputPayPalEmailAccount.isDisplayed()) {
				inputPayPalEmailAccount.sendKeys(chequePayeOrPaypalEmail);
			}
		}
	}

	public void clickOnAboutUsOption() {
		aboutUsRadioButton.click();
	}

	public void clickOnContinueButtonAffiliateUser() {
		continueButtonAffiliateUser.click();
	}

	public boolean successMessageAffiliateUserCreatedIsDisplayed() {
		if (successMessageAffiliateUserCreated.isDisplayed()) {
			return true;
		} else {
			return false;
		}
	}

//	============== edit affiliate methods=========
	public void clickOnEditAffiliateInformatinLink() {
		editAffiliateUserInformation.click();
	}

	public void selectPaymentMethodBankTransfer() {
		if (paymentMethodRadioButtonBankTransfer.isDisplayed()) {
			paymentMethodRadioButtonBankTransfer.click();
	
		}
	}

	public void enterBankInformation(String bankName, String abaNumber, String swiftCode, String accountName,
			String accountNumber) {

		UtilityClass.ScrollToElement(inputAccountName);

		if (inputBankName.isDisplayed() && inputBankName.isEnabled()) {
			inputBankName.clear();
			inputBankName.sendKeys(bankName);
		}
		inputBranchNumber.clear();
		inputBranchNumber.sendKeys(abaNumber);
		inputSWIFTCode.clear();
		inputSWIFTCode.sendKeys(swiftCode);
		inputAccountName.clear();
		inputAccountName.click();
		inputAccountName.sendKeys(accountName);

		inputAccountNumber.click();
		inputAccountNumber.clear();
		inputAccountNumber.sendKeys(accountNumber);
	}

	// next two methods in this scenario are repeated.

//	=============== edit account info methods ====== 
	public void clickOnEditAccountInfoLink() {
		editAccountInformationLink.click();
	}

	public void enterEditAccountInfo(String firstName, String lastName, String email, String telePhone) {
		inputFirstName.click();
		inputFirstName.clear();
		inputFirstName.sendKeys(firstName);

		inputLastName.click();
		inputLastName.clear();
		inputLastName.sendKeys(lastName);

		inputEmail.click();
		inputEmail.clear();
		inputEmail.sendKeys(email);

		inputTelePhone.click();
		inputTelePhone.clear();
		inputTelePhone.sendKeys(telePhone);


	}

	// clickOnContinueButtonMethod is already present. same xpath

	public boolean isEditAccountInfoSuccessMessagePresent() {
//		String actualSuccessMessage = successMessageEditAccountInfo.getText(); 
//		String expectedSuccessMessage = " Success: Your account has been successfully updated."; 
//		if (actualSuccessMessage.equals(expectedSuccessMessage)) {
//			return true;
//		} else {
//			return false;
//		}
		if (successMessageEditAccountInfo.isDisplayed()) {
			return true;
		} else {
			return false;
		}

	}
}
