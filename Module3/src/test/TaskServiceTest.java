package test;

import com.snhu.taskmanager.TaskService;
import com.snhu.taskmanager.Task;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class TaskServiceTest {
    
    private TaskService service;

    // This method runs before each test, setting up a fresh TaskService for each test case
    @BeforeEach
    public void setUp() {
        service = new TaskService();
    }

    // Test case for adding a task successfully. 
    // It ensures that adding a task with a unique ID does not throw any exception
    @Test
    public void testAddTask() {
        // Adding a task with ID "1" and verifying that it can be retrieved without throwing an exception
        service.addTask("1", "Task One", "Description for Task One");
        Assertions.assertDoesNotThrow(() -> service.getTaskById("1"));
    }

    // Test case for attempting to add a task with an ID that already exists.
    // This will throw an IllegalArgumentException
    @Test
    public void testAddTaskWithDuplicateId() {
        // Adding a task with ID "2" and then attempting to add another task with the same ID.
        service.addTask("2", "Task Two", "Description for Task Two");
        Assertions.assertThrows(IllegalArgumentException.class, () -> service.addTask("2", "Task Two Duplicate", "Duplicate Description"));
    }

    // Test case for deleting an existing task. It verifies that the task is deleted successfully 
   //  and cannot be retrieved afterward
    @Test
    public void testDeleteTask() {
        service.addTask("3", "Task Three", "Description for Task Three");
        Assertions.assertDoesNotThrow(() -> service.deleteTask("3"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> service.getTaskById("3"));
    }

    // Test case for updating the name and description of an existing task.
    // Test verifies that the updates are applied correctly
    @Test
    public void testUpdateTask() {
        service.addTask("4", "Task Four", "Description for Task Four");
        Assertions.assertDoesNotThrow(() -> service.updateTaskName("4", "Task Four Updated"));
        Assertions.assertDoesNotThrow(() -> service.updateTaskDescription("4", "Updated Description for Task Four"));
        Task updatedTask = service.getTaskById("4");
        Assertions.assertEquals("Task Four Updated", updatedTask.getName());
        Assertions.assertEquals("Updated Description for Task Four", updatedTask.getDescription());
    }
}
