import java.util.ArrayList;

public class PhoneBook{
	private ArrayList<Favorite> contacts;
	private ArrayList<Favorite> favorites;
	private CallHistory myCallHistory;

	public PhoneBook() {
		this.contacts = new ArrayList<Favorite>();
		this.favorites = new ArrayList<Favorite>();
		this.myCallHistory = new CallHistory();
	}

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
	

	public void compareFavorites() {
		for (int i = 0; i < favorites.size(); i++) {
			for (int j = 0; j < favorites.size(); j++) {
				if (favorites.get(i).getSpeedDial() < favorites.get(j).getSpeedDial()) {
					Favorite temporaryFavorite = new Favorite(favorites.get(j).getName(), favorites.get(j).getNumber(), favorites.get(j).getNotes(),
							favorites.get(j).getSpeedDial());
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