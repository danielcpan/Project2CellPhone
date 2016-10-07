import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String again = " ";
		String number;

		while (!again.equals("done")) {
			Contact userContact = new Contact();

			System.out.println("Please enter a contact name");
			userContact.setName(scan.nextLine());

			System.out.println("Please enter the contact cellphone number");
			userContact.setNumber(scan.nextLine());
			while (userContact.getNumber().length() == 10 || userContact.getNumber().length() == 7) {
				userContact.setNumber(scan.nextLine());
			}

			System.out.println("Please enter any notes");
			userContact.setNotes(scan.nextLine());

		}
	}
}