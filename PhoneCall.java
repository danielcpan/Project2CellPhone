import java.util.Calendar;

public class PhoneCall {
	private String timestamp;
	private boolean isIncoming;
	private Contact contact;
	private String incoming;
	private int numberOfCalls = 1;

	public PhoneCall() {
		calcTimestamp();
	}
	// public PhoneCall(Contact contact, boolean isIncoming) {
	// 	this.calcTimestamp();
	// 	this.setAll(contact, this.getTimestamp(), isIncoming);
	// }
	public PhoneCall(Contact contact, String timestamp, boolean isIncoming) {
		this.calcTimestamp();
		this.setAll(contact, this.getTimestamp(), isIncoming, numberOfCalls);
	}
	public void setAll(Contact contact, String timestamp, boolean isIncoming, int numberOfCalls) {
		this.setContact(contact);
		this.setTimestamp(timestamp);
		this.setisIncoming(isIncoming);
		this.setNumberOfCalls(numberOfCalls);
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public void setisIncoming(boolean isIncoming) {
		this.isIncoming = isIncoming;
	}

	public void setNumberOfCalls(int numberOfCalls) {
		this.numberOfCalls = numberOfCalls;
	}

	public void calcTimestamp() {
		Calendar today;
		int day, month, year, hour;
		String minute;
		String amPm, timestamp;
		today = Calendar.getInstance();
		day = today.get(Calendar.DAY_OF_MONTH);
		month = today.get(Calendar.MONTH) + 1;
		year = today.get(Calendar.YEAR);
		hour = today.get(Calendar.HOUR);
		minute = String.format("%02d", today.get(Calendar.MINUTE));
		if (today.get(Calendar.AM_PM) == 0) {
			amPm = "AM";
		}
		else {
			amPm = "PM";
		}
		this.timestamp = hour + ":" + minute + ":" + amPm + "\n" + month + "/" + day + "/" + year;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public Contact getContact() {
		return contact;
	}

	public String getIsIncoming() {
		incoming = " ";
		if (isIncoming == true) {
			incoming = "Incoming";
		}
		else {
			incoming = "Outgoing";
		}
		return incoming;
	}

	public int getNumberOfCalls() {
		return numberOfCalls;
	}

}