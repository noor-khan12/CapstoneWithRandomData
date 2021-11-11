package stepDefinitions;

import java.util.List;
import java.util.Map;

import core.Base;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import pageObjects.RegisterPageObject;
import utilities.UtilityClass;

public class RegisterStepDef extends Base{
	
	RegisterPageObject registerPage = new RegisterPageObject(); 
	
	@When("user click on Register")
	public void user_click_on_register() {
		registerPage.clickOnRegister();
		logger.info("User clicked on register button");
		UtilityClass.takeScreenShot(); 

	}
	@And("user fill out the registration form with the below information")
	public void user_fill_out_the_registration_form_with_the_below_information(DataTable dataTable) {
		List<Map<String, String>> info = dataTable.asMaps(String.class, String.class); 
		registerPage.enterFirstName(info.get(0).get("firstName"));
		registerPage.enterLastName(info.get(0).get("lastName"));
		registerPage.enterEmail(info.get(0).get("email"));
		registerPage.enterPhone(info.get(0).get("telephone"));
		registerPage.enterPassword(info.get(0).get("password"));
		registerPage.enterConfirmPassword(info.get(0).get("confirmPassword"));
		registerPage.subscription(info.get(0).get("subscribe"));
		logger.info("user entered personal information");
		UtilityClass.takeScreenShot(); 
		
	}
	@When("user agree to privacy policy")
	public void user_agree_to_privacy_policy() {
		registerPage.clickOnPrivacyPolicy();
		logger.info("user clicked on privacy policy");
		UtilityClass.takeScreenShot();
	}
	@When("user click on continue button")
	public void user_click_on_continue_button() {
		registerPage.clickOnContinueButton();
		logger.info("user clicked on continue button");
		UtilityClass.takeScreenShot();

	}
	@Then("user should see successful message {string}")
	public void user_should_see_successful_message(String string) {
		Assert.assertEquals(string, registerPage.getSuccessMessage());
		logger.info("account was created successfully");
		UtilityClass.takeScreenShot();
		
	}
	

}
