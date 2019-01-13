package tema_22_12_2018_part_2;

public class Main {

	public static void main(String[] args) {

		Phone phone = new SamsungGalaxyA5();



	       phone.addContact("1", "0748776230", "Ciprian", "Tarlev");

	       phone.addContact("2", "0753822568", "Cristina", "Tarlev");

	       phone.listContacts();



	       // send a message to the first contact from the previous listed

	        // max number of characters - 100

	       phone.sendMessage("0748776230", "Ana are mere");

	       phone.listMessages("0748776230");



	        // send a message to the second contact from the previous listed

	       phone.call("0753822568");

	       phone.viewHistory();
	}

}
