
import java.util.ArrayList;

/**
 * Every PhoneBook object has instance variables ArrayList<Contact> contacts, ArrayList<Contact> favorites, CallHistory myCallHistory.
 * Simulates a phone where all the contacts, favorites, and call log data is saved.
 * @author Chad, Victoria, Daniel P, Daniel R, Minh
 */
public class PhoneBook{
	/*****INSTANCE VARIABLES*****/
	private ArrayList<Contact> contacts;
	private ArrayList<Contact> favorites;
	private CallHistory myCallHistory;

//CONSTRUCTORS
	/**
	 * default constructor - instantiates instance variables
	 */
	public PhoneBook() {
		this.contacts = new ArrayList<Contact>();
		this.favorites = new ArrayList<Contact>();
		this.myCallHistory = new CallHistory();
	}

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
	}
	
	/**
	 * removes parameter Contact object from instance variable ArrayList<Contact> favorites
	 * @param favorite - Contact
	 */
	public void removeFavorite(Contact favorite){
		this.favorites.remove(favorite);
	}
	
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
	public  void compareContacts() {
		Contact temporary = new Contact();
		
		for (int i = 0; i < contacts.size(); i++) {
			for (int j = 0; j < contacts.size(); j++) {
				// greater than 0 means contact i comes after contact j
				// alphabetically
				if (contacts.get(i).getName().compareTo(contacts.get(j).getName()) > 0) {

				}
				// less than 0 means contact i comes before contact j
				// alphabetically
				if (contacts.get(i).getName().compareTo(contacts.get(j).getName()) < 0) {
					temporary = contacts.get(j);
					contacts.set(j, contacts.get(i));
					contacts.set(i, temporary);
				}
			}
		}
	}
	
	/**
	 * 
	 */
	public void compareFavorites() {
		for (int i = 0; i < favorites.size(); i++) {
			for (int j = 0; j < favorites.size(); j++) {
				if (favorites.get(i).getSpeedDial() < favorites.get(j).getSpeedDial()) {
					Contact temporaryFavorite = new Contact(favorites.get(j).getName(), favorites.get(j).getNumber(), favorites.get(j).getNotes(),
							favorites.get(j).getSpeedDial());
					favorites.set(j, favorites.get(i));
					favorites.set(i, temporaryFavorite);
				}
			}
		}
	}
	
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
	
	
}