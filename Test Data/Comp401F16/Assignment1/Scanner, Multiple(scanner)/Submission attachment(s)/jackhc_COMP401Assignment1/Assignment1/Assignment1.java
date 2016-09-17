package main;

import java.util.Scanner;

//Jack Crouse
//COMP 401-001 Assignment #1: Writing a Number Scanner

public class Assignment1 {
	public static void main(String[] args) {
		processInput();
	
	}
	public static int indexOf(String s, char ch, int fromIndex) {
		int index = fromIndex;
		while (index <= s.length() && s.charAt(index) != ch) {
			index++;
		}
		if (index >= s.length()) {
			index = -1;
		}
		return index;
	}
	public static void scanString(String s) {
		int anIndex = 0;
		int startingIndex = 0;
		int valueOfS = 0;
		int sumOfTokens = 0;
		int productOfTokens = 1;
		
		System.out.println("Tokens:");
		while (anIndex < s.length() - 1) {
			System.out.println(s.substring(startingIndex, indexOf(s, ' ', startingIndex)));
			valueOfS = Integer.parseInt(s.substring(startingIndex, indexOf(s, ' ', startingIndex)));
			anIndex = indexOf(s, ' ', startingIndex);
			startingIndex = indexOf(s, ' ', startingIndex) + 1;
			
			sumOfTokens = sumOfTokens + valueOfS;
			productOfTokens = productOfTokens * valueOfS;
		}
		System.out.println("Sum: " + sumOfTokens);
		System.out.println("Product: " + productOfTokens);
	}
	public static void processInput() {
		System.out.println("String?");
		Scanner scanner = new Scanner(System.in);
		String scannedString = scanner.nextLine();
		
		if (scannedString.charAt(0) == '.') {
			System.out.println("Goodbye!");
		}
		else {
			
			scanString(scannedString);
			processInput();
		}
	}
}
