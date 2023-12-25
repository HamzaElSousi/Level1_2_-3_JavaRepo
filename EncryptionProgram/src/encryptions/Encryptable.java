/**
 * Student Name:Hamza El Sousi
 * Student Number:040982818
 * Course: CST8132 Object Oriented Programming
 * Program: CET-CS-Level 2
 * Professor: James Mwangi PhD.
 * Lab Professor: Fedor Ilitchev 
 * Description: Interface Encryptable will be implemented by classes CaesarCipher and VigenereCipher. 
  */

package encryptions;

/**
 * @author Hamza El Sousi
 * @version 2.2
 *
 */

/**
 * The Encryptable interface defines the required methods for all encryption
 * classes.
 */
public interface Encryptable {
	/**
	 * Constant representing 'space' on ASCII
	 */
	static final int START_CHAR = 32; // ASCII value of space character
	/**
	 * Constant representing last alphabet on ASCII
	 */
	static final int END_CHAR = 122; // ASCII value of 'z' character
	/**
	 * The number of valid string values
	 */
	static final int RANGE = END_CHAR - START_CHAR + 1;

	/**
	 * Encrypts the given input string.
	 * 
	 * @param input The string to be encrypted.
	 * @return The encrypted version of the input string.
	 */
	String encrypt(String input);

	/**
	 * Decrypts the given encrypted string.
	 *
	 * @param input The encrypted string to be decrypted.
	 * @return The decrypted version of the input string.
	 */
	String decrypt(String input);
}

/*
 * REFERENCE : The ASCII table I referred to while making this program is listed below.
 * 
 * https://www.rapidtables.com/code/text/ascii-table.html
 */
