/*Assessment: Lab Exercise 04 Task 1:Lobster 
 *Student Name: Enter Hamza El Sousi
 *Lab Professor Name: David Houtman 
 *Lab Section Number: 303
 *Due Date: March 24th, 2023
 */


/*
 * Lab Exercise 04 (23W) Task 1 Starter Code
 * Author: David Haley
 * Modified By: Hamza El Sousi
 * Desciption: Lab Exercise 04 Task 1
 * 
 * [1]   The Government of Canada’s Department of Fisheries and Oceans Canada (DFO) Website
 * – Offshore lobster and Jonah crab - Maritimes Region. Para 1.3.1 Management approach
 * https://www.dfo-mpo.gc.ca/fisheries-peches/ifmp-gmp/lobster-crab-homard/2019/index-eng.html
 * (Accessed February 27, 2023)
 * [2]  Wikipedia The Free Encyclopedia – Definition of Carapace.
 * https://en.wikipedia.org/wiki/Carapace
 * [3] A. Morgana. Rubber Duck Debugging: Why it is the best way to debug your code. Blog.zenhub.com.
 * https://blog.zenhub.com/why-rubber-duck-debugging-is-the-best-way-to-debug-your-code/ (Accessed February 27, 2023)
 */

	import java.util.Scanner;

/*
 * This class uses class Lobster to provide a report
 * to indicate if a Lobster is a legal size or a prohibited size,
 * based on its carapace length.
 */
	public class LobsterSizeChecker {

	/*
	 * The main method asks for a length, uses an instance 
	 * of class Lobster to generate a report, and writes
	 * the report to the console.
	 */
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		Lobster myLobster = new Lobster();
		double length;
		String report;
		
		/*
		*The code was missing a length setter for myLobster. Added Setter with length
		*as the setLength(argument parameter). 
		*/
		
		System.out.printf("%s", "Lobster’s Carapace Length: ");
		length = keyboard.nextDouble();
		myLobster.setLength(length);
		
		report = myLobster.sizeReport();
		
		System.out.printf("%s%n", report);
		System.out.printf("%s%n", "Programmed by Hamza El Sousi");
		
	}

}
