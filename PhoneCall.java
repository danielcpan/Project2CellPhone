import java.util.Calendar;

public class PhoneCall {
	private String time;
	private String date;
	private boolean isIncoming;
	private Contact contact;

	public PhoneCall(PhoneCall other) {
		this.setAll(new Contact(other.contact),other.time,other.isIncoming,other.date);
	}

	public PhoneCall(Contact contact, boolean isIncoming) {
		this.calcTime();
		this.calcDate();
		this.setAll(contact, this.getTime(), isIncoming, this.getDate());
	}
	public void setAll(Contact contact, String timestamp, boolean isIncoming, String datestamp) {
		this.setContact(contact);
		this.setTimestamp(timestamp);
		this.setisIncoming(isIncoming);
		this.setDateStamp(datestamp);
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

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

	public void calcDate() {
		Calendar today;
		int day, month, year;
		today = Calendar.getInstance();
		day = today.get(Calendar.DAY_OF_MONTH);
		month = today.get(Calendar.MONTH) + 1;
		year = today.get(Calendar.YEAR);

		this.date = month + "/" + day + "/" + year;
	}

	public String getTime() {
		return this.time;
	}

	public String getDate() {
		return this.date;
	}

	public Contact getContact() {
		return this.contact;
	}

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
	}
}