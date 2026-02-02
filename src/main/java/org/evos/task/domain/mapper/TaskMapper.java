package org.evos.task.domain.mapper;

import org.evos.task.domain.CreateTaskRequest;
import org.evos.task.domain.dto.CreateTaskRequestDto;
import org.evos.task.domain.dto.TaskDto;
import org.evos.task.domain.entity.Task;

public interface TaskMapper {
  CreateTaskRequest fromDto(CreateTaskRequestDto dto);
  TaskDto toDto(Task task);
}
