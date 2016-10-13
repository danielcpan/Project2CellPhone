import java.util.Scanner;

public class Main1 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
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
		/////////////////////////////////////////////
		//TESTING PURPOSES: FAVORITES
		Contact one = new Contact("Timmy", "7630589246", "Yummy");
		FavoriteContactFrame firstframe = new FavoriteContactFrame("C:\\Users\\Chad\\Pictures\\CECS274Proj2\\penguin.jpg", 800, 600);
		Contact two = new Contact("Hercules", "9239036", "You're so strong ;) ");
		FavoriteContactFrame secondframe = new FavoriteContactFrame("C:\\Users\\Katherine\\Pictures\\gitProfile.jpg", 800, 600);
		Contact three = new Contact("Armani", "9282937345", "Sameeeeeee");
		FavoriteContactFrame thirdframe = new FavoriteContactFrame("C:\\Users\\Katherine\\Pictures\\gitProfile.jpg", 800, 600);
		Contact four = new Contact("Gucci", "8720182", "WTF CALVIN HARRIS != TAYLOR SWIFT");
		FavoriteContactFrame fourthframe = new FavoriteContactFrame("C:\\Users\\Katherine\\Pictures\\gitProfile.jpg", 800, 600);
		Contact five = new Contact("Cleo", "4522834", "First love");
		FavoriteContactFrame fifthframe = new FavoriteContactFrame("C:\\Users\\Katherine\\Pictures\\gitProfile.jpg", 800, 600);
		Favorite top1 = new Favorite(one,1,firstframe);
		Favorite top2 = new Favorite(two,2,secondframe);
		Favorite top3 = new Favorite(three,3,thirdframe);
		Favorite top4 = new Favorite(four,4,fourthframe);
		Favorite top5 = new Favorite(five,5,fifthframe);
		//PhoneBook.addFavorite(top1);
		PhoneBook.addFavorite(top2);
		PhoneBook.addFavorite(top3);
		PhoneBook.addFavorite(top4);
		PhoneBook.addFavorite(top5);
		PhoneBook.favoritesToString();
		/////////////////////////////////////////////
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
<<<<<<< Updated upstream
=======
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
					callByNumber(myPhoneBook, myCallHistory);
					break;
				case 2:
					callByName(myPhoneBook, myCallHistory);
					break;
				case 3:
					callFromFavorites();	//Not Finished
					break;
				}
				break;
			//////////////////////////////////////////////////////////
			//Receive a call	
			case 2:
				receiveCall(myPhoneBook, myCallHistory);
				break;
			////////////////////////////////////////////////////////////
			//Access Top 5
			case 3:
				System.out.println("1.Add a favorite.\n2.Remove a favorite.\n3.Switch numbers of two favorites.\n4.Display a favorite.");
				int response3 = scan.nextInt();
				scan.nextLine();
				switch (response3){
				case 1:
					addFavoriteContact(myPhoneBook);
					break;
				case 2:
					removeFavoriteContact();	//Not finished
					break;
				case 3:
					switchFavoriteSpeedDialNumber();	//Not finished
					break;
				case 4:
					displayFavorite(myPhoneBook);
					break;
				}
				break;
			////////////////////////////////////////////////////////////
			//Access Phone book
			case 4:
				System.out.println("1.Add a contact.\n2.Remove a contact\n3.Display the phone book.");
				int response4 = scan.nextInt();
				scan.nextLine();
				switch(response4){
					case 1:
						addContact(myPhoneBook);
						break;
					case 2:
						removeContact();	//Not finished
						break;
					case 3:
						displayPhoneBook(myPhoneBook);
						break;
				}
				break;
			////////////////////////////////////////////////////////////
			//Access Call History
			case 5:
			myCallHistory.displayCallLog();
			boolean again7 = true;
			while (again7 == true) {
				System.out.println("Would you like to view call details? (y/n)");
				String response5 = scan.nextLine();
				if (response5.equals("y")) {
					System.out.println("Please enter caller assigned number");
					String response6 = scan.nextLine();
					myCallHistory.displayHiddenLog(Integer.parseInt(response6));
					again7 = false;
				}
				else if (response5.equals("n")) {
					again7 = false;
				}
				else {
					System.out.println("Test");
				}
			}

				// System.out.println("1.Display Call Log.\n2.View Call Details.");
				// int response5 = scan.nextInt();
				// scan.nextLine();
				// switch(response5) {
				// 	case 1:
				// 		myCallHistory.displayCallLog();
				// 		break;
				// 	case 2:
				// 		System.out.println("Enter caller assigned number");
				// 		int userInput = scan.nextInt();
				// 		scan.nextLine();
				// 		myCallHistory.displayHiddenLog(userInput);
				// 		// if (userInput.equals())
				// 		break;
				// }
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
>>>>>>> Stashed changes
		System.out.println("Phone Menu");
		System.out.println("--------------------");
		System.out.println("1.Make a call.");
		System.out.println("2.Receive a call.");
		System.out.println("3.Access the top 5 contacts.");
		System.out.println("4.Access the phone book.");
		System.out.println("5.Access the call history.");
		System.out.println("6.End the program");
		int response = scan.nextInt();
		scan.nextLine();
		switch(response)
		{
		///////////////////////////////////////////////
		//Make a call
		case 1:
			System.out.println("1.Call by number.");
			System.out.println("2.Call by name.");
			System.out.println("3.Call from favorites");
			int response1 = scan.nextInt();
			scan.nextLine();
			switch(response1)
			{
			//Call by Number
			case 1:
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
				break;
			//Call by Name
			case 2:
				String name = "";
				String again2 = "";
				while(!again2.equals("done")){
				boolean nameValid = false;
				while(!nameValid && !name.equals("done")){
				System.out.println("What is name of the person you would like to call?");
				name = scan.nextLine();
				for(int a = 0; a < PhoneBook.getContactSize(); a++){
					if (name.equals(PhoneBook.getContactArrayList().get(a).getName())){
						System.out.println("You called " + PhoneBook.getContactArrayList().get(a).getName());
						nameValid = true;
					}
				}
				if (!nameValid){
					System.out.println("You didn't enter a correct name in your phonebook.");
					System.out.println("Would you like to reenter the name or return to menu?(add/done)");
					name = scan.nextLine();
				}
				}
				System.out.println("Would you like to call another contact by name? (add/done)");
				again2 = scan.nextLine();
				}
				break;
			//Call from favorites
			case 3:
				System.out.println("Enter the speed dial number");
				int speedDial = Integer.parseInt(scan.nextLine());
				
				break;
			}
			break;
		//////////////////////////////////////////////////////////
		//Receive a call	
		case 2:
			String again3 = "";
			while (!again3.equals("done")){
			int areaCode = (int) (Math.random()*999);
			int firstNumber = (int)(Math.random()*999);
			int secondNumber = (int) (Math.random()*9999);
			System.out.println("Ring Ring Ring.........\nYou are getting a call from " + "(" + areaCode + ")" + firstNumber + "-" + secondNumber);
			System.out.println("Do you want to pick up? (y/n)");
			String answer = scan.nextLine();
			boolean validAns = false;
			while(!validAns){
			if(answer.equalsIgnoreCase("y")){
				System.out.println("You picked up, Call was recorded.");			
				validAns = true;
			}
			else if(answer.equalsIgnoreCase("n")){
				System.out.println("You declined the call.");
				validAns = true;
			}
			else{
				System.out.println("Enter a valid command.");
				answer = scan.nextLine();
			}
			}
			System.out.println("Do you want to receive another call? (add/done)");
			again3 = scan.nextLine();
			}
			break;
		////////////////////////////////////////////////////////////
		//Access Top 5
		case 3:
			System.out.println("1.Add a favorite.\n2.Remove a favorite.\n3.Switch numbers of two favorites.\n4.Display a favorite.");
			int response3 = scan.nextInt();
			scan.nextLine();
			switch (response3){
			//Adding Favorite contact
			case 1:
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
				break;
			//Removing favorite contact
			case 2:
				break;
			//Switching speed dial #'s
			case 3:
				break;
			//Display favorite frame
			case 4:
				System.out.println("Which favorites information do you want displayed");
				int answer1 = Integer.parseInt(scan.nextLine());
					for (int i = 0; i < PhoneBook.getFavoriteSize(); i++)
					{
						if(answer1 == PhoneBook.getFavoriteArrayList().get(i).getSpeedDial())
						{
							PhoneBook.getFavoriteArrayList().get(i).getContactFrame().displayContactImage(PhoneBook.getFavoriteArrayList().get(i).getName());;
						}
					}
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
			//Adding a contact
			case 1:
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
				break;
			//Removing a contact
			case 2:
				break;
			//Displaying Phonebook contact
			case 3:
				PhoneBook.compareContacts();
				System.out.println("Your Phone book.");
				System.out.println("-------------------------------------");
				PhoneBook.contactsToString();
				System.out.println("Would you like to call one of your contacts? (y/n)");
				String answer3 = scan.nextLine();
				
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

}