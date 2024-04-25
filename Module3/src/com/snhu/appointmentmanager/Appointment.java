package com.snhu.appointmentmanager;

import java.util.Date;

public class Appointment {
	
    // Immutable identifier for the appointment, assigned at creation.
    private final String appointmentID;
    // The scheduled date and time for the appointment.
    private Date appointmentDate;
    // A short description of the appointment purpose.
    private String appointmentDescription;
    
    // Constructor initializes a new Appointment object with specified ID, date, and description.
    public Appointment (String appointmentID, Date appointmentDate, String appointmentDescription) {
    	
        // Validates appointment ID is not null and does not exceed 10 characters.
    	if (appointmentID == null || appointmentID.length() > 10) {
            throw new IllegalArgumentException("Invalid appointment ID");
        }
    	
    	// Validates the appointment date is not null and not in the past
        if (appointmentDate == null || appointmentDate.before(new Date())) {
            throw new IllegalArgumentException("Invalid appointment date");
        }
        
        // Validates the appointment description is not null and does not exceed 50 characters.
        if (appointmentDescription == null || appointmentDescription.length() > 50) {
            throw new IllegalArgumentException("Invalid appointment description");
        }
        
        // Assign validated values to the object's fields.
        this.appointmentID = appointmentID;
        this.appointmentDate = appointmentDate;
        this.appointmentDescription = appointmentDescription;
    }

    // Returns the appointment's ID.
	public String getAppointmentID() {
		return appointmentID;
	}

    // Returns the appointment's scheduled date.
	public Date getAppointmentDate() {
		return appointmentDate;
	}

    // Updates the appointment's date with a new valid date (not null or past).
	public void setAppointmentDate(Date appointmentDate) {
		if (appointmentDate != null && !appointmentDate.before(new Date())) {
			this.appointmentDate = appointmentDate;
		} else {
			throw new IllegalArgumentException("Appointment date cannot be null or in the past.");
		}
	}

    // Returns the description of the appointment.
	public String getAppointmentDescription() {
		return appointmentDescription;
	}

    // Updates the appointment's description with a new valid description (not null and <= 50 characters).
	public void setAppointmentDescription(String appointmentDescription) {
		if (appointmentDescription != null && appointmentDescription.length() <= 50) {
			this.appointmentDescription = appointmentDescription;
		} else {
			throw new IllegalArgumentException("Appointment description cannot be null and must be 50 characters or less.");
		}
	}
}
