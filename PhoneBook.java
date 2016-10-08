import java.util.ArrayList;

public class PhoneBook{
	private static ArrayList<Contact> contacts = new ArrayList<Contact>();
	private static ArrayList<Favorite> favorites = new ArrayList<Favorite>();
	private static Contact temporary;

	public PhoneBook() {

	}

	public static void addContact(Contact userContact) {
		contacts.add(userContact);
	}

	public static void addFavorite(Favorite userFavorite) {
		favorites.add(userFavorite);
	}
	public static int getContactSize() {
		return contacts.size();
	}

	public int getFavoriteSize() {
		return favorites.size();
	}
	
	public static ArrayList<Contact> getContactArrayList(){
		return contacts;
	}
	
	
	public static void contactsToString(){
		for (int i = 0; i < contacts.size(); i++){
			if (contacts.get(i).getNumber().length() == 10){
				System.out.printf("%-40s%-40s%-40s", "Name: " + contacts.get(i).getName(), "Number: (" + contacts.get(i).getNumber().substring(0,3) + ")" + 
						contacts.get(i).getNumber().substring(3,6) + "-" + contacts.get(i).getNumber().substring(6,10), 
						"Notes: " + contacts.get(i).getNotes());
				System.out.println();
			}
			if(contacts.get(i).getNumber().length() == 7){
				System.out.printf("%-40s%-40s%-40s", "Name: " + contacts.get(i).getName(), "Number: " + contacts.get(i).getNumber().substring(0,3) + "-" + 
						contacts.get(i).getNumber().substring(3,7), "Notes: " + contacts.get(i).getNotes());
				System.out.println();
			}
			
		}
	}
	public static void favoritesToString(){
		for (int i = 0; i < favorites.size(); i++){
			System.out.println(i + " Name: " + favorites.get(i).getName() + " Number: " + favorites.get(i).getNumber()
					+ " Notes: " + favorites.get(i).getNotes() + " #: " + favorites.get(i).getSpeedDial());
	}
	}
	
	public static void compareContacts() {
		for (int i = 0; i < contacts.size(); i++) {
			for (int j = i + 1; j < contacts.size() - i - 1; j++) {
				// greater than 0 means contact i comes after contact j
				// alphabetically
				if (contacts.get(i).getName().compareTo(contacts.get(j).getName()) > 0) {
					temporary = contacts.get(i);
					contacts.set(i, contacts.get(j));
					contacts.set(j, temporary);
				}
				// less than 0 means contact i comes before contact j
				// alphabetically
				if (contacts.get(i).getName().compareTo(contacts.get(j).getName()) < 0) {

				}
			}
		}
	}
	
}