package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage {
	
	WebDriver driver = null;
		
	public BasePage(WebDriver driver) {
		this.driver = driver;
	}
		
	public void fillText(WebElement el, String text) {
		el.clear();
		el.sendKeys(text);
	}
	
	public void click(WebElement el) { 
		el.click();
	}
	

	public void sleep(long mills) {
		try {
			Thread.sleep(mills);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
