package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import core.Base;

public class LaptopAndNotebooksPageObject extends Base {

	public LaptopAndNotebooksPageObject() {
		PageFactory.initElements(driver, this);
	}

	JavascriptExecutor js = (JavascriptExecutor) driver;

	@FindBy(xpath = "//a[normalize-space()='Laptops & Notebooks']")
	private WebElement laptopsAndNotebooksLink;

	@FindBy(xpath = "//a[normalize-space()='Show All Laptops & Notebooks']")
	private WebElement showAllLaptopsAndNotebooks;

	@FindBy(xpath = "//a[normalize-space()='MacBook']")
	private WebElement macBookItem;

	@FindBy(xpath = "//button[@id='button-cart']")
	private WebElement addToCartBlueButton;

	@FindBy(xpath = "//div[text()='Success: You have added ']//a[text()='MacBook']")
//	div[@class='alert alert-success alert-dismissible']
	private WebElement macBookSuccessMessageAddToCart;

	@FindBy(xpath = "//h2[normalize-space()='$602.00']")
	private WebElement amountText;

	@FindBy(xpath = "//span[text()=' 1 item(s) - $602.00']")
	private WebElement blackCartButton;

	@FindBy(xpath = "//button[@title='Remove']")
	private WebElement cartRemoveButton;

	@FindBy(xpath = "//span[text()=' 0 item(s) - $0.00']")
	private WebElement blackCartEmptyButton;
//	==================== Product Comparison Elements==============

	@FindBy(xpath = "//body[1]/div[2]/div[1]/div[1]/div[4]/div[2]/div[1]/div[2]/div[2]/button[3]")
	private WebElement macBookCompareButton;

	@FindBy(xpath = "//div[3]//div[1]//div[2]//div[2]//button[3]")
	private WebElement macBookAirCompareButton;

	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
//	//div[text()=' Success: You have added ']//a[text()='MacBook Air']
//	//div[@class='alert alert-success alert-dismissible']
	private WebElement compareSuccessMessageMacBook;

	@FindBy(xpath = "//a[@id='compare-total']")
	////*[@id=\"top-links\"]/ul/li[1]/a
	//a[normalize-space()='product comparison']
	//again jenkins can interact with this element!! 
	private WebElement productComparisonLink;

	@FindBy(xpath = "//h1[normalize-space()='Product Comparison']")
	private WebElement productComparisonChart;

	@FindBy(xpath = "//img[@title='MacBook']")
	//strong[normalize-space()='MacBook']
	private WebElement macBookLinkInChart;

	@FindBy(xpath = "//img[@title='MacBook Air']")
	//strong[normalize-space()='MacBook Air']
	// this element couldn't interacted by jenkins so changing it
	
	private WebElement macBookAirLinkInChart;
//	============== add to wishlist Elements ========

	@FindBy(xpath = "//div[5]//div[1]//div[2]//div[2]//button[2]")
	// i[@class='fa fa-heart' and @xpath='1']
	// this xpath can be highlighted in the DOM but selenium can't find it.
	// NoSuchELementException thrown at me!
	private WebElement addToWishListButtonSonyVAIO;

	@FindBy(xpath = "//div[text()=' You must ']//a[text()='Sony VAIO']")
	private WebElement sonyVAIOTextInTheMessage;

	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement wishListErroMessage;
//	==================== validate price elements ======= 
	@FindBy(xpath = "//a[text()='MacBook Pro']")
	private WebElement macBookProItem;

	@FindBy(xpath = "//h2[text()='$2,000.00']")
	private WebElement macBookProPrice;

	public void clickOnLaptopAndNotebook() {
		laptopsAndNotebooksLink.click();
	}

	public void clickOnShowAllLaptopsAndNotebooks() {
		showAllLaptopsAndNotebooks.click();
	}

	public void clickOnMacBookItem() {
		macBookItem.click();
	}

	public void clickOnAddCartMacBookBlue() {
		addToCartBlueButton.click();
	}

	public boolean isCartSuccessMessageDisplayed() {
		if (macBookSuccessMessageAddToCart.isDisplayed()) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isItemAddedToBlackCartDisplayed() {
		String actualPurchaseValue = amountText.getText();
		String expectePurchaseValue = "$602.00";
		if (blackCartButton.isDisplayed() && actualPurchaseValue.equals(expectePurchaseValue)) {
			return true;
		} else {
			return false;
		}
	}

	public void clickOnBlackCart() {
		blackCartButton.click();
	}

	public void clickOnRedRemoveButton() {
		cartRemoveButton.click();
	}

	public boolean isItemRemovedFromBlackCartDisplayed() {
		if (blackCartEmptyButton.isDisplayed()) {
			return true;
		} else {
			return false;
		}
	}

//	============== product comparison methods ===== 
	public void clickOnProductComparisonMacBook() {
		macBookCompareButton.click();
	}

	public void clickOnProductComparisonMacBookAir() {
		macBookAirCompareButton.click();
	}

	public boolean isProcutComparisonSuccessMessageDisplayed() {
		if (compareSuccessMessageMacBook.isDisplayed()) {
			return true;
		} else {
			return false;
		}
	}

	public void clickOnProductComparisonLink() {
		productComparisonLink.click();
	}

	public boolean isProcutComparisonChartDisplayed() {
		if (productComparisonChart.isDisplayed()) {
			return true;
		} else {
			return false;
		}
	}

	public void clickOnHeartIconSonyVAIO() {
		addToWishListButtonSonyVAIO.click();
	}

	public boolean isWishListErrorMessagePresent() {
		if (wishListErroMessage.isDisplayed() && sonyVAIOTextInTheMessage.isDisplayed()) {
			return true;
		} else {
			return false;
		}
	}

	public void clickOnMacBookProItem() {
		macBookProItem.click();
	}

	public boolean isMacBookProPriceEqualsTheExpectedPrice() {
		String actualMacBookProPrice = macBookProPrice.getText();
		String expecteMacBookProPrice = "$2,000.00";

		if (actualMacBookProPrice.equals(expecteMacBookProPrice)) {
			return true;
		} else {
			return false;
		}
	}

}
