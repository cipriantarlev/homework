package tema_22_12_2018_part_2;

import java.util.ArrayList;
import java.util.List;

public abstract class Phone {

	protected int batteryLife;
	protected String color;
	protected String material;
	protected String imei;
	
	
	protected List<Contact> contactList = new ArrayList<>();
	
	public void addContact (String order, String phoneNumber, String firstName, String lastName) {
		Contact contact = new Contact(order, phoneNumber, firstName, lastName);
		contactList.add(contact);
	}
	
	public void listContacts() {
		for (Contact intermediatContact : contactList) {
			System.out.println(intermediatContact.toString());
		}
	}
	
		public void sendMessage (String phoneNumber, String messageContent) {
			if (messageContent.length() > 500) {
				System.out.println("You've reached the maximum numbers of characters");
			}else {
			for (Contact intermediatContact : contactList) {
				if (intermediatContact.getPhoneNumber() == phoneNumber) {
					intermediatContact.setMessage(messageContent);
					}
				}
				batteryLife -= 1;
			}
			
		}
		
		
		public void listMessages (String phoneNumber) {
			for (Contact intermediatContact : contactList) {
				if (intermediatContact.getPhoneNumber() == phoneNumber) {
					intermediatContact.listMessages();
				}
			}
		}
		
		List <String> calls = new ArrayList<>();
		
		public void call(String phoneNumber) {
			calls.add(phoneNumber);	
			batteryLife -= 2;
		}
		
		public void viewHistory() {
			System.out.println("Phone history:");
			for (String intermediatCall : calls)
			System.out.println(intermediatCall);
		}
}
