package com.amanuel.qurying.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.amanuel.qurying.models.Task;
import com.amanuel.qurying.repos.TaskRepo;

@Service
@Transactional
public class TaskService {
	private TaskRepo taskRepo;
	public TaskService(TaskRepo taskRepo) {
		this.taskRepo = taskRepo;
	}
	@Autowired
	private static final int PAGE_SIZE = 5;
	
	public Page<Task> tasksPerPage(int pageNumber){
		PageRequest pageRequest = new PageRequest(pageNumber, PAGE_SIZE, Sort.Direction.ASC, "id");
		Page<Task> tasks = taskRepo.findAll(pageRequest);
		return tasks;
	}
	public List<Task> allTask(){
		return (List<Task>) taskRepo.findAll();
	}
}
