package org.evos.task.service.impl;

import org.evos.task.domain.CreateTaskRequest;
import org.evos.task.domain.entity.Task;
import org.evos.task.domain.entity.TaskStatus;
import org.evos.task.repository.TaskRepository;
import org.evos.task.service.TaskService;
import static org.springframework.data.domain.Sort.*;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {
  private final TaskRepository repository;

  public TaskServiceImpl(TaskRepository repository) {
    this.repository = repository;
  }

  @Override
  public Task createTask(CreateTaskRequest request) {
    Instant now = Instant.now();
    Task task = new Task(
      null,
      request.title(),
      request.description(),
      request.dueDate(),
      TaskStatus.OPEN,
      request.priority(),
      now,
      now
    );
    return repository.save(task);
  }

  @Override
  public List<Task> listTasks() {
    return repository.findAll(Sort.by(Direction.ASC, "created"));
  }
}
