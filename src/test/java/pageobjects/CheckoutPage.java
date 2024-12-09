package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends BasePage{

	public CheckoutPage(WebDriver driver) {
		super(driver);
	}
	
	public void stepOne(String fname,String lname,String zipcode) {
		fillText(driver.findElement(By.cssSelector("#first-name")),fname);
		fillText(driver.findElement(By.cssSelector("#last-name")),lname);
		fillText(driver.findElement(By.cssSelector("#postal-code")),zipcode);
	}
	
	public void button(String name) {
		click(driver.findElement(By.cssSelector("#"+name)));
	}
	
	public void _cancel() {
		this.button("cancel");
	}
	
	public void _continue() {
		this.button("continue");
	}
	
	public void _finish() {
		this.button("finish");
	}
	public void _backToHome() {
		this.button("back-to-products");
	}
	
}
