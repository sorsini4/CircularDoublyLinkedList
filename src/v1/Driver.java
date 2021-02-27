package v1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/*
 * Purpose: Data Structure and Algorithms Lab 4 Problem 1
 * Status: Incomplete, everything works as should besides the reverse method.
 * Last update: 10/08/20
 * Submitted:  10/08/20
 * Comment: test suite and sample run attached
 * @author: Steven Orsini
 * @version: 2020.10.08
 */
public class Driver {

	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) {
		
		ListCDLS<String> userList = new ListCDLS<String>();
		
		boolean done = false;
		
		while(!done) {
			try {
				System.out.print("0. Exit Program \n1. Insert item to the list\n"
						+ "2. Remove item from the list \n3. Get an item from the list\n"
						+ "4. Clear the list\n5. Display size and content of the list\n"
						+ "6. Reverse the list\n> ");
				int userAnswer = Integer.parseInt(input.readLine());
				switch(userAnswer) {
					case 0:
						System.out.println("Goodbye.");
						System.exit(0);
						break;
					case 1:
						insertItem(userList);
						break;
					case 2:
						removeItem(userList);
						break;
					case 3:
						getItem(userList);
						break;
					case 4:
						clearList(userList);
						break;
					case 5:
						display(userList);
						break;
					case 6:
						userList = reverseList(userList);
						break;						
					default:
						System.out.println("Please choose an option.");
				}

			}
			catch(NumberFormatException e) {
				System.out.println("Please enter a number 1-8.");
			} 
			catch (IOException e1) {
				System.out.println("Caught: " + e1);
			}
		}
	}

	public static void insertItem(ListCDLS<String> userList) {
		try {	
			System.out.print("Enter item: ");
			String item = input.readLine();
			System.out.print("Enter the index: ");
			int index = Integer.parseInt(input.readLine());
			userList.add(index, item);
			System.out.println("Inserted " + item + " into position " + index + " in the list.");
		}
		catch(ListIndexOutOfBoundsException e) {
			System.out.println("Specified index out of range!");
		}
		catch(NumberFormatException e1) {
			System.out.println("Please enter a number, try again.");
			insertItem(userList);
		}
		catch(IOException e2) {
			System.out.println("Caught: " + e2);
		}
	}
	
	public static void removeItem(ListCDLS<String> userList) {
		try {
			System.out.print("Enter the position to remove the item from: ");
			int index = Integer.parseInt(input.readLine());
			String name = (String) userList.get(index);
			userList.remove(index);
			System.out.println("Item " + name  + " removed from position " + index + " in the list.");
		}
		catch(ListIndexOutOfBoundsException e) {
			System.out.println("Specified index out of range!");
		}
		catch(NumberFormatException e1) {
			System.out.println("Please enter a number, try again.");
			removeItem(userList);
		}
		catch(IOException e2) {
			System.out.println("Caught: " + e2);
		}
		
	}
	
	public static void getItem(ListCDLS<String> userList) {
		try {
			System.out.print("Enter position to retrieve the item from: ");
			int index = Integer.parseInt(input.readLine());
			System.out.println("Item " + userList.get(index) + " retrieved from position "
					+ index + " in the list.");
		}
		catch(ListIndexOutOfBoundsException e) {
			System.out.println("Specified index out of range!");
		}
		catch(NumberFormatException e1) {
			System.out.println("Please enter a number, try again.");
			getItem(userList);
		}
		catch(IOException e2) {
			System.out.println("Caught: " + e2);
		}
		catch(NullPointerException e3) {
			System.out.println("Specified index out of range!");
		}
		
	}
	
	public static void clearList(ListCDLS<String> userList) {
		if(userList.isEmpty()) {
			System.out.println("List is empty! Nothing to clear.");
		}
		else {
			userList.removeAll();
			System.out.println("Cleared the list!");
		}
	}
	
	public static void display(ListCDLS<String> userList) {
		if(userList.isEmpty()) {
			System.out.println("List is empty! Nothing to show.");
		}
		else {
			System.out.println("List of size " + userList.size() + " has the following items: "
					+ userList.toString());
		}
	}
	
	public static ListCDLS<String> reverseList(ListCDLS<String> userList) {
		int size = userList.size();
		ListCDLS<String> temp = new ListCDLS<String>();

		if(userList.isEmpty() || size <= 1) {
			System.out.println("List is empty, or does not contain enough elements! "
					+ "Nothing to reverse.");
			return userList;
		}
		else {
			for(int i = 0; i < size; i++) {
				temp.add(0, userList.get(i));
			}
			System.out.println("List has been reversed.");
			return temp;
		}
	}
	
}