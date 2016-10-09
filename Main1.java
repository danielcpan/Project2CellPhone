import java.util.Scanner;

public class Main1 {
	public static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		// Scanner scan = new Scanner(System.in);
		//PhoneCall call1 = new PhoneCall();
		CallHistory history = new CallHistory();
		////////////////////////////////////////////////////////////
		//TESTING PURPOSES: CONTACTS
		Contact first = new Contact("John", "9387836748", "C00l Guy");
		Contact second = new Contact("Samantha", "8371907834", "Chick I met");
		Contact third = new Contact("Pope Francis", "3980827", "HOLLLLLYYYYYY");
		Contact fourth = new Contact("Commando", "2560637", "Command me, sir");
		PhoneBook.addContact(first);
		PhoneBook.addContact(second);
		PhoneBook.addContact(third);
		PhoneBook.addContact(fourth);
		//PhoneBook.contactsToString();
		//System.out.println("ssssssssssssssssssssssssssssssssss");
		//PhoneBook.compareContacts();
		PhoneBook.contactsToString();
				// /////////////////////////////////////////////
				// //TESTING PURPOSES: FAVORITES
				// Contact one = new Contact("Timmy", "7630589246", "Yummy");
				// FavoriteContactFrame firstframe = new FavoriteContactFrame("C:\\Users\\Chad\\Pictures\\CECS274Proj2\\penguin.jpg", 800, 600);
				// Contact two = new Contact("Hercules", "9239036", "You're so strong ;) ");
				// FavoriteContactFrame secondframe = new FavoriteContactFrame("C:\\Users\\Katherine\\Pictures\\gitProfile.jpg", 800, 600);
				// Contact three = new Contact("Armani", "9282937345", "Sameeeeeee");
				// FavoriteContactFrame thirdframe = new FavoriteContactFrame("C:\\Users\\Katherine\\Pictures\\gitProfile.jpg", 800, 600);
				// Contact four = new Contact("Gucci", "8720182", "WTF CALVIN HARRIS != TAYLOR SWIFT");
				// FavoriteContactFrame fourthframe = new FavoriteContactFrame("C:\\Users\\Katherine\\Pictures\\gitProfile.jpg", 800, 600);
				// Contact five = new Contact("Cleo", "4522834", "First love");
				// FavoriteContactFrame fifthframe = new FavoriteContactFrame("C:\\Users\\Katherine\\Pictures\\gitProfile.jpg", 800, 600);
				// Favorite top1 = new Favorite(one,1,firstframe);
				// Favorite top2 = new Favorite(two,2,secondframe);
				// Favorite top3 = new Favorite(three,3,thirdframe);
				// Favorite top4 = new Favorite(four,4,fourthframe);
				// Favorite top5 = new Favorite(five,5,fifthframe);
				// //PhoneBook.addFavorite(top1);
				// PhoneBook.addFavorite(top2);
				// PhoneBook.addFavorite(top3);
				// PhoneBook.addFavorite(top4);
				// PhoneBook.addFavorite(top5);
				// PhoneBook.favoritesToString();
				// /////////////////////////////////////////////
		//Asking user to input favorites
		/*for(int a = 1; a < 6; a++){
			Contact favContact = new Contact();
			System.out.println("Please enter a name for: Contact Favorite #" + a);
			favContact.setName(scan.nextLine());
			System.out.println("Please enter the cellphone number for: Contact Favorite #" + a);
			favContact.setNumber(scan.nextLine());
			while (favContact.getNumber().length() != 10 && favContact.getNumber().length() != 7) {
				System.out.println("Phone number is invalid, please enter a valid phone number.");
				favContact.setNumber(scan.nextLine());
			}
			System.out.println("Please enter any notes for: Contact Favorite #" + a);
			favContact.setNotes(scan.nextLine());
			Favorite userFavorite = new Favorite(favContact, a);
			PhoneBook.addFavorite(userFavorite);
					//PhoneBook.favoritesToString();
		} */
		
		
		////////////////////////////////////////////////////
		//Menus System of the phone, with 5 options
		boolean end = false;
		while (!end){
			displayMenu();
			int response = scan.nextInt();
			// scan.nextLine();
			switch(response){
			///////////////////////////////////////////////
			//Make a call
			case 1: 
				System.out.println("1.Call by number\n2.Call by name\n3.Call from favorites");
				int response1 = scan.nextInt();
				scan.nextLine();
				switch(response1) {
				case 1:
					callByNumber();
					break;
				case 2:
					callByName();
					break;
				case 3:
					callFromFavorites();
					break;
				}
				break;
			//////////////////////////////////////////////////////////
			//Receive a call	
			case 2:
				receiveCall();
				break;
			////////////////////////////////////////////////////////////
			//Access Top 5
			case 3:
				System.out.println("1.Add a favorite.\n2.Remove a favorite.\n3.Switch numbers of two favorites.\n4.Display a favorite.");
				int response3 = scan.nextInt();
				scan.nextLine();
				switch (response3){
				case 1:
					addFavoriteContact();
					break;
				case 2:
					removeFavoriteContact();	//Not finished
					break;
				case 3:
					switchFavoriteSpeedDialNumber();	//Not finished
					break;
				case 4:
					displayFavorite();
					break;
				}
				break;
			////////////////////////////////////////////////////////////
			//Access Phone book
			case 4:
				System.out.println("1.Add a contact.\n2.Remove a contact\n3.Display the phonebook.");
				int response4 = scan.nextInt();
				scan.nextLine();
				switch(response4){
					case 1:
						addContact();
						break;
					case 2:
						removeContact();	//Not finished
						break;
					case 3:
						displayPhoneBook();
						break;
				}
				break;
			////////////////////////////////////////////////////////////
			//Access Call History
			case 5:
				break;
			////////////////////////////////////////////////////////////
			//End program
			default:
				end = true;
				break;
		}
		}	

	}
	public static void displayMenu() {
		System.out.println("Phone Menu");
		System.out.println("--------------------");
		System.out.println("1.Make a call.");
		System.out.println("2.Receive a call.");
		System.out.println("3.Access the top 5 contacts.");
		System.out.println("4.Access the phone book.");
		System.out.println("5.Access the call history.");
		System.out.println("6.End the program");
	}

	public static void callByNumber() {
		String again1 = "";
		while (!again1.equals("done")){
		boolean numValid = false;
			System.out.println("What is the number you would like to call");
			String number = scan.nextLine();
			while (number.length() != 10 && number.length() != 7) {
				System.out.println("Phone number is invalid, please enter a valid phone number.");
				number = scan.nextLine();
			}
		for(int a = 0; a < PhoneBook.getContactSize(); a++){
			if (number.equals(PhoneBook.getContactArrayList().get(a).getNumber())){
				System.out.println("You called " + PhoneBook.getContactArrayList().get(a).getName());
				numValid = true;
			}
		}
		if(!numValid){
			System.out.println("Number is not on your contacts, but call was still made.");
			Contact unknown = new Contact();
			unknown.setNumber(number);
			PhoneBook.addUnknown(unknown);
			//PhoneBook.unknownToString(); // Testing unknown arraylist
		}
		System.out.println("Do you want to call another number? (add/done)");
		again1 = scan.nextLine();
		}
	}

	public static void callByName() {
		String name = " ";
		String userInput = " ";
		boolean again = true;
		boolean again2 = true;
		boolean nameValid = true;
		while (again == true) {
			while(again2 == true){
				System.out.println("What is name of the person you would like to call?");
				name = scan.nextLine();
				for(int a = 0; a < PhoneBook.getContactSize(); a++){
					if (name.equals(PhoneBook.getContactArrayList().get(a).getName())){
						System.out.println("You called " + PhoneBook.getContactArrayList().get(a).getName());
						nameValid = true;
					}
					else {
						nameValid = false;
					}
				}
				if (nameValid == false){
					System.out.println("You didn't enter a correct name in your phonebook.");
					System.out.println("Would you like to reenter the name or return to menu?(add/done)");
					userInput = scan.nextLine();
					if (userInput.equals("done")) {
						again2 = false;
					}
				}
			}
			System.out.println("Would you like to call another contact by name? (add/done)");
			userInput = scan.nextLine();
			if (userInput.equals("add")) {
				again2 = true;
			}
			else if (userInput.equals("done")) {
				again = false;
			}
		}
	}

	public static void callFromFavorites() {
		System.out.println("Enter the speed dial number");
		int speedDial = Integer.parseInt(scan.nextLine());		
	}

	public static void receiveCall() {
		String userInput = " ";
		boolean again3 = true;
		boolean again4 = true;
		while (again3 == true) {
			int randomNumber = (int) (Math.random() * 999999999);
			String areaCode = Integer.toString(randomNumber);
			areaCode = areaCode.substring(0,3);

			randomNumber = (int) (Math.random() * 999999999);
			String firstNumber = Integer.toString(randomNumber);
			firstNumber = firstNumber.substring(0,3);

			randomNumber = (int) (Math.random() * 999999999);
			String secondNumber = Integer.toString(randomNumber);
			secondNumber = secondNumber.substring(0,4);

			while(again4 == true){
				System.out.println("Ring Ring Ring.........\nYou are getting a call from " + "(" + areaCode + ")" + firstNumber + "-" + secondNumber);
				System.out.println("Do you want to pick up? (y/n)");
				userInput = scan.nextLine();

				if(userInput.equalsIgnoreCase("y")){
					System.out.println("You picked up, Call was recorded.");
					again4 = false;
				} else if(userInput.equalsIgnoreCase("n")){
					System.out.println("You declined the call.");
					again4 = false;
				} else {
					System.out.println("Enter a valid command.");
					userInput = scan.nextLine();
				}
			}
			System.out.println("Do you want to receive another call? (y/n)");
			userInput = scan.nextLine();
			if (userInput.equalsIgnoreCase("y")) {
				again4 = true;
			} else if (userInput.equalsIgnoreCase("n")) {
				again3 = false;
			}
		}
	}

	public static void addFavoriteContact() {
		String again = "";
		while(!again.equals("done")){
				System.out.println("Enter the name of the favorite contact");
				String favName = scan.nextLine();
				System.out.println("Enter the number of the favorite contact.");
				String favNumber = scan.nextLine();
			while (favNumber.length() != 10 && favNumber.length() != 7) {
				System.out.println("Phone number is invalid, please enter a valid phone number.");
				favNumber = scan.nextLine();
			}
			System.out.println("Enter the note for the favorite contact.");
			String favNote = scan.nextLine();
			Contact favContact = new Contact(favName,favNumber,favNote);
			System.out.println("Enter the speed dial number of this favorite contact.");
			int favSpeedDial = Integer.parseInt(scan.nextLine());
			while(favSpeedDial < 1 || favSpeedDial > 5){
				System.out.println("Enter a valid speed dial number (1-5)");
				favSpeedDial = Integer.parseInt(scan.nextLine());
			}
			//NEEDS ALOT MORE WORK TO CHECK FOR MULTIPLE SPEED DIAL #
			System.out.println("Enter the path of the picture of the favorite contact.");
			String path = scan.nextLine();
			System.out.println("Enter the width of the image.");
			int imageWidth = Integer.parseInt(scan.nextLine());
			System.out.println("Enter the height of the image.");
			int imageHeight = Integer.parseInt(scan.nextLine());
			FavoriteContactFrame contactFrame = new FavoriteContactFrame(path,imageWidth,imageHeight);
			Favorite favFavorite = new Favorite(favContact, favSpeedDial, contactFrame);
			PhoneBook.addFavorite(favFavorite);
			System.out.println("Do you want to add another favorite? (add/done)");
			again = scan.nextLine();
		}
	}

	public static void removeFavoriteContact() {
		//Empty
	}

	public static void switchFavoriteSpeedDialNumber() {
		//Empty
	}

	public static void displayFavorite() {
		System.out.println("Which favorites information do you want displayed");
		int answer1 = Integer.parseInt(scan.nextLine());
		for (int i = 0; i < PhoneBook.getFavoriteSize(); i++) {
			if (answer1 == PhoneBook.getFavoriteArrayList().get(i).getSpeedDial()) {
				PhoneBook.getFavoriteArrayList().get(i).getContactFrame().displayContactImage(PhoneBook.getFavoriteArrayList().get(i).getName());;
			}
		}
	}

	public static void addContact() {
		String again = "";
		while (!again.equals("done")) {
			Contact userContact = new Contact();
			System.out.println("Please enter a contact name");
			userContact.setName(scan.nextLine());
			System.out.println("Please enter the contact cellphone number");
			userContact.setNumber(scan.nextLine());
			while (userContact.getNumber().length() != 10 && userContact.getNumber().length() != 7) {
				System.out.println("Phone number is invalid, please enter a valid phone number.");
				userContact.setNumber(scan.nextLine());
			}
			System.out.println("Please enter any notes");
			userContact.setNotes(scan.nextLine());
			PhoneBook.addContact(userContact);
			PhoneBook.contactsToString();    //Checking arraylist
			System.out.println("Do you want to add another contact? (add/done)");
			again = scan.nextLine();
		}
	}

	public static void removeContact() {
		//Empty
	}

	public static void displayPhoneBook() {
		PhoneBook.compareContacts();
		System.out.println("Your Phone book.");
		System.out.println("-------------------------------------");
		PhoneBook.contactsToString();
		System.out.println("Would you like to call one of your contacts? (y/n)");
		String answer3 = scan.nextLine();
	}
}