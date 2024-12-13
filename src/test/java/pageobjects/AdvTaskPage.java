package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class AdvTaskPage extends BasePage {
	
	@FindBy(css="#duedate")
	WebElement dueDateField;
	
	@FindBy(css="#taskedit_form [name=task]")
	WebElement titleField;

	@FindBy(css="[name=note]")
	WebElement noteField;
	
	@FindBy(css="[name=tags]")
	WebElement tagsField;

	@FindBy(css=".form-row [type=submit]")
	WebElement submitBtn;
	
	@FindBy(css="[name=prio]")
	WebElement priorityItem;

	public AdvTaskPage(WebDriver driver) {
		super(driver);
	}

	public void advancedTask() {
		sleep(1000);
		click(driver.findElement(By.cssSelector("#newtask_adv")));
	}
	
	public void createTask(String priorityValue, String duedateValue, String titleValue, String noteValue, String tagsValue) { 
		Select prio = new Select(priorityItem);
		prio.selectByValue(priorityValue);
		
		fillText(dueDateField,duedateValue);
		fillText(titleField,titleValue);
		fillText(noteField,noteValue);
		fillText(tagsField,tagsValue);
		click(submitBtn);
	}
}
