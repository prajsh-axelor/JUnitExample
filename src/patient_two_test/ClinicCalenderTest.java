package patient_two_test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import patient_two.ClinicCalendar;
import patient_two.Doctor;
import patient_two.PatientAppointment;

public class ClinicCalenderTest {

	private ClinicCalendar calendar;

	   @BeforeEach
	   void init() {
	      calendar = new ClinicCalendar(LocalDate.of(2018, 8, 26));
	   }

	   @Test
	   void allowEntryOfAnAppointment() {
	      calendar.addAppointment("Jim", "Weaver", "avery",
	         "09/01/2018 2:00 pm");
	      calendar.addAppointment("Prajjwal", "Singh", "Singh",
	 	         "09/01/2018 2:00 pm");
	      calendar.addAppointment("Kinjal", "Kumar", "avery",
	 	         "09/01/2018 2:00 pm");
	      List<PatientAppointment> appointments = calendar.getAppointments();
	      assertNotNull(appointments);
	      assertEquals(3, appointments.size());
	      
	      PatientAppointment enteredAppt = appointments.get(0);

	      assertAll(
	         () -> assertEquals("Jim", enteredAppt.getPatientFirstName()),
	         () -> assertEquals("Weaver", enteredAppt.getPatientLastName()),
	         () -> assertSame(Doctor.avery, enteredAppt.getDoctor()),
	         () -> assertEquals("9/1/2018 02:00 PM",
	            enteredAppt.getAppointmentDateTime().format(DateTimeFormatter.ofPattern("M/d/yyyy hh:mm a")))
	      );
	   }

	   @Test
	   void returnTrueForHasAppointmentsIfThereAreAppointments() {
	      calendar.addAppointment("Jim", "Weaver", "avery","09/01/2018 2:00 pm");
	      assertTrue(calendar.hasAppointment(LocalDate.of(2018, 9, 1)));
	   }

	   @Test
	   void returnFalseForHasAppointmentsIfThereAreNoAppointments() {
	      assertFalse(calendar.hasAppointment(LocalDate.of(2018, 9, 1)));
	   }

	   @Test
	   void returnCurrentDaysAppointments() {
	      calendar.addAppointment("Jim", "Weaver", "avery",
	         "08/26/2018 2:00 pm");
	      calendar.addAppointment("Jim", "Weaver", "avery",
	         "08/26/2018 3:00 pm");
	      calendar.addAppointment("Jim", "Weaver", "avery",
	         "09/01/2018 2:00 pm");
	      assertEquals(20, calendar.getTodayAppointments().size());
	}

}
