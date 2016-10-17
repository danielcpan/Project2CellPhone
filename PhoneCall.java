import java.util.Calendar;

/**
 * Every PhoneCall object has an instance variable String time, String date, boolean isIncoming, Contact contact.
 * Simulates every phone call made, a PhoneCall object is created.
 * @author Chad, Victoria, Daniel P, Daniel R, Minh
 */
public class PhoneCall {
	
	/*****INSTANCE VARIABLES*****/
	private String time;
	private String date;
	private boolean isIncoming;
	private Contact contact;

//CONSTRUCTORS
	/**
	 * copy constructor - initializes instance variables to parameter PhoneCall object's values
	 * @param other - PhoneCalls
	 * returns reference to PhoneCall object created
	 */
	public PhoneCall(PhoneCall other) {
		this.setAll(new Contact(other.contact),other.time,other.isIncoming,other.date);
	}

	/**
	 * loaded constructor - sets time and date using calcTime() and calcDate() methods
	 * @param contact - Contact 
	 * @param isIncoming - boolean
	 * returns reference to PhoneCall object created
	 */
	public PhoneCall(Contact contact, boolean isIncoming) {
		String time, date;
		
		time = this.calcTime();
		date = this.calcDate();
		this.setAll(contact, time, isIncoming, date);
	}
	
//SETTERS
	/**
	 * sets all instance variables with parameter values
	 * @param contact - Contact
	 * @param time - String
	 * @param isIncoming - boolean
	 * @param date - String
	 */
	public void setAll(Contact contact, String time, boolean isIncoming, String date) {
		this.setContact(contact);
		this.setTime(time);
		this.setIsIncoming(isIncoming);
		this.setDate(date);
	}

	/**
	 * sets this.contact
	 * @param contact - Contact
	 */
	public void setContact(Contact contact) {
		this.contact = contact;
	}

	/**
	 * sets this.time
	 * @param time - String
	 */
	public void setTime(String time) {
		this.time = time;
	}

	/**
	 * sets this.date
	 * @param date - String
	 */
	public void setDate(String date) {
		this.date = date;
	}

	/**
	 * sets this.isIncoming
	 * @param isIncoming - boolean
	 */
	public void setIsIncoming(boolean isIncoming) {
		this.isIncoming = isIncoming;
	}

	/**
	 * creates Calendar object to get the timestamp of when the PhoneCall object is created
	 * @return String
	 */
	public String calcTime() {
		Calendar today;
		int day, month, year, hour;
		String minute;
		String amPm, timestamp;
		today = Calendar.getInstance();
		hour = today.get(Calendar.HOUR);
		if (hour == 0) {
			hour = 12;
		}
		else if (hour > 12)
		{
			hour -= 12;
		}
		minute = String.format("%02d", today.get(Calendar.MINUTE));
		if (today.get(Calendar.AM_PM) == 0) {
			amPm = "AM";
		}
		else {
			amPm = "PM";
		}
		
		return hour + ":" + minute + amPm;
	}

	/**
	 * creates Calendar object to get the datestamp of when the PhoneCall object is created
	 * @return String
	 */
	public String calcDate() {
		Calendar today;
		int day, month, year;
		today = Calendar.getInstance();
		day = today.get(Calendar.DAY_OF_MONTH);
		month = today.get(Calendar.MONTH) + 1;
		year = today.get(Calendar.YEAR);

		return month + "/" + day + "/" + year;
	}

//GETTERS
	/**
	 * @return String time
	 */
	public String getTime() {
		return this.time;
	}

	/**
	 * @return String date
	 */
	public String getDate() {
		return this.date;
	}

	/**
	 * @return Contact contact object reference (SHALLOW COPY!!!)
	 */
	public Contact getContact() {
		return this.contact;
	}

	/**
	 * @return String - "incoming" if true; "outgoing" if false
	 */
	public String getIsIncoming() {
		if (this.isIncoming)
		{
			return "incoming";
		}
		return "outgoing";
	}
	
	/**
	 * @return String - instance variables Contact, date, time, status concatenated
	 */
	public String toString()
	{
		return "contact = " + this.contact + ", date = " + this.date + " ,time = " + this.time + " ,status = " + this.getIsIncoming();
	}
}