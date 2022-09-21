/*************************
 * Name: 	Brandon Ricks 
 * Course: 	CS-320 
 * Date: 	May 23, 2021
 * Description: This is the contact service. It maintains a list of contacts and has capabilities
 * for adding and deleting contacts, as well as updating first name, last name, phone number, and address.
 *************************/

package Contact;

import java.util.ArrayList;

public class ContactService {
	// Start with an ArrayList of contacts to hold the list of contacts
	public ArrayList<Contact> contactList = new ArrayList<Contact>();

	// Display the full list of contacts to the console for error checking.
	public void displayContactList() {
		for (int counter = 0; counter < contactList.size(); counter++) {
			System.out.println("\t Contact ID: " + contactList.get(counter).getContactID());
			System.out.println("\t First Name: " + contactList.get(counter).getFirstName());
			System.out.println("\t Last Name: " + contactList.get(counter).getLastName());
			System.out.println("\t Phone Number: " + contactList.get(counter).getNumber());
			System.out.println("\t Address: " + contactList.get(counter).getAddress() + "\n");
		}
	}

	// Adds a new contact using the Contact constructor, then assign the new contact to the list.
	public void addContact(String firstName, String lastName, String number, String address) {
		// Create the new contact
		Contact contact = new Contact(firstName, lastName, number, address);
		contactList.add(contact);

	}

	// Using Contact ID, return a contact object
	// If a matching Contact ID is not found, return a contact object with default values
	public Contact getContact(String contactID) {
		Contact contact = new Contact(null, null, null, null);
		for (int counter = 0; counter < contactList.size(); counter++) {
			if (contactList.get(counter).getContactID().contentEquals(contactID)) {
				contact = contactList.get(counter);
			}
		}
		return contact;
	}

	// Delete contact.
	// Use the contactID to find the right contact to delete from the list
	// If we get to the end of the list without finding a match for contactID report that to the console.
	// This method of searching for contactID is the same for all update methods below.
	public void deleteContact(String contactID) {
		for (int counter = 0; counter < contactList.size(); counter++) {
			if (contactList.get(counter).getContactID().equals(contactID)) {
				contactList.remove(counter);
				break;
			}
			if (counter == contactList.size() - 1) {
				System.out.println("Contact ID: " + contactID + " not found.");
			}
		}
	}

	// Update the first name.
	public void updateFirstName(String updatedString, String contactID) {
		for (int counter = 0; counter < contactList.size(); counter++) {
			if (contactList.get(counter).getContactID().equals(contactID)) {
				contactList.get(counter).setFirstName(updatedString);
				break;
			}
			if (counter == contactList.size() - 1) {
				System.out.println("Contact ID: " + contactID + " not found.");
			}
		}
	}

	// Update the last name.
	public void updateLastName(String updatedString, String contactID) {
		for (int counter = 0; counter < contactList.size(); counter++) {
			if (contactList.get(counter).getContactID().equals(contactID)) {
				contactList.get(counter).setLastName(updatedString);
				break;
			}
			if (counter == contactList.size() - 1) {
				System.out.println("Contact ID: " + contactID + " not found.");
			}
		}
	}

	// Update the phone number.
	public void updateNumber(String updatedString, String contactID) {
		for (int counter = 0; counter < contactList.size(); counter++) {
			if (contactList.get(counter).getContactID().equals(contactID)) {
				contactList.get(counter).setNumber(updatedString);
				break;
			}
			if (counter == contactList.size() - 1) {
				System.out.println("Contact ID: " + contactID + " not found.");
			}
		}
	}

	// Update the address.
	public void updateAddress(String updatedString, String contactID) {
		for (int counter = 0; counter < contactList.size(); counter++) {
			if (contactList.get(counter).getContactID().equals(contactID)) {
				contactList.get(counter).setAddress(updatedString);
				break;
			}
			if (counter == contactList.size() - 1) {
				System.out.println("Contact ID: " + contactID + " not found.");
			}
		}
	}
}