package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Date;
import com.snhu.appointmentmanager.AppointmentService;

class AppointmentServiceTest {

    private AppointmentService service;

    @BeforeEach
    void setUp() {
        service = new AppointmentService();
    }

    @Test
    void testAddAppointmentSuccess() {
        // Set a future date for the appointment to 1 day ahead
        Date futureDate = new Date(System.currentTimeMillis() + 24 * 60 * 60 * 1000);

        // Test that adding a valid appointment does not throw any exceptions
        assertDoesNotThrow(() -> service.addAppointment("123", futureDate, "Dental Checkup"));

        // Verify that the appointment can be successfully retrieved
        assertNotNull(service.getAppointment("123"));
    }

    @Test
    void testAddAppointmentWithDuplicateId() {
        // Add an initial appointment to the service
        Date futureDate = new Date(System.currentTimeMillis() + 24 * 60 * 60 * 1000);
        service.addAppointment("124", futureDate, "Eye Exam");

        // Test that adding another appointment with the same ID throws an IllegalArgumentException
        assertThrows(IllegalArgumentException.class, () -> service.addAppointment("124", futureDate, "Another Eye Exam"));
    }

    @Test
    void testDeleteAppointmentSuccess() {
        // Add an appointment that will be deleted in this test
        Date futureDate = new Date(System.currentTimeMillis() + 24 * 60 * 60 * 1000);
        service.addAppointment("125", futureDate, "General Checkup");

        // Test that deleting the appointment does not throw any exceptions
        assertDoesNotThrow(() -> service.deleteAppointment("125"));

        // Ensure that the deleted appointment is null when attempted to retrieve
        assertNull(service.getAppointment("125"));
    }

    @Test
    void testDeleteNonExistentAppointment() {
        // Test that attempting to delete an appointment that doesn't exist in the service throws an IllegalArgumentException
        assertThrows(IllegalArgumentException.class, () -> service.deleteAppointment("999"));
    }
}
