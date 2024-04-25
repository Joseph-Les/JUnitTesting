package com.snhu.contactmanager;

// Represents a contact with essential personal information.
public class Contact {
	
    // Identifier for the contact, immutable after creation.
    private final String contactID;
    private String firstName;
    private String lastName;
    private String phone;
    private String address;

    // Constructs a new Contact instance, validating input parameters.
    public Contact(String contactID, String firstName, String lastName, String phone, String address) {
        if (contactID == null || contactID.length() > 10) {
            throw new IllegalArgumentException("Invalid contact ID");
        }
        if (firstName == null || firstName.length() > 10) {
            throw new IllegalArgumentException("Invalid first name");
        }
        if (lastName == null || lastName.length() > 10) {
            throw new IllegalArgumentException("Invalid last name");
        }
        if (phone == null || !phone.matches("\\d{10}")) {
            throw new IllegalArgumentException("Invalid phone number");
        }
        if (address == null || address.length() >= 31) {
            throw new IllegalArgumentException("Invalid address");
        }
        
        this.contactID = contactID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.address = address;
    }

    // Returns the contact's ID
    public String getContactID() {
        return contactID;
    }

    // Returns the contact's first name.
    public String getFirstName() {
        return firstName;
    }

    // Sets the contact's first name if it meets the validation criteria.
    public void setFirstName(String firstName) {
        if (firstName != null && firstName.length() <= 10) {
            this.firstName = firstName;
        } else {
            throw new IllegalArgumentException("Invalid first name.");
        }
    }

    // Returns the contact's last name.
    public String getLastName() {
        return lastName;
    }

    // Sets the contact's last name if it meets the validation criteria.
    public void setLastName(String lastName) {
        if (lastName != null && lastName.length() <= 10) {
            this.lastName = lastName;
        } else {
            throw new IllegalArgumentException("Invalid last name.");
        }
    }

    // Returns the contact's phone number.
    public String getPhone() {
        return phone;
    }

    // Sets the contact's phone number if it meets the validation criteria (10 digits).
    public void setPhone(String phone) {
        if (phone != null && phone.matches("\\d{10}")) {
            this.phone = phone;
        } else {
            throw new IllegalArgumentException("Invalid phone number.");
        }
    }

    // Returns the contact's address.
    public String getAddress() {
        return address;
    }

    // Sets the contact's address if it meets the validation criteria (no more than 30 characters).
    public void setAddress(String address) {
        if (address != null && address.length() <= 30) {
            this.address = address;
        } else {
            throw new IllegalArgumentException("Invalid address.");
        }
    }
}
