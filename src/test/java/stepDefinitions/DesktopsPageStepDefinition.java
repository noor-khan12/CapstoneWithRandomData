package stepDefinitions;

import java.util.List;
import java.util.Map;

import javax.print.attribute.standard.Destination;

import org.junit.Assert;

import core.Base;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.masterthought.cucumber.util.Util;
import pageObjects.DesktopsPageObject;
import utilities.UtilityClass;

public class DesktopsPageStepDefinition extends Base {
	DesktopsPageObject desktopPageObjects = new DesktopsPageObject();

	@Given("User is on Retail Website")
	public void user_is_on_retail_website() {
		String actualPageTitle = driver.getTitle();
		String expectedPageTitle = "TEK SCHOOL"; // is this correct?
		Assert.assertEquals(actualPageTitle, expectedPageTitle);
		logger.info("User is on retail website, actual page title equals the expected page title");
		UtilityClass.takeScreenShot();
	}

	@When("User click on Desktops tab")
	public void user_click_on_desktops_tab() {
		desktopPageObjects.clickOnDesktops();
		logger.info("User clicked on Desktops tab");

	}

	@When("User click on show all desktops")
	public void user_click_on_show_all_desktops() {
		desktopPageObjects.clickOnShowAllDesktops();
		logger.info("User clicked on Show All Desktops");
	}

	@Then("User should see all items are present in Desktops page")
	public void user_should_see_all_items_are_present_in_desktops_page() {
		Assert.assertTrue(desktopPageObjects.isAllItemsShowing());
		logger.info("All items are present in Desktops page");
		UtilityClass.takeScreenShot();
	}

	// cartSuccessMessageScenario
	@When("User click  ADD TO CART option on ‘HP LP3065’ item")
	public void user_click_add_to_cart_option_on_hp_lp3065_item() {
		desktopPageObjects.clickOnAddToCartHPLP3065();
		logger.info("User Added HP LP3065 to the Cart!");
		UtilityClass.takeScreenShot();

	}

	@When("^User select quantity '1'$")
	public void user_select_quantity() {
		Assert.assertTrue(desktopPageObjects.cartQuantityEqualsTo1IsPresent());
		logger.info("User selected quantity");
		UtilityClass.takeScreenShot();
	}

	@When("User click add to Cart button")
	public void user_click_add_to_cart_button() {
		desktopPageObjects.clickOnBlueAddToCartButton();
		logger.info("User clicked on the Blue Add to Cart Button!");
		UtilityClass.takeScreenShot();

	}

	@Then("^User should see a message ‘Success: you have added HP LP3065 to your Shopping cart!’$")
	public void user_should_see_a_message_success_you_have_added_hp_lp_to_your_shopping_cart() {
		Assert.assertTrue(desktopPageObjects.isSuccessMessageDisplayedAndEqualsExpected());
		logger.info("HP LP is successfully added to the cart");
		UtilityClass.takeScreenShot();

	}

//	======================Canon Step Def======================
	@When("^User click ADD TO CART option on 'Canon EOS 5D' item$")
	public void u_ser_click_add_to_cart_option_on_item() {
		desktopPageObjects.clickOnAddToCartCanon();
		logger.info("User added Canon EOS 5D to the Cart");
		UtilityClass.takeScreenShot();
	}

	@When("User select color from dropdown ‘Red’")
	public void user_select_color_from_dropdown_red() {
		desktopPageObjects.selectRedColorFromDropDown();
		logger.info("User chose 'Red' Color from drop down menu");
		UtilityClass.takeScreenShot();

	}

	@When("^User select canon quantity '1'$")
	public void user_select_quantity1() {
		Assert.assertTrue(desktopPageObjects.canonCartQuantityEqualsOne());
		logger.info("Canon purchase quantity is 1");
		UtilityClass.takeScreenShot();
	}

	@When("^User click add to Cart button canon$")
	public void user_click_add_to_cart_option_on_item() {
		desktopPageObjects.clickOnAddToCartBlueButtonCanon();
		logger.info("User added Canon to cart and clicked on Add to Cart button");
		UtilityClass.takeScreenShot();
	}

	@Then("User should see a message ‘Success: You have added Canon EOS 5D to your shopping cart!’")
	public void user_should_see_a_message_success_you_have_added_canon_eos_5d_to_your_shopping_cart() {
		Assert.assertTrue(desktopPageObjects.isSuccessMessageDisplayedCanon());
		logger.info("Success message displayed for Canon purchase");
		UtilityClass.takeScreenShot();
	}
	
//	================= dataTableReview Methods============
	
	@When("User click on Canon EOS 5D item")
	public void user_click_on_canon_eos_5d_item() {
		desktopPageObjects.clickOnCanonItem();;
		logger.info("User Clicked on Canon Item");
		UtilityClass.takeScreenShot(); 
	}
	@When("User click on write a review link")
	public void user_click_on_write_a_review_link() {
		desktopPageObjects.clickOnWriteReview();
		logger.info("User clicked on write review link");
		UtilityClass.takeScreenShot();
	}
	@When("^user fill the review information with below information '(.+)' '(.+)' '(.+)'$")
	public void user_fill_the_review_information_with_below_information(String name, String review, String rating) {
		desktopPageObjects.enterName(name);
		desktopPageObjects.enterReviewText(review);
		desktopPageObjects.selectRating(rating);
		UtilityClass.takeScreenShot();
//
//		List<Map<String, String>> inputs = dataTable.asMaps(String.class, String.class); 
//		desktopPageObjects.enterName(inputs.get(0).get("yourname"));
//		desktopPageObjects.enterReviewText(inputs.get(0).get("yourReview"));
//		//desktopPageObjects.selectRating(inputs.get(0).get("Rating"));
//		//this will take a string argument however those are 
//		//radio buttons, not good and bad 
//		desktopPageObjects.selectRating(inputs.get(0).get("Rating"));
//		try {
//			Thread.sleep(3000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		logger.info("User gave a bad review to the product one star!");
//		UtilityClass.takeScreenShot();
//		// explanation: so this will pass the 'Rating' we have in the 
//		// feature file to the method selectRating and based on the 
//		// values that method will click on any of the five buttons!! 
//		desktopPageObjects.enterName(inputs.get(1).get("yourname"));
//		desktopPageObjects.enterReviewText(inputs.get(1).get("yourReview"));
//		desktopPageObjects.selectRating(inputs.get(1).get("Rating"));
//		
//		desktopPageObjects.enterName(inputs.get(2).get("yourname"));
//		desktopPageObjects.enterReviewText(inputs.get(2).get("yourReview"));
//		desktopPageObjects.selectRating(inputs.get(2).get("Rating"));
		
		// these all run in the same step for just one test case
		// i need to put them in the scenario outline to run for five times i guess 
		
		
	}
	@When("User click on Continue Button")
	public void user_click_on_continue_button() {
		desktopPageObjects.clickOnContinueButtonReview();
		logger.info("User clicked on review continue button");
		UtilityClass.takeScreenShot(); 
	}
	@Then("^User should see a message with 'Thank you for your review. It has been submitted to the webmaster for approval.'$")
	public void user_should_see_a_message_with_thank_you_for_your_review_it_has_been_submitted_to_the_webmaster_for_approval() {
	Assert.assertTrue(desktopPageObjects.isReviewSuccessMessagePresent());
	logger.info("Review Successfully submitted");
	UtilityClass.takeScreenShot();
	}

}
