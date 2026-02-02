package org.evos.task.service;

import org.evos.task.domain.CreateTaskRequest;
import org.evos.task.domain.entity.Task;

import java.util.List;

public interface TaskService {
  Task createTask(CreateTaskRequest request);
  List<Task> listTasks();
}
