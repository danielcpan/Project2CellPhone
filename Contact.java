/**
<<<<<<< HEAD
 * holds characteristics of a contact: name, number, notes can be used to create
 * a favorite: holds name, number, notes, speed dial number, and favorite
 * contact frame
 * 
 * @author Chad Chotikasatien, Daniel Pan, Daniel Ring, Victoria Hong, Minhkhoa
 *         Vu
 * @version 1.0
 * @since 2016-10-13
=======
 * Every Contact object has a String name, String number, String notes, int speedDial, FavoriteContactFrame contactframe.
 * Simulates every contact added to your phone, a Contact object is created.
 * @author Chad, Victoria, Daniel P, Daniel R, Minh
 *
>>>>>>> origin/master
 */
public class Contact {
	
	/*****CONTANTS*****/
	private static final String DEFAULT_NAME = "UNKNOWN";
	private static final String DEFAULT_NUMBER = "";
	private static final String DEFAULT_NOTES = "";
	public static final int DEFAULT_SPEEDDIAL = 10;

	/*****INSTANCE VARIABLES*****/
	private String name;
	private String number;
	private String notes;
	private int speedDial;
	private FavoriteContactFrame contactframe;

<<<<<<< HEAD
	/**
	 * Default constructor for contact class, sets name, number, notes, and
	 * speed dial number to default Creates contact frame object
=======
//CONTRUCTORS
	/**
	 * default contructor - sets instance variables to default values
	 * returns reference of Contact object created
>>>>>>> origin/master
	 */
	public Contact() {
		this.setAll(DEFAULT_NAME, DEFAULT_NUMBER, DEFAULT_NOTES);
		this.setSpeedDial(DEFAULT_SPEEDDIAL);
		this.setContactFrame();
	}

<<<<<<< HEAD
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
=======
	/**
	 * loaded constructor - default contactFrame
	 * @param name - String
	 * @param number - String
	 * @param notes - String
	 * @param speedDial - int 
	 * returns reference of Contact object created
	 */
>>>>>>> origin/master
	public Contact(String name, String number, String notes, int speedDial) {
		this.setAll(name, number, notes);
		this.setSpeedDial(speedDial);
		this.setContactFrame();
	}
	
	/**
	 * loaded constructor - default speedDial and contactFrame
	 * @param name - String
	 * @param number - String
	 * @param notes - String
	 * returns reference of Contact object created
	 */
	public Contact(String name, String number, String notes){
		this.setAll(name, number, notes);
		this.setSpeedDial(DEFAULT_SPEEDDIAL);
		this.setContactFrame();
	}

<<<<<<< HEAD
>>>>>>> Daniel-Ring-Branch
=======
	/**
	 * fully loaded constructor - no defaults
	 * @param name - String
	 * @param number - String
	 * @param notes - String
	 * @param speedDial - int (MUST BE 1-5)
	 * @param directory - String (to initialize contactFrame object)
	 * @param fWidth - int (to initialize contactFrame object)
	 * @param fHeight - int (to initialize contactFrame object)
	 * return reference of Contact object created
	 */
>>>>>>> origin/master
	public Contact(String name, String number, String notes, int speedDial, String directory, int fWidth, int fHeight) {
		this.setAll(name, number, notes);
		this.setSpeedDial(speedDial);
		this.contactframe = new FavoriteContactFrame(directory, fWidth, fHeight);
		this.contactframe.setNameInfo(name);
		this.contactframe.setNumberInfo(number);
		this.contactframe.setNotesInfo(notes);
	}

<<<<<<< HEAD
<<<<<<< HEAD
	/**
	 * overloaded constructor for contact class
	 * 
	 * @param other
	 *            Takes in a contact object to values of new contact object
	 **/
=======
>>>>>>> Daniel-Ring-Branch
=======
	/**
	 * copy constructor - initializes instance variables to the same instance variable values as the parameter Contact object
	 * @param other - Contact
	 * returns reference of Contact object created
	 */
>>>>>>> origin/master
	public Contact(Contact other) {
		this.setAll(other.name, other.number, other.notes);
		this.setSpeedDial(other.speedDial);
		this.setContactFrame(other.contactframe);
	}

<<<<<<< HEAD
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
=======
//SETTERS
	/**
	 * sets non-favorite array Contact variables
	 * @param name - String
	 * @param number - String
	 * @param notes - String
	 */
>>>>>>> origin/master
	public void setAll(String name, String number, String notes) {
		this.setName(name);
		this.setNumber(number);
		this.setNotes(notes);
	}
<<<<<<< HEAD

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
=======
	
	/**
	 * checks equality of Contact objects' name, number, notes, speedDial
	 * @param other - Contact
	 * @return boolean : true if equal, false if not equal
	 */
	public boolean equals(Contact other)
	{
		if (this.name.equals(other.name))
		{
			if (this.number.equals(other.number))
			{
				if (this.notes.equals(other.notes))
				{
					if (this.speedDial == other.speedDial)
					{
						return true;
					}
				}
			}
		}
		return false;
	}

	/**
	 * sets this.name
	 * @param name - String
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * sets this.number
	 * @param number - String
	 */
	public void setNumber(String number) {
		this.number = number;
	}
	
	/**
	 * sets this.notes
	 * @param notes - String
	 */
>>>>>>> origin/master
	public void setNotes(String notes) {
		this.notes = notes;
	}

	/**
<<<<<<< HEAD
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
=======
	 * sets this.speedDial
	 * @param speedDial - int
	 */
	public void setSpeedDial(int speedDial) {
		this.speedDial = speedDial;
	}
	
	/**
	 * overloaded setContactFrame - calls copy constructor for FavoriteContactFrame object
	 * sets contactframe instance variable to parameter's FavoriteContactFrame values
	 * @param contactframe
	 */
>>>>>>> origin/master
	public void setContactFrame(FavoriteContactFrame contactframe) {
		this.contactframe = new FavoriteContactFrame(contactframe);
	}

<<<<<<< HEAD
<<<<<<< HEAD
	/**
	 * Sets contactframe of contact to a default contactframe
	 **/
=======
>>>>>>> Daniel-Ring-Branch
=======
	/**
	 * default setContactFrame() - sets contactframe instance variable to default FavoriteContactFrame object
	 */
>>>>>>> origin/master
	public void setContactFrame() {
		this.contactframe = new FavoriteContactFrame();
	}
	
//GETTERS
	/**
	 * @return String name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * @return String number
	 */
	public String getNumber() {
		return this.number;
	}

	/**
	 * @return String notes
	 */
	public String getNotes() {
		return this.notes;
	}

<<<<<<< HEAD
<<<<<<< HEAD
	/**
	 * Returns the ContactFrame of a contact
	 **/
=======
>>>>>>> Daniel-Ring-Branch
=======
	/**
	 * @return int speedDial
	 */
	public int getSpeedDial() {
		return this.speedDial;
	}
	
	/**
	 * @return FavoriteContactFrame object reference (SHALLOW COPY!!!)
	 */
>>>>>>> origin/master
	public FavoriteContactFrame getContactFrame() {
		return this.contactframe;
	}
	
	/**
	 * @return String - name, number, notes, speedDial concatenated
	 */
	public String toString()
	{
		return "name = " + this.name + ", number = " + this.number + ", notes = " + this.notes + ", speeddial = " + this.speedDial;
	}

}