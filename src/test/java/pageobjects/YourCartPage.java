package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class YourCartPage extends BasePage{

	public YourCartPage(WebDriver driver) {
		super(driver);
	}

	public void checkout() {
		click(driver.findElement(By.cssSelector(".btn.btn_action.btn_medium.checkout_button")));
	}
}
