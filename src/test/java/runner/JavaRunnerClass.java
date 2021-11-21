package runner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import core.Base;
import pageObjects.DesktopsPageObject;

public class JavaRunnerClass extends Base {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		DesktopsPageObject desktopPageObject = new DesktopsPageObject(); 
		//String successMessage = //desktopPageObject.successMessageAddedToCart.getText();
		WebElement successM = driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']")); 
		String successText = successM.getText();
		
		System.out.println(successText);

	}

}
