package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import com.App;

public class BaseTest {

	WebDriver driver;
	
	@BeforeClass
	public void beforeClass() {
        System.setProperty("webdriver.chrome.driver","C:/Users/ASUS/workspace/automation-project-2024/test-app/chromedriver-win64/chromedriver.exe");
        this.driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://localhost/");		
	}
	
	@AfterClass
	public void afterClass() {
		//driver.quit();
	}
}
