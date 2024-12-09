package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage extends BasePage{
	
	public ProductPage(WebDriver driver) {
		super(driver);
	}
	
	public void addToCart() {
		click(driver.findElement(By.cssSelector(".btn.btn_primary.btn_small.btn_inventory")));
	}
	
	public void backToProducts() {
		click(driver.findElement(By.cssSelector(".btn.btn_secondary.back.btn_large.inventory_details_back_button")));
	}
	
	public void openCart() {
		click(driver.findElement(By.cssSelector(".shopping_cart_link")));
	}
}
