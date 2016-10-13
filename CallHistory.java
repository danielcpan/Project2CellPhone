import java.util.Scanner;
import java.util.ArrayList;

public class CallHistory {

	private ArrayList<PhoneCall> log = new ArrayList<PhoneCall>();
	private ArrayList<String> displayLog = new ArrayList<String>();
	// private static ArrayList<Contact> log = new ArrayList<Contact>();

	public CallHistory() {
	}

	public void addCall(PhoneCall contact) {
		log.add(contact);
	}

	public void displayLogTest() {
		for (int i = 0; i < log.size(); i++) {
			System.out.println(log.get(i));
		}
	}
	public void displayCallLog() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Ener 1 for Raw Call Log or Enter 2 for formatted Call Log (TESTING STUFF SHUSSSH)");
		String userInput = scan.nextLine();
		if (userInput.equals("1")) {
			displayLogTest();
		}
		else if (userInput.equals("2")) {
			checkNumberOfCalls();
			System.out.println("Call History");
			System.out.println("--------------------");
			for (int i = 0; i < log.size(); i++) {
				if (log.get(i).getIndex()!=log.get(i+1).getIndex()) {
					if (log.get(i).getNumberOfCalls() > 1) {
						if (log.get(i).getContact().getName().equals("UNKNOWN")) {
							System.out.println(i+1 + "." + "|Number: " + log.get(i).getContact().getNumber() + " (" + log.get(i).getNumberOfCalls() + ")");
							System.out.println("--------------------");
						}
						else {
							System.out.println(i+1 + "." + "|Name: " + log.get(i).getContact().getName() + " (" + log.get(i).getNumberOfCalls() + ")");
							System.out.println("  |Number: " + log.get(i).getContact().getNumber());
							System.out.println("--------------------");
						}
					}
					else if (log.get(i).getNumberOfCalls() == 1) {
						if (log.get(i).getContact().getName().equals("UNKNOWN")) {
							System.out.println(i+1 + "." + "|Number: " + log.get(i).getContact().getNumber());
							System.out.println("  |Time: " + log.get(i).getTimestamp());
							System.out.println("  |Date: " + log.get(i).getDatestamp());
							System.out.println("  |Status: " + log.get(i).getPhoneStatus());
							System.out.println("--------------------");
						}
						else {
							System.out.println(i+1 + "." + "|Name: " + log.get(i).getContact().getName());
							System.out.println("  |Number: " + log.get(i).getContact().getNumber());
							System.out.println("  |Time: " + log.get(i).getTimestamp());
							System.out.println("  |Date: " + log.get(i).getDatestamp());
							System.out.println("  |Status: " + log.get(i).getPhoneStatus());
							System.out.println("--------------------");
						}
					}
				}
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
					log.get(i).setIndex(i);
					log.get(j).setIndex(i);
					log.remove(j);
					j--;
				}
			}
		}
	}
}