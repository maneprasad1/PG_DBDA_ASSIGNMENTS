package com.taskmanager.tester;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;

import com.taskmanager.core.TaskManager;
import com.taskmanager.custom_exception.CustomTaskException;
import com.taskmanager.operations.TaskManagerOperationsImpl;

public class TaskTester {

	public static void main(String[] args) throws CustomTaskException {
		try (Scanner sc = new Scanner(System.in)) {
			TaskManagerOperationsImpl tm = new TaskManagerOperationsImpl();
			HashMap<Integer, TaskManager> map = tm.populateData();
//			map.values().forEach(v -> System.out.println(v));
			System.out.println("Options - \n1.Enter new Task \n2.Delete task \n3.Dispaly all tasks"
					+ "\n4.Update task status \n5.Display pending tasks"
					+ "\n6.Display tasks sorted acc to dates \n0.EXIT");
			boolean flag = false;
			int idCounter = 4;
			while (!flag) {
				switch (sc.nextInt()) {
				case 1:
					System.out.println("Enter taskname, task description");
					// taskId(int), taskName, description, taskDate, status, active
					TaskManager task = tm.addTask(idCounter++,sc.next(),sc.next(),
							LocalDate.now(),"pending",true);
					System.out.println("Task added successfully");
//					if(map.containsKey(task.getTaskName())) {
//						throw new CustomTaskException("Task already exists");
//					}
					map.put(task.getTaskId(), task);
					break;
				case 2:
					System.out.println("Enter task id to delete task");
					tm.DeleteTask(sc.nextInt(), map);
					break;
				case 3:
					map.values().forEach(v -> System.out.println(v));
					break;
				case 4:
					System.out.println("Enter task id and status to update");
					tm.UpdateTaskStatus(sc.nextInt(), sc.next(), map);
					break;
				case 5:
					System.out.println("Displaying today's pending tasks");
					tm.DisplayPendingTasks(map);
					break;
				case 6:
					System.out.println("Displaying tasks sorted acc to dates");
					Comparator<TaskManager> c = (c1,c2) -> c1.getTaskDate().compareTo(c2.getTaskDate());
					map.values().stream().sorted(c);
					break;
				case 0:
					flag = true;
					break;
				}
			}
		}

	}

}
