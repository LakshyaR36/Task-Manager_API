package com.vishal.taskmanager.service;

import com.vishal.taskmanager.dto.TaskRequest;
import com.vishal.taskmanager.dto.TaskResponse;

import java.util.List;

public interface TaskService {

    TaskResponse createTask(TaskRequest request);

    List<TaskResponse> getAllTasks();

    TaskResponse getTaskById(Long id);

    TaskResponse updateTask(Long id, TaskRequest request);

    void deleteTask(Long id);
}