// Milestone 6: Contact, Appointment, and Task Services by Joseph Les //

package com.snhu.contactmanager;

import java.util.Date;
import com.snhu.appointmentmanager.AppointmentService;
import com.snhu.taskmanager.TaskService;

public class Main {
    public static void main(String[] args) {
        ContactService contactService = new ContactService();
        AppointmentService appointmentService = new AppointmentService();
        TaskService taskService = new TaskService();

        // Add a few contacts
        contactService.addContact("ID01", "Jerome", "Cable", "1234567890", "51 Pegasi St");
        contactService.addContact("ID02", "Douglas", "Rutland", "0987654321", "042 Reme St");

        // Add a few appointments
        Date futureDate = new Date(System.currentTimeMillis() + 24 * 60 * 60 * 1000); // 1 day in the future
        appointmentService.addAppointment("APPT01", futureDate, "Dental Checkup");
        appointmentService.addAppointment("APPT02", new Date(System.currentTimeMillis() + 48 * 60 * 60 * 1000), "Annual Physical Exam");

        // Add a few tasks
        taskService.addTask("TASK01", "Update Project", "Project update");
        taskService.addTask("TASK02", "Review Code", "Review PR");

        // Attempt to update a contact.
        try {
            contactService.updateFirstName("ID01", "John");
            contactService.updateAddress("ID01", "117 Carrow St");
            System.out.println("Contact updated successfully.");
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }

        // Attempt to delete a contact
        try {
            contactService.deleteContact("ID02");
            System.out.println("Contact deleted successfully.");
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }

        // Attempt to update a task
        try {
            taskService.updateTaskName("TASK01", "Project Updated");
            taskService.updateTaskDescription("TASK01", "Completed");
            System.out.println("Task updated successfully.");
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
        
        // Attempt to delete a task
        try {
            taskService.deleteTask("TASK01");
            System.out.println("Task deleted successfully.");
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
        
     // Attempt to delete an appointment
        try {
            appointmentService.addAppointment("APPT03", futureDate, "Vet Checkup");
            System.out.println("Appointment added successfully.");
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }

        // Attempt to delete an appointment
        try {
            appointmentService.deleteAppointment("APPT01");
            System.out.println("Appointment deleted successfully.");
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }
}
