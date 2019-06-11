package PatientIntake;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class ClinicCalender {
	
	private List<PatientAppoinment> appointments;
	private LocalDate today;
	
	public ClinicCalender() {
		this.appointments = new ArrayList<PatientAppoinment>();
	}
	
	public ClinicCalender(LocalDate today) {
		this.appointments = new ArrayList<PatientAppoinment>();
		this.today = today;
	}	

	public void addAppointment(String patientFirstName, String patientLastName, String doctorKey, String dateTime) {
		Doctor doc = Doctor.valueOf(doctorKey.toLowerCase());
		LocalDateTime localDateTime;
		
		try {
			localDateTime = LocalDateTime.parse(dateTime.toUpperCase(),DateTimeFormatter.ofPattern("M/d/yyyy h:mm a"));
		} catch (Throwable t) {
			throw new RuntimeException("Unable to create date time from: [" + dateTime.toUpperCase() + "], please enter with format [M/d/yyyy h:mm a");
		}
		PatientAppoinment appointment = new PatientAppoinment(patientFirstName, patientLastName, localDateTime, doc);
		appointments.add(appointment);
	}
	
	public List<PatientAppoinment> getAppointments() {
		return this.appointments;
	}
	
	public List<PatientAppoinment> getTodayAppointment() {
		return appointments.stream().filter(appt -> appt.getAppointmentDateTime().toLocalDate().equals(today)).collect(Collectors.toList());
	}
	
	public boolean hasAppointment(LocalDate date) {
		return appointments.stream().anyMatch(appt -> appt.getAppointmentDateTime().toLocalDate().equals(date));
	}
	
}




