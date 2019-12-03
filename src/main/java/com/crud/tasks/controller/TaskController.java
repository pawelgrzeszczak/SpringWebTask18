package com.crud.tasks.controller;

import com.crud.tasks.domain.TaskDto;
import com.crud.tasks.mapper.TaskMapper;
import com.crud.tasks.service.DbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/task")

public class TaskController {
    @Autowired
    private DbService service;
    @Autowired
    private TaskMapper taskMapper;

    @RequestMapping(method = RequestMethod.GET, value = "getTasks")
    public List<TaskDto> getTasks() {
        return taskMapper.mapToTaskDtoList(service.getAllTasks());
    }

    @RequestMapping(method = RequestMethod.GET, value = "tasks/{taskId}")
    public TaskDto getTask(@PathVariable Long taskId) {
        return taskMapper.mapToTaskDto(service.getTask(taskId).orElseThrow(IllegalArgumentException::new));
//        return new TaskDto(1L, "test title", "test_content");
    }


//    @RequestMapping(method = RequestMethod.GET, value = "tasks/{taskId}")
//    public TaskDto getTask(@PathVariable Long taskId) {
//        return tasks.stream().filter(task -> task.getId() == taskId).findAny().orElseThrow(IllegalArgumentException::new);
//    }



    @RequestMapping(method = RequestMethod.DELETE, value = "tasks/{taskId}")
    public void deleteTask(@PathVariable Long taskId) {

    }

    @RequestMapping(method = RequestMethod.PUT, value = "tasks")
    public TaskDto updateTask(@RequestBody TaskDto taskDto) {
        return new TaskDto(1L, "Edited test title", "Test content");
    }

    @RequestMapping(method = RequestMethod.POST, value = "tasks")
    public void createTask(@RequestBody TaskDto taskDto) {
    }
}
