package org.evos.task.domain.mapper.impl;

import org.evos.task.domain.CreateTaskRequest;
import org.evos.task.domain.dto.CreateTaskRequestDto;
import org.evos.task.domain.dto.TaskDto;
import org.evos.task.domain.entity.Task;
import org.evos.task.domain.mapper.TaskMapper;
import org.springframework.stereotype.Component;

@Component
public class TaskMapperImpl implements TaskMapper {

  @Override
  public CreateTaskRequest fromDto(CreateTaskRequestDto dto) {
    return new CreateTaskRequest(
            dto.title(),
            dto.description(),
            dto.dueDate(),
            dto.priority()
    );
  }

  @Override
  public TaskDto toDto(Task task) {
    return new TaskDto(
            task.getId(),
            task.getTitle(),
            task.getDescription(),
            task.getDueDate(),
            task.getStatus(),
            task.getPriority()
    );
  }
}
