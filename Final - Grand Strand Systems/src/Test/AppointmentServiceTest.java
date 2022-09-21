/*************************
 * Name: 	Brandon Ricks 
 * Course: 	CS-320 
 * Date: 	May 30, 2021
 * Description: This is the test class for TaskService.
 *************************/

package Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import Appointment.Appointment;
import Appointment.AppointmentService;

class AppointmentServiceTest {

	/*
	 * The following tests exercise the AppointmentService class. In each test, a new
	 * service is created with default values for each field. Then the service is
	 * requested to make some change to the list of tasks and the result is
	 * tested to ensure the actual field matches what is expected.
	 *
	 * Because each appointment that gets created has a new automatically assigned
	 * appointmentID, and the tests are run based on that appointmentID, the order in which
	 * the tests are run depend on the value of each appointmentID. Therefore,
	 * the @Order annotation is used to keep the tests in a specific order.
	 *
	 * For evidence that the appointmentID is correct for each test, uncomment the
	 * service.displayAppointmentList(); prior to each assertion so that the records are
	 * displayed on the console for error checking.
	 */
	
	
	public Date Date(int i, int january, int j) {
		java.util.Date Date = null;
		return Date;
	}
	
	@Test
	@DisplayName("Test to Update appointment date")
	@Order(1)
	void testUpdateAppointmentDate() {
		AppointmentService service = new AppointmentService();
		service.addAppointment(Date(2022, Calendar.JANUARY, 1), "Description");
		service.updateAppointmentDate(Date(3022, Calendar.FEBRUARY, 2), "7");
		service.displayAppointmentList();
		assertEquals(Date(3022, Calendar.FEBRUARY, 2), service.getAppointment("7").getAppointmentDate(), "Appointment date was not updated.");
	}

	@Test
	@DisplayName("Test to Update appointment description.")
	@Order(2)
	void testUpdateAppointmentDesc() {
		AppointmentService service = new AppointmentService();
		service.addAppointment(Date(2022, Calendar.JANUARY, 1), "Description");
		service.updateAppointmentDesc("Updated Description", "9");
		service.displayAppointmentList();
		assertEquals("Updated Description", service.getAppointment("9").getAppointmentDesc(), "Appointment description was not updated.");
	}

	@Test
	@DisplayName("Test to ensure that service correctly deletes appointments.")
	@Order(3)
	void testDeleteAppointment() {
		AppointmentService service = new AppointmentService();
		service.addAppointment(Date(2022, Calendar.JANUARY, 1), "Description");
		service.deleteAppointment("11");
		// Ensure that the AppointmentList is now empty by creating a new empty AppointmentList to compare it with
		ArrayList<Appointment> appointmentListEmpty = new ArrayList<Appointment>();
		service.displayAppointmentList();
		assertEquals(service.appointmentList, appointmentListEmpty, "The appointment was not deleted.");
	}

	@Test
	@DisplayName("Test to ensure that service can add an appointment.")
	@Order(4)
	void testAddAppointment() {
		AppointmentService service = new AppointmentService();
		service.addAppointment(Date(2022, Calendar.JANUARY, 1), "Description");
		service.displayAppointmentList();
		assertNotNull(service.getAppointment("1"), "Appointment was not added correctly.");
	}
}
