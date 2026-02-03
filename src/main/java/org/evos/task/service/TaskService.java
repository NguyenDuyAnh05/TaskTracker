package org.evos.task.service;

import org.evos.task.domain.CreateTaskRequest;
import org.evos.task.domain.UpdateTaskRequest;
import org.evos.task.domain.entity.Task;

import java.util.List;
import java.util.UUID;

public interface TaskService {
  Task createTask(CreateTaskRequest request);
  List<Task> listTasks();
  Task updateTask(UUID id, UpdateTaskRequest request);
}
