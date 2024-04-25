package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import com.snhu.taskmanager.Task;

public class TaskTest {

    @Test
    public void testTaskCreationSuccess() {
        // Test task creation with valid inputs and verify each field
        Task task = new Task("1234567890", "Valid Name", "Valid Description");
        Assertions.assertNotNull(task);
        Assertions.assertEquals("1234567890", task.getTaskId());
        Assertions.assertEquals("Valid Name", task.getName());
        Assertions.assertEquals("Valid Description", task.getDescription());
    }

    @Test
    public void testMaxBoundaryName() {
        // Test that a max boundary name (20 characters) does not throw an exception
        Assertions.assertDoesNotThrow(() -> {
            new Task("1", "12345678901234567890", "Description");
        });
    }

    @Test
    public void testMaxBoundaryDescription() {
        // Test that a max boundary description (50 characters) does not throw an exception
        Assertions.assertDoesNotThrow(() -> {
            new Task("1", "Task Name", "12345678901234567890123456789012345678901234567890");
        });
    }

    @Test
    public void testUpdateTaskName() {
        // Test updating the task's name with a valid new name
        Task task = new Task("1", "Initial Name", "Initial Description");
        task.setName("Updated Name");
        Assertions.assertEquals("Updated Name", task.getName());
    }

    @Test
    public void testUpdateTaskDescription() {
        // Test updating the task's description with a valid new description
        Task task = new Task("1", "Initial Name", "Initial Description");
        task.setDescription("Updated Description");
        Assertions.assertEquals("Updated Description", task.getDescription());
    }
}
