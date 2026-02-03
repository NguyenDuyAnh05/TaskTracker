package org.evos.task.exception;

import java.util.UUID;

public class TaskNotFoundException extends RuntimeException {
  private final UUID id;

  public TaskNotFoundException(UUID id) {
    this.id = id;
    super(
        String.format("Task with id '%s' does not exist!", id)
    );
  }

  public UUID getId() {
    return id;
  }
}
