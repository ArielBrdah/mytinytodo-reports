package tests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.App;

import pageobjects.CheckoutPage;
import pageobjects.LoginPage;
import pageobjects.ProductPage;
import pageobjects.ProductsPage;
import pageobjects.YourCartPage;

public class Main {
	
	public static void main(String args[]) {
		  
        System.setProperty("webdriver.chrome.driver","C:/Users/ASUS/workspace/automation-project-2024/test-app/chromedriver-win64/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        App.driver = driver;
        driver.manage().window().maximize();
        driver.get("https://saucedemo.com/");
        
		LoginPage lp = new LoginPage(driver);
		lp.login("standard_user", "secret_sauce");
		
		ProductsPage psp = new ProductsPage(driver);
		psp.chooseProduct("Test.allTheThings() T-Shirt (Red)");
		
		ProductPage pp = new ProductPage(driver);
		pp.addToCart();
		pp.backToProducts();
		
		psp.chooseProduct("Sauce Labs Bike Light");
		pp.addToCart();
		pp.backToProducts();
		psp.openCart();
		
		YourCartPage ycp = new YourCartPage(driver);
		ycp.checkout();
		
		CheckoutPage cp = new CheckoutPage(driver);
		cp.stepOne("Blob", "Blib", "34567");
		cp._continue();
		cp._finish();
		cp._backToHome();
		
	}
}
