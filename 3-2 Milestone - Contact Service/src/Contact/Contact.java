/*************************
 * Name: 	Brandon Ricks 
 * Course: 	CS-320 
 * Date: 	May 23, 2021
 * Description: This is the contact class. It creates and stores contact information.
 *************************/

package Contact;

import java.util.concurrent.atomic.AtomicLong;

public class Contact {
	private final String contactID;
	private String firstName;
	private String lastName;
	private String number;
	private String address;
	private static AtomicLong idGenerator = new AtomicLong();

	// CONSTRUCTOR
	/*
	 * The constructor takes first name, last name, phone number, and address as
	 * parameters. The first thing it does is generates a new ID for the contactID
	 * field.
	 *
	 * First name and last name are checked for null condition or blank fields. If
	 * either of those conditions exist, fill in the field with the phrase "NULL" so
	 * that something exists to protect data integrity while making it clear it is a
	 * placeholder. In both cases, if the first or last name is greater than 10
	 * characters, truncate it so that only the first 10 characters are used.
	 *
	 * For the number field, if the phone number is not exactly 10 characters then
	 * fill it with the placeholder '5555555555'.
	 *
	 * Address is like first and last names. If it is blank or null, set it to
	 * "NULL". If it is more than 30 characters, truncate to the first 30
	 * characters.
	 */
	public Contact(String firstName, String lastName, String number, String address) {

		// CONTACTID
		// Contact ID is generated when the constructor is called. It is set as a final variable and has
		// no other getter or setter so there should be no way to change it.
		// The idGenerator is static to prevent duplicates across all contacts.
		this.contactID = String.valueOf(idGenerator.getAndIncrement());

		// FIRSTNAME
		if (firstName == null || firstName.isEmpty()) {
			this.firstName = "NULL";
		// If first name is longer than 10 characters, just grab the first 10 characters
		} else if (firstName.length() > 10) {
			this.firstName = firstName.substring(0, 10);
		} else {
			this.firstName = firstName;
		}

		// LASTNAME
		if (lastName == null || lastName.isEmpty()) {
			this.lastName = "NULL";
		} else if (lastName.length() > 10) {
			this.lastName = lastName.substring(0, 10);
		} else {
			this.lastName = lastName;
		}
		
		// NUMBER
		if (number == null || number.isEmpty() || number.length() != 10) {
			this.number = "5555555555";
		} else {
			this.number = number;
		}
		
		// ADDRESS
		if (address == null || address.isEmpty()) {
			this.address = "NULL";
		} else if (address.length() > 30) {
			this.address = address.substring(0, 30);
		} else {
			this.address = address;
		}
	}

	// GETTERS
	public String getContactID() {
		return contactID;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getNumber() {
		return number;
	}

	public String getAddress() {
		return address;
	}

	// SETTERS
	/*
	 * The setters follow the same rules as the constructor.
	 */
	public void setFirstName(String firstName) {
		if (firstName == null || firstName.isEmpty()) {
			this.firstName = "NULL";

		// If first name is longer than 10 characters, just grab the first 10 characters
		} else if (firstName.length() > 10) {
			this.firstName = firstName.substring(0, 10);
		} else {
			this.firstName = firstName;
		}
	}

	public void setLastName(String lastName) {
		if (lastName == null || lastName.isEmpty()) {
			this.lastName = "NULL";
		} else if (lastName.length() > 10) {
			this.lastName = lastName.substring(0, 10);
		} else {
			this.lastName = lastName;
		}
	}

	public void setNumber(String number) {
		if (number == null || number.isEmpty() || number.length() != 10) {
			this.number = "5555555555";
		} else {
			this.number = number;
		}
	}

	public void setAddress(String address) {
		if (address == null || address.isEmpty()) {
			this.address = "NULL";
		} else if (address.length() > 30) {
			this.address = address.substring(0, 30);
		} else {
			this.address = address;
		}
	}
}