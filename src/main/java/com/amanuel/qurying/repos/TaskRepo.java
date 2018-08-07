package com.amanuel.qurying.repos;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.amanuel.qurying.models.Task;

public interface  TaskRepo extends PagingAndSortingRepository<Task, Long> {

}
