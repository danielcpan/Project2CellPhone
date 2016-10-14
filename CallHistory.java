import java.util.ArrayList;

public class CallHistory {

	private ArrayList<PhoneCall> log;
	private ArrayList<PhoneCall> hiddenLog;

	public CallHistory() {
		this.log = new ArrayList<PhoneCall>();
		this.hiddenLog = new ArrayList<PhoneCall>();
	}

	public CallHistory(CallHistory other)
	{
		this.log = new ArrayList<PhoneCall>();
		this.hiddenLog = new ArrayList<PhoneCall>();
		
		for (int i = 0; i < other.log.size(); i++)
		{
			this.log.add(new PhoneCall(other.log.get(i)));
		}
		
		for (int i = 0; i < other.hiddenLog.size(); i++)
		{
			this.hiddenLog.add(new PhoneCall(other.hiddenLog.get(i)));
		}
	}
	public void addCall(PhoneCall contact) {
		log.add(contact);
	}

	public void displayCallLog() {
		checkNumberOfCalls();
		System.out.println("Call History");
		System.out.println("--------------------");
		for (int i = 0; i < log.size(); i++) {
			if ((log.get(i).getNumberOfCalls() > 1)) {
				if (log.get(i).getContact().getName().equals("UNKNOWN")) {
					System.out.println(i+1 + "." + "|Number: " + log.get(i).getContact().getNumber() + " (" + log.get(i).getNumberOfCalls() + ")");
				}
				else {
					System.out.println(i+1 + "." + "|Name: " + log.get(i).getContact().getName() + " (" + log.get(i).getNumberOfCalls() + ")");
					System.out.println("  |Number: " + log.get(i).getContact().getNumber());
				}
				System.out.println("--------------------");
			}
			else if ((log.get(i).getNumberOfCalls() == 1)) {
				if (log.get(i).getContact().getName().equals("UNKNOWN")) {
					System.out.println(i+1 + "." + "|Number: " + log.get(i).getContact().getNumber());
					System.out.println("  |Time: " + log.get(i).getTimestamp());
					System.out.println("  |Date: " + log.get(i).getDatestamp());
					System.out.println("  |Status: " + log.get(i).getPhoneStatus());
				}
				else {
					System.out.println(i+1 + "." + "|Name: " + log.get(i).getContact().getName());
					System.out.println("  |Number: " + log.get(i).getContact().getNumber());
					System.out.println("  |Time: " + log.get(i).getTimestamp());
					System.out.println("  |Date: " + log.get(i).getDatestamp());
					System.out.println("  |Status: " + log.get(i).getPhoneStatus());
				}
				System.out.println("--------------------");
			}
		}
	}

	public void displayHiddenLog(int index) {
		int count = 0;
		for (int i = 0; i < log.size(); i ++) {
			if (log.get(i).getIndex()==index) {
				count++;
				System.out.println(count + "." + "|Name: " + log.get(i).getContact().getName());
				System.out.println("  |Number: " + log.get(i).getContact().getNumber());
				System.out.println("  |Time: " + log.get(i).getTimestamp());
				System.out.println("  |Date: " + log.get(i).getDatestamp());
				System.out.println("  |Status: " + log.get(i).getPhoneStatus());
				System.out.println("--------------------");
			}
		}
		for (int j = 0; j < hiddenLog.size(); j++) {
			if (hiddenLog.get(j).getIndex()==index) {
				count++;
				System.out.println(count + "." + "|Name: " + hiddenLog.get(j).getContact().getName());
				System.out.println("  |Number: " + hiddenLog.get(j).getContact().getNumber());
				System.out.println("  |Time: " + hiddenLog.get(j).getTimestamp());
				System.out.println("  |Date: " + hiddenLog.get(j).getDatestamp());
				System.out.println("  |Status: " + hiddenLog.get(j).getPhoneStatus());
				System.out.println("--------------------");				
			}
		}
	}

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
				}
			}
		}
	}
}