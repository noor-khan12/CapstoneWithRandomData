package stepDefinitions;

import org.junit.Assert;

import core.Base;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.IphonePageObject;


public class IphoneStepDefinition extends Base{
	
	IphonePageObject iphonePageObject = new IphonePageObject(); 
	
	@When("user search for {string}")
	public void user_search_for(String string) {
	iphonePageObject.enterValue(string);
	}
	
	
	@Then("iphone should be displayed")
	public void iphone_should_be_displayed() {
	Assert.assertTrue(iphonePageObject.isSearchResultTextDisplayed());
	
	}

}
