package com.devsworks.api_java_spring_boot.tasks.facade;

import com.devsworks.api_java_spring_boot.tasks.dto.TasksDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class tasksFacade {
    private static final Map<Long, TasksDto> tasks = new HashMap<>();

    public TasksDto create(TasksDto tasksDto) {
        Long nextId = tasks.keySet().size() + 1L;
        tasksDto.setId(nextId);
        tasks.put(nextId, tasksDto);
        return tasksDto;
    }

    public TasksDto update(TasksDto tasksDto, Long taskId){
        tasks.put(taskId, tasksDto);
        return tasksDto;
    }

    public TasksDto getById (Long taskId){
        return tasks.get(taskId);
    }

    public List<TasksDto> getAll (){
        return new ArrayList<>(tasks.values());
    }

    public String delete (Long taskId) {
        tasks.remove(taskId);
        return "DELETED";
    }

}
