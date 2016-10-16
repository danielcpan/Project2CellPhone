import java.util.ArrayList;

public class PhoneBook{
	private ArrayList<Favorite> contacts;
	private ArrayList<Favorite> favorites;
<<<<<<< HEAD
	private CallHistory myCallHistory;

=======
	private ArrayList<Contact> unknowns;
	private Contact temporary;
	/**
	 * default constructor
	 */
>>>>>>> origin/master
	public PhoneBook() {
		this.contacts = new ArrayList<Favorite>();
		this.favorites = new ArrayList<Favorite>();
		this.myCallHistory = new CallHistory();
	}
<<<<<<< HEAD

	public void addContact(Favorite contact) {
		this.contacts.add(contact);
	}
	public void removeContact(Favorite contact){
		this.contacts.remove(contact);
	}

	public void addFavorite(Favorite favorite) {
		this.favorites.add(favorite);
	}
	public void removeFavorite(Favorite favorite){
		this.favorites.remove(favorite);
	}
	
	public  ArrayList<Favorite> getContacts(){
		return this.contacts;
	}
	
	public  ArrayList<Favorite> getFavorites(){
		return this.favorites;
	}
	
	public  void printContacts(){
=======
	/**
	 * adds contact to contacts list
	 * @param userContact - known contact that is not a favorite 
	 */
	public void addContact(Contact userContact) {
		contacts.add(userContact);
	}
	/**
	 * removes a contact from contacts list
	 * @param userContact - known contact that is not a favorite 
	 */
	public void removeContact(Contact userContact){
		contacts.remove(userContact);
	}
	/**
	 * adds an unknwon contact when user decides to receive a call
	 * @param userUnknown - unknown contact with no name
	 */
	public void addUnknown(Contact userUnknown){
		unknowns.add(userUnknown);
	}
	/**
	 * adds a favorite contact to favorites list
	 * @param userFavorite - favorite contact of user
	 */
	public void addFavorite(Favorite userFavorite) {
		favorites.add(userFavorite);
	}
	/**
	 * removes favorite contact from favorites list
	 * @param userFavorite - favorite contact of user
	 */
	public void removeFavorite(Favorite userFavorite){
		favorites.remove(userFavorite);
	}
	/**
	 * gets the size of the contacts list
	 * @return contacts.size - size of contacts array list
	 */
	public int getContactSize() {
		return contacts.size();
	}
	/**
	 * gets the size of the favorites list
	 * @return favorites.size - size of contacts array list
	 */
	public  int getFavoriteSize() {
		return favorites.size();
	}
	/**
	 * gets the array list of known, non-favored contacts
	 * @return contacts - array list of contacts 
	 */
	public  ArrayList<Contact> getContactArrayList(){
		return contacts;
	}
	/**
	 * gets the array list of known, favored contacts
	 * @return favorites - array list of favorites 
	 */
	public  ArrayList<Favorite> getFavoriteArrayList(){
		return favorites;
	}
	/**
	 * formats 7 or 10 digit phone number
	 * @param unformattedNumber - randomly generated 7 or 10-digit phone number
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
	/**
	 * displays contacts in a specific format
	 */
	public  void contactsToString(){
>>>>>>> origin/master
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
<<<<<<< HEAD
	public  void printFavorites(){
=======
	/**
	 * displays favorite contacts in a specific format
	 */
	public  void favoritesToString(){
>>>>>>> origin/master
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
<<<<<<< HEAD
	
=======
	/**
	 * displays unknown contacts
	 */
	public  void unknownToString(){
		for(int i = 0; i < unknowns.size(); i++){
			System.out.println(i + " Name: " + unknowns.get(i).getName() + " Number: " + unknowns.get(i).getNumber() + " Notes: " + 
					unknowns.get(i).getNotes());
		}
	}
	/**
	 * sort contacts list alphabetically
	 */
>>>>>>> origin/master
	public  void compareContacts() {
		Favorite temporary = new Favorite();
		
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
	 * sort favorites list alphabetically
	 */
	public void compareFavorites() {
		for (int i = 0; i < favorites.size(); i++) {
			for (int j = 0; j < favorites.size(); j++) {
				if (favorites.get(i).getSpeedDial() < favorites.get(j).getSpeedDial()) {
<<<<<<< HEAD
					Favorite temporaryFavorite = new Favorite(favorites.get(j).getName(), favorites.get(j).getNumber(), favorites.get(j).getNotes(),
							favorites.get(j).getSpeedDial());
=======
					Favorite temporaryFavorite = new Favorite(favorites.get(j).getName(), favorites.get(j).getNumber(), favorites.get(j).getEmail(),
							favorites.get(j).getSpeedDial(), favorites.get(j).getDirectory(), favorites.get(j).getWidth(), favorites.get(j).getHeight());
>>>>>>> origin/master
					favorites.set(j, favorites.get(i));
					favorites.set(i, temporaryFavorite);
				}
			}
		}
	}
	
	public void setCallHistory(CallHistory callHistory)
	{
		this.myCallHistory = new CallHistory(callHistory);
	}
	
	public CallHistory getCallHistory()
	{
		return this.myCallHistory;
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
	
	
}