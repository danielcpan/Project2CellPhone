/**
 * Every Contact object has a String name, String number, String notes, int speedDial, FavoriteContactFrame contactframe.
 * @author Chad, Victoria, Daniel P, Daniel R, Minh
 *
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

//CONTRUCTORS
	/**
	 * default contructor - sets instance variables to default values
	 * returns reference of Contact object created
	 */
	public Contact() {
		this.setAll(DEFAULT_NAME, DEFAULT_NUMBER, DEFAULT_NOTES);
		this.setSpeedDial(DEFAULT_SPEEDDIAL);
		this.setContactFrame();
	}

	/**
	 * loaded constructor - default contactFrame
	 * @param name - String
	 * @param number - String
	 * @param notes - String
	 * @param speedDial - int 
	 * returns reference of Contact object created
	 */
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
	public Contact(String name, String number, String notes, int speedDial, String directory, int fWidth, int fHeight) {
		this.setAll(name, number, notes);
		this.setSpeedDial(speedDial);
		this.contactframe = new FavoriteContactFrame(directory, fWidth, fHeight);
		this.contactframe.setNameInfo(name);
		this.contactframe.setNumberInfo(number);
		this.contactframe.setNotesInfo(notes);
	}

	/**
	 * copy constructor - initializes instance variables to the same instance variable values as the parameter Contact object
	 * @param other - Contact
	 * returns reference of Contact object created
	 */
	public Contact(Contact other) {
		this.setAll(other.name, other.number, other.notes);
		this.setSpeedDial(other.speedDial);
		this.setContactFrame(other.contactframe);
	}

//SETTERS
	/**
	 * sets non-favorite array Contact variables
	 * @param name - String
	 * @param number - String
	 * @param notes - String
	 */
	public void setAll(String name, String number, String notes) {
		this.setName(name);
		this.setNumber(number);
		this.setNotes(notes);
	}
	
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
	public void setNotes(String notes) {
		this.notes = notes;
	}

	/**
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
	public void setContactFrame(FavoriteContactFrame contactframe) {
		this.contactframe = new FavoriteContactFrame(contactframe);
	}

	/**
	 * default setContactFrame() - sets contactframe instance variable to default FavoriteContactFrame object
	 */
	public void setContactFrame() {
		this.contactframe = new FavoriteContactFrame();
	}
	
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

	/**
	 * @return int speedDial
	 */
	public int getSpeedDial() {
		return this.speedDial;
	}
	
	/**
	 * @return FavoriteContactFrame object reference (SHALLOW COPY!!!)
	 */
	public FavoriteContactFrame getContactFrame() {
		return this.contactframe;
	}
	
	/**
	 * @return String - name, number, notes, speedDial contatenated
	 */
	public String toString()
	{
		return "name = " + this.name + ", number = " + this.number + ", notes = " + this.notes + ", speeddial = " + this.speedDial;
	}

}