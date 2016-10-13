public class Contact {

	private static final String DEFAULT_NAME = "UNKNOWN";
	private static final String DEFAULT_NUMBER = "";
	private static final String DEFAULT_NOTES = "";

	String name;
	String number;
	String notes;

	public Contact() {
		this.setAll(DEFAULT_NAME, DEFAULT_NUMBER, DEFAULT_NOTES);
	}

	public Contact(String name, String number, String notes) {
		this.setAll(name, number, notes);
	}
	
	public Contact(Contact other)
	{
		this.setAll(other.name, other.number, other.notes);
	}

	public void setAll(String name, String number, String notes)
	{
		this.setName(name);
		this.setNumber(number);
		this.setNotes(notes);
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getNumber() {
		return this.number;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String getNotes() {
		return this.notes;
	}

}