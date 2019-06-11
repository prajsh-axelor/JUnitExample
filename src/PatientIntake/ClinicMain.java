package PatientIntake;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ClinicMain {
	
	public static ClinicCalender calender;
	
	public static void main(String [] args) throws Throwable {
		calender = new ClinicCalender();
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to the Patient Intake Computer System");
		String lastOption = "";
		while (!lastOption.equalsIgnoreCase("x")) {
			lastOption = displayMenu(sc);
		}
		System.out.println("Exiting System");
	}
	
	private static String displayMenu(Scanner sc) throws Throwable {
		System.out.println("Please select an option");
		System.out.println("1. Enter a Patient Appoinment ");
		System.out.println("2. View all Appoinments");
		System.out.println("x. Exit system");
		System.out.println("Option : ");
		
		String option = sc.next();
		switch(option) {
		case "1": performPatientEntry(sc);
					return option;
		case "2": performAllAppointments();
					return option;
		default: System.out.println("Invalid option, please re-enter.");
					return option;
		}
	}
	
	private static void performPatientEntry(Scanner sc) {
		sc.nextLine();
		System.out.println("Please enter appointment info : ");
		System.out.println("Patient last name : ");
		String lastName = sc.nextLine();
		System.out.println("Patient first name : ");
		String firstName = sc.nextLine();
		System.out.println("Appointment date (m/d/yyyy h:mm) : ");
		String when = sc.nextLine();
		System.out.println("Doctor last name ; ");
		String doc = sc.nextLine();
		
		try {
			calender.addAppointment(firstName, lastName, doc, when);
		}catch (Throwable t) {
			System.out.println("Error! "+t.getMessage());
		}
		System.out.println("Patient entered successfully.");
	}
	
	private static void performAllAppointments() throws Throwable {
		System.out.println("All appointments in System: ");
		for(PatientAppoinment appointment : calender.getAppointments()) {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yyyy hh:mm");
			String apptTime = formatter.format(appointment.getAppointmentDateTime());
			System.out.println(String.format("%s: %s, %s \t\t Doctor: %s", apptTime, appointment.getPatientLastName(),
					appointment.getPatientFirstName(), appointment.getDoctor().getName()));
		}
	}
	
	private static void performTodayAppointments() throws Throwable {
		 System.out.println("\n\nAppointments for Today:");
		 for(PatientAppoinment appointment : calender.getTodayAppointment()) {
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yyyy hh:mm");
				String apptTime = formatter.format(appointment.getAppointmentDateTime());
				System.out.println(String.format("%s: %s, %s \t\t Doctor: %s", apptTime, appointment.getPatientLastName(),
						appointment.getPatientFirstName(), appointment.getDoctor().getName()));
			}
	      System.out.println("\n\n");
	}

}
