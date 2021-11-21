package stepDefinitions;

import org.junit.Assert;

import core.Base;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.masterthought.cucumber.util.Util;
import pageObjects.LaptopAndNotebooksPageObject;
import utilities.UtilityClass;

public class LaptopAndNotebooksStepDefinition extends Base{
	LaptopAndNotebooksPageObject laptopAndNotebookPageObject = new LaptopAndNotebooksPageObject(); 
	
	@Given("^User is on Retail website 'Laptop Scenario'$")
	public void user_is_on_retail_website() {
		String actualPageTitle = driver.getTitle();
		String expectPageTitle = "TEK SCHOOL"; 
		Assert.assertEquals(expectPageTitle, actualPageTitle);
		logger.info("actual page title equals expected page title");
		UtilityClass.takeScreenShot(); 
	}
	@When("User click on Laptop &NoteBook tab")
	public void user_click_on_laptop_note_book_tab() {
		laptopAndNotebookPageObject.clickOnLaptopAndNotebook();
		logger.info("User clicked on laptop and Notebooks Tab");
		UtilityClass.takeScreenShot(); 
	}
	@When("User click on Show all Laptop &NoteBook option")
	public void user_click_on_show_all_laptop_note_book_option() {
		laptopAndNotebookPageObject.clickOnShowAllLaptopsAndNotebooks();
		logger.info("User clicked on show all laptop and Notebooks link");
		UtilityClass.takeScreenShot(); 
	}
	@When("User click on MacBook  item")
	public void user_click_on_mac_book_item() {
		laptopAndNotebookPageObject.clickOnMacBookItem();
		logger.info("User clicked on Mac Book item");
		UtilityClass.takeScreenShot(); 
	}
	@When("User click add to Cart button for Mac Book")
	public void user_click_add_to_cart_button_for_mac_book() {
		laptopAndNotebookPageObject.clickOnAddCartMacBookBlue();
		logger.info("User clicked on Blue Add To Cart Button for MacBook");
		UtilityClass.takeScreenShot(); 
	}
	//one method missing here 

	@Then("^User should see a message ‘Success: You have added MacBook to your shopping cart!’$")
	public void user_should_see_a_message_success_you_have_added_mac_book_to_your_shopping_cart() {
		Assert.assertTrue(laptopAndNotebookPageObject.isCartSuccessMessageDisplayed());
		logger.info("Add to Cart Success Message is shown");
		UtilityClass.takeScreenShot(); 
		
	}
	@When("^User should see ' 1 items' showed to the cart$")
	public void user_should_see_showed_to_the_cart() {
		Assert.assertTrue(laptopAndNotebookPageObject.isItemAddedToBlackCartDisplayed());
		logger.info("'1-Items-602' message showed on the black cart!");
		UtilityClass.takeScreenShot(); 
	}
	@Then("User click on cart option")
	public void user_click_on_cart_option() {
		laptopAndNotebookPageObject.clickOnBlackCart();
		logger.info("User clicked on black cart button again");
		UtilityClass.takeScreenShot(); 
	}
	@Then("user click on red X button to remove the item from cart")
	public void user_click_on_red_x_button_to_remove_the_item_from_cart() {
		laptopAndNotebookPageObject.clickOnRedRemoveButton();
		logger.info("User clicked on Remove from Cart button");
		UtilityClass.takeScreenShot(); 
	}
	@Then("^item should be removed and cart should show ' 0 items'$")
	public void item_should_be_removed_and_cart_should_show() {
		Assert.assertTrue(laptopAndNotebookPageObject.isItemRemovedFromBlackCartDisplayed());
		logger.info("Items removed from the black card shown");
		UtilityClass.takeScreenShot(); 
	}
	
//	=============== product comparison methods ============
	@When("User click on product comparison icon on ‘MacBook’")
	public void user_click_on_product_comparison_icon_on_mac_book() {
		laptopAndNotebookPageObject.clickOnProductComparisonMacBook();
		logger.info("macbook product comparison button clicked");
		UtilityClass.takeScreenShot(); 
	}
	@When("User click on product comparison icon on ‘MacBook Air")
	public void user_click_on_product_comparison_icon_on_mac_book_air() throws InterruptedException {
		laptopAndNotebookPageObject.clickOnProductComparisonMacBookAir();;
		logger.info("macbook Air product comparison button clicked");
		UtilityClass.takeScreenShot(); 
		Thread.sleep(5000);
	}
	@Then("User should see a message ‘Success: You have added MacBook Air to your product comparison!’")
	public void user_should_see_a_message_success_you_have_added_mac_book_air_to_your_product_comparison() {
		Assert.assertTrue(laptopAndNotebookPageObject.isProcutComparisonSuccessMessageDisplayed()); 
		logger.info("Mac Book added for comparison");
		UtilityClass.takeScreenShot();
	}
	@Then("User click on Product comparison link")
	public void user_click_on_product_comparison_link() {
		laptopAndNotebookPageObject.clickOnProductComparisonLink();;
		logger.info("product comparison link clicked");
		UtilityClass.takeScreenShot(); 
	}
	@Then("User should see Product Comparison Chart")
	public void user_should_see_product_comparison_chart() {
		Assert.assertTrue(laptopAndNotebookPageObject.isProcutComparisonChartDisplayed()); 
		logger.info("product comparison chart is displayed!");
		UtilityClass.takeScreenShot();
	}
//	================= add to wish list methods ======= 
	@When("User click on heart icon to add ‘Sony VaIO’ laptop to wish list")
	public void user_click_on_heart_icon_to_add_sony_va_io_laptop_to_wish_list() {
		laptopAndNotebookPageObject.clickOnHeartIconSonyVAIO();
		logger.info("User clicked on the heart icon to add Sony VAIO to wish list");
		UtilityClass.takeScreenShot(); 
	}
	@Then("User should get a message ‘You must login or create an account to save Sony VAIO to your wish list!’")
	public void user_should_get_a_message_you_must_login_or_create_an_account_to_save_sony_vaio_to_your_wish_list() {
		Assert.assertTrue(laptopAndNotebookPageObject.isWishListErrorMessagePresent());
		logger.info("Wish list error messge is displayed on the page");
		UtilityClass.takeScreenShot(); 
	}
	
//	================ validate price methods ========== 
	
	@When("User click on ‘MacBook Pro’ item")
	public void user_click_on_mac_book_pro_item() {
		laptopAndNotebookPageObject.clickOnMacBookProItem();
		logger.info("User clicked on the macBook Pro Item");
		UtilityClass.takeScreenShot(); 
	}
	@Then("User should see  ‘doolarSign two thousands’ price tag is present on UI.")
	public void user_should_see_doolar_sign_two_thousands_price_tag_is_present_on_ui() {
		Assert.assertTrue(laptopAndNotebookPageObject.isMacBookProPriceEqualsTheExpectedPrice());
		logger.info("Mac Book Pro Price is 2000 as expected");
		UtilityClass.takeScreenShot(); 
	}

}
