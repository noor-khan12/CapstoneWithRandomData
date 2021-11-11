package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import core.Base;

public class DesktopPageObject extends Base{

	
	public DesktopPageObject() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//button[@class='btn btn-link dropdown-toggle']")
	private WebElement currencyButton; 
	
	@FindBy(xpath="//button[@class='currency-select btn btn-link btn-block'] [@name='EUR']")
		private WebElement currencyEuro; 
	
	@FindBy(xpath="//button[@class='currency-select btn btn-link btn-block'] [@name='GBP']")
	private WebElement currencyPoundSterling; 
	
	@FindBy(xpath="//button[@name='USD']")
	private WebElement currencyUSD; 
	
//	@FindBy(xpath="//a[@title='My Account'")
//	private WebElement myAccount;
	// this element is already present in the login page object class , 
	// shall we add it again? I think no 
	// yes we add it because this is a new page object , so the other page 
	// is different and those elements are private and can't be shared with 
	// this page. so we write it again!! 
	
	// oh he said we don't need it lol 
//	
//	@FindBy(xpath="//a[normalize-space()='Register']")
//	private WebElement register; 
//	
//	@FindBy(xpath = "//a[text()='Login']")
//	private WebElement login; 
	

	@FindBy(xpath="//a[@id = 'wishlist-total']")
	private WebElement wishList; 
	
	@FindBy(xpath="//a[@title='Shopping Cart']")
	private WebElement shopingCart; 
	
	@FindBy(xpath="//a[@title='Checkout']")
	private WebElement checkout; 
	
	@FindBy (xpath = "//a[normalize-space()='TEST ENVIRONMENT']")
	private WebElement testEnvironmentText; 
	
	@FindBy(xpath = "//input[@name='search']")
	private WebElement searchBox;
	
	@FindBy(xpath = "//button[@type='button'][@class='btn btn-default btn-lg']")
	private WebElement searchButton; 
	
	@FindBy(xpath= "//button[@data-toggle='dropdown'][@data-loading-text='Loading...']")
	private WebElement basketAndAmount; 
	
	@FindBy(xpath="//a[normalize-space()='Desktops']")
	private WebElement desktopsLink; 
	
	@FindBy(xpath="//a[@xpath='1']")
	private WebElement pcLink; 
	
	@FindBy(xpath="//a[normalize-space()='Mac (1)']")
	private WebElement macLink; 
	
	@FindBy(xpath="//a[normalize-space()='Show All Desktops']")
	private WebElement allDesktops; 
	
	
	@FindBy(xpath="//a[normalize-space()='Laptops & Notebooks']")
	private WebElement laptopsAndNotebooksLink; 
	///to be continued from here. 
	//question; I have Macs And Windows under this link but i also have mac under 
	// desktops how to differentiate these two 
	
	
	@FindBy(xpath="//a[normalize-space()='Components']")
	private WebElement componentsLink; 
	
	@FindBy(xpath="//a[normalize-space()='Tablets']")
	private WebElement tabletsLink; 
	

	
	
	
	
}
