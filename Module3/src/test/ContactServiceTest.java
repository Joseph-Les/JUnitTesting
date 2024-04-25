package test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.snhu.contactmanager.Contact;
import com.snhu.contactmanager.ContactService;

import org.junit.jupiter.api.Assertions;

public class ContactServiceTest {
    private ContactService contactService;

    @BeforeEach
    public void setUp() {
        contactService = new ContactService();
    }

    @Test
    public void testAddContact() {
        // Test adding a contact successfully
        contactService.addContact("ID100000", "Frederic", "Ellsworth", "1234567890", "42 Wallaby Way");
        Assertions.assertNotNull(contactService.getContactByID("ID100000"));
    }

    @Test
    public void testAddContactWithDuplicateID() {
        // Test adding a contact with a duplicate ID
        contactService.addContact("ID200000", "Kelly", "Shaddock", "0987654321", "42 Wallaby Way");
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            contactService.addContact("ID200000", "Kelly", "Shaddock", "1231231234", "42 Wallaby Way");
        });
    }

    @Test
    public void testDeleteContact() {
        // Test deleting a contact successfully
        String contactID = "ID300000";
        contactService.addContact(contactID, "Charlie", "Chocolate", "1112223333", "42 Wallaby Way");
        contactService.deleteContact(contactID);
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            contactService.getContactByID(contactID);
        });
    }

    @Test
    public void testUpdateContact() {
        // Test updating contact fields successfully
        String contactID = "ID400000";
        contactService.addContact(contactID, "Linda", "Pravdin", "4445556666", "42 Wallaby Way");
        
        // Update fields
        contactService.updateFirstName(contactID, "John");
        contactService.updateLastName(contactID, "Unknown");
        contactService.updatePhone(contactID, "0000000117");
        contactService.updateAddress(contactID, "1170 Eridanus Planet");

        // Verify updates
        Contact updatedContact = contactService.getContactByID(contactID);
        Assertions.assertEquals("John", updatedContact.getFirstName());
        Assertions.assertEquals("Unknown", updatedContact.getLastName());
        Assertions.assertEquals("0000000117", updatedContact.getPhone());
        Assertions.assertEquals("1170 Eridanus Planet", updatedContact.getAddress());
    }
    
}
