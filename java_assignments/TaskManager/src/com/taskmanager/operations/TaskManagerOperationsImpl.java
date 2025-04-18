package com.taskmanager.operations;

import java.time.LocalDate;
import java.util.HashMap;

import com.taskmanager.core.TaskManager;
import com.taskmanager.core.TaskStatus;

public class TaskManagerOperationsImpl implements TaskManagerOperations {
	
	public HashMap<Integer, TaskManager> populateData() {
		HashMap<Integer, TaskManager> map = new HashMap<>();
		//taskId(int), taskName, description, taskDate, status, active
		map.put(1, addTask(1,"java", "solve problems", LocalDate.now(), "COMPLETED", false));
		map.put(2, addTask(2,"college", "attend lectures",LocalDate.now(), "PENDING", true));
		map.put(3, addTask(3,"gym", "push day", LocalDate.now(), "PENDING", true));
		return map;
	}
	
	@Override
	public TaskManager addTask(int i, String string, String string2, LocalDate date, String pending,
			boolean b) {
//		LocalDate d = LocalDate.parse(date);
		TaskStatus ts = TaskStatus.valueOf(pending.toUpperCase());
		
		return new TaskManager(i, string, string2, date, ts, b);
	}

	@Override
	public void DeleteTask(int id, HashMap<Integer, TaskManager> map) {
		TaskManager tm = map.get(id);
		tm.setActive(false);
		System.out.println("Deleted task "+ id);
	}

	@Override
	public void UpdateTaskStatus(int id,String taskstatus, HashMap<Integer, TaskManager> map) {
		TaskManager tm = map.get(id);
		TaskStatus status = TaskStatus.valueOf(taskstatus.toUpperCase());
		tm.setStatus(status);
		System.out.println("Updated task status of "+id);
		
	}
	@Override
	public void DisplayPendingTasks(HashMap<Integer, TaskManager> map) {
		map.values().stream().filter(p -> p.getTaskDate().isEqual(LocalDate.now()))
		.forEach(p -> System.out.println(p));
	}




}
