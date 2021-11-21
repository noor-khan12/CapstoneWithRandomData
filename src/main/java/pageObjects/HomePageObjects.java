package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import core.Base;

public class HomePageObjects extends Base {

	public HomePageObjects() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//button[@class='btn btn-link dropdown-toggle']")
	private WebElement currencyButton;

	//Select currency = new Select(currencyButton);
	// an objec of Select class for the drop-down currency

	@FindBy(xpath = "//button[@class='currency-select btn btn-link btn-block'] [@name='EUR']")
	private WebElement currencyEuro;

	@FindBy(xpath = "//strong[contains(text(),'€')]")
	private WebElement euroCurrencySign;

	@FindBy(xpath = "//button[@class='currency-select btn btn-link btn-block'] [@name='GBP']")
	private WebElement currencyPoundSterling;

	@FindBy(xpath = "//button[@name='USD']")
	private WebElement currencyUSD;

//	@FindBy(xpath="//a[@title='My Account'")
//	private WebElement myAccount;
	// this element is already present in the login page object class ,
	// shall we add it again? I think no
	// yes we add it because this is a new page object , so the other page
	// is different and those elements are private and can't be shared with
	// this page. so we write it again!!

	// oh he said we don't need it lol why? because
	// it is the same object even though placed in two different pages?
//	
//	@FindBy(xpath="//a[normalize-space()='Register']")
//	private WebElement register; 
//	
//	@FindBy(xpath = "//a[text()='Login']")
//	private WebElement login; 

	@FindBy(xpath = "//a[@id = 'wishlist-total']")
	private WebElement wishList;

//	@FindBy(xpath = "//a[@title='Shopping Cart']")
//	private WebElement shopingCart;

	@FindBy(xpath = "//a[@title='Checkout']")
	private WebElement checkout;
	
	@FindBy(xpath = "//body/nav[@id='top']/div[@class='container']/div[@id='top-links']/ul[@class='list-inline']/li[4]")
	private WebElement shoppingCart;

	@FindBy(xpath = "//a[normalize-space()='TEST ENVIRONMENT']")
	private WebElement testEnvironmentText;

	@FindBy(xpath = "//input[@name='search']")
	private WebElement searchBox;

	@FindBy(xpath = "//button[@type='button'][@class='btn btn-default btn-lg']")
	private WebElement searchButton;

	@FindBy(xpath = "//button[@data-toggle='dropdown'][@data-loading-text='Loading...']")
	private WebElement basketAndAmount;

	@FindBy(xpath = "//a[normalize-space()='Desktops']")
	private WebElement desktopsLink;

	@FindBy(xpath = "//a[@xpath='1']")
	private WebElement pcLink;

	@FindBy(xpath = "//a[normalize-space()='Mac (1)']")
	private WebElement macLink;

	@FindBy(xpath = "//a[normalize-space()='Show All Desktops']")
	private WebElement showAllDesktops;

	@FindBy(xpath = "//a[normalize-space()='Laptops & Notebooks']")
	private WebElement laptopsAndNotebooksLink;
	/// to be continued from here.
	// question; I have Macs And Windows under this link but i also have mac under
	// desktops how to differentiate these two
	@FindBy(css = "a[href='http://tek-school.com/retail/index.php?route=product/category&path=18_46']")
	private WebElement macsLinkUnderLaptops;
	// this is a dynamic element, i need to review the dynamic elements
	// tagname[contains (@attribute, 'value')]
	// tagname [starts-with (@attribute, 'value']

	@FindBy(css = "a[href='http://tek-school.com/retail/index.php?route=product/category&path=18_45']")
	private WebElement windowsLinkUnderLaptops;

	@FindBy(xpath = "//a[normalize-space()='Show All Laptops & Notebooks']")
	private WebElement showAllLaptopsAndNotebooks;

	@FindBy(xpath = "//a[normalize-space()='Components']")
	private WebElement componentsLink;

	@FindBy(xpath = "//a[normalize-space()='Tablets']")
	private WebElement tabletsLink;
	
	@FindBy(xpath = "//div[@id='content']//p[contains(text(),'Your shopping cart is empty!')]")
	private WebElement shoppingCartEmptyMessage;
	

	public void clickOnCurrencyButton() {
		currencyButton.click();
	}

	public void clickOnEuroCurrency() {
		currencyEuro.click();
		//currency.selectByIndex(0);
	}

	public boolean euroCurrencyIsDisplayed() {
		if (euroCurrencySign.isDisplayed()) {
			return true; 
		} else {
			return false; 
		}
	}
	
	public void clickOnShoppingCart() {
		shoppingCart.click();
	}
	
	public boolean isShoppingCartEmptyMessageDisplayed() {
		if (shoppingCartEmptyMessage.isDisplayed()) {
			return true;
		} else {
			return false; 
		}
	}
}
