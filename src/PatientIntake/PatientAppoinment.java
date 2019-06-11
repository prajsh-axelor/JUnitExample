package PatientIntake;

import java.time.LocalDateTime;

public class PatientAppoinment {
	
	private String patientFirstName;
	private String patientLastName;
	private LocalDateTime appointmentDateTime;
	private Doctor doctor;
	
	public PatientAppoinment(String patientFirstName, String patientLastName, LocalDateTime appointmentDateTime,
			Doctor doctor) {
		super();
		this.patientFirstName = patientFirstName;
		this.patientLastName = patientLastName;
		this.appointmentDateTime = appointmentDateTime;
		this.doctor = doctor;
	}

	public String getPatientFirstName() {
		return patientFirstName;
	}

	public String getPatientLastName() {
		return patientLastName;
	}

	public LocalDateTime getAppointmentDateTime() {
		return appointmentDateTime;
	}

	public Doctor getDoctor() {
		return doctor;
	}

}
