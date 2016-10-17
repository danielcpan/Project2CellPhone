import java.util.ArrayList;

/**
 * Every CallHistory object has instance variables ArrayList<PhoneCall> log, int[] referToIndex, int[] numberOfCalls, String[] printLog.
 * Simulates how a call log in a phone can display information in multiple folders.
 * @author Chad, Victoria, Daniel P, Daniel R, Minh
 */
public class CallHistory {

	/*****INSTANCE VARIABLES*****/
	private ArrayList<PhoneCall> log;
	private int[] referToIndex;
	private int[] numberOfCalls;
	private String[] printLog;
	
//CONSTRUCTORS
	/**
	 * default constructor - instantiates ArrayList<PhoneCall> log only
	 */
	public CallHistory() {
		this.log = new ArrayList<PhoneCall>();
	}

	/**
	 * copy constructor - initializes CallHistory object instance variable ArrayList<PhoneCall> log to parameter value
	 * @param other - CallHistory
	 */
	public CallHistory(CallHistory other)
	{
		this.log = new ArrayList<PhoneCall>();
		
		for (int i = 0; i < other.log.size(); i++)
		{
			this.log.add(new PhoneCall(other.log.get(i)));
		}
	}

//SETTERS
	/**
	 * adds PhoneCall parameter to ArrayList<PhoneCall> log
	 * @param contact - PhoneCall
	 */
	public void addCall(PhoneCall phoneCall) {
		this.log.add(phoneCall);
	}
	
//GETTERS
	/**
	 * @return ArrayList<PhoneCall> reference (SHALLOW COPY!!!)
	 */
	public ArrayList<PhoneCall> getLog()
	{
		return this.log;
	}
	
	/**
	 * @return int[] referToIndex reference (SHALLOW COPY!!!)
	 */
	public int[] getReferToIndex()
	{
		return this.referToIndex;
	}
	
	/**
	 * @return int[] numberOfCalls reference (SHALLOW COPY!!!)
	 */
	public int[] getNumberOfCalls()
	{
		return this.numberOfCalls;
	}
	
	/**
	 * @return String[] printLog reference (SHALLOW COPY!!!)
	 */
	public String[] getPrintLog()
	{
		return this.printLog;
	}

//OTHER METHODS
	/**
	 * 
	 */
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
		System.out.println("--------------------");
		
		for (int i = 0; i < this.log.size(); i++)
		{
			if (numberOfCalls[i] == 1 && this.referToIndex[i] == i)
			{
				if (this.log.get(i).getContact().getName().equals("UNKNOWN")) {
					this.printLog[count] = (count+1 + "." + "|Number: " + log.get(i).getContact().getNumber() + "\n  |Time: " + log.get(i).getTime() + "\n  |Date: " + log.get(i).getDate() + "\n  |Status: " + log.get(i).getIsIncoming());
				}
				else {
					this.printLog[count] = (count+1 + "." + "|Name: " + log.get(i).getContact().getName() + "\n  |Number: " + log.get(i).getContact().getNumber() + "\n  |Time: " + log.get(i).getTime() + "\n  |Date: " + log.get(i).getDate() + "\n  |Status: " + log.get(i).getIsIncoming());
				}
				System.out.println(this.printLog[count]);
				System.out.println("--------------------");
				count++;
			}
			if (this.numberOfCalls[i] > 1)
			{
				if (this.log.get(i).getContact().getName().equals("UNKNOWN")) {
					this.printLog[count] = (count+1 + "." + "|Number: " + log.get(i).getContact().getNumber() + " (" + this.numberOfCalls[i] + ")");
				}
				else {
					this.printLog[count] = (count+1 + "." + "|Name: " + log.get(i).getContact().getName() + " (" + this.numberOfCalls[i] + ")\n" + "  |Number: " + log.get(i).getContact().getNumber());
				}
				System.out.println(this.printLog[count]);
				System.out.println("--------------------");
				count++;
			}
		}
	}
	
	/**
	 * 
	 * @param number
	 * @param length
	 */
	public void displayHiddenLog(int number, int length) //more info
	{	
		int[] numCalls, referTo;
		int index, temp, count;
		
		numCalls = new int[length];
		referTo = new int[length];
		
		index = number-1;
		count = 0;
		
		for (int i = 0; i < this.numberOfCalls.length; i++)
		{
			if (this.numberOfCalls[i] != 0)
			{
				numCalls[count] = this.numberOfCalls[i];
				referTo[count] = this.referToIndex[i];
				count++;
			}
		}
		
		temp = referTo[index];
		
		if (this.numberOfCalls[temp] >= 1)
		{
			for (int i = 0; i < this.referToIndex.length; i++)
			{
				if (this.referToIndex[i] == temp)
				{
					System.out.println("--------------------");
					System.out.println("  |Name: " + log.get(i).getContact().getName() + "\n  |Number: " + log.get(i).getContact().getNumber() + "\n  |Time: " + log.get(i).getTime() + "\n  |Date: " + log.get(i).getDate() + "\n  |Status: " + log.get(i).getIsIncoming());
					System.out.println("--------------------");
				}
			}
		}
	}
	
}