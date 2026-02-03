package org.evos.task.domain;

import org.evos.task.domain.entity.TaskPriority;
import org.evos.task.domain.entity.TaskStatus;

import java.time.LocalDate;

public record UpdateTaskRequest(
    String title,
    String description,
    LocalDate dueDate,
    TaskStatus status,
    TaskPriority priority

) {
  }
