package com.todo_app.Controller;

import com.todo_app.Service.TaskService;
import com.todo_app.exception.UserExceptionHandler;
import com.todo_app.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class TaskController {
    @Autowired
    private TaskService taskService;
    @GetMapping("/tasks")
    public List<Task> getTasks(){
        return taskService.getTasks();
    }

    @GetMapping("/tasks/{id}")
    public Task getTaskById(@PathVariable Integer id){
        return taskService.getTaskById(id);
    }

    @PostMapping("/CreateTask")
    public String createTask(@RequestBody Task task){
        return taskService.createTask(task);

    }

    @DeleteMapping("task/{id}")
    public String deleteTaskById(@PathVariable Integer id){
        return taskService.deleteById(id);
    }


}
