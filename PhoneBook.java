import java.util.ArrayList;

public class PhoneBook {
	private static ArrayList<Contact> contacts = new ArrayList<Contact>();
	private static ArrayList<Favorite> favorites = new ArrayList<Favorite>();

	public PhoneBook() {

	}

	public static void addContact(Contact userContact) {
		contacts.add(userContact);
	}

	public static void addFavorite(Contact userFavorite) {
		favorites.add(userFavorite);
	}

	public int getFavoriteSize() {
		return favorites.size();
	}
	
	public ArrayList<Contact> getContactArrayList(){
		return contacts;
	}
	
	public ArrayList
}