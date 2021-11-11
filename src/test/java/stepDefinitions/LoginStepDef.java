package stepDefinitions;

import org.junit.Assert;

import core.Base;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LoginPageObject;
import utilities.UtilityClass;


public class LoginStepDef extends Base {
	
	LoginPageObject loginPageObject = new LoginPageObject(); 
	
	
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
		loginPageObject.clickOnMyAccount();
		logger.info("user clicked on My Account");
		UtilityClass.takeScreenShot();

	}
	
	@And("^user click on Login$")
	public void user_clic_Login(){
		loginPageObject.clickOnLogin(); 
		logger.info("user clicked on Login option");
		UtilityClass.takeScreenShot();


	}
	
	@And("^user enter userName '(.+)' and password '(.+)'$")
	public void user_enter_userName_and_Password(String userName, String Password) {
		loginPageObject.enterEmailAndPassword(userName, Password);
		logger.info("user entered userName: "+userName+" and Passwod: "+Password);
		UtilityClass.takeScreenShot();


	}
	@And("^user click on LoginButton$")
	public void user_click_login_Button() {
		loginPageObject.clickOnLoginButton();
		logger.info("user clicked on the login button");

	}
	
	@Then("^user should be logged in to my account dashboard$")
	public void user_should_be_logged_into_MyAccount() {
		Assert.assertTrue(loginPageObject.myAccountTextIsPresent());
		logger.info("user is logged into the My Account Dashboard");
		UtilityClass.takeScreenShot();

		
	}
	
	
	
}
