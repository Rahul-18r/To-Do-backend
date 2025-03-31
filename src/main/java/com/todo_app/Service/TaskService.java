package com.todo_app.Service;

import com.todo_app.exception.UserExceptionHandler;
import com.todo_app.model.Task;
import com.todo_app.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;

@Service
public class TaskService {
    private TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getTasks() {
        return taskRepository.findAll();
    }

    public Task getTaskById(Integer id) {
        return taskRepository.findById(id).orElseThrow(()->new UserExceptionHandler("Task Can't be Created"));
    }

    public String createTask(Task task) {
        try {
            taskRepository.save(task);
            return "Task Added Successfully";
        } catch (Exception e) {
            return "Task Cannot be Added: " + e.getMessage();
        }
    }

    public String deleteById(Integer id) {
        Task task=taskRepository.findById(id).orElseThrow(()->new UserExceptionHandler("Task Not Exist."));
        String msg=task.toString()+" Is Deleted.";
        taskRepository.deleteById(id);
        return msg;

    }
}
