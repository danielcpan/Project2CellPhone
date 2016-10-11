
package project2;

import java.util.Calendar;

public class PhoneCall1 
{
	private Contact contact;
	private String timestamp;
	private boolean isIncoming;
	
	public PhoneCall1(Contact contact, boolean isIncoming)
	{
		if (contact != null)
		{
			this.calcTimestamp();
			this.setAll(contact, this.getTimestamp(), isIncoming);
		}
		else
		{
			System.out.println("ERROR: cannot set null to an instance variable. Exiting. ");
			System.exit(0);
		}
	}
	
	public boolean setAll(Contact contact, String timestamp, boolean isIncoming)
	{
		if (contact != null)
		{
			this.setIsIncoming(isIncoming);
			return this.setTimestamp(timestamp) && this.setContact(contact);
		}
		return false;
	}
	
	public boolean setContact(Contact contact)
	{
		if (contact != null)
		{
			this.contact = new Contact(contact);
			return true;
		}
		return false;
	}
	
	public boolean setTimestamp(String timestamp)
	{
		if (timestamp != null && timestamp.length() > 0)
		{
			this.timestamp = timestamp;
			return true;
		}
		return false;
	}
	
	public void setIsIncoming(boolean isIncoming)
	{
		this.isIncoming = isIncoming;
	}
	
	public void calcTimestamp()
	{
		Calendar today;
		int day, month, year, hour, minute;
		String amPm, timestamp;
		
		today = Calendar.getInstance();
		
		day = today.get(Calendar.DAY_OF_MONTH);
		month = today.get(Calendar.MONTH) + 1;
		year = today.get(Calendar.YEAR);
		hour = today.get(Calendar.HOUR);
		minute = today.get(Calendar.MINUTE);
		
		if (today.get(Calendar.AM_PM) == 0)
		{
			amPm = "AM";
		}
		else
		{
			amPm = "PM";
		}
		
		this.timestamp = hour + ":" + minute + " " + amPm + "\n" + month + "/" + day + "/" + year;
	}
	
	public String getTimestamp()
	{
		return this.timestamp;
	}
	
	public Contact getContact()
	{
		return this.contact;
	}
	
	public boolean getIsIncoming()
	{
		return this.isIncoming;
	}
}
