/*Assessment: Lab Assignment 1
 *Student Name:Hamza El Sousi
 *Lab Professor Name: Leanne Seaward
 *Lab Section Number: CST_8116_302
 *Due Date: June 9th, 2023
 */

/**
 * Assignment 01 - Calculate Volume of a Donut
 * 
 * This program calculates the volume of a donut (torus) based on the provided formula.
 * The formula used for the volume calculation is V = (1/4) * π^2 * (R^2 - r^2) * (R - r),
 * where R is the outer radius, and r is the inner radius of the donut.
 * 
 * Formula Source: https://www.had2know.org/academics/torus-volume-surface-area-calculator.html
 * 
 * Program by Hamza El Sousi
 */

// import scanner API
import java.util.Scanner;

public class Main {
	// main method
	public static void main(String[] args) {
		// scanner instance to collect user input
		Scanner scanner = new Scanner(System.in);
		// prints request to input outer radius
		System.out.print("Enter outer radius: ");
		double outerRadius = scanner.nextDouble();
		// prints request to input inner radius
		System.out.print("Enter inner radius: ");
		double innerRadius = scanner.nextDouble();
		// instance of new donut with parameters 
		Donut donut = new Donut(outerRadius, innerRadius);
		double volume = donut.computeDonutVolume();
		// prints report 
		System.out.printf("Volume is %.2f", volume);
		System.out.printf("\nProgram by Hamza El Sousi");
	}
}