package org.evos.task.domain.dto;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.evos.task.domain.entity.TaskPriority;
import org.evos.task.domain.entity.TaskStatus;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;
import java.util.UUID;

public record UpdateTaskRequestDto(
    @NotBlank(message = ERROR_MESSAGE_TITLE_LENGTH)
    @Length(max = 255)
    String title,
    @Length(max = 1000, message = ERROR_MESSAGE_DESCRIPTION_LENGTH)
    @Nullable
    String description,
    @FutureOrPresent(message = ERROR_MESSAGE_DUE_DATE_FUTURE)
    @Nullable
    LocalDate dueDate,
    @NotNull(message = ERROR_MESSAGE_STATUS)
    TaskStatus status,
    @NotNull(message = ERROR_MESSAGE_PRIORITY)
    TaskPriority priority
) {
  private static final String ERROR_MESSAGE_TITLE_LENGTH =
    "Title must be between 1 and 255";
  private static final String ERROR_MESSAGE_DESCRIPTION_LENGTH =
    "The maximum length is 1000 characters";
  private static final String ERROR_MESSAGE_DUE_DATE_FUTURE =
    "Due date must be in the future";
  private static final String ERROR_MESSAGE_STATUS =
    "Status must be provided";
  private static final String ERROR_MESSAGE_PRIORITY =
     "Priority must be provided";
}
