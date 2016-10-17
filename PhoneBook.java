import java.util.ArrayList;

<<<<<<< HEAD
<<<<<<< HEAD
import java.util.ArrayList;

=======
/**
 * Every PhoneBook object has instance variables ArrayList<Contact> contacts, ArrayList<Contact> favorites, CallHistory myCallHistory.
 * Simulates a phone where all the contacts, favorites, and call log data is saved.
 * @author Chad, Victoria, Daniel P, Daniel R, Minh
 */
>>>>>>> origin/master
public class PhoneBook{
	/*****INSTANCE VARIABLES*****/
	private ArrayList<Contact> contacts;
<<<<<<< HEAD
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
=======
	private ArrayList<Contact> favorites;
	private CallHistory myCallHistory;
>>>>>>> origin/master

//CONSTRUCTORS
	/**
	 * default constructor - instantiates instance variables
	 */
	public PhoneBook() {
		this.contacts = new ArrayList<Contact>();
		this.favorites = new ArrayList<Contact>();
		this.myCallHistory = new CallHistory();
	}

<<<<<<< HEAD
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
=======
//SETTERS
	/**
	 * adds parameter Contact object to instance variable ArrayList<Contact> contacts
	 * @param contact - Contact
	 */
	public void addContact(Contact contact) {
		this.contacts.add(contact);
	}
	
	/**
	 * removes parameter Contact object from instance variable ArrayList<Contact> contacts
	 * @param contact - Contact
	 */
	public void removeContact(Contact contact){
		this.contacts.remove(contact);
	}

	/**
	 * adds parameter Contact object to instance variable ArrayList<Contact> favorites
	 * @param favorite - Contact
	 */
	public void addFavorite(Contact favorite) {
		this.favorites.add(favorite);
>>>>>>> origin/master
	}
	
	/**
	 * removes parameter Contact object from instance variable ArrayList<Contact> favorites
	 * @param favorite - Contact
	 */
	public void removeFavorite(Contact favorite){
		this.favorites.remove(favorite);
	}
<<<<<<< HEAD
	
	/**
	 * calls copy constructor to set CallHistory instance variable to parameter's values
	 * @param callHistory
	 */
	public void setCallHistory(CallHistory callHistory)
	{
		this.myCallHistory = new CallHistory(callHistory);
	}
	
//GETTERS	
	/**
	 * @return ArrayList<Contact> contacts reference(SHALLOW COPY!!!)
	 */
	public  ArrayList<Contact> getContacts(){
		return this.contacts;
	}
	
	/**
	 * @return ArrayList<Contact> favorites reference (SHALLOW COPY!!!)
	 */
	public  ArrayList<Contact> getFavorites(){
		return this.favorites;
	}
	
	/**
	 * @return CallHistory reference (SHALLOW COPY!!!)
	 */
	public CallHistory getCallHistory()
	{
		return this.myCallHistory;
	}

//OTHER METHODS
	/**
	 * 
	 */
	public  void printContacts(){
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
	
	/**
	 * 
	 */
	public  void printFavorites(){
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
	
	/**
	 * 
	 */
	public  void compareContacts() {
<<<<<<< HEAD
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
=======
		Contact temporary = new Contact();
		
>>>>>>> origin/master
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
	
<<<<<<< HEAD
=======
>>>>>>> Daniel-Ring-Branch

=======
	/**
	 * 
	 */
>>>>>>> origin/master
	public void compareFavorites() {
		for (int i = 0; i < favorites.size(); i++) {
			for (int j = 0; j < favorites.size(); j++) {
<<<<<<< HEAD
				if (favorites.get(i).getSpeedDial() < favorites.get(j).getSpeedDial()) {
<<<<<<< HEAD
					Favorite temporaryFavorite = new Favorite(favorites.get(j).getName(), favorites.get(j).getNumber(), favorites.get(j).getNotes(),
							favorites.get(j).getSpeedDial(), favorites.get(j).getDirectory(), favorites.get(j).getWidth(), favorites.get(j).getHeight());
=======
				if (favorites.get(i).getSpeedDial() > favorites.get(j).getSpeedDial()) {
					temporaryFavorite = favorites.get(j);
>>>>>>> Daniel-Ring-Branch
=======
					Contact temporaryFavorite = new Contact(favorites.get(j).getName(), favorites.get(j).getNumber(), favorites.get(j).getNotes(),
							favorites.get(j).getSpeedDial());
>>>>>>> origin/master
					favorites.set(j, favorites.get(i));
					favorites.set(i, temporaryFavorite);
				}
			}
		}
	}
<<<<<<< HEAD
	
	/**
	 * 
	 * @param unformattedNumber - String
	 * @return String
	 */
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
	
	
=======

>>>>>>> Daniel-Ring-Branch
}