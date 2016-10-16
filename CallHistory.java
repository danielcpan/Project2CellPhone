import java.util.ArrayList;

public class CallHistory {

	private ArrayList<PhoneCall> log;
<<<<<<< HEAD
	private int[] referToIndex;
	private int[] numberOfCalls;
	private String[] printLog;

=======
	private ArrayList<PhoneCall> hiddenLog;
	/**
	 * default constructor
	 */
>>>>>>> origin/master
	public CallHistory() {
		this.log = new ArrayList<PhoneCall>();
	}
	/**
	 * overloaded constructor that has a list of contacts
	 * @param other - object with a given list of contacts who have called you
	 */
	public CallHistory(CallHistory other)
	{
		this.log = new ArrayList<PhoneCall>();
		
		for (int i = 0; i < other.log.size(); i++)
		{
			this.log.add(new PhoneCall(other.log.get(i)));
		}
	}
	/**
	 * logs the call to the call history
	 * @param contact - contact that has called you at least once
	 */
	public void addCall(PhoneCall contact) {
		this.log.add(contact);
	}
<<<<<<< HEAD
	
	public ArrayList<PhoneCall> getLog()
	{
		return this.log;
	}
	
	public int[] getReferToIndex()
	{
		return this.referToIndex;
	}
	
	public int[] getNumberOfCalls()
	{
		return this.numberOfCalls;
	}
	
	public String[] getPrintLog()
	{
		return this.printLog;
	}
	public void displayCallLog()
	{	
		int count,temp;
		
		count = 0;
		this.printLog = new String[this.log.size()];
		this.numberOfCalls = new int[this.log.size()];
		this.referToIndex = new int[this.log.size()];
	
		for (int i = 0; i < this.log.size(); i++)
		{
			this.referToIndex[i] = i;
		}
		
		for (int i = 0; i < this.log.size(); i++)
		{
			for (int j = 1; j < this.log.size()-1; j++)
			{
				if (this.log.get(i).getContact().equals(this.log.get(j).getContact()) && this.log.get(i).getDate().equals(this.log.get(j).getDate()) && this.log.get(i).getIsIncoming().equals(this.log.get(j).getIsIncoming()))
				{
					this.referToIndex[i] = j;
				}
			}
		}
		
		for (int i = 0; i < this.log.size(); i++)
		{
			if (this.referToIndex[i] == i)
			{
				this.numberOfCalls[i]++;	
			}
			else
			{
				this.numberOfCalls[this.referToIndex[i]]++;
			}
		}
		System.out.println("\nCall History");
=======
	/**
	 * displays the call history
	 */
	public void displayCallLog() {
		checkNumberOfCalls();
		System.out.println("Call History");
>>>>>>> origin/master
		System.out.println("--------------------");
		
		for (int i = 0; i < this.log.size(); i++)
		{
			if (numberOfCalls[i] == 1 && this.referToIndex[i] == i)
			{
				if (this.log.get(i).getContact().getName().equals("UNKNOWN")) {
					this.printLog[count] = (count+1 + "." + "|Number: " + log.get(i).getContact().getNumber() + "\n  |Time: " + log.get(i).getTime() + "\n  |Date: " + log.get(i).getDate() + "\n  |Status: " + log.get(i).getIsIncoming() + "\n");
				}
				else {
					this.printLog[count] = (count+1 + "." + "|Name: " + log.get(i).getContact().getName() + "\n  |Number: " + log.get(i).getContact().getNumber() + "\n  |Time: " + log.get(i).getTime() + "\n  |Date: " + log.get(i).getDate() + "\n  |Status: " + log.get(i).getIsIncoming() + "\n");
				}
				System.out.println(this.printLog[count]);
				System.out.println("--------------------");
				count++;
			}
			if (this.numberOfCalls[i] > 1)
			{
				if (this.log.get(i).getContact().getName().equals("UNKNOWN")) {
					this.printLog[count] = (count+1 + "." + "|Number: " + log.get(i).getContact().getNumber() + " (" + this.numberOfCalls[i] + ")\n");
				}
				else {
					this.printLog[count] = (count+1 + "." + "|Name: " + log.get(i).getContact().getName() + " (" + this.numberOfCalls[i] + ")\n" + "  |Number: " + log.get(i).getContact().getNumber() + "\n");
				}
				System.out.println(this.printLog[count]);
				System.out.println("--------------------");
<<<<<<< HEAD
=======
			}
		}
	}
	/**
	 * displays information of call log when number of calls is greater than 1
	 * @param index - position of the contact in the call history (call log)
	 */
	public void displayHiddenLog(int index) {
		int count = 0;
		for (int i = 0; i < log.size(); i ++) {
			if (log.get(i).getIndex()==index) {
>>>>>>> origin/master
				count++;
			}
		}
	}
	
	public void displayHiddenLog(int number, int length) //more info
	{	
		int index, temp, count;
		count = 0;
		index = number-1;
		
		for (int i = 0; i < this.log.size(); i++)
		{
			if (numberOfCalls[i] == 1 && this.referToIndex[i] == i)
			{
				if (this.log.get(i).getContact().getName().equals("UNKNOWN")) {
					temp = count;
				}
				else {
					temp = count;
				}
				if (count == index)
				{
					System.out.println("|Name: " + log.get(count).getContact().getName() + "\n  |Number: " + log.get(count).getContact().getNumber() + "\n  |Time: " + log.get(count).getTime() + "\n  |Date: " + log.get(count).getDate() + "\n  |Status: " + log.get(count).getIsIncoming() + "\n");
				}
				count++;
			}
<<<<<<< HEAD
			if (this.numberOfCalls[i] > 1)
			{
				if (this.log.get(i).getContact().getName().equals("UNKNOWN")) {
					temp = count;
=======
		}
	}
	/**
	 * determines of the number of calls to a contact is 1 or more
	 */
	public void checkNumberOfCalls() {
		int numberOfCalls;
		for (int i = 0; i < log.size(); i++) {
			for (int j = i+1; j < log.size(); j++) {
				if (log.get(i).getContact().getNumber().equals(log.get(j).getContact().getNumber())
					&& log.get(i).getDatestamp().equals(log.get(j).getDatestamp())
					&& log.get(i).getPhoneStatus().equals(log.get(j).getPhoneStatus())) {
					numberOfCalls = log.get(i).getNumberOfCalls();
					numberOfCalls++;
					log.get(i).setNumberOfCalls(numberOfCalls);
					log.get(i).setIndex(i+1);
					System.out.println("Index " + log.get(i).getIndex());
					log.get(j).setIndex(log.get(i).getIndex());
					hiddenLog.add(log.get(j));
					log.remove(j);
					j--;
>>>>>>> origin/master
				}
				else {
					temp = count;
				}
				if (count == index)
				{
					System.out.println("|Name: " + log.get(count).getContact().getName() + "\n  |Number: " + log.get(count).getContact().getNumber() + "\n  |Time: " + log.get(count).getTime() + "\n  |Date: " + log.get(count).getDate() + "\n  |Status: " + log.get(count).getIsIncoming() + "\n");
				}
				count++;
			}
		}
		
		
	}
	
}