package pageobjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TasksPage extends BasePage {

	@FindBy(css = ".mtt-tabs-new-button")
	WebElement newBtn;

	@FindBy(css = "#modalTextInput")
	WebElement listTitleField;

	@FindBy(css = "#btnModalOk")
	WebElement okBtn;

	@FindBy(css = "#btnDeleteList")
	WebElement removeListBtn;
	
	@FindBy(css = "#newtask_form #task")
	WebElement taskField;
	
	@FindBy(css ="#newtask_submit.mtt-taskbox-icon")
	WebElement submitNewTaskIcon;
	
	@FindBy(css="#search")
	WebElement searchField;
	
	@FindBy(css="#tasklist .task-row")
	List<WebElement> taskRows;
	

	@FindBy(css="#taskcontextcontainer .cmenu_delete")
	WebElement removeItem;
	
	
	@FindBy(css =".taskactionbtn.mtt-menu-button-active")
	WebElement threedot;
	public TasksPage(WebDriver driver) {
		super(driver);
	}

	public void addList(String title) {
		click(newBtn);
		fillText(listTitleField, title);
		click(okBtn);
		sleep(500);
	}

	public void deleteList() {
		click(removeListBtn);
	}

	public void deleteListByTitle(String title) {
		while (true) {

			if (!isElementPresent(By.cssSelector("[title=" + title + "]"))) {
				break;
			}
			WebElement l = driver.findElement(By.cssSelector("[title=" + title + "]"));
			useList(l);
			displayMenu(l);
			deleteList();
			alertOk();
			sleep(3000);

		}

	}

	public void useList(WebElement l) {
		click(l);
	}

	public void chooseList(String name) {
		click(driver.findElement(By.cssSelector(name)));
	}

	public boolean isElementPresent(By locator) {
		return !driver.findElements(locator).isEmpty();
	}

	public void alertOk() {
		click(okBtn);
	}

	public void displayMenu(WebElement l) {
		click(l.findElement(By.cssSelector(".list-action.mtt-img-button")));
		sleep(500);
	}

	public void addTask(String taskValue) {
		fillText(taskField, taskValue);
		click(submitNewTaskIcon);
	}
	
	public void removeTaskByName(String taskValue) {
		
		for(WebElement taskRow : taskRows) {
			if(getText(taskRow.findElement(By.cssSelector(".task-title"))).equalsIgnoreCase(taskValue)) {
				moveTo(taskRow);
				click(threedot);
				click(removeItem);
				break;
			}
		}
		// return the id of deleted item.
	}
	
	public void search(String itemToSearch) { 
		searchField.sendKeys(itemToSearch);
	}
	
	public String getTaskByName(String name) {
		this.search(name);
		WebElement taskRow = taskRows.get(1);
		if(taskRow != null) return taskRow.findElement(By.cssSelector(".task-title")).getText();
		else return "";
	}
	

}
