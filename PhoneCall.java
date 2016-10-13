
import java.util.Calendar;

public class PhoneCall {
	private String timestamp;
	private String datestamp;
	private boolean phoneStatus;
	private Contact contact;
	private String status;
	private int numberOfCalls = 1;
	private int index;

	public PhoneCall() {

	}
	// public PhoneCall(Contact contact, boolean phoneStatus) {
	// 	this.calcTimestamp();
	// 	this.setAll(contact, this.getTimestamp(), phoneStatus);
	// }
	public PhoneCall(Contact contact, String timestamp, boolean phoneStatus) {
		this.calcTimestamp();
		this.calcDateStamp();
		this.setAll(contact, this.getTimestamp(), phoneStatus, numberOfCalls, this.getDatestamp(), index);
	}
	public void setAll(Contact contact, String timestamp, boolean phoneStatus, int numberOfCalls, String datestamp, int index) {
		this.setContact(contact);
		this.setTimestamp(timestamp);
		this.setphoneStatus(phoneStatus);
		this.setNumberOfCalls(numberOfCalls);
		this.setDateStamp(datestamp);
		this.setIndex(index);
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public void setDateStamp(String datestamp) {
		this.datestamp = datestamp;
	}

	public void setphoneStatus(boolean phoneStatus) {
		this.phoneStatus = phoneStatus;
	}

	public void setNumberOfCalls(int numberOfCalls) {
		this.numberOfCalls = numberOfCalls;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public void calcTimestamp() {
		Calendar today;
		int day, month, year, hour;
		String minute;
		String amPm, timestamp;
		today = Calendar.getInstance();
		hour = today.get(Calendar.HOUR);
		if (hour == 0) {
			hour = 12;
		}
		minute = String.format("%02d", today.get(Calendar.MINUTE));
		if (today.get(Calendar.AM_PM) == 0) {
			amPm = "AM";
		}
		else {
			amPm = "PM";
		}
		this.timestamp = hour + ":" + minute + ":" + amPm;
	}

	public void calcDateStamp() {
		Calendar today;
		int day, month, year;
		today = Calendar.getInstance();
		day = today.get(Calendar.DAY_OF_MONTH);
		month = today.get(Calendar.MONTH) + 1;
		year = today.get(Calendar.YEAR);

		this.datestamp = month + "/" + day + "/" + year;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public String getDatestamp() {
		return datestamp;
	}

	public Contact getContact() {
		return contact;
	}

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

	public int getNumberOfCalls() {
		return numberOfCalls;
	}

	public int getIndex() {
		return index;
	}

}