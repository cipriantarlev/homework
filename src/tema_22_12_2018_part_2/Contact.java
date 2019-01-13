package tema_22_12_2018_part_2;

import java.util.ArrayList;
import java.util.List;

public class Contact {
	
	public String order;
	public String phoneNumber;

	public String firstName;
	public String lastName;
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public Contact(String order, String phoneNumber, String firstName, String lastName) {
		this.order = order;
		this.phoneNumber = phoneNumber;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "Contact [order=" + order + ", phoneNumber=" + phoneNumber + ", firstName=" + firstName + ", lastName="
				+ lastName + "]";
	}
	
	List <String> messages = new ArrayList<>();
	
	public void setMessage (String messageContent) {
		messages.add(messageContent);
	}
	public void listMessages() {
		for (String intermediatMessage : messages) {
			System.out.println(intermediatMessage);
	}
	}
}