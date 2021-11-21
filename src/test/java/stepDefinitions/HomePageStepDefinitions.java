package stepDefinitions;

import org.junit.Assert;

import core.Base;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.masterthought.cucumber.util.Util;
import pageObjects.HomePageObjects;
import utilities.UtilityClass;

public class HomePageStepDefinitions extends Base{
	
	HomePageObjects homePageObjects = new HomePageObjects(); 
	
	@Given("User is on Retail website")
	public void user_is_on_retail_website() {
		String actualPageTitle = driver.getTitle(); 
		String expectedPageTitle = "TEK SCHOOL"; 
	
		Assert.assertEquals(actualPageTitle, expectedPageTitle);
		logger.info("Actual title is matching with expected Title, so User is on retail website homepage");
		UtilityClass.takeScreenShot(); 

	}
	
	@When("User click on currency")
	public void user_click_on_currency() {
		homePageObjects.clickOnCurrencyButton();
		logger.info("User click on Currency Button");
		UtilityClass.takeScreenShot(); 
	}
	@When("User choose Euro from dropdown")
	public void user_choose_euro_from_dropdown() {
		homePageObjects.clickOnEuroCurrency();
		logger.info("User choose Euro from Dropdown");
		UtilityClass.takeScreenShot();
		
	}
	@Then("Currency value should change to Euro")
	public void currency_value_should_change_to_euro() {
		Assert.assertTrue(homePageObjects.euroCurrencyIsDisplayed());
		logger.info("Currency value has changed to Euro");
		UtilityClass.takeScreenShot(); 
	}
	
	@When("User click on shopping cart")
	public void user_click_on_shopping_cart() {
		homePageObjects.clickOnShoppingCart();
		logger.info("User click on Shopping Cart Link");
		UtilityClass.takeScreenShot(); 
	}
	@Then("“Your shopping cart is empty!” message should display")
	public void your_shopping_cart_is_empty_message_should_display() {
		Assert.assertTrue(homePageObjects.isShoppingCartEmptyMessageDisplayed());
		logger.info("Shopping Cart empty message is displayed");
		UtilityClass.takeScreenShot();
	}

}
