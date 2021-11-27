package stepDefinitions;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.json.JSONException;
import org.json.simple.parser.ParseException;
import org.junit.Assert;

import core.Base;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.RegisterPageObject;
import pageObjects.RegisterUserAndCreateRandomDataMethods;
import pageObjects.RetailPageObject;
import utilities.UtilityClass;

public class RetailPageFakeStepDefinitions extends Base {
	
	RetailPageObject retailPageObject = new RetailPageObject();
	RegisterUserAndCreateRandomDataMethods registerUserAndCreateRandomDataMethods = new RegisterUserAndCreateRandomDataMethods();
	RegisterPageObject registerPageObject = new RegisterPageObject(); 
	

	@Given("^user is on Retail website$")
	public void user_is_on_Retail_Website() {
		String actualPageTitle = driver.getTitle();
		String expectedPageTitle = "TEK SCHOOL";

		Assert.assertEquals(expectedPageTitle, actualPageTitle);
		logger.info("Acutal Title is matching with expected title");
		UtilityClass.takeScreenShot();
	}


	@When("^user click on MyAccount$")
	public void user_click_MyAccount() {
		retailPageObject.clickOnMyAccount();
		logger.info("user clicked on My Account");
		UtilityClass.takeScreenShot();

	}

	@And("^user click on Login$")
	public void user_clic_Login() {
		retailPageObject.clickOnLogin();
		logger.info("user clicked on Login option");
		UtilityClass.takeScreenShot();

	}


	@And("user enter userName 'fakeEmail' and password 'fakePassword'$")
	public void user_enter_userName_and_Password() throws IOException, ParseException, JSONException, InterruptedException {

		String fakeJSONEmail = registerUserAndCreateRandomDataMethods.readFakeEmailFromJsonFile(); 
		String fakeJSONPassword = registerUserAndCreateRandomDataMethods.readFakePasswordFromJsonFile(); 
		retailPageObject.enterEmailAndPassword(fakeJSONEmail, fakeJSONPassword);
		logger.info("user entered userName: "  + " and Passwod: " );
		UtilityClass.takeScreenShot();

	}

	@And("^user click on LoginButton$")
	public void user_click_login_Button() {
		retailPageObject.clickOnLoginButton();
		logger.info("user clicked on the login button");

	}

	@Then("^user should be logged in to my account dashboard$")
	public void user_should_be_logged_into_MyAccount() {
		Assert.assertTrue(retailPageObject.myAccountTextIsPresent());
		logger.info("user is logged into the My Account Dashboard");
		UtilityClass.takeScreenShot();

	}
	
//	============== Register Affiliate User methods ===== 
	@When("User click on ‘Register for an Affiliate Account’ link")
	public void user_click_on_register_for_an_affiliate_account_link() {
		retailPageObject.clickOnRegisterAsAffiliateAccountLink();
		logger.info("user clicked on the login button");
		UtilityClass.takeScreenShot(); 
	}
	
	private static boolean flag = true;
	//I created this flag to use it in the below method
	//couldn't connect paymentMethod.dataTable.RetailPage.feature here 
	//so created a flag to say false if payment method is cheque and
	//true if payment method is paypal. not the best way 
	
	@When("User fill affiliate form with below information")
	public void user_fill_affiliate_form_with_below_information(DataTable dataTable) {
		List<Map<String, String>> affiliateInputs = dataTable.asMaps(String.class, String.class);  
		
		retailPageObject.enterCompanyName(affiliateInputs.get(0).get("company"));
		retailPageObject.enterwebsite(affiliateInputs.get(0).get("website"));
		retailPageObject.enterTaxID(affiliateInputs.get(0).get("taxID"));
		
		if (flag=false){
			retailPageObject.selectPaymentMethod(affiliateInputs.get(0).get("paymentMethod"), affiliateInputs.get(0).get("chequePayeeName"));
		} else {
			retailPageObject.selectPaymentMethod(affiliateInputs.get(0).get("paymentMethod"), affiliateInputs.get(0).get("paypalEmail"));
		}
		// question: can we have dataTable in feature file that has one column not used/invoke?? 
		//yes it worked without using paypalEmail cell. 
		
		logger.info("User entered info to register for affiliate user");
		UtilityClass.takeScreenShot();
	}
	@When("User check on About us check box")
	public void user_check_on_about_us_check_box() {
		retailPageObject.clickOnAboutUsOption();
		logger.info("User clicked on About Us Button");
		UtilityClass.takeScreenShot();
	}
	@When("User click on Continue button")
	public void user_click_on_continue_button() {
		retailPageObject.clickOnContinueButtonAffiliateUser();
		logger.info("User clicked on continue button");
		UtilityClass.takeScreenShot();
	}
	@Then("User should see a success message")
	public void user_should_see_a_success_message() {
		retailPageObject.successMessageAffiliateUserCreatedIsDisplayed();
		logger.info("Affiliate User Success Message is displayed!");
		UtilityClass.takeScreenShot();
	}
	
//	============edit affiliate user methods========
	
	@When("User click on ‘Edit your affiliate informationlink")
	public void user_click_on_edit_your_affiliate_informationlink() {
		retailPageObject.clickOnEditAffiliateInformatinLink();
		logger.info("user clicked on Edit your affiliate information link  ");
		UtilityClass.takeScreenShot(); 
	}
	@When("user click on Bank Transfer radio button")
	public void user_click_on_bank_transfer_radio_button() {
		retailPageObject.selectPaymentMethodBankTransfer();
		logger.info("user clicked on Bank Transfer payment method");
		UtilityClass.takeScreenShot(); 
	}
	@When("User fill Bank information with below information")
	public void user_fill_bank_information_with_below_information(DataTable dataTable) {
		List<Map<String, String>> editAffiliate = dataTable.asMaps(String.class, String.class); 
		
	retailPageObject.enterBankInformation(editAffiliate.get(0).get("bankName"), 
			editAffiliate.get(0).get("abaNumber"),
			editAffiliate.get(0).get("swiftCode"), 
			editAffiliate.get(0).get("accountName"),
			editAffiliate.get(0).get("accountNumber"));
	
	logger.info("User entered info to edit affiliate user");
	UtilityClass.takeScreenShot();
	}
	@When("User click on Continue button1")
	public void user_click_on_continue_button1() {
		retailPageObject.clickOnContinueButtonAffiliateUser();
		logger.info("User clicked on continue button");
		UtilityClass.takeScreenShot();
	}
	@Then("User should see a success message1")
	public void user_should_see_a_success_message1() {
		Assert.assertTrue(retailPageObject.successMessageAffiliateUserCreatedIsDisplayed());
		logger.info("Affiliate User Success Message is displayed!");
		UtilityClass.takeScreenShot();
	}
	
//	==================== edit account info methods ====
	@When("User click on ‘Edit your account information’ link")
	public void user_click_on_edit_your_account_information_link() {
		retailPageObject.clickOnEditAccountInfoLink();
		logger.info("user clicked on Edit Account information link  ");
		UtilityClass.takeScreenShot();
	}
	@When("User modify below information")
	public void user_modify_below_information() {
//		List<Map<String, String>> editAccount = dataTable.asMaps(String.class, String.class); 
//		
//	retailPageObject.enterEditAccountInfo(editAccount.get(0).get("firstname"), 
//			editAccount.get(0).get("lastName"),
//			editAccount.get(0).get("email"),
//			editAccount.get(0).get("telephone"));
	
	retailPageObject.enterEditAccountInfo(registerUserAndCreateRandomDataMethods.getFakeFirstName(),
						registerUserAndCreateRandomDataMethods.getFakeLasttName(),
						registerUserAndCreateRandomDataMethods.getFakeEmail(),
						registerUserAndCreateRandomDataMethods.getFakeTelePhone());
	
	logger.info("User entered info to edit affiliate user");
	UtilityClass.takeScreenShot();
	}
	
	@When("User click on continue button for edit account info")
	public void user_click_on_continue_button_for_edit_account_info() {
		retailPageObject.clickOnContinueButtonAffiliateUser();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		logger.info("user clicked on continue button");
		UtilityClass.takeScreenShot();

	}
	@Then("User should see a message ‘Success: Your account has been successfully updated.1’")
	public void user_should_see_a_message_success_your_account_has_been_successfully_updated() {
		Assert.assertTrue(retailPageObject.isEditAccountInfoSuccessMessagePresent());
		logger.info("Edit Account info Success Message is displayed!");
		UtilityClass.takeScreenShot();
	}

}
