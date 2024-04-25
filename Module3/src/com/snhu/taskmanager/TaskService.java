package com.snhu.taskmanager;

import java.util.HashMap;
import java.util.Map;

// Manages tasks by providing functionalities to add, update, and delete tasks.
public class TaskService {
    private final Map<String, Task> tasks;

    // Initializes the task service with an empty map.
    public TaskService() {
        this.tasks = new HashMap<>();
    }

    // Adds a task to the map if the task ID is unique.
    public void addTask(String taskId, String name, String description) {
        if (tasks.containsKey(taskId)) {
            throw new IllegalArgumentException("Task ID already exists.");
        }
        Task newTask = new Task(taskId, name, description);
        tasks.put(taskId, newTask);
    }

    // Deletes a task by its ID.
    public void deleteTask(String taskId) {
        if (!tasks.containsKey(taskId)) {
            throw new IllegalArgumentException("Task ID does not exist.");
        }
        tasks.remove(taskId);
    }

    // Updates the name of an existing task.
    public void updateTaskName(String taskId, String newName) {
        Task task = getTaskById(taskId);
        task.setName(newName);
    }

    // Updates the description of an existing task.
    public void updateTaskDescription(String taskId, String newDescription) {
        Task task = getTaskById(taskId);
        task.setDescription(newDescription);
    }

    // Retrieves a task by its ID, throwing an exception if the task doesn't exist.
    public Task getTaskById(String taskId) {
        if (!tasks.containsKey(taskId)) {
            throw new IllegalArgumentException("Task ID does not exist.");
        }
        return tasks.get(taskId);
    }
}
