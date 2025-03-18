package com.devsworks.api_java_spring_boot.tasks.api;

import com.devsworks.api_java_spring_boot.tasks.dto.TasksDto;
import com.devsworks.api_java_spring_boot.tasks.facade.tasksFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.DeleteMapping;


import java.util.List;


@Controller
@RequestMapping(value = "/tasks", produces = MediaType.APPLICATION_JSON_VALUE)
public class tasksAPI {
    @Autowired
    private tasksFacade tasksFacade;

    @PostMapping
    @ResponseBody
    public TasksDto create(@RequestBody TasksDto tasksDto) {
        return tasksFacade.create(tasksDto);
    }

    @PutMapping("/{taskId}")
    @ResponseBody
    public TasksDto update(@PathVariable("taskId") Long taskId,
                           @RequestBody TasksDto tasksDto){

        return tasksFacade.update(tasksDto, taskId);
    }

    @GetMapping
    @ResponseBody
    public List<TasksDto> getAll() {
        return tasksFacade.getAll();
    }

    @DeleteMapping("/{taskId}")
    @ResponseBody
    public String delete(@PathVariable("taskId") Long taskId) {
        return tasksFacade.delete(taskId);
    }
}

