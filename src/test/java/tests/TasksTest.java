package tests;

import org.testng.annotations.Test;

import junit.framework.Assert;
import pageobjects.TasksPage;

public class TasksTest extends BaseTest {

	@Test
	public void tc01_addTask() {
		
		/**
		 * @function: add task to list.
		 * @description: on the tasks page, selecting `List`, then adding new task.
		 */
		TasksPage tsp = new TasksPage(driver);
		String taskNameData = "Cleaning the house.";
		String listNameData = "Todo";
		tsp.chooseList("[title="+listNameData+"]");
		tsp.addTask(taskNameData);
		
		/**
		 * @description: verify the added task is present in the choosen list.
		 */
		tsp.chooseList("[title="+listNameData+"]");
		String taskName = tsp.getTaskByName(taskNameData);
		Assert.assertEquals(taskName, taskNameData);
	}
	
	@Test
	public void tc02_deleteTask() {
		
		/**
		 * @function: delete task from the list.
		 * @description: on the tasks page, selecting `List`, then removing task.
		 */
		TasksPage tsp = new TasksPage(driver);
		String taskNameData = "Today";
		String listNameData = "Todo";
		tsp.chooseList("[title="+listNameData+"]");
		tsp.removeTaskByName(taskNameData);
		// String taskId = tsp.removeTaskByName(taskNameData);
		
		/**
		 * @description: verify the added task is present in the choosen list.
		 */
//		tsp.chooseList("[title="+listNameData+"]");
//		String existTask = tsp.foundTaskId(taskId);
//		Assert.assertEquals(false, existTask);
	}
	
	
	
	
	
	
	
}
