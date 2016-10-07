import java.util.ArrayList;

public class Contact {

	private static final String DEFAULT_NAME = "";
	private static final String DEFAULT_NUMBER = "";
	private static final String DEFAULT_NOTES = "";
	private static final String DEFAULT_FAVORITE = "";

	String name;
	String cellNumber;
	String notes;
	String favorite;
	ArrayList<Contact> contacts = new ArrayList<Contact>();
	
	public Contact() {
		this.setName(DEFAULT_NAME);
		this.setNumber(DEFAULT_NUMBER);
		this.setNotes(DEFAULT_NOTES);
		this.setFavorite(DEFAULT_FAVORITE);
	}

	/**
	 * OVERLOADED CONSTRUCTORS
	 * 
	 * public Contacts(String name, String cellNumber, String notes){
	 * this.setName(name); this.setNumber(cellNumber); this.setNotes(notes); }
	 * 
	 * public Contacts(String name, String cellNumber, String notes, String
	 * favorite){ this.setName(name); this.setNumber(cellNumber);
	 * this.setNotes(notes); this.setFavorite(favorite); }
	 **/

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public void setNumber(String cellNumber) {
		this.cellNumber = cellNumber;
	}

	public String getNumber() {
		return this.cellNumber;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String getNotes() {
		return this.notes;
	}

	public void setFavorite(String favorite) {
		this.favorite = favorite;
	}

	public String getFavorite() {
		return favorite;
	}
}
