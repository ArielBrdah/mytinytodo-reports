package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
	
	WebDriver driver = null;
	Actions actions;	
	
	public BasePage(WebDriver driver) {
		this.driver = driver;
		this.actions = new Actions(driver);
		PageFactory.initElements(driver, this);
	}
		
	public void fillText(WebElement el, String text) {
		el.clear();
		el.sendKeys(text);
	}
	
	public void click(WebElement el) { 
		el.click();
	}
	
	public void moveTo(WebElement el) {
		this.actions.moveToElement(el).build().perform();
	}
	
	public String getText(WebElement el) {
		return el.getText();
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
