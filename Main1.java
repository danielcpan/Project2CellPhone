import java.util.*;
import java.io.*;

public class Main1 {

	public static void main(String[] args) {
		Scanner answer = new Scanner(System.in);
		Contact contact1 = new Contact();
		Favorite favContact = new Favorite();
		PhoneBook book = new PhoneBook();
		PhoneCall call1 = new PhoneCall();
		CallHistory history = new CallHistory();
		
		System.out.println("Pick 1 of the 5 choices:");
		System.out.println("1. Make a call.");
		System.out.println("2. Receive a call.");
		System.out.println("3. Access the top 5 contacts.");
		System.out.println("4. Access the phone book.");
		System.out.println("5. Access the call history.");
		int response = answer.nextInt();
		answer.nextLine();
		switch(response)
		{
		case 1:
			System.out.println("Call from 1 of the 3 options:");
			System.out.println("1. Call by number.");
			System.out.println("2. Call by name.");
			System.out.println("Call from favorites");
			int response1 = answer.nextInt();
			answer.nextLine();
			switch(response1)
			{
			case 1:
				int areaCode = (int) Math.random()*999;
				int firstNumber = (int)Math.random()*999;
				int secondNumber = (int) Math.random()*9999;
				break;
			case 2:
				break;
			case 3:
				System.out.println("Would you like to display 1 of the favorites?");
				String answer1 = answer.nextLine();
				if(answer1.equalsIgnoreCase("Yes"))
				{
					System.out.println("Which favorites information do you want displayed");
					String response2 = answer.nextLine();
					for (int i = 0; i < book.getFavoriteSize(); i++)
					{
						if(response2.equals(book.getSpeedDial(i)))
						{
							
						}
					}
				}
				break;
			}
			break;
		case 2:
			break;
		case 3:
			break;
		case 4:
			break;
		case 5:
			break;
		}

	}

}

