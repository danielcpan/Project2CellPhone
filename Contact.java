public class Contact {

	private static final String DEFAULT_NAME = "UNKNOWN";
	private static final String DEFAULT_NUMBER = "";
	private static final String DEFAULT_NOTES = "";
	private static final String DEFAULT_FAVORITE = "";

	String name;
	String cellNumber;
	String notes;

	public Contact() {
		this.setName(DEFAULT_NAME);
		this.setNumber(DEFAULT_NUMBER);
		this.setNotes(DEFAULT_NOTES);
	}

	public Contact(String name, String cellNumber, String notes) {
		this.setName(name);
		this.setNumber(cellNumber);
		this.setNotes(notes);
	}

	public Contact(String name, String cellNumber, String notes, String favorite) {
		this.setName(name);
		this.setNumber(cellNumber);
		this.setNotes(notes);
	}

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

}
