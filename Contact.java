public class Contact {

	private static final String DEFAULT_NAME = "UNKNOWN";
	private static final String DEFAULT_NUMBER = "";
	private static final String DEFAULT_NOTES = "";
	public static final int DEFAULT_SPEEDDIAL = 10;

	private String name;
	private String number;
	private String email;
	private int speedDial;
	private FavoriteContactFrame contactframe;
	/**
	 * default constructor containing contact information of a person/contact
	 */
	public Contact() {
		this.setAll(DEFAULT_NAME, DEFAULT_NUMBER, DEFAULT_NOTES);
		this.setSpeedDial(DEFAULT_SPEEDDIAL);
		this.setContactFrame();
	}
	/**
	 * default constructor containing contact information of a favorite that is calling you
	 * @param name - name of the favorite
	 * @param number - phone number of favorite
	 * @param email - e-mail address of contact/favorite
	 * @param speedDial - index of favorie
	 */
	public Contact(String name, String number, String email, int speedDial) {
		this.setAll(name, number, email);
		this.setSpeedDial(speedDial);
		this.setContactFrame();
	}
	/**
	 * default constructor that displays an image of the contact or favorite and his or her contact information
	 * @param name - name of the favorite
	 * @param number - phone number of favorite
	 * @param email - e-mail address of contact/favorite
	 * @param speedDial - index of favorie
	 * @param directory - image being displayed on frame
	 * @param fWidth - width of frame
	 * @param fHeight - height of frame
	 */
	public Contact(String name, String number, String email, int speedDial, String directory, int fWidth, int fHeight) {
		this.setAll(name, number, email);
		this.setSpeedDial(speedDial);
		this.contactframe = new FavoriteContactFrame(directory, fWidth, fHeight);
		this.contactframe.setNameInfo(name);
		this.contactframe.setNumberInfo(number);
		this.contactframe.setNotesInfo(email);
	}
	/**
	 * overloaded constructor that contains contact information of a random person
	 * @param other - random contact calling you
	 */
	public Contact(Contact other) {
		this.setAll(other.name, other.number, other.email);
		this.setSpeedDial(other.speedDial);
		this.setContactFrame(other.contactframe);
	}
	/**
	 * initializes all user input to the atributes of a contact
	 * @param name - user input for name of contact
	 * @param number - user input for phone number of contact
	 * @param email - user input for email of contact
	 */
	public void setAll(String name, String number, String email) {
		this.setName(name);
		this.setNumber(number);
		this.setNotes(email);
	}
	/**
	 * initializes name to user input
	 * @param  name - user input's name
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * gets the name of the contact
	 * @return this.name - name of contact
	 */
	public String getName() {
		return this.name;
	}
	/** intializes number to user input for phone number
	 * @param number - user input's phone number
	 */
	public void setNumber(String number) {
		this.number = number;
	}
	/** gets the phone numberof the contact
	 * @return this.number - phone number of contact
	 */
	public String getNumber() {
		return this.number;
	}
	/** intializes email to user input's e-mail address
	 * @param email - user input's email
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/** gets the email address of contact
	 * @return this.email - email address of contact
	 */
	public String getEmail() {
		return this.email;
	}
	/** initializes index of contact or favorite, depending what number is assigned
	 * @param speedDial - index of contact
	 */
	public void setSpeedDial(int speedDial) {
		this.speedDial = speedDial;
	}
	/** gets the index of the contact (might be a favorite)
	 * @return this.speedDial - position of contact
	 */
	public int getSpeedDial() {
		return this.speedDial;
	}
	/** creates a new contact frame with specific image
	 * @param contactframe - user input's frame of a favorite contact
	 */
	public void setContactFrame(FavoriteContactFrame contactframe) {
		this.contactframe = new FavoriteContactFrame(contactframe);
	}
	/** initializes frame of user input to instance variable contactframe
	 */
	public void setContactFrame() {
		this.contactframe = new FavoriteContactFrame();
	}
	/** gets contact frame of the favorite
	 * @return this.contactframe - image of favorite with their contact information
	 */
	public FavoriteContactFrame getContactFrame() {
		return this.contactframe;
	}

}