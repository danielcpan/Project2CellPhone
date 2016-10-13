public class Contact {

	private static final String DEFAULT_NAME = "UNKNOWN";
	private static final String DEFAULT_NUMBER = "";
	private static final String DEFAULT_NOTES = "";
	public static final int DEFAULT_SPEEDDIAL = 10;

	String name;
	String number;
	String notes;
	private int speedDial;
	private FavoriteContactFrame contactframe;

	public Contact() {
		this.setAll(DEFAULT_NAME, DEFAULT_NUMBER, DEFAULT_NOTES);
		this.setSpeedDial(DEFAULT_SPEEDDIAL);
		this.setContactFrame();
	}

	public Contact(String name, String number, String notes, int speedDial) {
		this.setAll(name, number, notes);
		this.setSpeedDial(speedDial);
		this.setContactFrame();
	}

	public Contact(String name, String number, String notes, int speedDial, String directory, int fWidth, int fHeight) {
		this.setAll(name, number, notes);
		this.setSpeedDial(speedDial);
		this.contactframe = new FavoriteContactFrame(directory, fWidth, fHeight);
		this.contactframe.setNameInfo(name);
		this.contactframe.setNumberInfo(number);
		this.contactframe.setNotesInfo(notes);
	}

	public Contact(Contact other) {
		this.setAll(other.name, other.number, other.notes);
		this.setSpeedDial(other.speedDial);
		this.setContactFrame(other.contactframe);
	}

	public void setAll(String name, String number, String notes) {
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

	public void setSpeedDial(int speedDial) {
		this.speedDial = speedDial;
	}

	public int getSpeedDial() {
		return this.speedDial;
	}

	public void setContactFrame(FavoriteContactFrame contactframe) {
		this.contactframe = new FavoriteContactFrame(contactframe);
	}

	public void setContactFrame() {
		this.contactframe = new FavoriteContactFrame();
	}

	public FavoriteContactFrame getContactFrame() {
		return this.contactframe;
	}

}