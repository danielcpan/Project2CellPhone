/**
 * holds characteristics of a contact: name, number, notes can be used to create
 * a favorite: holds name, number, notes, speed dial number, and favorite
 * contact frame
 * 
 * @author Chad Chotikasatien, Daniel Pan, Daniel Ring, Victoria Hong, Minhkhoa
 *         Vu
 * @version 1.0
 * @since 2016-10-13
 */
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

	/**
	 * Default constructor for contact class, sets name, number, notes, and
	 * speed dial number to default Creates contact frame object
	 */
	public Contact() {
		this.setAll(DEFAULT_NAME, DEFAULT_NUMBER, DEFAULT_NOTES);
		this.setSpeedDial(DEFAULT_SPEEDDIAL);
		this.setContactFrame();
	}

<<<<<<< HEAD
	/**
	 * overloaded constructor for contact class
	 * 
	 * @param name
	 *            String for name of contact
	 * @param number
	 *            String for number of contact
	 * @param notes
	 *            String for notes of contact
	 */
	public Contact(String name, String number, String notes) {
		this.setAll(name, number, notes);
		this.setSpeedDial(DEFAULT_SPEEDDIAL);
		this.setContactFrame();
	}

	/**
	 * overloaded constructor for contact class
	 * 
	 * @param name
	 *            String for name of contact
	 * @param number
	 *            String for number of contact
	 * @param notes
	 *            String for notes of contact
	 * @param speedDial
	 *            Integer for speed dial number of favorite contact
	 * @param directory
	 *            String for location of picture of favorite contact
	 * @param fWidth
	 *            Integer for width of picture
	 * @param fHeight
	 *            Integer for height of picture
	 */
=======
	public Contact(String name, String number, String notes, int speedDial) {
		this.setAll(name, number, notes);
		this.setSpeedDial(speedDial);
		this.setContactFrame();
	}

>>>>>>> Daniel-Ring-Branch
	public Contact(String name, String number, String notes, int speedDial, String directory, int fWidth, int fHeight) {
		this.setAll(name, number, notes);
		this.setSpeedDial(speedDial);
		this.contactframe = new FavoriteContactFrame(directory, fWidth, fHeight);
		this.contactframe.setNameInfo(name);
		this.contactframe.setNumberInfo(number);
		this.contactframe.setNotesInfo(notes);
	}

<<<<<<< HEAD
	/**
	 * overloaded constructor for contact class
	 * 
	 * @param other
	 *            Takes in a contact object to values of new contact object
	 **/
=======
>>>>>>> Daniel-Ring-Branch
	public Contact(Contact other) {
		this.setAll(other.name, other.number, other.notes);
		this.setSpeedDial(other.speedDial);
		this.setContactFrame(other.contactframe);
	}

<<<<<<< HEAD
	/**
	 * Sets name, number, and notes all at once for contact
	 * 
	 * @param name
	 *            String for name of contact
	 * @param number
	 *            String for number of contact
	 * @param notes
	 *            String for notes of contact
	 */
=======
>>>>>>> Daniel-Ring-Branch
	public void setAll(String name, String number, String notes) {
		this.setName(name);
		this.setNumber(number);
		this.setNotes(notes);
	}

	/**
	 * Sets name for contact
	 * 
	 * @param name
	 *            String for setting name of contact
	 **/
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Returns name of contact
	 **/
	public String getName() {
		return this.name;
	}

<<<<<<< HEAD
	/**
	 * Sets number for contact
	 * 
	 * @param number
	 *            String for setting number of contact
	 *
	 **/
=======
>>>>>>> Daniel-Ring-Branch
	public void setNumber(String number) {
		this.number = number;
	}

	/**
	 * Returns number of contact
	 **/
	public String getNumber() {
		return this.number;
	}

	/**
	 * Sets notes for contact
	 * 
	 * @param notes
	 *            String for setting notes of contact
	 *
	 **/
	public void setNotes(String notes) {
		this.notes = notes;
	}

	/**
	 * Returns notes of contact
	 **/
	public String getNotes() {
		return this.notes;
	}

<<<<<<< HEAD
	/**
	 * Sets speed dial number for contact
	 * 
	 * @param speedDial
	 *            Integer for setting speed dial number of contact
	 *
	 **/
=======
>>>>>>> Daniel-Ring-Branch
	public void setSpeedDial(int speedDial) {
		this.speedDial = speedDial;
	}

<<<<<<< HEAD
	/**
	 * Returns speed dial number of contact
	 **/
=======
>>>>>>> Daniel-Ring-Branch
	public int getSpeedDial() {
		return this.speedDial;
	}

<<<<<<< HEAD
	/**
	 * Sets contact frame for favorite contact sends in a existing ContactFrame
	 * to create the new ContactFrame
	 * 
	 * @param contactframe
	 *            FavoriteContactFrame object for setting
	 *
	 **/
=======
>>>>>>> Daniel-Ring-Branch
	public void setContactFrame(FavoriteContactFrame contactframe) {
		this.contactframe = new FavoriteContactFrame(contactframe);
	}

<<<<<<< HEAD
	/**
	 * Sets contactframe of contact to a default contactframe
	 **/
=======
>>>>>>> Daniel-Ring-Branch
	public void setContactFrame() {
		this.contactframe = new FavoriteContactFrame();
	}

<<<<<<< HEAD
	/**
	 * Returns the ContactFrame of a contact
	 **/
=======
>>>>>>> Daniel-Ring-Branch
	public FavoriteContactFrame getContactFrame() {
		return this.contactframe;
	}

}