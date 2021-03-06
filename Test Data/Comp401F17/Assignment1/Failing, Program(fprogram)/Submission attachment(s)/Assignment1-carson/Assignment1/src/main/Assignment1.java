package main;
//imports scanner utility to java
import java.util.Scanner;

public class Assignment1 {

	// checks if line is terminating line, if it isn't it passes along to scanString
	public static void processInput() {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.println("String?");

			String scannedString = scanner.nextLine();

			if (scannedString.charAt(0) == '.') {
				System.out.println("Thank you for using number scanner, have a nice day!");
				break;
			}

			else {
				// method removes all invalid characters from string
				scannedString = cleanString(scannedString);
				/*
				 * Adds a space to the end of the string to avoid problem with indexOf returning
				 * -1 when final number of string is reached
				 */
				scannedString += ' ';
				scanString(scannedString);
			}
		}
		scanner.close();
	}

	public static void scanString(String unformattedNumbers) {
		// Used to cycle through string in loop
		int index = 0;
		// Establishes two variables to build off of to calculate sum and product
		int sum = 0;
		int product = 1;
		System.out.println("Tokens:");
		/*
		 * Loops through string pulling out integers until it gets a -1 from indexOf or
		 * indexOfNot meaning there are no numbers left in string
		 */
		while (index != -1) {
			// index of next space character given by indexOf method
			int nextSpace = indexOf(unformattedNumbers, ' ', index);
			// if current character is a space go to the next character that is not a space
			if (unformattedNumbers.charAt(index) == ' ') {
				index = indexOfNot(unformattedNumbers, ' ', index);
			} else {
				/*
				 * otherwise (when current character is a digit) read substring from current
				 * digit until the next space print it out then turn it into an integer to be
				 * used for operations
				 */
				System.out.println(unformattedNumbers.substring(index, nextSpace));
				int currentNumber = Integer.parseInt(unformattedNumbers.substring(index, nextSpace));
				// Adds/Multiplies to totals and sets index to that of the next space
				sum += currentNumber;
				product *= currentNumber;
				index = nextSpace;
			}
		}
		// once the whole string has been read print totals
		System.out.println("Sum: " + sum);
		System.out.println("Product: " + product);
	}

	/*
	 * Method created to remove illegal characters, does so by looping through
	 * string and checking if each character is a space or digit, if so it adds it
	 * to new "cleaned string" and if it isn't it replaces it with a space
	 */
	public static String cleanString(String dirtyString) {
		String cleanedString = "";
		for (int i = 0; i < dirtyString.length(); i++) {
			if (dirtyString.charAt(i) == ' ' || Character.isDigit(dirtyString.charAt(i))) {
				cleanedString += dirtyString.charAt(i);
			} else {
				cleanedString += ' ';
			}
		}
		return cleanedString;
	}

	// loops through string while it is not the wanted character, once it is it
	// reports its index
	public static int indexOf(String text, char x, int startIndex) {
		int currentIndex = startIndex;

		while (text.charAt(currentIndex) != x) {
			if (currentIndex == text.length() - 1) {
				return -1;
			} else {
				currentIndex++;
			}
		}
		return currentIndex;

	}

	/*
	 * finds next character that is not the given character, only difference from
	 * indexOf is that it loops while the current character is the inputed one
	 * instead of is not
	 */
	public static int indexOfNot(String text, char x, int startIndex) {
		int currentIndex = startIndex;

		while (text.charAt(currentIndex) == x) {
			if (currentIndex == text.length() - 1) {
				return -1;
			} else {
				currentIndex++;
			}
		}
		return currentIndex;

	}

	// main method that only calls static method processInput
	public static void main(String[] args) {

		processInput();
	}
}