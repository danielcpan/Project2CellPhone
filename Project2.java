import java.util.Scanner;
import utilitiesVH.UtilitiesVH;

public class Project2 
{
	public static final String MENU = "Phone Menu\n--------------------\n1.Make a call.\n2.Receive a call.\n3.Access favorites.\n4.Access contacts.\n5.Access call history.\n6.End the program\n";

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		PhoneBook myPhoneBook = new PhoneBook();
		int response, response1, response3, response4, response6, count;
		String response5;
		
		count = 0;
		////////////////////////////////////////////////////////////
		//TESTING PURPOSES: FAVORITES
		
		Contact top1 = new Contact("Timmy","(763)058-9246", "Yummy",1,"C:\\Users\\Chad\\Pictures\\CECS274Proj2\\penguin.jpg", 800, 600);
		Contact top2 = new Contact("Hercules", "923-9036", "You're so strong ;)", 2 ,"C:\\Users\\Chad\\Pictures\\CECS274Proj2\\corgi.gif", 800, 600);
		Contact top3 = new Contact("Armani", "(928)293-7345", "Sameeeeeee",3,"C:\\Users\\Chad\\Pictures\\CECS274Proj2\\penguin.jpg", 800, 600);
		Contact top4 = new Contact("Gucci", "872-0182", "WTF CALVIN HARRIS != TAYLOR SWIFT",4,"C:\\Users\\Chad\\Pictures\\CECS274Proj2\\penguin.jpg", 800, 600);
		Contact top5 = new Contact("Cleo", "452-2834", "First love",5,"C:\\Users\\Chad\\Pictures\\CECS274Proj2\\penguin.jpg", 800, 600);
		
		myPhoneBook.addContact(top1);
		myPhoneBook.addContact(top2);
		myPhoneBook.addContact(top3);
		myPhoneBook.addContact(top4);
		myPhoneBook.addContact(top5);
		
		myPhoneBook.addFavorite(top4);
		myPhoneBook.addFavorite(top2);
		myPhoneBook.addFavorite(top3);
		myPhoneBook.addFavorite(top1);
		myPhoneBook.addFavorite(top5);
		
		//Menus System of the phone, with 5 options
		System.out.println(MENU);
		response = UtilitiesVH.readInt(scan,"Enter choice: ",1,6);
		while (response != 6)
		{
			switch(response)
			{
				case 1: //make a call
					System.out.println("\n1. Call by number\n2. Call by name\n3. Call from favorites\n4. Go Back");
					response1 = UtilitiesVH.readInt(scan,"\nEnter choice: ",1,4);
					
					while (response1 != 4)
					{
						switch(response1) 
						{
							case 1: //call by number
								callByNumber(scan,myPhoneBook);
								break;
							case 2: //call by name
								callByName(scan,myPhoneBook);
								break;
							case 3: //call from favorites
								callFromFavorites(scan,myPhoneBook);
								break;
						}
						System.out.println("\n1. Call by number\n2. Call by name\n3. Call from favorites\n4. Go Back");
						response1 = UtilitiesVH.readInt(scan,"\nEnter choice: ",1,4);
					}
					break;
				case 2: //receive a call
					receiveCall(scan,myPhoneBook);
					break;
				case 3: //access favorites
					System.out.println("\n1. Add a favorite.\n2. Remove a favorite.\n3. Switch numbers of two favorites.\n4. Display a favorite.\n5. Go back");
					response3 = UtilitiesVH.readInt(scan, "\nEnter choice: ", 1,5);
					
					while (response3 != 5)
					{
						switch (response3)
						{
							case 1:
								addFavoriteContact(scan,myPhoneBook);
								break;
							case 2:
								removeFavoriteContact(scan,myPhoneBook);	
								break;
							case 3:
								switchFavoriteSpeedDialNumber(scan, myPhoneBook);
								break;
							case 4:
								displayFavorites(scan,myPhoneBook);
								break;
						}
						System.out.println("\n1. Add a favorite.\n2. Remove a favorite.\n3. Switch numbers of two favorites.\n4. Display a favorite.\n5. Go back");
						response3 = UtilitiesVH.readInt(scan, "\nEnter choice: ", 1,5);
					}
					break;
				case 4: //access contacts
					System.out.println("1. Add a contact.\n2. Remove a contact\n3. Edit a contact.\n4. Display the phone book.\n5. Go back");
					response4 = UtilitiesVH.readInt(scan, "\nEnter choice: ", 1,5);
					while (response != 5)
					{
						switch(response4){
							case 1:
								addContact(scan,myPhoneBook);
								break;
							case 2:
								removeContact(scan, myPhoneBook);
								break;
							case 3:
								editContact(scan,myPhoneBook);
								break;
							case 4:
								displayContacts(scan,myPhoneBook);
								break;
						}
						System.out.println("\n1. Add a contact.\n2. Remove a contact\n3. Edit a contact.\n4. Display the phone book.\n5. Go back");
						response4 = UtilitiesVH.readInt(scan, "\nEnter choice: ", 1,5);
					}
					break;
				case 5: //access call history
					myPhoneBook.getCallHistory().displayCallLog();
					
					for (int i = 0; i < myPhoneBook.getCallHistory().getPrintLog().length; i++)
					{
						if(myPhoneBook.getCallHistory().getNumberOfCalls()[i] != 0)
						{
							count++;
						}
					}
					
					System.out.print("\nEnter the caller assigned number: (done to go back) ");
					response5 = scan.nextLine().toLowerCase();
					
					while (!response5.equals("done")) {
						try
						{
							response6 = Integer.parseInt(response5);
							if (response6 >= 1 && response6 <= count)
							{
								myPhoneBook.getCallHistory().displayHiddenLog(response6, count);
							}
							else
							{
								System.out.println("ERROR: enter a number between 1 and " + count);
							}
							System.out.print("\nEnter the caller assigned number: (done to go back) ");
							response5 = scan.nextLine().toLowerCase();
						}
						catch (NumberFormatException e)
						{
							System.out.print("\nEnter the caller assigned number: (done to go back) ");
							response5 = scan.nextLine().toLowerCase();
						}
					}
					break;
			}
			System.out.println("\n"+MENU);
			response = UtilitiesVH.readInt(scan,"\nEnter choice: ",1,6);
		}	
	}

	public static void callByNumber(Scanner scan, PhoneBook myPhoneBook) {
		char again;
		String validChars = "YyNn";
		String formatNumber;
		PhoneCall recordedPhoneCall;
		boolean numValid;
		
		again = 'y';
		numValid = false;
		
		while (again == 'Y' || again == 'y')
		{
			System.out.print("Enter the number you would like to call: ");
			String number = scan.nextLine();
			
			while (number.length() != 10 && number.length() != 7) 
			{
				System.out.println("Phone number is invalid, please enter a valid phone number.");
				number = scan.nextLine();
			}
			formatNumber = myPhoneBook.formatNumber(number);
			
			for(int a = 0; a < myPhoneBook.getContacts().size(); a++)
			{
				if (formatNumber.equals(myPhoneBook.getContacts().get(a).getNumber()))
				{
					System.out.println("You called " + myPhoneBook.getContacts().get(a).getName());
					recordedPhoneCall = new PhoneCall(myPhoneBook.getContacts().get(a), true);
					myPhoneBook.getCallHistory().addCall(recordedPhoneCall);
					numValid = true;
				}
			}
			
			if(!numValid)
			{
				System.out.println("Number is not on your contacts, but call was still made.");
				Contact unknown = new Contact();
				unknown.setNumber(formatNumber);
				recordedPhoneCall = new PhoneCall(unknown, false);
				myPhoneBook.getCallHistory().addCall(recordedPhoneCall);
			}
		
			again = UtilitiesVH.readChar(scan, "Do you want to call another number? (Y/N) ", validChars);
		}
	}

	public static void callByName(Scanner scan, PhoneBook myPhoneBook) {
		String name;
		boolean again;
		boolean nameValid = false;
		PhoneCall recordedPhoneCall;
		
		System.out.print("Enter the name of the person you would like to call: ");
		name = scan.nextLine().toLowerCase();
		
		while (!name.equals("done")) 
		{
			for(int a = 0; a < myPhoneBook.getContacts().size(); a++)
			{
				if (name.equals(myPhoneBook.getContacts().get(a).getName().toLowerCase()))
				{
					System.out.println("You called " + myPhoneBook.getContacts().get(a).getName());
					recordedPhoneCall = new PhoneCall(myPhoneBook.getContacts().get(a), false);
					myPhoneBook.getCallHistory().addCall(recordedPhoneCall);
					nameValid = true;
				}
			}
			if (nameValid == false)
			{
				System.out.println("We didn't recognize that name from your contacts.");
			}
			System.out.print("Enter the name of the person you would like to call: (done to exit) ");
			name = scan.nextLine().toLowerCase();
		}
	}

	public static void callFromFavorites(Scanner scan, PhoneBook myPhoneBook) {
		String userInput;
		boolean speedDialValid;
		PhoneCall recordedPhoneCall;
		int speedDial;
		
		speedDialValid = false;
		
		System.out.print("Enter a speed dial number 1-5 (or done to exit): ");
		userInput = scan.nextLine().toLowerCase();
		
		while (!userInput.equals("done"))
		{
			try
			{
				speedDial = Integer.parseInt(userInput);
				
				for (int a = 0; a < myPhoneBook.getFavorites().size(); a++)
				{
					if(speedDial == myPhoneBook.getFavorites().get(a).getSpeedDial())
					{
						System.out.println("You called " + myPhoneBook.getFavorites().get(a).getName());
						recordedPhoneCall = new PhoneCall(myPhoneBook.getFavorites().get(a), false);
						myPhoneBook.getCallHistory().addCall(recordedPhoneCall);
						speedDialValid = true;
					}
					else
					{
						speedDialValid = speedDialValid || false;
					}
				}
				
				if (speedDialValid == false){
					System.out.println("You didn't enter a valid speed dial number or you don't have a contact assigned for that speed dial number.");
				}
				
				System.out.print("Enter a speed dial number 1-5 (or done to exit): ");
				userInput = scan.nextLine().toLowerCase();
			}
			catch (NumberFormatException e)
			{
				System.out.print("Enter a speed dial number 1-5 (or done to exit): ");
				userInput = scan.nextLine().toLowerCase();
			}
		}
	}

	public static void receiveCall(Scanner scan, PhoneBook myPhoneBook) {
		String formatNumber;
		char userInput;
		char receiveAnother;
		int randomOrContact = 0;
		int favIndex;
		int contactIndex;
		PhoneCall recordedPhoneCall;
		
		randomOrContact = 0;
		recordedPhoneCall = null;
		receiveAnother = 'Y';
		
		
		////FAVORITE
		while(receiveAnother == 'Y' || receiveAnother == 'y')
		{
			randomOrContact = (int) (Math.random()* 10);
			/////One of your favorites call
			if(randomOrContact < 5)
			{
				 favIndex = (int) (Math.random() * myPhoneBook.getFavorites().size());
				 System.out.println("You are getting called by " + myPhoneBook.getFavorites().get(favIndex).getName());
				 
				 userInput = UtilitiesVH.readChar(scan,"Do you want to pick up? (Y/N) ","YyNn");
				 if(userInput == 'Y' || userInput == 'y')
				 {
					 System.out.println("You picked up and had a delightful conversation with " + 
							 	myPhoneBook.getFavorites().get(favIndex).getName() + ".\n Your call has been recorded.");
						recordedPhoneCall = new PhoneCall(myPhoneBook.getFavorites().get(favIndex), true);
				 }
				 else
				 {
					 System.out.println("You rejected the call with " + myPhoneBook.getFavorites().get(favIndex).getName()
							 + ".\n Your call has been recorded still.");
					 	recordedPhoneCall = new PhoneCall(myPhoneBook.getFavorites().get(favIndex), true);
				 }
			}
			// One of your contacts call
			else if(randomOrContact > 4 && randomOrContact < 8){
				contactIndex = (int) (Math.random() * myPhoneBook.getContacts().size());
				System.out.println("You are getting called by " + myPhoneBook.getContacts().get(contactIndex).getName());
				
				userInput = UtilitiesVH.readChar(scan,"Do you want to pick up? (Y/N) ","YyNn");
				 if(userInput == 'Y' || userInput == 'y')
				 {
					 System.out.println("You picked up and had a delightful conversation with " + 
							 	myPhoneBook.getContacts().get(contactIndex).getName() + ".\n Your call has been recorded.");
						recordedPhoneCall = new PhoneCall(myPhoneBook.getContacts().get(contactIndex), true);
				 }
				 else
				 {
					 System.out.println("You rejected the call with " + myPhoneBook.getContacts().get(contactIndex).getName()
							 + ".\n Your call has been recorded still.");
					 	recordedPhoneCall = new PhoneCall(myPhoneBook.getContacts().get(contactIndex), true);
				 }
			}
			// Random number calls you	
			else if(randomOrContact > 7)
			{	
				int randomNumber = (int) (Math.random() * 999999999);
				String areaCode = Integer.toString(randomNumber);
				areaCode = areaCode.substring(0,3);

				randomNumber = (int) (Math.random() * 999999999);
				String firstNumber = Integer.toString(randomNumber);
				firstNumber = firstNumber.substring(0,3);

				randomNumber = (int) (Math.random() * 999999999);
				String secondNumber = Integer.toString(randomNumber);
				secondNumber = secondNumber.substring(0,4);
				String entireNumber = areaCode+firstNumber+secondNumber;
				
				formatNumber = myPhoneBook.formatNumber(entireNumber);
				Contact unknown = new Contact();
				unknown.setNumber(formatNumber);
				myPhoneBook.addContact(unknown);
				
				System.out.println("You are getting a call from " + unknown.getNumber());
				
				userInput = UtilitiesVH.readChar(scan,"Do you want to pick up? (Y/N) ","YyNn");
				 if(userInput == 'Y' || userInput == 'y')
				 {
					 System.out.println("You picked up and had a delightful conversation with " + 
							 			unknown.getNumber() + ".\n Your call has been recorded.");
						recordedPhoneCall = new PhoneCall(unknown, true);
				 }
				 else
				 {
					 System.out.println("You rejected the call with " + recordedPhoneCall.getContact().getNumber()
							 + ".\n Your call has been recorded still.");
					 	recordedPhoneCall = new PhoneCall(unknown, true);
				 }
			}
			
			myPhoneBook.getCallHistory().addCall(recordedPhoneCall);
			receiveAnother = UtilitiesVH.readChar(scan,"Do you want to receive another call? (Y/N) ", "YyNn");
			
		}

			
	}

	public static void addFavoriteContact(Scanner scan,PhoneBook myPhoneBook) 
	{
		int choice;
		char again;
		
		System.out.println("\n1. Add an existing contact to Favorites\n2. Add a new contact to Favorites\n3. Go back\n");
		choice = UtilitiesVH.readInt(scan,"Enter choice: ",1,3);
		
		while (choice != 3)
		{
			if (choice == 1)
			{
				addExistingContactToFav(scan,myPhoneBook);
			}
			else if (choice == 2)
			{
				addContact(scan,myPhoneBook);
				addExistingContactToFav(scan,myPhoneBook);
			}
			
			again = UtilitiesVH.readChar(scan,"Do you want to add another person to Favorites? (Y/N) ","YyNn");
			
			if (again == 'N' || again == 'n')
			{
				choice = 3;
			}
			else
			{
				System.out.println("\n1. Add an existing contact to Favorites\n2. Add a new contact to Favorites\n3. Go back\n");
				choice = UtilitiesVH.readInt(scan,"Enter choice: ",1,3);
			}
		}
	}
	
	public static void addExistingContactToFav(Scanner scan, PhoneBook myPhoneBook)
	{
		int speedDial;
		String name;
		boolean isFound,isAlreadyTaken;
		char replaced;
		
		isFound = false;
		isAlreadyTaken = false;
		
		System.out.print("Enter the name of the existing contact you wish to add to Favorites: ");
		name = scan.nextLine().toLowerCase();
		for (int i = 0; i < myPhoneBook.getContacts().size(); i++)
		{
			if (myPhoneBook.getContacts().get(i).getName().toLowerCase().equals(name))
			{
				speedDial = UtilitiesVH.readInt(scan,"Enter the speed dial number 1-5 you wish to assign to " + name + ":", 1,5);
				for (int j = 0; j < myPhoneBook.getFavorites().size(); j++)
				{
					if (myPhoneBook.getFavorites().get(j).getSpeedDial() == speedDial)
					{
						System.out.println(myPhoneBook.getFavorites().get(j).getName() + " is assigned to this speed dial number. ");
						System.out.println("Do you want to replace " + myPhoneBook.getFavorites().get(j).getName() + " with " + name + " anyway? (Y/N)");
						replaced = UtilitiesVH.readChar(scan, "Do you want to replace " + myPhoneBook.getFavorites().get(j).getName() + " with " + name + " anyway? (Y/N)", "YyNn");
						
						if (replaced == 'Y' || replaced == 'y')
						{
							myPhoneBook.getFavorites().get(j).setSpeedDial(10);
							myPhoneBook.getContacts().get(i).setSpeedDial(speedDial);
							myPhoneBook.getFavorites().remove(j);
							myPhoneBook.getFavorites().add(myPhoneBook.getContacts().get(i));
						}
						else
						{
							System.out.println("Ok. " + myPhoneBook.getFavorites().get(j) + " is still set to speed dial " + myPhoneBook.getFavorites().get(j).getSpeedDial());
							System.out.println(name + " is still just a regular contact.");
						}
						isAlreadyTaken = true;
					}
				}
				if (!isAlreadyTaken)
				{
					myPhoneBook.getContacts().get(i).setSpeedDial(speedDial);
					myPhoneBook.getFavorites().add(myPhoneBook.getContacts().get(i));
					System.out.println(myPhoneBook.getContacts().get(i) + " is successfully assign to " + speedDial + " for Favorites");
				}
				isFound = true;
			}
			else
			{
				isFound = isFound || false;
			}
		}
		if (!isFound)
		{
			System.out.println("That person isn't on your contacts list.");
		}
		
	}

	public static void removeFavoriteContact(Scanner scan,PhoneBook myPhoneBook) {
		String name;
		char unfav;
		boolean isFound;
		
		isFound = false;
		
		System.out.print("Enter the name of the contact you wish to un-Favorite: ");
		name = scan.nextLine().toLowerCase();
		
		while (!name.equals("done"))
		{
			for (int i = 0; i < myPhoneBook.getFavorites().size(); i++)
			{
				if (myPhoneBook.getFavorites().get(i).getName().toLowerCase().equals(name))
				{
					System.out.println("Are you sure you want to un-Favorite: " + myPhoneBook.getFavorites().get(i).getName());
					System.out.println("Number: " + myPhoneBook.getFavorites().get(i).getNumber());
					System.out.println("Notes: " + myPhoneBook.getFavorites().get(i).getNotes());
					unfav = UtilitiesVH.readChar(scan, "(Y/N): ", "YyNn");
					
					if (unfav == 'Y' || unfav == 'y')
					{
						myPhoneBook.getFavorites().get(i).setSpeedDial(10);
						myPhoneBook.getFavorites().remove(i);
					}
					isFound = true;
				}
				else
				{
					isFound = isFound || false;
				}
			}
			
			if (!isFound)
			{
				System.out.println("The name entered is not found in your Favorites list. ");
			}
		
			System.out.print("Enter the name of the contact you wish to un-Favorite: (done to exit) ");
			name = scan.nextLine().toLowerCase();
		}
	}
	
	public static void switchFavoriteSpeedDialNumber(Scanner scan, PhoneBook myPhoneBook)
	{
		int speedDial1, speedDial2, index1, index2;
		String userInput;
		boolean isValid1, isValid2;
		
		speedDial1 = 10;
		speedDial2 = 10;
		
		index1 = 10;
		index2 = 10;
		isValid1 = false;
		isValid2 = false;
		
		System.out.print("\nEnter a speed dial number you want to switch: (done to exit) ");
		userInput = scan.nextLine().toLowerCase();
		
		while (!userInput.equals("done"))
		{
			try
			{
				speedDial1 = Integer.parseInt(userInput);
				
				for (int i = 0; i < myPhoneBook.getFavorites().size(); i++)
				{
					if (myPhoneBook.getFavorites().get(i).getSpeedDial() == speedDial1)
					{
						index1 = i;
						speedDial2 = UtilitiesVH.readInt(scan, "Enter a speed dial number you want to switch with: ", 1,5);
						isValid1 = true;
					}
					else
					{
						isValid1 = isValid1 || false;
					}
				}
				for (int j = 0; j < myPhoneBook.getFavorites().size(); j++)
				{
					if (myPhoneBook.getFavorites().get(j).getSpeedDial() == speedDial2)
					{
						index2 = j;
						isValid2 = true;
					}
					else
					{
						isValid2 = isValid2 || false;
					}
				}
				if (isValid1 && isValid2)
				{
					myPhoneBook.getFavorites().get(index1).setSpeedDial(speedDial2);
					myPhoneBook.getFavorites().get(index2).setSpeedDial(speedDial1);
					System.out.println("Speed dial number switch: success.");
				}
				else
				{
					System.out.println("There is no favorite assigned to that speed dial number. ");
				}
				
				System.out.print("\nEnter a speed dial number you want to switch: (done to exit) ");
				userInput = scan.nextLine().toLowerCase();
			}
			catch (NumberFormatException e)
			{
				System.out.println("ERROR: please enter a number between 1-5 (done to exit)");
				System.out.print("\nEnter a speed dial number you want to switch: (done to exit) ");
				userInput = scan.nextLine().toLowerCase();
			}
		}
	}

	public static void displayFavorites(Scanner scan, PhoneBook myPhoneBook)
	{
		int userInput;
		
		System.out.println("Enter the speed dial number you want contact info to be displayed: ");
		userInput = Integer.parseInt(scan.nextLine());
		
		for (int i = 0; i < myPhoneBook.getFavorites().size(); i++)
		{
			if (myPhoneBook.getFavorites().get(i).getSpeedDial() == userInput)
			{
				myPhoneBook.getFavorites().get(i).getContactFrame().displayContactImage(myPhoneBook.getFavorites().get(i));
			}
		}
		
		
	}

	public static void addContact(Scanner scan, PhoneBook myPhoneBook) 
	{
		String name, number, notes, formatNumber;
		Contact newContact;
		char another;
		boolean again;
		
		again = true;
		
		while(again)
		{
			System.out.print("\nEnter a name for your new contact: ");
			name = scan.nextLine();
			System.out.print("Enter the new contact cellphone number: ");
			number = scan.nextLine();
			while (number.length() != 10 && number.length() != 7) {
				System.out.println("Phone number is invalid, please enter a valid phone number.");
				number = scan.nextLine();
			}
			formatNumber = myPhoneBook.formatNumber(number);
			System.out.println("Please enter any notes");
			notes = scan.nextLine();
			newContact = new Contact(name,number,notes);
			
			another = UtilitiesVH.readChar(scan,"Do you want to add another contact? (Y/N)", "YyNn");
			if (another == 'N' || another == 'n')
			{
				again = false;
			}
		}
	}

	public static void editContact(Scanner scan,PhoneBook myPhoneBook)
	{
		int menu, submenu;
		char edit;
		String name, number, formatNumber, notes;
		
		System.out.println("1. Edit contact by name\n2. Edit contact by number\n 3. Go back\n");
		menu = UtilitiesVH.readInt(scan, "Enter choice: ", 1,3);
		
		while (menu != 3)
		{
			if (menu == 1)
			{
				System.out.println("Enter the name of the contact you wish to edit: ");
				name = scan.nextLine();
				
				for (int i = 0; i < myPhoneBook.getContacts().size(); i++)
				{
					if (myPhoneBook.getContacts().get(i).getName().equals(name))
					{
						System.out.println("Do you want to..\n1. Edit number\n2. Edit notes\n3. Go back\n");
						submenu = UtilitiesVH.readInt(scan, "Enter choice: ", 1,3);
						
						if (submenu == 1)
						{
							System.out.println("Name: " + myPhoneBook.getContacts().get(i).getName());
							System.out.println("Number: " + myPhoneBook.getContacts().get(i).getNumber());
							System.out.println("Notes: " + myPhoneBook.getContacts().get(i).getNotes());
							System.out.println("\nEnter new number: ");
							number = scan.nextLine();
							while (number.length() != 10 && number.length() != 7) {
								System.out.println("Phone number is invalid, please enter a valid phone number.");
								number = scan.nextLine();
							}
							formatNumber = myPhoneBook.formatNumber(number);
							myPhoneBook.getContacts().get(i).setNumber(formatNumber);
						}
						else if (submenu == 2)
						{
							System.out.println("Name: " + myPhoneBook.getContacts().get(i).getName());
							System.out.println("Number: " + myPhoneBook.getContacts().get(i).getNumber());
							System.out.println("Notes: " + myPhoneBook.getContacts().get(i).getNotes());
							System.out.println("\nEnter new notes: ");
							notes = scan.nextLine();
							myPhoneBook.getContacts().get(i).setNotes(notes);
						}
					}
				}
			}
			else if (menu == 2)
			{
				System.out.println("Enter the number of the contact you wish to edit: ");
				number = scan.nextLine();
				while (number.length() != 10 && number.length() != 7) {
					System.out.println("Phone number is invalid, please enter a valid phone number.");
					number = scan.nextLine();
				}
				formatNumber = myPhoneBook.formatNumber(number);
				for (int i = 0; i < myPhoneBook.getContacts().size(); i++)
				{
					if (myPhoneBook.getContacts().get(i).getNumber().equals(number))
					{
						System.out.println("Do you want to..\n1. Edit name\n2. Edit notes\n3. Go back\n");
						submenu = UtilitiesVH.readInt(scan, "Enter choice: ", 1,3);
						
						if (submenu == 1) //edit name
						{
							System.out.println("Name: " + myPhoneBook.getContacts().get(i).getName());
							System.out.println("Number: " + myPhoneBook.getContacts().get(i).getNumber());
							System.out.println("Notes: " + myPhoneBook.getContacts().get(i).getNotes());
							System.out.println("\nEnter new name: ");
							name = scan.nextLine();
							myPhoneBook.getContacts().get(i).setName(name);
						}
						else if (submenu == 2) //edit notes
						{
							System.out.println("Name: " + myPhoneBook.getContacts().get(i).getName());
							System.out.println("Number: " + myPhoneBook.getContacts().get(i).getNumber());
							System.out.println("Notes: " + myPhoneBook.getContacts().get(i).getNotes());
							System.out.println("\nEnter new notes: ");
							notes = scan.nextLine();
							myPhoneBook.getContacts().get(i).setNotes(notes);
						}
					}
				}
				
			}
			
			edit = UtilitiesVH.readChar(scan,"Do you want to edit another contact? (Y/N)", "YyNn");
			if (edit == 'Y' || edit == 'y')
			{
				System.out.println("1. Edit contact by name\n2. Edit contact by number\n 3. Go back\n");
				menu = UtilitiesVH.readInt(scan, "Enter choice: ", 1,3);
			}
			else
			{
				menu = 3;
			}
		}
		
	}
	
	public static void removeContact(Scanner scan, PhoneBook myPhoneBook) 
	{
		int menu;
		String name, number, formatNumber;
		char sure;
		
		System.out.println("1. Delete contact by name\n2. Delete contact by number\n3. Go back\n");
		menu = UtilitiesVH.readInt(scan, "Enter choice: ", 1,3);
		
		while (menu != 3)
		{
			if (menu == 1)
			{
				System.out.println("Enter the name of the contact you would like to delete: ");
				name = scan.nextLine();
				
				for (int i = 0; i < myPhoneBook.getContacts().size(); i++)
				{
					if (myPhoneBook.getContacts().get(i).getName().equals(name))
					{
						System.out.println("Name: " + myPhoneBook.getContacts().get(i).getName());
						System.out.println("Number: " + myPhoneBook.getContacts().get(i).getNumber());
						System.out.println("Notes: " + myPhoneBook.getContacts().get(i).getNotes());
						
						System.out.println("Are you sure you want to delete this contact? (Y/N");
						sure = UtilitiesVH.readChar(scan, "Are you sure you want to delete this contact? (Y/N", "YyNn");
						
						if (sure == 'Y' || sure == 'y')
						{
							myPhoneBook.getContacts().remove(i);
							
							for (int j = 0; j < myPhoneBook.getFavorites().size(); j++)
							{
								if (myPhoneBook.getFavorites().get(j).equals(myPhoneBook.getContacts().get(i)))
								{
									myPhoneBook.getFavorites().remove(j);
								}
							}
						}
					}
				}
			}
			else if (menu == 2)
			{
				System.out.println("Enter the number of the contact you wish to delete: ");
				number = scan.nextLine();
				while (number.length() != 10 && number.length() != 7) {
					System.out.println("Phone number is invalid, please enter a valid phone number.");
					number = scan.nextLine();
				}
				formatNumber = myPhoneBook.formatNumber(number);
				
				for (int i = 0; i < myPhoneBook.getContacts().size(); i++)
				{
					if (myPhoneBook.getContacts().get(i).getNumber().equals(formatNumber))
					{
						System.out.println("Name: " + myPhoneBook.getContacts().get(i).getName());
						System.out.println("Number: " + myPhoneBook.getContacts().get(i).getNumber());
						System.out.println("Notes: " + myPhoneBook.getContacts().get(i).getNotes());
						
						System.out.println("Are you sure you want to delete this contact? (Y/N");
						sure = UtilitiesVH.readChar(scan, "Are you sure you want to delete this contact? (Y/N", "YyNn");
						
						if (sure == 'Y' || sure == 'y')
						{
							myPhoneBook.getContacts().remove(i);
							
							for (int j = 0; j < myPhoneBook.getFavorites().size(); j++)
							{
								if (myPhoneBook.getFavorites().get(j).equals(myPhoneBook.getContacts().get(i)))
								{
									myPhoneBook.getFavorites().remove(j);
								}
							}
						}
					}
				}
			}
			System.out.println("1. Delete contact by name\n2. Delete contact by number\n3. Go back\n");
			menu = UtilitiesVH.readInt(scan, "Enter choice: ", 1,3);
		}
	}
	
	public static void displayContacts(Scanner scan, PhoneBook myPhoneBook){
		myPhoneBook.printContacts();
	}
	
}
