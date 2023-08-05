/*
 * Student Name: Hamza El Sousi
 * Lab Professor: Professor David Houtman
 * Due Date: March 31st, 2023 
 * Description: Assignment 02 (22W) Sample Solution  Update of original concept
 *              by Professor Stanley Pieda
 */
 

 /* This class is the main entry point for Assignment 02. It prompts the user
 * to enter dimensions for lumber and checks if the lumber is within
 * specifications for thickness, width, and length using the LumberChecker class.
 */
import java.util.Scanner;

public class Assignment02 {

	/* 
	 * This method is the main entry point of the program. It prompts the user
	 * to enter dimensions for lumber and checks if the lumber is within
	 * specifications for thickness, width, and length.
	 */
	public static void main(String[] args) {

		// create a LumberChecker object to validate the lumber dimensions
		LumberChecker lumberChecker = new LumberChecker();

		// create a User object to get user input
		User user = new User();

		// create a Scanner object to read user input from the keyboard
		Scanner keyboard = new Scanner(System.in);

		// initialize continueInput to "yes" to start the loop
		String continueInput = "yes";

		// loop until the user enters "no" when asked to continue
		do {
			System.out.println("Enter dimensions for lumber");
			System.out.println("Expected values for dimensions are 1.50 for thickness, 5.50 for width, 192.00 for length");

			// get user input for lumber dimensions
			double thickness = user.inputDouble("Enter measured thickness (inches): ");
			double width = user.inputDouble("Enter measured width (inches): ");
			double length = user.inputDouble("Enter measured length (inches): ");

			// create a DimensionalLumber object with the user input dimensions
			DimensionalLumber lumber = new DimensionalLumber(thickness, width, length);

			// display the dimensions of the lumber
			System.out.println(lumber.toString());

			// validate the lumber dimensions using LumberChecker
			String report = lumberChecker.validate(lumber);
			System.out.println(report);

			// display modification information and ask user if they want to continue
			System.out.println("Program modified by: Hamza El Sousi");
			System.out.println("Do you have more data to enter? (yes/no)");
			continueInput = keyboard.nextLine().toLowerCase();
			
		} while (continueInput.equals("yes"));

		// display message to indicate the program is shutting down
		System.out.println("Program will now shutdown.");
	}
}
