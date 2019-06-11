package PatientIntake;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.junit.jupiter.api.Test;

public class ClinicCalenderTest {

	@Test
	public void allowEntryOfAnAppointment() {
//		ClinicCalender calender = new ClinicCalender();
		
		ClinicCalender calender = new ClinicCalender(LocalDate.now());
		calender.addAppointment("Prajjwal", "Singh", "Singh", "09/01/2019 2:00 pm");
		
		List<PatientAppoinment> appointments = calender.getAppointments();
		assertNotNull(appointments);
		assertEquals(1, appointments.size());
		
		PatientAppoinment enteredAppt = appointments.get(0);
		System.out.println(enteredAppt.getPatientFirstName()+ enteredAppt.getPatientLastName()+ enteredAppt.getDoctor()+ enteredAppt.getAppointmentDateTime().format(DateTimeFormatter.ofPattern("M/d/yyyy hh:mm a")));
		assertEquals("Prajjwal", enteredAppt.getPatientFirstName());
		assertEquals("Singh", enteredAppt.getPatientLastName());
		assertEquals(Doctor.singh, enteredAppt.getDoctor());
		assertSame(Doctor.singh, enteredAppt.getDoctor());  
		// // assertNotSame(unexpected, actual);
		assertEquals("9/1/2019 02:00 PM", enteredAppt.getAppointmentDateTime().format(DateTimeFormatter.ofPattern("M/d/yyyy hh:mm a")));
		
	}
	
	@Test
	public void returnTrueIfAppointmentsPresent () {
		ClinicCalender calender = new ClinicCalender(LocalDate.now());
		calender.addAppointment("Prajjwal", "Singh", "Singh", "09/01/2019 2:00 pm");
		assertTrue(calender.hasAppointment(LocalDate.of(2019, 9, 01)));
	}
	
	@Test
	public void returnFalseIfAppointmentsNotPresent () {
		ClinicCalender calender = new ClinicCalender(LocalDate.now());
//		calender.addAppointment("Prajjwal", "Singh", "Singh", "09/01/2019 2:00 pm");
		assertFalse(calender.hasAppointment(LocalDate.of(2019, 9, 01)));
	}

}
