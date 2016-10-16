//Victoria Hong
//CECS 274H

package utilitiesVH;

import java.util.Scanner;
import homework2.Item;

public class UtilitiesVH 
{
	// DESCRIPTION:		reads input from user, returns char value (error-checked using validChars)
	// PRECONDITIONS:	key is instantiated
	// POSTCONDITIONS:	result is char value if validChars.indexOf(result) returns a number not -1
	//					(meaning the index is found so result is in validChars), buffer still has
	//					whitespace
	public static char readChar(Scanner keyboard, String prompt, String validChars)
	{
		String temp;
		char result;
		boolean isNotValid;
		
		do
		{
			System.out.print(prompt);
			temp = keyboard.nextLine();
			
			isNotValid = (validChars.indexOf(temp) == -1);
			
			if (isNotValid)
			{
				System.out.println("ERROR: please enter a valid char such as " + validChars + "\n");
			}
			
		} while (isNotValid);
		
		result = temp.charAt(0);
			
		return result;
	}
	
	// DESCRIPTION:		reads input from user, returns double value (error-checked using bounds)
	// PRECONDITIONS:	key is instantiated, lower < upper
	// POSTCONDITIONS:	returns a double between lower and upper values, inclusive, buffer still has whitespace
	public static double readDouble(Scanner keyboard, String prompt, double bound)
	{
		String temp;
		double result;
		boolean isNotValid;
		
		isNotValid = true;
		result = 0;
		
		do
		{
			System.out.print(prompt);
			temp = keyboard.nextLine();
			
			try
			{
				result = Double.parseDouble(temp);
				isNotValid = (result < bound);
				
				if (isNotValid)
				{
					System.out.println("ERROR: please enter value greater than " + bound);
				}
			}
			catch (NumberFormatException nfe)
			{
				System.out.println("ERROR: decimal input required" );
			}
			
		} while (isNotValid);
		
		return result;
	}
	
	// DESCRIPTION:		reads input from user, returns integer value (error-checked using bounds)
	// PRE-CONDITIONS:	key is instantiated, lower < upper
	// POST-CONDITIONS:	returns integer value between lower and upper (inclusive)
	public static int readInt(Scanner keyboard, String prompt, int lowerBound, int upperBound)
	{
		String temp;
		int result;
		boolean isNotValid;
		
		isNotValid = true;
		result = 0;
		
		do
		{
			System.out.print(prompt);
			temp = keyboard.nextLine();
			
			try
			{
				result = Integer.parseInt(temp);
				isNotValid = (result < lowerBound || result > upperBound);
			
				if (isNotValid)
				{
					System.out.println("ERROR: please enter a value between " + lowerBound + " and " + upperBound);
				}
			}
			catch (NumberFormatException nfe)
			{
				if (temp.equals("done"))
				{
					return -1;
				}
				else
				{
					System.out.println("ERROR: please enter an integer between 1-5. ");
				}
			}
			
		} while (isNotValid);
		
		return result;
	}
	
//overloaded, gets positive int
	public static int readInt(Scanner keyboard, String prompt, int lowerBound)
	{
		String temp;
		int result;
		boolean isNotValid;
		
		isNotValid = true;
		result = 0;
		
		do
		{
			System.out.print(prompt);
			temp = keyboard.nextLine();
			
			try
			{
				result = Integer.parseInt(temp);
				isNotValid = (result < lowerBound);
			
				if (isNotValid)
				{
					System.out.println("ERROR: please enter a value greater than " + lowerBound);
				}
			}
			catch (NumberFormatException nfe)
			{
				System.out.println("ERROR: please enter one of the following integers (or done to stop)");
			}
			
		} while (isNotValid);
		
		return result;
	}

	//DESCRIPTION:		sorts itemsArray and keeps costsArray and itemsCount arrays parallel
	//PRE-CONDITIONS:	parameter values are valid
	//POST-CONDITIONS:	arrays are changed via reference so void
	public static void sortArrays(String[] itemsArray, double[] costsArray, int[] itemCount)
	{
		int indexOfNextSmallest, temp2;
		String temp;
		double temp1;
		
		for (int i = 0; i < itemsArray.length - 1; i++)
		{
			indexOfNextSmallest = indexOfSmallest(i, itemsArray);
			
			temp = itemsArray[i];
			temp1 = costsArray[i];
			temp2 = itemCount[i];
			itemsArray[i] = itemsArray[indexOfNextSmallest];
			costsArray[i] = costsArray[indexOfNextSmallest];
			itemCount[i] = itemCount[indexOfNextSmallest];
			itemsArray[indexOfNextSmallest] = temp;
			costsArray[indexOfNextSmallest] = temp1;
			itemCount[indexOfNextSmallest] = temp2;
		}
	}

//overloaded
	public static void sortArrays(Item[] items, int[] itemCount)
	{
		int indexOfNextSmallest, temp1;
		Item temp;
		
		temp = new Item();
		
		for (int i = 0; i < items.length - 1; i++)
		{
			indexOfNextSmallest = indexOfSmallest(i, items);
			
			temp = items[i];
			temp1 = itemCount[i];
			items[i] = items[indexOfNextSmallest];
			itemCount[i] = itemCount[indexOfNextSmallest];
			items[indexOfNextSmallest] = temp;
			itemCount[indexOfNextSmallest] = temp1;
		}
	}
	
	//DESCRIPTION:		gets the index of the smallest value from the startIndex parameter
	//PRE-CONDITIONS:	parameter values are valid
	//POST-CONDITIONS:	returns int indexOfMin
	private static int indexOfSmallest(int startIndex, String[] itemsArray)
	{
		int min, index, indexOfMin;
		
		min = (int)itemsArray[startIndex].charAt(0);
		indexOfMin = startIndex;
		
		for (index = startIndex + 1; index < itemsArray.length; index++)
		{
			if ((int)itemsArray[index].charAt(0) < min)
			{
				min = (int)itemsArray[index].charAt(0);
				indexOfMin = index;
			}
		}
		return indexOfMin;
	}
	
//overloaded
	private static int indexOfSmallest(int startIndex, Item[] items)
	{
		int min, index, indexOfMin;
		
		min = (int)(items[startIndex].getItem()).charAt(0);
		indexOfMin = startIndex;
		
		for (index = startIndex + 1; index < items.length; index++)
		{
			if ((int)(items[index].getItem()).charAt(0) < min)
			{
				min = (int)(items[index].getItem()).charAt(0);
				indexOfMin = index;
			}
		}
		return indexOfMin;
	}
}
