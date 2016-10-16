import java.util.ArrayList;

import java.util.ArrayList;

public class PhoneBook{
	private ArrayList<Contact> contacts;
	private ArrayList<Favorite> favorites;
	private ArrayList<Contact> unknowns;
	private Contact temporary;
	/**
	 * default constructor
	 */
	public PhoneBook() {
		contacts = new ArrayList<Contact>();
		favorites = new ArrayList<Favorite>();
		unknowns = new ArrayList<Contact>();
	}
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
	 * displays favorite contacts in a specific format
	 */
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
	public  void compareContacts() {
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
					Favorite temporaryFavorite = new Favorite(favorites.get(j).getName(), favorites.get(j).getNumber(), favorites.get(j).getEmail(),
							favorites.get(j).getSpeedDial(), favorites.get(j).getDirectory(), favorites.get(j).getWidth(), favorites.get(j).getHeight());
					favorites.set(j, favorites.get(i));
					favorites.set(i, temporaryFavorite);
				}
			}
		}
	}
	
	
}