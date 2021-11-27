package stepDefinitions;

import java.io.IOException;

import org.json.JSONException;
import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import core.Base;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.RegisterPageObject;
import pageObjects.RegisterUserAndCreateRandomDataMethods;
import pageObjects.RetailPageObject;
import utilities.UtilityClass;

public class RegisterAndLoginWithRandomDataStepDefinitions extends Base{
	RetailPageObject retailPageObject = new RetailPageObject();
	RegisterUserAndCreateRandomDataMethods registerUserAndCreateRandomDataMethods = new RegisterUserAndCreateRandomDataMethods();
	RegisterPageObject registerPageObject = new RegisterPageObject(); 
	
	@Given("^user is registered on retail website1$")
	public void user_is_registered_on_retail_website() throws InterruptedException, JSONException {
		registerPageObject.clickOnMyAccount();
		registerPageObject.clickOnRegister();
		registerUserAndCreateRandomDataMethods.registerUser();
		registerUserAndCreateRandomDataMethods.writeEmailToJsonFile();
		registerUserAndCreateRandomDataMethods.writePasswordToJsonFile();
		registerPageObject.clickOnContinueButtonAfterRegister();
		registerPageObject.clickOnLogout();
		UtilityClass.takeScreenShot();
		driver.navigate().to("http://tek-school.com/retail/");
	}

	@Given("^user is on Retail Website1$")
	public void user_is_on_Retail_Website() {
		String actualPageTitle = driver.getTitle();
		String expectedPageTitle = "TEK SCHOOL";

		Assert.assertEquals(expectedPageTitle, actualPageTitle);
		logger.info("Acutal Title is matching with expected title");
		UtilityClass.takeScreenShot();
	}


	@When("^user click on MyAccount1$")
	public void user_click_MyAccount1() {
		retailPageObject.clickOnMyAccount();
		logger.info("user clicked on My Account1");
		UtilityClass.takeScreenShot();

	}

	@And("^user click on Login1$")
	public void user_clic_Login() {
		retailPageObject.clickOnLogin();
		logger.info("user clicked on Login option");
		UtilityClass.takeScreenShot();

	}


	@And("user enter userName 'fakeEmail' and password1 'fakePassword'$")
	public void user_enter_userName_and_Password() throws IOException, ParseException, JSONException, InterruptedException {
		Thread.sleep(3000);

		String fakeJSONEmail = registerUserAndCreateRandomDataMethods.readFakeEmailFromJsonFile(); 
		String fakeJSONPassword = registerUserAndCreateRandomDataMethods.readFakePasswordFromJsonFile(); 
		// here i can put a code to refresh directory automatically for jenkins
		
		retailPageObject.enterEmailAndPassword(fakeJSONEmail, fakeJSONPassword);
		logger.info("user entered userName: "  + " and Passwod: " );
		UtilityClass.takeScreenShot();

	}

	@And("^user click on LoginButton1$")
	public void user_click_login_Button() {
		retailPageObject.clickOnLoginButton();
		logger.info("user clicked on the login button");

	}

	@Then("^user should be logged in to my account dashboard1$")
	public void user_should_be_logged_into_MyAccount() {
		Assert.assertTrue(retailPageObject.myAccountTextIsPresent());
		logger.info("user is logged into the My Account Dashboard");
		UtilityClass.takeScreenShot();

	}

}
