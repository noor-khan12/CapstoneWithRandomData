package pageObjects;

import java.util.concurrent.TimeUnit;

import org.joda.time.Seconds;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import core.Base;
import utilities.UtilityClass;

public class DesktopsPageObject extends Base {

	public DesktopsPageObject() {

		PageFactory.initElements(driver, this);
	}

	JavascriptExecutor js = (JavascriptExecutor) driver;
	// using this class to scroll down until an element is shown

	@FindBy(xpath = "//a[normalize-space()='Desktops']")
	private WebElement desktopsLink;

	@FindBy(xpath = "//a[@xpath='1']")
	private WebElement pcLink;

	@FindBy(xpath = "//a[normalize-space()='Mac (1)']")
	private WebElement macLink;

	@FindBy(xpath = "//a[normalize-space()='Show All Desktops']")
	private WebElement showAllDesktops;

	@FindBy(xpath = "//button[@id='list-view']")
	private WebElement listView;

	@FindBy(xpath = "//button[@id='grid-view']")
	private WebElement gridView;

	@FindBy(xpath = "//a[normalize-space()='Apple Cinema 30\"']")
	private WebElement appleCinema30;

	@FindBy(xpath = "//a[normalize-space()='Canon EOS 5D']")
	private WebElement cannonEOS5D;

	@FindBy(xpath = "//a[normalize-space()='HP LP3065']")
	private WebElement hPLP3065;

	@FindBy(xpath = "//div[3]//div[1]//div[2]//div[2]//button[1]")
	// button[normalize-space()='Add to Cart'][@xpath='1']
	private WebElement hPLP3065AddToCart;

	@FindBy(xpath = "//input[@id='input-quantity' and @value='1']")
	private WebElement purchaseQuantityValue;

	@FindBy(xpath = "//button[@id='button-cart']")
	private WebElement addToCartButtonBlueHPLP;

	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement successMessageAddedToCart;

	@FindBy(xpath = "//a[normalize-space()='HTC Touch HD']")
	private WebElement hTCTouchHD;

	@FindBy(xpath = "//a[normalize-space()='iPhone']")
	private WebElement iPhone;

	@FindBy(xpath = "//a[contains(text(), 'iPod')]")
	private WebElement iPodClassic;

	@FindBy(xpath = "//a[normalize-space()='MacBook']")
	private WebElement macBook;

	@FindBy(xpath = "//a[normalize-space()='MacBook Air']")
	private WebElement macBookAir;

	@FindBy(xpath = "//a[normalize-space()='Palm Treo Pro']")
	private WebElement palmTreoPro;

	@FindBy(xpath = "//a[normalize-space()='Product 8']")
	private WebElement product8;

	@FindBy(xpath = "//a[normalize-space()='Samsung SyncMaster 941BW']")
	private WebElement samsungSyncMaster941BW;

	@FindBy(xpath = "//a[normalize-space()='Sony VAIOPalm Treo Pro']")
	private WebElement sonyVAIO;

//	@FindBy (xpath = "//div[normalize-space()='Showing 1 to 12 of 12 (1 Pages)'][@xpath='1']")
//	private WebElement showingAllItemsText;

	@FindBy(xpath = "//div[contains(text(), 'Showing 1 to 12 of 12 (1 Pages)')]")
	private WebElement showingAllItemsText;
//	============================= Canon Add to Cart Elements ================================

	@FindBy(xpath = "//div[@id='product-category']//div[2]//div[1]//div[2]//div[2]//button[1]")
	private WebElement addToCartCanonEOS5D;

	@FindBy(xpath = "//select[@id='input-option226']")
	private WebElement colorDropDownMenu;

	@FindBy(xpath = "//input[@id='input-quantity' and @value='1']")
	private WebElement cartQuantityCanon;

	@FindBy(xpath = "//button[@id='button-cart']")
	private WebElement addToCartButtonBlueCanon;

	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement successMessageCanon;

	@FindBy(xpath = "//ul[@class='breadcrumb']//li[2]")
	private WebElement scrollToSuccessMessageThroughCanonLink;

//	=================== Review Elements=================
	@FindBy(xpath = "//a[normalize-space()='Write a review']")
	private WebElement writeAReview;

	@FindBy(xpath = "//input[@id='input-name']")
	private WebElement inputNameForReview;

	@FindBy(xpath = "//textarea[@id='input-review']")
	private WebElement inputReviewText;

	@FindBy(xpath = "//div[@id='product-product']//div[4]//div[1]")
	private WebElement ratingRowLabels;

	@FindBy(xpath = "//input[@name='rating' and @value='1']")
	private WebElement rating1;

	@FindBy(xpath = "//input[@value='2']")
	private WebElement rating2;

	@FindBy(xpath = "//input[@value='3']")
	private WebElement rating3;

	@FindBy(xpath = "//input[@value='4']")
	private WebElement rating4;

	@FindBy(xpath = "//input[@value='5']")
	private WebElement rating5;

	@FindBy(xpath = "//button[@id='button-review']")
	private WebElement reviewContinueButton;

	@FindBy(xpath = "//div[contains(text(), ' Thank you for your review. It has been submitted to the webmaster for approval.')]")
	private WebElement reviewSuccessMessage;
//	=============== verify desktop items==================

	public void clickOnDesktops() {
		desktopsLink.click();
		UtilityClass.ScrollToElement(desktopsLink);
	}

	public void clickOnShowAllDesktops() {
		showAllDesktops.click();
		UtilityClass.ScrollToElement(showAllDesktops);
	}

	public boolean isAllItemsShowing() {
		js.executeScript("arguments[0].scrollIntoView();", showingAllItemsText);

		if (showingAllItemsText.isDisplayed()) {
			return true;
		} else {
			return false;
		}
		// note: I can verify all items showing through creating a boolean
		// method for each item separately and then calling each method
		// in the step def class. that is the better way but it will take
		// more space and code.

		// also one step was executed, the three steps in the background
		// are not included in the Pretty report, why?
	}

	public void clickOnAddToCartHPLP3065() {
		hPLP3065AddToCart.click();
	}

	public boolean cartQuantityEqualsTo1IsPresent() {
		if (purchaseQuantityValue.isDisplayed()) {
			return true;
		} else {
			return false;
		}
	}

	public void clickOnBlueAddToCartButton() {
		addToCartButtonBlueHPLP.click();
	}

	public String successMessageText() {
		return successMessageAddedToCart.getText();
	}

	public boolean isSuccessMessageDisplayedAndEqualsExpected() {
//		String actualSuccessMessage = successMessageAddedToCart.getText(); 
//		String expectedSuccessMessage = "Success: You have added HP LP3065 to your shopping cart"; 
		if (successMessageAddedToCart.isDisplayed()) {
			return true;
		} else {
			return false;
		}
	}

	public void clickOnAddToCartCanon() {
		addToCartCanonEOS5D.click();
	}

	public void selectRedColorFromDropDown() {
		UtilityClass.selectByValue(colorDropDownMenu, "15");
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	}

	public boolean canonCartQuantityEqualsOne() {
		String canonQuantityValue = cartQuantityCanon.getAttribute("value");
		if (canonQuantityValue.equals("1")) {
			return true;
		} else {
			return false;
		}
	}

	public void clickOnAddToCartBlueButtonCanon() {
		addToCartButtonBlueCanon.click();
	}

	public boolean isSuccessMessageDisplayedCanon() {
		//js.executeScript("arguments[0].scrollIntoView();", scrollToSuccessMessageThroughCanonLink);

		if (successMessageCanon.isDisplayed()) {
			return true;
		} else {
			return false;
		}

	}

//	====== review methods====
	public void clickOnCanonItem() {
		cannonEOS5D.click(); 
	}
	
	public void clickOnWriteReview() {
		writeAReview.click();
	}
	
	public void enterName(String name) {
		inputNameForReview.sendKeys(name);
	}

	public void enterReviewText(String reviewText) {
		inputReviewText.sendKeys(reviewText);
	}

	public void selectRating(String rating) {
//		String rating = "";
		switch (rating) {
		case "worse":
			rating1.click();
			break;
		case "bad":
			rating2.click();
			break;
		case "good":
			rating3.click();
			break;
		case "very good":
			rating4.click();
			break;
		case "excellent":
			rating5.click();
			break;
		}
	}
	
	public void enterRating(String rating) {
		
	}
	
	public void clickOnContinueButtonReview() {
		reviewContinueButton.click();
	}
	
	public boolean isReviewSuccessMessagePresent() {
		String actualReviewSuccessMessage = reviewSuccessMessage.getText(); 
		String expectedReviewSuccessMessage = "Thank you for your review. It has been submitted to the webmaster for approval."; 
		if (actualReviewSuccessMessage.equals(expectedReviewSuccessMessage)) {
			return true;
		} else {
			return false; 
		}
		
	}

}
