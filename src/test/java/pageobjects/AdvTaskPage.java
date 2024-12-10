package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class AdvTaskPage extends BasePage {

	public AdvTaskPage(WebDriver driver) {
		super(driver);
	}

	public void advancedTask() {
		sleep(1000);
		click(driver.findElement(By.cssSelector("#newtask_adv")));
	}
	
	public void createTask(String priority, String duedate, String title, String note, String tags) { 
		Select prio = new Select(driver.findElement(By.cssSelector("[name=prio]")));
		prio.selectByValue(priority);
		
		fillText(driver.findElement(By.cssSelector("#duedate")),duedate);
		fillText(driver.findElement(By.cssSelector("#taskedit_form [name=task]")),title);
		fillText(driver.findElement(By.cssSelector("[name=note]")),note);
		fillText(driver.findElement(By.cssSelector("[name=tags]")),tags);
		click(driver.findElement(By.cssSelector(".form-row [type=submit]")));
	}
}
