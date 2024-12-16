package pageobjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import helpers.Convert;
import models.TaskModel;

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
	

	@FindBy(css="#taskcontextcontainer #cmenu_delete")
	WebElement removeItem;
	
	@FindBy(css="#taskcontextcontainer #cmenu_edit")
	WebElement updateItem;
	
	
	@FindBy(css =".taskactionbtn")
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
		sleep(500);
		click(driver.findElement(By.cssSelector("[title="+name+"]")));
		sleep(500);
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
	
	public String getTaskIdFromTask(WebElement task) {
		return task.getAttribute("data-id");
	}
	
	public Boolean existTaskId(String taskId) { 
		for(WebElement taskRow : this.taskRows) {
			if(this.getTaskIdFromTask(taskRow).equalsIgnoreCase(taskId)) {
				return true;
			}
		}
		return false;
	}
	
	public String removeTaskByName(String taskValue) {
		String taskId = "";
		for(WebElement taskRow : this.taskRows) {
			if(getText(taskRow.findElement(By.cssSelector(".task-middle .task-through .task-title"))).equalsIgnoreCase(taskValue)) {
				moveTo(taskRow);
				click(taskRow.findElement(By.cssSelector(".taskactionbtn")));
				click(removeItem);
				click(okBtn);
				taskId = this.getTaskIdFromTask(taskRow);
				System.out.println(taskId);
				break;
			}
		}
		// return the id of deleted item.
		return taskId;
	}
	
	public TaskModel getTaskModelFromId(String id) {
		String taskId = "";
		for(WebElement taskRow : this.taskRows) {
			if(taskRow.getAttribute("data-id").equalsIgnoreCase(id)) {
				String prio = getText(taskRow.findElement(By.cssSelector(".task-prio")));
				if(prio.contains("+")) prio = prio.substring(1);
				String title = getText(taskRow.findElement(By.cssSelector(".task-middle .task-through .task-title")));
				String due = taskRow.findElement(By.cssSelector(".task-through-right .duedate")).getAttribute("title").substring(4);
				String []dueArr = due.split(" ");
				due = Convert.mon(dueArr[1])+"/"+dueArr[0]+"/"+dueArr[dueArr.length-1];
				
				click(taskRow.findElement(By.cssSelector(".task-toggle")));
				String note = taskRow.findElement(By.cssSelector(".task-note-block .task-note")).getText();
				String tags = getText(taskRow.findElement(By.cssSelector(".task-tags")));
				
				return new TaskModel(prio,due,title,note,tags,id);
			}
		}
		return null;
	}
	
	
	
	public String updateTask(String taskTitle, TaskModel t) {
		String taskId = "";
		for(WebElement taskRow : this.taskRows) {
			if(getText(taskRow).equalsIgnoreCase(taskTitle)) {
				moveTo(taskRow);
				click(taskRow.findElement(By.cssSelector(".taskactionbtn")));
				click(this.updateItem);
				String id = getTaskIdFromTask(taskRow);
				t.setId(id);
				AdvTaskPage atp = new AdvTaskPage(driver);
				atp.fillForm(t.getPriority(), t.getDue(), t.getTitle(), t.getNote(), t.getTags());
				atp.submit();
				return t.getId();
			}
		}
		// return the id of deleted item.
		return taskId;
	}
	
	public void search(String itemToSearch) { 
		searchField.sendKeys(itemToSearch);
	}
	
	public String getTaskByName(String name) {
		this.search(name);
		sleep(1000);
		WebElement taskRow = taskRows.get(0);
		if(taskRow != null) return taskRow.findElement(By.cssSelector(".task-title")).getText();
		else return "";
	}
	

}
