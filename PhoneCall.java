import java.util.Calendar;

public class PhoneCall {
	private String timestamp;
	private boolean isIncoming;
	private Contact contact;

	public PhoneCall(Contact contact, boolean isIncoming) {
		this.calcTimestamp();
		this.setAll(contact, this.getTimestamp(), isIncoming);
	}
	public static void setAll(Contact contact, String timestamp, boolean isIncoming) {

	}

	public static boolean setContact(Contact contact) {

	}

	public static void setTimestamp(String timestamp) {

	}

	public static void setisIncoming(boolean isIncoming) {

	}

	public static void calcTimestamp() {
		Calendar today;
		int day, month, year, hour, minute;
		String amPm, timestamp;
		today = Calendar.getInstance();
		day = today.get(Calendar.DAY_OF_MONTH);
		month = today.get(Calendar.MONTH) + 1;
		year = today.get(Calendar.YEAR);
		hour = today.get(Calendar.HOUR);
		minute = today.get(Calendar.MINUTE);
		if (today.get(Calendar.AM_PM) == 0) {
			amPM = "AM";
		}
		else {
			amPM = "PM"
		}
		this.timestamp = hour + ":" + minute + ":" + amPM + "\n" + month + "/" + day + "/" + year;
	}

	public static String getTimestamp() {
		return timestamp;
	}

	public static Contact getContact() {
		return contact;
	}

	public static boolean getIsIncoming() {
		return isIncoming;
	}

}