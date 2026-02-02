package org.evos.task.domain.controller;

import jakarta.validation.Valid;
import org.evos.task.domain.CreateTaskRequest;
import org.evos.task.domain.dto.CreateTaskRequestDto;
import org.evos.task.domain.dto.TaskDto;
import org.evos.task.domain.entity.Task;
import org.evos.task.domain.mapper.TaskMapper;
import org.evos.task.service.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/tasks")
public class TaskController {

  private final TaskService service;
  private final TaskMapper taskMapper;

  public TaskController(TaskService service, TaskMapper taskMapper) {
    this.service = service;
    this.taskMapper = taskMapper;
  }

  @PostMapping
  public ResponseEntity<TaskDto> createTask(
          @Valid @RequestBody CreateTaskRequestDto createTaskRequestDto
  ){
    CreateTaskRequest createTaskRequest = taskMapper.fromDto(createTaskRequestDto);
    Task task = service.createTask(createTaskRequest);
    TaskDto dto = taskMapper.toDto(task);

    return new ResponseEntity<>(dto, HttpStatus.CREATED);
  }

  @GetMapping
  public ResponseEntity<List<TaskDto>> getTasks(){
    final List<Task> listTasks = service.listTasks();
    final List<TaskDto> taskDtos = listTasks.stream().map(taskMapper::toDto).toList();
    return ResponseEntity.ok(taskDtos);
  }
}
