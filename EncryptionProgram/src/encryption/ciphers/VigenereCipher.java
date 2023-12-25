/**
 * Student Name:Hamza El Sousi
 * Student Number:040982818
 * Course: CST8132 Object Oriented Programming
 * Program: CET-CS-Level 2
 * Professor: James Mwangi PhD.
 * Description: Class VigenereCipher implements the interface Encryptable and is a blue print for Vigenere encyption. 
  */
package encryption.ciphers;

import encryptions.Encryptable;

/**
 * @author Hamza El Sousi
 * @version 2.2 The VigenereCipher class is an Encryptable class that uses a
 *          Vigenere cipher to encrypt/decrypt strings.
 */
public class VigenereCipher implements Encryptable {

	private String key;
	private int keyLength;

	/**
	 * Constructs a VigenereCipher object with the given password.
	 *
	 * @param password The password used to encrypt and decrypt the text.
	 */
	public VigenereCipher(String password) {
		key = password.toLowerCase(); // Convert the key to lowercase for case-insensitive encryption/decryption
		keyLength = key.length();
	}

	@SuppressWarnings("javadoc")
	@Override //Method encrypt in class overrides interface method. 
	public String encrypt(String input) {
		StringBuilder encrypted = new StringBuilder();

		for (int i = 0; i < input.length(); i++) {
			char originalChar = input.charAt(i);
			char keyChar = key.charAt(i % keyLength);

			char encryptedChar;
			if (Character.isLetter(originalChar)) {
				encryptedChar = encryptCharacter(originalChar, keyChar);
			} else {
				encryptedChar = originalChar; // Preserve non-letter characters
			}

			encrypted.append(encryptedChar);
		}

		return encrypted.toString();
	}

	@SuppressWarnings("javadoc")
	@Override
	public String decrypt(String input) {
		StringBuilder decrypted = new StringBuilder();

		for (int i = 0; i < input.length(); i++) {
			char encryptedChar = input.charAt(i);
			char keyChar = key.charAt(i % keyLength);

			char decryptedChar;
			if (Character.isLetter(encryptedChar)) {
				decryptedChar = decryptCharacter(encryptedChar, keyChar);
			} else {
				decryptedChar = encryptedChar; // Preserve non-letter characters
			}

			decrypted.append(decryptedChar);
		}

		return decrypted.toString();
	}

	private char encryptCharacter(char originalChar, char keyChar) {
		char base = Character.isUpperCase(originalChar) ? 'A' : 'a';
		int originalIndex = originalChar - base;
		int keyIndex = keyChar - 'a';
		int encryptedIndex = (originalIndex + keyIndex) % 26;
		return (char) (base + encryptedIndex);
	}

	private char decryptCharacter(char encryptedChar, char keyChar) {
		char base = Character.isUpperCase(encryptedChar) ? 'A' : 'a';
		int encryptedIndex = encryptedChar - base;
		int keyIndex = keyChar - 'a';
		int decryptedIndex = (encryptedIndex - keyIndex + 26) % 26;
		return (char) (base + decryptedIndex);
	}
}
/*
 * REFERENCE : The ASCII table I referred to while making this program is listed below.
 * 
 * https://www.rapidtables.com/code/text/ascii-table.html
 */