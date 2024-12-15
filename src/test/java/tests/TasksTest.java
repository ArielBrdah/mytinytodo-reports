package tests;

import org.testng.annotations.Test;

import junit.framework.Assert;
import models.TaskModel;
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
		tsp.chooseList("[title=" + listNameData + "]");
		tsp.addTask(taskNameData);

		/**
		 * @description: verify the added task is present in the choosen list.
		 */
		tsp.chooseList("[title=" + listNameData + "]");
		String taskName = tsp.getTaskByName(taskNameData);
		Assert.assertEquals(taskName, taskNameData);
	}

	@Test
	public void tc02_deleteExistingTask() {

		// Data Set
		String listNameData = "Todo";
		String taskNameData = "Cleaning House";

		// Before test
		TasksPage tsp = new TasksPage(driver);
		tsp.chooseList(listNameData);
		tsp.addTask(taskNameData);

		// Starting Test

		/**
		 * @function: delete task from the list.
		 * @description: on the tasks page, selecting `List`, then removing task.
		 */

		String taskId = tsp.removeTaskByName(taskNameData);

		/**
		 * @description: verify the removed task is removed properly from the list by
		 *               data-id.
		 */
		tsp.chooseList(listNameData);
		Boolean existTask = tsp.existTaskId(taskId);
		Assert.assertTrue(!existTask);
	}

	@Test
	public void tc03_addAndUpdateTask() {
		
		// Data Set
		String listNameData = "Todo";
		String taskNameData = "Cleaning House";
		String upTaskNameData = "Simple Task";
		String upTaskNoteData = "The silence is golden.";
		TaskModel taskData = new TaskModel("1","12/16/2024",upTaskNameData,upTaskNoteData,"Test");

		
		TasksPage tsp = new TasksPage(driver);
		
		// Before Test Adding task: "Cleaning House"
		tsp.chooseList(listNameData);
		tsp.addTask(taskNameData);
		
		
		// Starting Update
		tsp.chooseList(listNameData);
		String taskId = tsp.updateTask(taskNameData, taskData);
		
		// getting the task from the id
		tsp.chooseList(listNameData);
		TaskModel task = tsp.getTaskModelFromId(taskId);
		Boolean taskUpdated = task.equals(taskData);

		if(taskUpdated) {
			// after test success rollback
			tsp.chooseList(listNameData);
			System.out.println("Removing Task ID...");
			String removedTaskId = tsp.removeTaskByName(upTaskNameData);
			System.out.println("Removed Task ID: #"+removedTaskId);
		}
		Assert.assertTrue(taskUpdated);
		
		
	}

}
