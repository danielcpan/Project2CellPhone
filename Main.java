import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String again = " ";
d
		int favNum;

		while (!again.equals("done")) {
			Contact userContact = new Contact();

			System.out.println("Please enter a contact name");
			userContact.setName(scan.nextLine());

			System.out.println("Please enter the contact cellphone number");
			userContact.setNumber(scan.nextLine());
			while (userContact.getNumber().length() != 10 || userContact.getNumber().length() != 7) {
				System.out.println("Phone number is invalid, please enter a valid phone number.");
				userContact.setNumber(scan.nextLine());
			}

			System.out.println("Please enter any notes");
			userContact.setNotes(scan.nextLine());

			PhoneBook.addContact(userContact);

			System.out.println("Do you want to add another contact? ('done' to exit");
			again = scan.nextLine();
		}

		again = " ";

		while (!again.equals("done")) {
			Contact favContact = new Contact();

			System.out.println("Please enter a favorite name");
			favContact.setName(scan.nextLine());

			System.out.println("Please enter the favorite cellphone number");
			favContact.setNumber(scan.nextLine());
			while (favContact.getNumber().length() != 10 || favContact.getNumber().length() != 7) {
				System.out.println("Phone number is invalid, please enter a valid phone number.");
				favContact.setNumber(scan.nextLine());
			}

			System.out.println("Please enter any notes");
			favContact.setNotes(scan.nextLine());

			System.out.println("Please enter the favorite's speed dial number");
			favNum = Integer.parseInt(scan.nextLine());
			if (favNum < 0 || favNum > 5) {
				System.out.println("Please enter a number between 1 and 5");
				favNum = Integer.parseInt(scan.nextLine());
			}

			Favorite userFavorite = new Favorite(favContact, favNum);
			PhoneBook.addContact(userFavorite);

			System.out.println("Do you want to add another favorite? ('done' to exit");
			again = scan.nextLine();
		}
	}
}