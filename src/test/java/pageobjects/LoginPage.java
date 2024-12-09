package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver){
		super(driver);
	}

	public void login(String user, String password) {
		fillText(driver.findElement(By.cssSelector("#user-name")), user);
		fillText(driver.findElement(By.cssSelector("#password")), password);
		click(driver.findElement(By.cssSelector("[type=submit]")));
	}
}
