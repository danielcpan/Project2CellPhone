import java.util.ArrayList;

<<<<<<< HEAD
import java.util.ArrayList;

public class PhoneBook{
	private ArrayList<Contact> contacts;
	private ArrayList<Favorite> favorites;
	private ArrayList<Contact> unknowns;
	private Contact temporary;
=======
public class PhoneBook {
	private ArrayList<Contact> contacts = new ArrayList<Contact>();
	private ArrayList<Favorite> favorites = new ArrayList<Favorite>();
	private ArrayList<Contact> unknowns = new ArrayList<Contact>();
	private Contact temporaryContact;
	private Favorite temporaryFavorite;
>>>>>>> Daniel-Ring-Branch

	public PhoneBook() {
		contacts = new ArrayList<Contact>();
		favorites = new ArrayList<Favorite>();
		unknowns = new ArrayList<Contact>();
	}

	public void addContact(Contact userContact) {
		contacts.add(userContact);
	}
<<<<<<< HEAD
	public void removeContact(Contact userContact){
		contacts.remove(userContact);
	}
	
	public void addUnknown(Contact userUnknown){
=======

	public void addUnknown(Contact userUnknown) {
>>>>>>> Daniel-Ring-Branch
		unknowns.add(userUnknown);
	}

	public void addFavorite(Favorite userFavorite) {
		favorites.add(userFavorite);
	}
<<<<<<< HEAD
	public void removeFavorite(Favorite userFavorite){
		favorites.remove(userFavorite);
	}
=======

>>>>>>> Daniel-Ring-Branch
	public int getContactSize() {
		return contacts.size();
	}

	public  int getFavoriteSize() {
		return favorites.size();
	}
<<<<<<< HEAD
	
	public  ArrayList<Contact> getContactArrayList(){
		return contacts;
	}
	public  ArrayList<Favorite> getFavoriteArrayList(){
		return favorites;
	}
	
	public String formatNumber(String unformattedNumber){
		String newNumber = "";
		if (unformattedNumber.length() == 7){
			 newNumber = unformattedNumber.substring(0,3) + "-" + unformattedNumber.substring(3,7);
		}
		if (unformattedNumber.length() == 10){
			newNumber = "(" + unformattedNumber.substring(0,3) + ")" + unformattedNumber.substring(3,6) + "-" + unformattedNumber.substring(6,10);
		}
		return newNumber;
	}
		
	
	public  void contactsToString(){
		for (int i = 0; i < contacts.size(); i++){
			if (contacts.get(i).getNumber().length() == 13){
				System.out.printf("%-40s%-40s%-40s", "Name: " + contacts.get(i).getName(), "Number:" + contacts.get(i).getNumber(), "Notes: " + contacts.get(i).getNotes());
				System.out.println();
			}
			if(contacts.get(i).getNumber().length() == 8){
				System.out.printf("%-40s%-40s%-40s", "Name: " + contacts.get(i).getName(), "Number: " + contacts.get(i).getNumber(), "Notes: " + contacts.get(i).getNotes());
				System.out.println();
			}
		}
		if(contacts.size() == 0 && favorites.size() == 0){
			System.out.println("No contacts available.");
		}
	}
	public  void favoritesToString(){
		for (int i = 0; i < favorites.size(); i++){
			if (favorites.get(i).getNumber().length() == 13){
				System.out.printf("%-40s%-40s%-40s", "Name: " + favorites.get(i).getName() + " #" + favorites.get(i).getSpeedDial(), "Number:" + favorites.get(i).getNumber(), "Notes: " + favorites.get(i).getNotes());
				System.out.println();
			}
			if(favorites.get(i).getNumber().length() == 8){
				System.out.printf("%-40s%-40s%-40s", "Name: " + favorites.get(i).getName() + " #" + favorites.get(i).getSpeedDial(), "Number: " + favorites.get(i).getNumber(), "Notes: " + favorites.get(i).getNotes());
				System.out.println();
			}
	}
	}
	
	public  void unknownToString(){
		for(int i = 0; i < unknowns.size(); i++){
			System.out.println(i + " Name: " + unknowns.get(i).getName() + " Number: " + unknowns.get(i).getNumber() + " Notes: " + 
					unknowns.get(i).getNotes());
		}
	}
	public  void compareContacts() {
=======

	public ArrayList<Contact> getContactArrayList() {
		return contacts;
	}

	public ArrayList<Favorite> getFavoriteArrayList() {
		return favorites;
	}

	public void contactsToString() {
		for (int i = 0; i < contacts.size(); i++) {
			if (contacts.get(i).getNumber().length() == 10) {
				System.out.printf("%-40s%-40s%-40s", "Name: " + contacts.get(i).getName(),
						"Number:(" + contacts.get(i).getNumber().substring(0, 3) + ")"
								+ contacts.get(i).getNumber().substring(3, 6) + "-"
								+ contacts.get(i).getNumber().substring(6, 10),
						"Notes: " + contacts.get(i).getNotes());
				System.out.println();
			}
			if (contacts.get(i).getNumber().length() == 7) {
				System.out.printf("%-40s%-40s%-40s",
						"Name: " + contacts.get(i).getName(), "Number: " + contacts.get(i).getNumber().substring(0, 3)
								+ "-" + contacts.get(i).getNumber().substring(3, 7),
						"Notes: " + contacts.get(i).getNotes());
				System.out.println();
			}

		}
	}

	public void favoritesToString() {
		for (int i = 0; i < favorites.size(); i++) {
			System.out.println(i + " Name: " + favorites.get(i).getName() + " Number: " + favorites.get(i).getNumber()
					+ " Notes: " + favorites.get(i).getNotes() + " #: " + favorites.get(i).getSpeedDial());
		}
	}

	public void unknownToString() {
		for (int i = 0; i < unknowns.size(); i++) {
			System.out.println(i + " Name: " + unknowns.get(i).getName() + " Number: " + unknowns.get(i).getNumber()
					+ " Notes: " + unknowns.get(i).getNotes());
		}
	}

	public void compareContacts() {
>>>>>>> Daniel-Ring-Branch
		for (int i = 0; i < contacts.size(); i++) {
			for (int j = 0; j < contacts.size(); j++) {
				// greater than 0 means contact i comes after contact j
				// alphabetically
				if (contacts.get(i).getName().compareTo(contacts.get(j).getName()) > 0) {

				}
				// less than 0 means contact i comes before contact j
				// alphabetically
				if (contacts.get(i).getName().compareTo(contacts.get(j).getName()) < 0) {
					temporaryContact = contacts.get(j);
					contacts.set(j, contacts.get(i));
					contacts.set(i, temporaryContact);
				}
			}
		}
	}
<<<<<<< HEAD
	
=======
>>>>>>> Daniel-Ring-Branch

	public void compareFavorites() {
		for (int i = 0; i < favorites.size(); i++) {
			for (int j = 0; j < favorites.size(); j++) {
<<<<<<< HEAD
				if (favorites.get(i).getSpeedDial() < favorites.get(j).getSpeedDial()) {
					Favorite temporaryFavorite = new Favorite(favorites.get(j).getName(), favorites.get(j).getNumber(), favorites.get(j).getNotes(),
							favorites.get(j).getSpeedDial(), favorites.get(j).getDirectory(), favorites.get(j).getWidth(), favorites.get(j).getHeight());
=======
				if (favorites.get(i).getSpeedDial() > favorites.get(j).getSpeedDial()) {
					temporaryFavorite = favorites.get(j);
>>>>>>> Daniel-Ring-Branch
					favorites.set(j, favorites.get(i));
					favorites.set(i, temporaryFavorite);
				}
			}
		}
	}
<<<<<<< HEAD
	
	
=======

>>>>>>> Daniel-Ring-Branch
}