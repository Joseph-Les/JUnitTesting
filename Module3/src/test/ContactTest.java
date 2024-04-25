package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.snhu.contactmanager.Contact;

public class ContactTest {

    @Test
    public void testContactCreationSuccess() {
        // Test successful contact creation
        Contact contact = new Contact("ID123456", "Joe", "Les", "1234567890", "123 Main St");
        Assertions.assertNotNull(contact);
        Assertions.assertEquals("Joe", contact.getFirstName());
        Assertions.assertEquals("Les", contact.getLastName());
        Assertions.assertEquals("1234567890", contact.getPhone());
        Assertions.assertEquals("123 Main St", contact.getAddress());
    }

    @Test
    public void testValidContactCreation() {
        // Creating a contact with all fields set to typical valid values within the allowed limits
        Assertions.assertDoesNotThrow(() -> {
            Contact contact = new Contact("IDValid01", "John", "Doe", "9876543210", "1 Infinite Loop");
            Assertions.assertEquals("John", contact.getFirstName());
            Assertions.assertEquals("Doe", contact.getLastName());
            Assertions.assertEquals("9876543210", contact.getPhone());
            Assertions.assertEquals("1 Infinite Loop", contact.getAddress());
        });
    }
    
    @Test
    public void testTypicalContactFields() {
        // Tests that creating a contact with typical valid values for each field does not throw exceptions
        Assertions.assertDoesNotThrow(() -> {
            Contact contact = new Contact("ID123456", "Alice", "Smith", "0123456789", "123 Elm Street");
            Assertions.assertEquals("Alice", contact.getFirstName());
            Assertions.assertEquals("Smith", contact.getLastName());
            Assertions.assertEquals("0123456789", contact.getPhone());
            Assertions.assertEquals("123 Elm Street", contact.getAddress());
        });
    }
    
    @Test
    public void testMaxBoundaryFirstName() {
        // Test that a max boundary first name does not throw an exception
        Assertions.assertDoesNotThrow(() -> {
            Contact contact = new Contact("ID123456", "ABCDEFGHIJ", "Les", "1234567890", "123 Main St");
            Assertions.assertEquals("ABCDEFGHIJ", contact.getFirstName());
        });
    }

    @Test
    public void testMaxBoundaryLastName() {
        // Test that a max boundary last name does not throw an exception
        Assertions.assertDoesNotThrow(() -> {
            Contact contact = new Contact("ID123456", "Joe", "ABCDEFGHIJ", "1234567890", "123 Main St");
            Assertions.assertEquals("ABCDEFGHIJ", contact.getLastName());
        });
    }

    @Test
    public void testMaxBoundaryPhone() {
        // Test that a max boundary phone number does not throw an exception
        Assertions.assertDoesNotThrow(() -> {
            Contact contact = new Contact("ID123456", "Joe", "Les", "1234567890", "123 Main St");
            Assertions.assertEquals("1234567890", contact.getPhone());
        });
    }

    @Test
    public void testMaxBoundaryAddress() {
        // Test that a max boundary address does not throw an exception
        String address = "123456789012345678901234567890"; // Exactly 30 characters
        Assertions.assertDoesNotThrow(() -> {
            Contact contact = new Contact("ID123456", "Joe", "Les", "1234567890", address);
            Assertions.assertEquals(address, contact.getAddress());
        });
    }

}
