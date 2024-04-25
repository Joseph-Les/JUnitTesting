package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import java.util.Date;
import com.snhu.appointmentmanager.Appointment;

class AppointmentTest {
	
	@Test
	void testAppointmentIdJustOverLimit() {
	    Date futureDate = new Date(System.currentTimeMillis() + 24 * 60 * 60 * 1000);
	    String longId = "12345678901"; // 11 characters, just over the 10 character limit
	    assertThrows(IllegalArgumentException.class, () -> new Appointment(longId, futureDate, "Valid Description"), "Expected to throw due to ID length");
	}

	@Test
	void testAppointmentDateAtCurrentTime() {
	    Date now = new Date(); // Test at the exact current time, should pass if your logic allows current time
	    assertDoesNotThrow(() -> new Appointment("12345", now, "Valid Description"));
	}

    // Tests successful creation of an Appointment object with valid parameters.
    @Test
    void testAppointmentCreationSuccess() {
        // Setting a future date for the appointment, 1 day into the fute
        Date futureDate = new Date(System.currentTimeMillis() + 24 * 60 * 60 * 1000);
        
        Appointment appointment = new Appointment("1234567890", futureDate, "Regular check-up");
        
        // Asserting that the appointment object is not null and its fields match the expected values
        assertNotNull(appointment);
        assertEquals("1234567890", appointment.getAppointmentID());
        assertEquals(futureDate, appointment.getAppointmentDate());
        assertEquals("Regular check-up", appointment.getAppointmentDescription());
    }

    // Tests that an IllegalArgumentException is thrown when the appointment ID is null.
    @Test
    void testAppointmentIdCannotBeNull() {
        Date futureDate = new Date(System.currentTimeMillis() + 24 * 60 * 60 * 1000);
        
        // Asserting that constructing an Appointment with a null ID
        assertThrows(IllegalArgumentException.class, () -> new Appointment(null, futureDate, "Description"));
    }

    // Tests that an IllegalArgumentException is thrown when the appointment ID exceeds 10 characters.
    @Test
    void testAppointmentIdCannotBeTooLong() {
        Date futureDate = new Date(System.currentTimeMillis() + 24 * 60 * 60 * 1000);
        
        // Asserting that constructing an Appointment with an ID longer than 10 characters
        assertThrows(IllegalArgumentException.class, () -> new Appointment("12345678901", futureDate, "Description"));
    }

    // Tests that an IllegalArgumentException is thrown when the appointment date is null.
    @Test
    void testAppointmentDateCannotBeNull() {
        
        // Asserting that constructing an Appointment with a null date
        assertThrows(IllegalArgumentException.class, () -> new Appointment("1234567890", null, "Description"));
    }

    // Include a test for immediately invalid conditions
    @Test
    void testJustOutsideBoundaryConditions() {
        String tooLongId = "12345678901"; // 11 characters
        String tooLongDescription = "A".repeat(51); // 51 characters
        Date pastDate = new Date(System.currentTimeMillis() - 1000); // 1 second in the past
        assertThrows(IllegalArgumentException.class, () -> new Appointment(tooLongId, new Date(), "Valid Description"));
        assertThrows(IllegalArgumentException.class, () -> new Appointment("12345", pastDate, "Valid Description"));
        assertThrows(IllegalArgumentException.class, () -> new Appointment("12345", new Date(System.currentTimeMillis() + 1000), tooLongDescription));
    }

    // Tests that an IllegalArgumentException is thrown when the appointment description is null.
    @Test
    void testAppointmentDescriptionCannotBeNull() {
        Date futureDate = new Date(System.currentTimeMillis() + 24 * 60 * 60 * 1000);
        
        // Asserting that constructing an Appointment with a null description
        assertThrows(IllegalArgumentException.class, () -> new Appointment("1234567890", futureDate, null));
    }

    // Tests that an IllegalArgumentException is thrown when the appointment description exceeds 50 characters.
    @Test
    void testAppointmentDescriptionCannotBeTooLong() {
        Date futureDate = new Date(System.currentTimeMillis() + 24 * 60 * 60 * 1000);
        String longDescription = "This description is deliberately made longer than fifty characters to test the validation logic in the Appointment constructor.";
        
        // Asserting that constructing an Appointment with a description longer than 50 characters
        assertThrows(IllegalArgumentException.class, () -> new Appointment("1234567890", futureDate, longDescription));
    }
    
    // Test that boundary values are correctly accepted.
    @Test
    void testBoundaryAppointmentId() {
        Date futureDate = new Date(System.currentTimeMillis() + 24 * 60 * 60 * 1000);
        assertDoesNotThrow(() -> new Appointment("1234567890", futureDate, "Valid Description")); // Max length ID
    }

    @Test
    void testBoundaryAppointmentDescription() {
        Date futureDate = new Date(System.currentTimeMillis() + 24 * 60 * 60 * 1000);
        String boundaryDescription = "12345678901234567890123456789012345678901234567890"; // Exactly 50 chars
        assertDoesNotThrow(() -> new Appointment("12345", futureDate, boundaryDescription));
    }

    @Test
    void testExactCurrentDateNotPast() {
        Date currentDate = new Date();
        assertDoesNotThrow(() -> new Appointment("12345", currentDate, "Valid Description")); // Testing right at the current time
    }

    @Test
    void testJustInsideBoundaryConditions() {
        String maxValidId = "1234567890"; // Exactly 10 characters
        String maxValidDescription = "A".repeat(50); // Exactly 50 characters
        Date futureDate = new Date(System.currentTimeMillis() + 1000); // 1 second in the future
        assertDoesNotThrow(() -> new Appointment(maxValidId, futureDate, maxValidDescription));
    }
}
