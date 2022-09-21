/*************************
 * Name: 	Brandon Ricks 
 * Course: 	CS-320 
 * Date: 	May 30, 2021
 * Description: This is the Task class. It creates and stores task information.
 *************************/

package Task;

import java.util.concurrent.atomic.AtomicLong;

public class Task {
	private final String taskID;
	private String taskName;
	private String taskDesc;
	private static AtomicLong idGenerator = new AtomicLong();
	
	// CONSTRUCTORS
	/*
	 * Constructor takes task ID, task name, and task description as parameters. 
	 * All parameters are checked if null or empty. If either exists, the field is filled
	 * with the phrase "NULL" to protect data integrity as a placeholder. Task ID is truncated 
	 * to a maximum of 10 characters, task name to 20 characters, and description to 50 characters.
	 * 
	 */
	public Task(String taskName, String taskDesc) {
		
		// TASKID
		// Task ID is generated when the constructor is called. It is set as a final variable and has
		// no other getter or setter so there should be no way to change it.
		// The idGenerator is static to prevent duplicates across all tasks.
		this.taskID = String.valueOf(idGenerator.getAndIncrement());
		
		if (taskName == null || taskName.isEmpty()) {
			this.taskName = "NULL";
		} else if (taskName.length() > 20) {
			this.taskName = taskName.substring(0, 20);
		} else {
			this.taskName = taskName;
		}
		
		if (taskDesc == null || taskDesc.isEmpty()) {
			this.taskDesc = "NULL";
		} else if (taskDesc.length() > 50) {
			this.taskDesc = taskDesc.substring(0, 50);
		} else {
			this.taskDesc = taskDesc;
		}
	}
	
	// GETTERS
	public String getTaskID() {
		return taskID;
	}
	
	public String getTaskName() {
		return taskName;
	}
	
	public String getTaskDesc() {
		return taskDesc;
	}
	
	// SETTERS
	/*
	 * The setters follow the same rules as the constructor.
	 */
	public void setTaskName(String taskName) {
		if (taskName == null || taskName.isEmpty()) {
			this.taskName = "NULL";
		} else if (taskName.length() > 20) {
			this.taskName = taskName.substring(0, 20);
		} else {
			this.taskName = taskName;
		}
	}
	
	public void setTaskDesc(String taskDesc) {
		if (taskDesc == null || taskDesc.isEmpty()) {
			this.taskDesc = "NULL";
		} else if (taskDesc.length() > 50) {
			this.taskDesc = taskDesc.substring(0, 50);
		} else {
			this.taskDesc = taskDesc;
		}
	}
}