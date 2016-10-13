import java.util.ArrayList;

import java.util.ArrayList;

public class PhoneBook{
	private ArrayList<Contact> contacts;
	private ArrayList<Favorite> favorites;
	private ArrayList<Contact> unknowns;
	private Contact temporary;

	public PhoneBook() {
		contacts = new ArrayList<Contact>();
		favorites = new ArrayList<Favorite>();
		unknowns = new ArrayList<Contact>();
	}

	public void addContact(Contact userContact) {
		contacts.add(userContact);
	}
	public void removeContact(Contact userContact){
		contacts.remove(userContact);
	}
	
	public void addUnknown(Contact userUnknown){
		unknowns.add(userUnknown);
	}

	public void addFavorite(Favorite userFavorite) {
		favorites.add(userFavorite);
	}
	public void removeFavorite(Favorite userFavorite){
		favorites.remove(userFavorite);
	}
	public int getContactSize() {
		return contacts.size();
	}

	public  int getFavoriteSize() {
		return favorites.size();
	}
	
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
	

	public void compareFavorites() {
		for (int i = 0; i < favorites.size(); i++) {
			for (int j = 0; j < favorites.size(); j++) {
				if (favorites.get(i).getSpeedDial() < favorites.get(j).getSpeedDial()) {
					Favorite temporaryFavorite = new Favorite(favorites.get(j).getName(), favorites.get(j).getNumber(), favorites.get(j).getNotes(),
							favorites.get(j).getSpeedDial(), favorites.get(j).getDirectory(), favorites.get(j).getWidth(), favorites.get(j).getHeight());
					favorites.set(j, favorites.get(i));
					favorites.set(i, temporaryFavorite);
				}
			}
		}
	}
	
	
}