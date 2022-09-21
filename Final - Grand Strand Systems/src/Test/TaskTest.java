/*************************
 * Name: 	Brandon Ricks 
 * Course: 	CS-320 
 * Date: 	May 30, 2021
 * Description: This is the test class for Task.
 *************************/

package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import Task.Task;

class TaskTest {
	/*
	 * The following tests exercise the Task class. The first 3 tests make sure
	 * the field does not become longer than the constraint (10 characters for
	 * task ID, 20 characters for task name, and 50 characters for task desciption.
	 * The last 2 tests ensure that each field is not null.
	 * TaskID is not tested for being not null because there isn't a way to
	 * create a contact with a null taskID. Likewise, it is not tested for being
	 * non-updateable because there is no way to update it.
	 */
	
	@Test
	@DisplayName("Task ID cannot have more than 10 characters")
	void testTaskIDWithMoreThanTenCharacters() {
		Task task = new Task("Name", "Description");
		if (task.getTaskID().length() > 10) {
			fail("Task ID has more than 10 characters.");
		}
	}

	@Test
	@DisplayName("Task Name cannot have more than 20 characters")
	void testTaskNameWithMoreThanTwentyCharacters() {
		Task task = new Task("OllyOllyOxenFreeOllyOllyOxenFree", "Description");
		if (task.getTaskName().length() > 20) {
			fail("Task Name has more than 20 characters.");
		}
	}

	@Test
	@DisplayName("Task Description cannot have more than 50 characters")
	void testTaskDescWithMoreThanFiftyCharacters() {
		Task task = new Task("Name", "123456789 is nine characters long" 
				+ "123456789 is another nine characters long" 
				+ "123456789 is another nine characters long"
				+ "123456789 is another nine characters long");
		if (task.getTaskDesc().length() > 50) {
			fail("Task Description has more than 50 characters.");
		}
	}

	@Test
	@DisplayName("Task Name shall not be null")
	void testTaskNameNotNull() {
		Task task = new Task(null, "Description");
		assertNotNull(task.getTaskName(), "Task Name was null.");
	}
	
	@Test
	@DisplayName("Task Description shall not be null")
	void testTaskDescNotNull() {
		Task task = new Task("Name", null);
		assertNotNull(task.getTaskDesc(), "Task Description was null.");
	}
}