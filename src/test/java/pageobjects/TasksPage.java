package pageobjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TasksPage extends BasePage {

	public TasksPage(WebDriver driver) {
		super(driver);
	}
	
	public void addList(String name) {
		click(driver.findElement(By.cssSelector(".mtt-tabs-new-button")));
		fillText(driver.findElement(By.cssSelector("#modalTextInput")),name);
		click(driver.findElement(By.cssSelector("#btnModalOk")));
		sleep(500);
	}
	
	public boolean isElementPresent(By locator) {
		return !driver.findElements(locator).isEmpty();
	}
	
	public void alertOk() {
		click(driver.findElement(By.cssSelector("#btnModalOk")));
	}
	public void deleteList() {
		click(driver.findElement(By.cssSelector("#btnDeleteList")));
	}
	
	public void displayMenu(WebElement l) {
		click(l.findElement(By.cssSelector(".list-action.mtt-img-button")));
		sleep(500);
	}
	
	public void useList(WebElement l) {
		click(l);		
	}
	
	public void removeList(String title) {
		while(true) {
			
			if(!isElementPresent(By.cssSelector("[title="+title+"]"))) {
				break;
			}
			WebElement l = driver.findElement(By.cssSelector("[title="+title+"]"));
			useList(l);
			displayMenu(l);
			deleteList();
			alertOk();
			sleep(3000);
			
		}

	}
	
	public void chooseList(String name) {
		sleep(1000);
		click(driver.findElement(By.cssSelector(name)));
	}

	public void addSimpleTask(String task) {
		click(driver.findElement(By.cssSelector("#task")));
		fillText(driver.findElement(By.cssSelector("#task")),task);
		click(driver.findElement(By.cssSelector("#newtask_submit")));
		sleep(1000);
	}
	
	
}
