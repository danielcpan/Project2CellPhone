import java.util.Calendar;

public class PhoneCall {
	private String time;
	private String date;
	private boolean isIncoming;
	private Contact contact;

	public PhoneCall(PhoneCall other) {
		this.setAll(new Contact(other.contact),other.time,other.isIncoming,other.date);
	}
<<<<<<< HEAD

	public PhoneCall(Contact contact, boolean isIncoming) {
		this.calcTime();
		this.calcDate();
		this.setAll(contact, this.getTime(), isIncoming, this.getDate());
	}
	public void setAll(Contact contact, String timestamp, boolean isIncoming, String datestamp) {
=======
	/**
	 * overloaded constructor with information of contact, time, and call type(incoming/outging)
	 * @param contact - the contact calling your phone
	 * @param timestamp - time contact called your phone
	 * @param phoneStatus - whether call was incoming or outgoin
	 */
	public PhoneCall(Contact contact, String timestamp, boolean phoneStatus) {
		this.calcTimestamp();
		this.calcDateStamp();
		this.setAll(contact, this.getTimestamp(), phoneStatus, numberOfCalls, this.getDatestamp(), index);
	}
	/**
	 * sets & assigns user input information to instance variables
	 * @param contact - person calling your phone (information provided
	 * @param timestamp - time the person called you
	 * @param phoneStatus - whether call was incoming or outgoin
	 * @param numberOfCalls - times person has called you
	 * @param datestamp - date the person called you
	 * @param index - position of contact (to be used if contact is a favorite or not)
	 */
	public void setAll(Contact contact, String timestamp, boolean phoneStatus, int numberOfCalls, String datestamp, int index) {
>>>>>>> origin/master
		this.setContact(contact);
		this.setTimestamp(timestamp);
		this.setisIncoming(isIncoming);
		this.setDateStamp(datestamp);
	}
	/**
	 * sets user input to instance variable contact
	 * @param contact - information of the contact who tried to call your phone
	 */
	public void setContact(Contact contact) {
		this.contact = contact;
	}
<<<<<<< HEAD

	public void setTimestamp(String time) {
		this.time = time;
	}

	public void setDateStamp(String date) {
		this.date = date;
	}

	public void setisIncoming(boolean isIncoming) {
		this.isIncoming = isIncoming;
	}

	public void calcTime() {
=======
	/**
	 * sets the current time to instance variable timestamp
	 * @param timestamp - time contact calls your phone
	 */
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	/**
	 * sets current date to instance variable datestamp
	 * @param datestamp - date contact calls your phone
	 */
	public void setDateStamp(String datestamp) {
		this.datestamp = datestamp;
	}
	/**
	 * sets status of call to instance varialbe phoneStatus
	 * @param phoneStatus - status of user input
	 */
	public void setphoneStatus(boolean phoneStatus) {
		this.phoneStatus = phoneStatus;
	}
	/**
	 * sets number of calls of contact to instance variable
	 * @param numberOfCalls - the amount of times the contact called your phone
	 */
	public void setNumberOfCalls(int numberOfCalls) {
		this.numberOfCalls = numberOfCalls;
	}
	/**
	 * sets position of contact to a certain index
	 * @param index - index of contact (used to decide if it is a favorite or not)
	 */
	public void setIndex(int index) {
		this.index = index;
	}
	/**
	 * initialize the current time to the timestamp instance variable
	 */
	public void calcTimestamp() {
>>>>>>> origin/master
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
		this.time = hour + ":" + minute + ":" + amPm;
	}
<<<<<<< HEAD

	public void calcDate() {
=======
	/**
	 * initialize the current date to the datestamp instance variable
	 */
	public void calcDateStamp() {
>>>>>>> origin/master
		Calendar today;
		int day, month, year;
		today = Calendar.getInstance();
		day = today.get(Calendar.DAY_OF_MONTH);
		month = today.get(Calendar.MONTH) + 1;
		year = today.get(Calendar.YEAR);

		this.date = month + "/" + day + "/" + year;
	}
<<<<<<< HEAD

	public String getTime() {
		return this.time;
	}

	public String getDate() {
		return this.date;
=======
	/**
	 * gets the current time stamp
	 * @return timestamp - current time
	 */
	public String getTimestamp() {
		return timestamp;
	}
	/**
	 * get the current date of the program
	 * @return datestamp - current date
	 */
	public String getDatestamp() {
		return datestamp;
>>>>>>> origin/master
	}
	/**
	 * gets the contact of the person calling you
	 * @return contact - person calling you
	 */
	public Contact getContact() {
		return this.contact;
	}
<<<<<<< HEAD

	public String getIsIncoming() {
		if (this.isIncoming)
		{
			return "incoming";
		}
		return "outgoing";
	}
	
	public String toString()
	{
		return "contact = " + this.contact + ", date = " + this.date + " ,time = " + this.time + " ,status = " + this.getIsIncoming();
=======
	/**
	 * gets the phone status of each call
	 * @return status - type of each phone call
	 */
	public String getPhoneStatus() {
		status = " ";
		if (phoneStatus == true) {
			status = "Incoming";
		}
		else {
			status = "Outgoing";
		}
		return status;
	}
	/**
	 * gets the number of calls for each contact
	 * @return numberOfCalls - frequency of calling the contact
	 */
	public int getNumberOfCalls() {
		return numberOfCalls;
	}
	/**
	 * get the index of the contact
	 * @return index - index of contact
	 */
	public int getIndex() {
		return index;
>>>>>>> origin/master
	}
}