/*
/*Assessment: Lab Exercise 04 Task 2  
 *Student Name: Enter Hamza El Sousi
 *Lab Professor Name: David Houtman 
 *Lab Section Number: 303
 *Due Date: March 24th, 2023
 */ 

/*
 * This class represents customers' age groups and
 *  a program that does the calculations for ticket price using constructor and if-else statements.
 */
public class Customer {
	private int age;
	
	/*
	 * Comment needed
	 */
	public Customer() {
		this(0);
	}
	
	/*
	 * Comment needed
	 */
	public Customer(int age) {
		this.age = age;
	}

	/*
	 * Comment needed
	 */
	public int getAge() {
		return age;
	}

	/*
	 * Comment needed
	 */
	public void setAge(int age) {
		this.age = age;
	}
	
	/*
	 * Comment needed, document here what a return value of -1 indicates
	 * so that other programmers will know.
	 */
	public double calculateTicketPrice() {
		double price =0; // set to -1 in case the age is invalid.
		
		// if the age is less than zero, or greater than or equal to 110 return -1.0
		if(age <0 || age >= 110){
			price = -1.0;
			
		}
			// if age  age is equal to 0 or less than 3 price is $0
		 else if(age >= 0 && age <3 ) {
			price= 0.00;
		 }
			
			 else if(age >= 3 && age <=13 ) {
				 price= 7.99;
			 }
			 	else if(age >=14 && age <65 ) {
			 		price= 10.99;
			 	}
			 		else if(age >= 65 && age <=110) {
			 			price= 8.50;
			 		}	
			 			else {
			 			}
			
				
	
		// use if statements with ranges to determine the price.
		// return the determined price
		
		return price; 
	}
	
}
