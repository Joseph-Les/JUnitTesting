package com.snhu.appointmentmanager;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class AppointmentService {
	
	private final Map<String, Appointment> appointments;
	
	public AppointmentService() {
		this.appointments = new HashMap<>();
	}
	
	public void addAppointment(String appointmentID, Date appointmentDate, String appointmentDescription) {
		// Check if the appointment ID already exists
		if (appointments.containsKey(appointmentID)) {
			throw new IllegalArgumentException("Appointment ID already exists.");
		}
		
		// Create a new Appointment object and add it to the map
		Appointment newAppointment = new Appointment(appointmentID, appointmentDate, appointmentDescription);
		appointments.put(appointmentID, newAppointment);
	}
	
	// Checks if appoint ID exists, throws error if does not or removes appointment
	public void deleteAppointment(String appointmentID) {
		// Check if the appointment ID exists
		if (!appointments.containsKey(appointmentID)) {
			throw new IllegalArgumentException("Appointment ID does not exist.");
		}
				
		appointments.remove(appointmentID);
	}
	
	// A method to retrieve an appointment, useful for validation/testing
	public Appointment getAppointment(String appointmentID) {
		return appointments.get(appointmentID);
	}
}
