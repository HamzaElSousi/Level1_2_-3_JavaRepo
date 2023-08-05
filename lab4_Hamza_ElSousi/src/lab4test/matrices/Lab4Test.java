/*
 * Description: The main method of the image processing application
 * Student Name: Hamza El Sousi 
 * StudentID 040982818
 * Due Date: June 24, 2023
 * Program: CET-CS CST8132
 * Lab Professor: James Mwangi PhD.
 */

package lab4test.matrices;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import javax.swing.JFileChooser;

/**
 * @author owner This class is a test class for the other classes in the package
 *
 */
public class Lab4Test {

	/**
	 * Fields Description: Kernels that can be used to do image processing based on
	 * https://en.wikipedia.org/wiki/Kernel_(image_processing)
	 * 
	 * kernels Array of convolution kernels
	 */
	private NamedMatrix[] kernels = {
			new NamedMatrix("identity", new double[][] { { 0, 0, 0 }, { 0, 2, 0 }, { 0, 0, 0 } }),

			new NamedMatrix("ridge", new double[][] { { -1, -1, -1 }, { -1, 10, -1 }, { -1, -1, -1 } }),

			new NamedMatrix("sharpen", new double[][] { { 0, -1, 0 }, { -1, 7, -1 }, { 0, -1, 0 } }),

			new NamedMatrix("unsharpen masking 5x5",
					new double[][] { { -1.0 / 257, -1.0 / 65, -3.0 / 128, -1.0 / 65, -1.0 / 257 },
							{ -1.0 / 65, -16.0 / 257, -3.0 / 65, -16.0 / 257, -1.0 / 65 },
							{ -3.0 / 128, -3.0 / 65, 119.0 / 65, -3.0 / 65, -6.0 / 257 },
							{ -1.0 / 65, -16.0 / 257, -3.0 / 65, -16.0 / 257, -1.0 / 65 },
							{ -1.0 / 257, -1.0 / 65, -3.0 / 128, -1.0 / 65, -1.0 / 257 } }),

			new NamedMatrix("laplace", new double[][] { // ridge + identity
					{ -1, -1, -1 }, { -1, 12, -1 }, { -1, -1, -1 } }) };

	/**
	 * Prompts the user to select a text file using a file chooser panel using the
	 * Jfilechooser from API.
	 *
	 * @return The selected image file.
	 */
	public File getImageFile() {
		JFileChooser chooser = new JFileChooser();
		int returnVal = chooser.showOpenDialog(null);
		File file;
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			file = chooser.getSelectedFile();
			System.out.println("You chose to open this file: " + file.getAbsolutePath());
		} else {
			file = new File("noneExistent");
			System.out.println("No file chosen");
		}
		return file;
	}

	/**
	 * Prompts the user to select a kernel filter and returns the corresponding
	 * NamedMatrix object.
	 *
	 * @return The selected kernel filter as a NamedMatrix object.
	 */
	public NamedMatrix getKernel() {
		while (true) {
			System.out.println("Please select one of the following filters:");
			for (int i = 0; i < kernels.length; i++) {
				System.out.println((i + 1) + ". " + kernels[i].getName());
			}
			int filterSelection = getUserInputInteger("Select a filter: ");
			if (filterSelection >= 1 && filterSelection <= kernels.length) {
				return kernels[filterSelection - 1];
			} else {
				System.out.println("Selection out of range. Enter an integer 1-5.");
			}
		}
	}

	/**
	 * Prompts the user to enter an integer input with the specified prompt message.
	 *
	 * @param prompt The prompt message to display.
	 * @return The integer input provided by the user.
	 */
	private int getUserInputInteger(String prompt) {
		Scanner scanner = new Scanner(System.in);
		int input;
		while (true) {
			try {
				System.out.print(prompt);
				input = scanner.nextInt();
				break;
			} catch (Exception e) {
				System.out.println("Invalid input. Please enter a valid integer from 1-5.");
				scanner.nextLine(); // Consume the remaining newline character
			}
		}
		return input;

	}

	/**
	 * @param args main method below with do,while loop
	 */
	// main method
	public static void main(String[] args) {
		Lab4Test lab4 = new Lab4Test();
		Scanner scanner = new Scanner(System.in);
		boolean continueProgram = true;

		do {
			File imageFile = lab4.getImageFile();
			if (!imageFile.exists()) {
				System.out.println("File does not exist. Please try again.");

			}

			NamedMatrix kernel = lab4.getKernel();

			try {
				Matrix originalImage = new FileMatrix(imageFile);
				Convolution convolution = new Convolution(kernel);
				FileMatrix filteredImage = new FileMatrix(convolution.filter(originalImage));
				String fileName = imageFile.getAbsolutePath();
				int dot = fileName.indexOf('.');
				String output = fileName.substring(0, dot) + "-" + kernel.getName() + fileName.substring(dot);
				File outputFile = new File(output);
				if (filteredImage.save(outputFile)) {
					System.out.println("File: " + output + " successfully written");
				} else {
					System.out.println("Could not write file: " + output);
				}
				// exception handling
			} catch (FileNotFoundException e) {
				System.out.println("Could not find file: " + imageFile.getAbsolutePath());
			} catch (IOException e) {
				System.out.println("An error occurred while processing the image: " + e.getMessage());
			} catch (NoSuchElementException e) {
				System.out.println("Error reading matrix data from file. Make sure the file is formatted correctly.");
			}
			// Prompts user to enter Y to continue program. Otherwise, program ends.
			System.out.print("Enter (Y) to continue program, otherwise program will exit:");
			String choice = scanner.nextLine().trim().toLowerCase();
			if (!choice.equals("y")) {
				continueProgram = false;
				System.out.println("Program ended \nProgram by Hamza El Sousi");
			}
		} while (continueProgram);
		scanner.close();
		scanner.close();

	}
}