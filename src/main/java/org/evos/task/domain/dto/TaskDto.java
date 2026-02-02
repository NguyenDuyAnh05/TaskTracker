package org.evos.task.domain.dto;

import org.evos.task.domain.entity.TaskPriority;
import org.evos.task.domain.entity.TaskStatus;

import java.time.LocalDate;
import java.util.UUID;

/*
* solely used for response AND NEVER used for request
* there is no need for validation
* */
public record TaskDto(
        UUID id,
        String title,
        String description,
        LocalDate dueDate,
        TaskStatus status,
        TaskPriority priority
) {
}
