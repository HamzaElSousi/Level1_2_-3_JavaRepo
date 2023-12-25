/**
 * Student Name:Hamza El Sousi
 * Student Number:040982818
 * Course: CST8132 Object Oriented Programming
 * Program: CET-CS-Level 2
 * Professor: James Mwangi PhD.
 * Description: Class CaeserCipher implements the interface Encryptable and is a blue print for Caeser encyption. 
  */

package encryption.ciphers;

import encryptions.Encryptable;

/**
 * @author Hamza El Sousi
 * @version 2.2
 * The CaesarCipher class is an Encryptable class that uses a Caesar cipher to encrypt/decrypt strings.
 */
public class CaesarCipher implements Encryptable {

	private int key;

	/**
	 * Constructs CaeserCipher with shift to object. 
	 * @param shift is a int value for how many spaces letters will be shifted to encrypt and/or decrypt.
	 */
	public CaesarCipher(int shift) {
		key = shift % RANGE; // Make sure the key is within the valid range
	}

	@SuppressWarnings("javadoc")
	@Override // method encrypt takes the input to encrypt
	public String encrypt(final String input) {
	    StringBuilder encrypted = new StringBuilder();

	    for (int i = 0; i < input.length(); i++) {
	        char originalChar = input.charAt(i);
	        if (Character.isLetter(originalChar)) { // Check if character is a letter
	            char encryptedChar = (char) (originalChar + key);
	            if (Character.isUpperCase(originalChar)) { // Check if character is uppercase
	                if (encryptedChar > 'Z') {
	                    encryptedChar = (char) ('A' + (encryptedChar - 'Z' - 1));
	                } else if (encryptedChar < 'A') {
	                    encryptedChar = (char) ('Z' - ('A' - encryptedChar - 1));
	                }
	            } else { // Character is lowercase
	                if (encryptedChar > 'z') {
	                    encryptedChar = (char) ('a' + (encryptedChar - 'z' - 1));
	                } else if (encryptedChar < 'a') {
	                    encryptedChar = (char) ('z' - ('a' - encryptedChar - 1));
	                }
	            }
	            encrypted.append(encryptedChar);
	        } else { // Character is not a letter, preserve it as is
	            encrypted.append(originalChar);
	        }
	    }

	    return encrypted.toString();
	}



	@SuppressWarnings("javadoc")
	@Override // method decrypt takes the input to decrypt 
	public String decrypt(final String input) {
	    StringBuilder decrypted = new StringBuilder();

	    for (int i = 0; i < input.length(); i++) {
	        char encryptedChar = input.charAt(i);
	        if (Character.isLetter(encryptedChar)) {
	            char decryptedChar = (char) (encryptedChar - key);
	            if (Character.isUpperCase(encryptedChar)) {
	                if (decryptedChar < 'A') {
	                    decryptedChar = (char) ('Z' - ('A' - decryptedChar - 1));
	                } else if (decryptedChar > 'Z') {
	                    decryptedChar = (char) ('A' + (decryptedChar - 'Z' - 1));
	                }
	            } else {
	                if (decryptedChar < 'a') {
	                    decryptedChar = (char) ('z' - ('a' - decryptedChar - 1));
	                } else if (decryptedChar > 'z') {
	                    decryptedChar = (char) ('a' + (decryptedChar - 'z' - 1));
	                }
	            }
	            decrypted.append(decryptedChar);
	        } else {
	            decrypted.append(encryptedChar);
	        }
	    }

	    return decrypted.toString();
	}
}

/*
 * REFERENCE : The ASCII table I referred to while making this program is listed below.
 * 
 * https://www.rapidtables.com/code/text/ascii-table.html
 */