package com.taskmanager.operations;

import java.time.LocalDate;
import java.util.HashMap;

import com.taskmanager.core.TaskManager;
import com.taskmanager.core.TaskStatus;

public interface TaskManagerOperations {
	
	TaskManager addTask(int i, String string, String string2, LocalDate date, String pending,
			boolean b);
	void DeleteTask(int id, HashMap<Integer, TaskManager> map);
	void UpdateTaskStatus(int id, String taskstatus, HashMap<Integer, TaskManager> map);
	void DisplayPendingTasks( HashMap<Integer, TaskManager> map);
	
}
