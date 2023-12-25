
/**
 * Student Name:Hamza El Sousi
 * Student Number:040982818
 * Course: CST8132 Object Oriented Programming
 * Program: CET-CS-Level 2
 * Professor: James Mwangi PhD.
 * Description: This class has the main method, selection structures, and loops for encryption program
  */
import encryptions.Encryptable;
import encryption.ciphers.CaesarCipher;
import encryption.ciphers.VigenereCipher;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Hamza El Sousi
 * @version 2.2
 * 
 */
public class Lab5Test {
	private Scanner input;
	private ArrayList<String> encryptedText;

	/**
	 * @return the encryptedText
	 */
	public ArrayList<String> getEncryptedText() {
		return encryptedText;
	}

	/**
	 * @param encryptedText the encryptedText to set
	 */
	public void setEncryptedText(ArrayList<String> encryptedText) {
		this.encryptedText = encryptedText;
	}

	/**
	 * Constructs a Lab5Test object. Initializes the Scanner for user input and the
	 * ArrayList to store encrypted texts.
	 */
	public Lab5Test() {
		input = new Scanner(System.in);
		setEncryptedText(new ArrayList<>());
	}

	/**
	 * Displays the menu options and gets the user's selected menu item.
	 *
	 * @param options The menu options. Varargs allows for arbitrary arguments/parameters
	 * @return The selected menu item.
	 */
	private int getMenuItem(String... options) {
	    int choice = -1;

	    while (choice < 1 || choice > options.length) {
	        System.out.println("\nEncryption tester\n");
	        for (int i = 0; i < options.length; i++) {
	            System.out.println("     " + (i + 1) + " - " + options[i]);
	        }
	        System.out.print("\nSelected action: ");

	        if (input.hasNextInt()) {
	            choice = input.nextInt();
	            input.nextLine(); // Consume the newline character

	            if (choice < 1 || choice > options.length) {
	                System.out.println("\nPlease select a number in the range\n");
	            }
	        } else {
	            input.nextLine(); // Clear invalid input
	            System.out.println("\nPlease enter an integer\n");
	        }
	    }

	    return choice;
	}


	/**
	 * Gets a string input from the user.
	 *
	 * @param prompt The prompt to display.
	 * @return The user's input string.
	 */
	private String getString(String prompt) {
		System.out.print(prompt + ": ");
		return input.nextLine();
	}

	/**
	 * Gets an integer input from the user.
	 *
	 * @param prompt The prompt to display.
	 * @return The user's input integer.
	 */
	private int getInt(String prompt) {
		int number = -1;

		while (number < 0) {
			System.out.print(prompt + ": ");

			if (input.hasNextInt()) {
				number = input.nextInt();
				input.nextLine();} // Consume the newline character
				
//			 if (input.hasNextInt(0 <= 5));{
//					System.out.println("Please select a number in range");
//					
//				}
			else {
				input.nextLine(); // Clear invalid input
				System.out.println("\nPlease enter an integer\n");
			}
		}

		return number;
	}

	/**
	 * The main method of the program. Executes the encryption lab functionality.
	 *
	 * @param args The command-line arguments.
	 */
	public static void main(String[] args) {
		System.out.println("Welcome to the Encryption Lab");

		ArrayList<String> encryptedText = new ArrayList<>();
		Lab5Test lab = new Lab5Test();

		int choice;
		do {
			choice = lab.getMenuItem("Encrypt text", "Decrypt text", "Display encrypted list", "Exit");

			switch (choice) {
			case 1:
				System.out.println();
				String textToEncrypt = lab.getString("Please enter text to be encrypted");
				int encryptionMethodChoice = lab.getMenuItem("Caesar", "Vigenere");
				Encryptable encryptionMethod = null;

				if (encryptionMethodChoice == 1) {
					int shift = lab.getInt("Shift value");
					encryptionMethod = new CaesarCipher(shift);
				} else if (encryptionMethodChoice == 2) {
					String password = lab.getString("Password");
					encryptionMethod = (Encryptable) new VigenereCipher(password);
				}

				if (encryptionMethod != null) {
					String encrypted = encryptionMethod.encrypt(textToEncrypt);
					encryptedText.add(encrypted);
					System.out.println("Encrypted value #" + encryptedText.size() + " is: " + encrypted);
				}
				break;
			// will print "Nothing to decrypt" if index of encrypted items is empty
			// Otherwise will prompt the user to select encrypted text by entering an int
			// type
			case 2:
				if (encryptedText.isEmpty()) {
					System.out.println("\n------------");
					System.out.println("Nothing to decrypt");
					System.out.println("------------");
				} else {
					System.out.println();
					int messageNumber = lab.getInt("Message number you want to decrypt");
					if (messageNumber >= 1 && messageNumber <= encryptedText.size()) {
						encryptionMethodChoice = lab.getMenuItem("Caesar", "Vigenere");
						Encryptable decryptionMethod = null;

						if (encryptionMethodChoice == 1) {
							int shift = lab.getInt("Shift value");
							decryptionMethod = new CaesarCipher(shift);
						} else if (encryptionMethodChoice == 2) {
							String password = lab.getString("Password");
							decryptionMethod = (Encryptable) new VigenereCipher(password);
						}

						if (decryptionMethod != null) {
							String encryptedMessage = encryptedText.get(messageNumber - 1);
							String decrypted = decryptionMethod.decrypt(encryptedMessage);
							System.out.println("Decrypted value #" + messageNumber + " is: " + decrypted);
						}
					} else {
						System.out.println("\nPlease select a number in the range\n");
					}
				}
				break;
			// Case 3 will check if index is empty and will print "Nothing to display"
			// Otherwise it will count the params in the index and print them as list format
			case 3:
				System.out.println("------------");
				if (encryptedText.isEmpty()) {
					System.out.println("Nothing to display");
				} else {
					for (int i = 0; i < encryptedText.size(); i++) {
						System.out.println("#" + (i + 1) + ": " + encryptedText.get(i));
					}
				}
				System.out.println("------------");
				break;

			// This case exits the program
			case 4:
				System.out.println("Good bye");
				System.out.println("Program by Hamza El Sousi");
				break;
			default:
				System.out.println("\nPlease select a number in the range\n");
				break;
			}

		} while (choice != 4);

	}
}
/*
 * REFERENCE : The ASCII table I referred to while making this program is listed
 * below.
 * 
 * https://www.rapidtables.com/code/text/ascii-table.html
 */
