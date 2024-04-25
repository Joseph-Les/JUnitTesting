package com.snhu.contactmanager;
import java.util.HashMap;
import java.util.Map;

// Manages contact information, allowing the addition, deletion, and updating of contacts.
public class ContactService {
	
    // Stores contacts using their ID as the key.
    private final Map<String, Contact> contacts;

    // Initializes the contact service with an empty list of contacts.
    public ContactService() {
        this.contacts = new HashMap<>();
    }

    // Adds a new contact to the service if the ID is unique and not null.
    public void addContact(String contactID, String firstName, String lastName, String phone, String address) {
        if (contactID == null || contacts.containsKey(contactID)) {
            throw new IllegalArgumentException("Contact ID is null or already exists.");
        }
        Contact newContact = new Contact(contactID, firstName, lastName, phone, address);
        contacts.put(contactID, newContact);
    }

    // Deletes the contact with the specified ID, if it exists.
    public void deleteContact(String contactID) {
        if (!contacts.containsKey(contactID)) {
            throw new IllegalArgumentException("Contact ID does not exist");
        }
        contacts.remove(contactID);
    }

    // Updates the first name of the contact with the given ID.
    public void updateFirstName(String contactID, String firstName) {
        Contact contact = getContactByID(contactID);
        contact.setFirstName(firstName);
    }

    // Updates the last name of the contact with the given ID.
    public void updateLastName(String contactID, String lastName) {
        Contact contact = getContactByID(contactID);
        contact.setLastName(lastName);
    }

    // Updates the phone number of the contact with the given ID.
    public void updatePhone(String contactID, String phone) {
        Contact contact = getContactByID(contactID);
        contact.setPhone(phone);
    }

    // Updates the address of the contact with the given ID.
    public void updateAddress(String contactID, String address) {
        Contact contact = getContactByID(contactID);
        contact.setAddress(address);
    }

    // Retrieves a contact by ID, throwing an exception if the contact does not exist
    public Contact getContactByID(String contactID) {
        Contact contact = contacts.get(contactID);
        if (contact == null) {
            throw new IllegalArgumentException("Contact ID does not exist.");
        }
        return contact;
    }
}
