
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
 * References (in order of the lab handout)
 * [1]   The Government of Canada’s Department of Fisheries and Oceans Canada (DFO) Website
 * – Offshore lobster and Jonah crab - Maritimes Region. Para 1.3.1 Management approach
 * https://www.dfo-mpo.gc.ca/fisheries-peches/ifmp-gmp/lobster-crab-homard/2019/index-eng.html
 * (Accessed February 27, 2023)
 * [2]  Wikipedia The Free Encyclopedia – Definition of Carapace.
 * https://en.wikipedia.org/wiki/Carapace
 * [3] A. Morgana. Rubber Duck Debugging: Why it is the best way to debug your code. Blog.zenhub.com.
 * https://blog.zenhub.com/why-rubber-duck-debugging-is-the-best-way-to-debug-your-code/ (Accessed February 27, 2023)
 */

/*
 * This class represents a Lobster with carapace length,
 * as well as a worker method that determines if a trapped Lobster
 * can be kept, or needs to be released back into the ocean.
 */
import java.util.Scanner;
public class Lobster {
	private static final double MINIMUM_CARAPACE_LENGTH = 82.5; // millimeters (mm) [1]
	
	private double length; 
	
	/*
	 * no-argument constructor, sets length to zero.
	 */
	public Lobster() {
		this(0.0);
	}
	
	/*
	 * Parameterized constructor, accepts a value for
	 * length
	 */
	
	/*
	 * Added accessor to qualify length.   
	 * this.legnth
	 */
	public Lobster(double length) {
		this.length = length; 
	}
	
	/*
	 * accessor for length
	 */
	public double getLength() { 
		return length;
	}
	
	/*
	 * mutator for length
	 */
	public void setLength(double length) {
		this.length = length;
	}
	
	/*
	 * worker method that reports if a Lobster can be kept
	 * or needs to be released, based on the length,
	 * which must be greater than the MINIMUM_CARAPACE_LENGTH
	 */
	public String sizeReport() {
		boolean isTooSmall;
		String report;
		/*
		 * Added an assignment operator (=) after (<) to correct the logic for MINIMUM_CARAPACE_LENGTH 
		 * to match program requirement: if length equals 82.5 or less.  
		*/
		isTooSmall = length <= MINIMUM_CARAPACE_LENGTH; 
		/*
		 * Added an assignment operator (=) so the if/else can compile properly. 
		 * Otherwise the boolean statement will always
		 * remain true because isTooSmall was assigned to true, rather than if equals true. 
		 */
		if(isTooSmall == true ) { 
			report = "Prohibited Size";
		}
		else {
			report = "Legal Size";
		} 
		
		return report;
	}
}
