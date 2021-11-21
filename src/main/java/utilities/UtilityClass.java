package utilities;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.velocity.texen.util.FileUtil;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import core.Base;

public class UtilityClass extends Base{

	// in this class we write our reusable methods. 
	// any methods we will use more than once are stored here in static 
	// methods for example screenshot 
	
	public static String screenShotName() { // this method returns 
		// date and time as a string 
		Date date = new Date(); 
		String ScreenShot = date.toString().replace(":", "_").replace(" ", "_"); 
		
		return ScreenShot; 
	}
	
	public static void takeScreenShot() {
		String location = System.getProperty("user.dir")+"\\output\\screenshots\\"; 
		String screenShotFileName= screenShotName() + ".png"; 
		
		File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE); 
		
		try {
			FileUtils.copyFile(file, new File(location + screenShotFileName));
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Exception in execution");
		}
	}
	//this method will select values from static drop-down 
	public static void selectByVisibleText(WebElement element , String text) {
		Select select = new Select (element); 
		select.selectByVisibleText(text);
	
	}
	
	public static void selectByIndex(WebElement element, int index) {
		Select select = new Select(element); 
		select.selectByIndex(index);
	}
	
	public static void selectByValue(WebElement element, String value) {
		Select select = new Select(element); 
		select.selectByValue(value);
	}
	
	public static void acceptAlert() {
		driver.switchTo().alert().accept(); 
	}
	
	public static void switchToWindow() {
		Set<String> WindowsHandles = driver.getWindowHandles(); 
		Iterator<String> it = WindowsHandles.iterator(); 
		
		String window = it.next(); 
		driver.switchTo().window(window); 
	}

	/**
	 * This method will clear the text using Keys.Control method
	 * 
	 * @param ele
	 */
	public static void clearTextUsingSendKeys(WebElement ele) {
		ele.sendKeys(Keys.CONTROL + "a");
		ele.sendKeys(Keys.DELETE);

	}

	/*
	 * This method will clear the value from input text field
	 */
	public static void clearText(WebElement ele) {
		ele.clear();

	}

	/*
	 * This method will scrollPage down using JSExecutor interface
	 */
	public static void scrollPageDownWithJS() {

		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");

	}

	// click on element using JSExeutor

	public static void clickElementWithJS(WebElement element) {

		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].click();", element);

	}

	// sendKeys using JSExecutor
	// we can use SendKeys with JSExecutor if WebElement has either one of ID, Name,
	// or Class attributes

	public static void sendKeysWithJS(String element, String value) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("document.getElementById('" + element + "').value='" + value + "'");

	}

	// how to select calendar date using JS Executor

	public static void selectCalendarDateWithJS(String date, WebElement element) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].setAttribute('value','" + date + "');", element);

	}

	/**
	 * This method will return text of element
	 * 
	 * @param ele
	 * @return
	 */
	public static String getText(WebElement ele) {
		String ElementText = ele.getText();
		return ElementText;
	}

	/**
	 * This method will drag and drop using Actions class
	 * 
	 * @param sourceElement
	 * @param targetElement
	 */
	public static void dragAndDrop(WebElement sourceElement, WebElement targetElement) {
		Actions action = new Actions(driver);
		action.dragAndDrop(sourceElement, targetElement);

	}

	public static boolean isElementDisplayed(WebElement element) {
		if (element.isDisplayed())
			return true;
		else
			return false;

	}
	
	public static void ScrollToElement(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
	}
	
	
}
