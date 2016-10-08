import java.util.Scanner;

public class Main1 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		//Favorite favContact = new Favorite();
		PhoneBook book = new PhoneBook();
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
		PhoneBook.contactsToString();
		//System.out.println("ssssssssssssssssssssssssssssssssss");
		//PhoneBook.compareContacts();
		//PhoneBook.contactsToString();
		/////////////////////////////////////////////
		//TESTING PURPOSES: FAVORITES
		Contact one = new Contact("Timmy", "7630589246", "Yummy");
		Contact two = new Contact("Hercules", "9239036", "You're so strong ;) ");
		Contact three = new Contact("Armani", "9282937345", "Sameeeeeee");
		Contact four = new Contact("Gucci", "8720182", "WTF CALVIN HARRIS != TAYLOR SWIFT");
		Contact five = new Contact("Cleo", "4522834", "First love");
		Favorite top1 = new Favorite(one,1);
		Favorite top2 = new Favorite(two,2);
		Favorite top3 = new Favorite(three,3);
		Favorite top4 = new Favorite(four,4);
		Favorite top5 = new Favorite(five,5);
		PhoneBook.addFavorite(top1);
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
		System.out.println("Pick 1 of the 5 choices:");
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
			System.out.println("Call from 1 of the 3 options:");
			System.out.println("1.Call by number.");
			System.out.println("2.Call by name.");
			System.out.println("3.Call from favorites");
			int response1 = scan.nextInt();
			scan.nextLine();
			switch(response1)
			{
			//Call by Number
			case 1:
				System.out.println("What is the number you would like to call");
				String number = scan.nextLine();
				for(int a = 0; a < PhoneBook.getContactSize(); a++){
					if (number.equals(PhoneBook.getContactArrayList().get(a).getNumber())){
						System.out.println("You called " + PhoneBook.getContactArrayList().get(a).getName());
						
					}
				}
				break;
			//Call by Name
			case 2:
				System.out.println("What is name of the person you would like to call?");
				String name = scan.nextLine();
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
			int areaCode = (int) (Math.random()*999);
			int firstNumber = (int)(Math.random()*999);
			int secondNumber = (int) (Math.random()*9999);
			System.out.println("Ring Ring Ring.........\nYou are getting a call from " + "(" + areaCode + ")" + firstNumber + "-" + secondNumber);
			System.out.println("Do you want to pick up? (y/n)");
			String answer = scan.nextLine();
			boolean validAns = false;
			while(!validAns){
			if(answer.equals("y")){
				System.out.println("You picked up, Call was recorded.");			
				validAns = true;
			}
			else if(answer.equals("n")){
				System.out.println("You declined the call.");
				validAns = true;
			}
			else{
				System.out.println("Enter a valid command.");
				answer = scan.nextLine();
			}
			}
			break;
		////////////////////////////////////////////////////////////
		//Access Top 5
		case 3:
			/*System.out.println("Would you like to display 1 of the favorites?");
			String answer1 = scan.nextLine();
			if(answer1.equalsIgnoreCase("Yes"))
			{
				System.out.println("Which favorites information do you want displayed");
				String answer2 = scan.nextLine();
				for (int i = 0; i < book.getFavoriteSize(); i++)
				{
					//if(answer2.equals(book.getSpeedDial(i)))
					{
						
					}
				}
			}*/
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
			//Displaying a contact
			case 3:
				System.out.println("Your Phone book.");
				System.out.println("-------------------------------------");
				PhoneBook.contactsToString();
				System.out.println("Would you like to call one of your contacts?");
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
		case 6:
			end = true;
			break;
		}
		}

		
		
	}

}
