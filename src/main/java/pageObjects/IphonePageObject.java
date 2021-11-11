package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import core.Base;

public class IphonePageObject extends Base {

	public IphonePageObject() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@name='search']")
	private WebElement searchBox;

	@FindBy(xpath = "//button[@class='btn btn-default btn-lg']")
	private WebElement searchButton;

	@FindBy(xpath = "//img[@title='iPhone']")
	private WebElement searchResultText;

	public void enterValue(String str) {
		searchBox.sendKeys(str);
		searchButton.click();
	}

	public boolean isSearchResultTextDisplayed() {
		if (searchResultText.isDisplayed()) {
			return true;
		} else {
			return false;
		}

	}
}
