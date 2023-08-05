/*
/*Assessment: Lab Exercise 04 Task 2  
 *Student Name: Enter Hamza El Sousi
 *Lab Professor Name: David Houtman 
 *Lab Section Number: 303
 *Due Date: March 24th, 2023
 */ 

import java.util.Scanner;

/*
 * utilizing java scanner to input age
 */
public class Exercise04 {

	/*
	 * Modification: declared data type for age and price.
	 */
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		Customer customer = new Customer();
		int age;
		double price;
		
		System.out.printf("Enter age: ");
		age = keyboard.nextInt();
		customer.setAge(age);
		
		price = customer.calculateTicketPrice();
		if (age >= 110 || age <0)  {
			System.out.printf("Invalid age entered.");	
		}
		else {
		System.out.printf("Price is: $%.2f\n" , price);
	}
		System.out.println("\nProgrammed by: Hamza El Sousi");
		
		
		//Suggestion: get the inputs, use an if to check the age
		// if the age is invalid, just report an error and stop
		// if the age is valid, set the values into the object and 
		// use the worker method to obtain the ticket price.
		// OR
		// detect if the returned price is less than zero and then
		// report an error message instead of a price.

	}
}
