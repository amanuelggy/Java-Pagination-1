package com.amanuel.qurying.controllers;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amanuel.qurying.models.Task;
import com.amanuel.qurying.services.TaskService;

@RestController
public class TaskController {
	private TaskService taskService;
	public int num = 5;
	public TaskController(TaskService taskService) {
		this.taskService = taskService;
	}
		@RequestMapping("")
		public Page<Task> index() {
			Page<Task> tasks = taskService.tasksPerPage(this.num - 1);
			int totalPage = tasks.getTotalPages();
			System.out.println("all tasks" + tasks);
			return tasks;
		}
}
