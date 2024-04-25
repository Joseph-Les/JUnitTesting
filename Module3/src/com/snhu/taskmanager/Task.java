package com.snhu.taskmanager;

// Represents a task with a unique ID, name, and description, enforcing certain constraints on each.
public class Task {
    private final String taskId;
    private String name;
    private String description;
    
    // Constructor that enforces the non-null and length constraints for task ID, name, and description.
    public Task(String taskId, String name, String description) {
    	
        // Validates the task ID: not null and length is less than or equal to 10 characters
        if (taskId == null || taskId.length() > 10) {
            throw new IllegalArgumentException("Task ID cannot be null and must be 10 characters or less.");
        }
        // Validates the name: not null and length is less than or equal to 20 characters
        if (name == null || name.length() > 20) {
            throw new IllegalArgumentException("Name cannot be null and must be 20 characters or less.");
        }
        // Validates the description: not null and length is less than or equal to 50 characters
        if (description == null || description.length() > 50) {
            throw new IllegalArgumentException("Description cannot be null and must be 50 characters or less.");
        }
        
        // Assigning validated values to the fields
        this.taskId = taskId;
        this.name = name;
        this.description = description;
    }

    public String getTaskId() {
        return taskId;
    }

    public String getName() {
        return name;
    }
    
    public String getDescription() {
        return description;
    }

    // Sets a new name for the task, enforcing the not-null and length is
    // less than or equal to 20 characters constraint.
    public void setName(String name) {
        if (name != null && name.length() <= 20) {
            this.name = name;
        } else {
            throw new IllegalArgumentException("Name must be 20 characters or less.");
        }
    }

    // Sets a new description for the task, enforcing the not-null and length is 
    // less than or equal to 50 characters constraint.
    public void setDescription(String description) {
        if (description != null && description.length() <= 50) {
            this.description = description;
        } else {
            throw new IllegalArgumentException("Description must be 50 characters or less.");
        }
    }
}
