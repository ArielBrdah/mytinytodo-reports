package pageobjects;

import org.openqa.selenium.JavascriptExecutor;
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
		highlightElement(el, "yellow");
		el.clear();
		el.sendKeys(text);
	}
	
	public void click(WebElement el) { 
		highlightElement(el, "yellow");
		el.click();
	}
	
	public void moveTo(WebElement el) {
		highlightElement(el, "yellow");
		this.actions.moveToElement(el).build().perform();
	}
	
	public String getText(WebElement el) {
		return el.getText();
	}
	
	
	private void highlightElement(WebElement element, String color) {
		//keep the old style to change it back
		String originalStyle = element.getAttribute("style");
		String newStyle = "border: 1px solid " + color + ";" + originalStyle;
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		// Change the style 
		js.executeScript("var tmpArguments = arguments;setTimeout(function () {tmpArguments[0].setAttribute('style', '" + newStyle + "');},0);",
				element);

		// Change the style back after few miliseconds
		js.executeScript("var tmpArguments = arguments;setTimeout(function () {tmpArguments[0].setAttribute('style', '"
				+ originalStyle + "');},400);", element);

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
