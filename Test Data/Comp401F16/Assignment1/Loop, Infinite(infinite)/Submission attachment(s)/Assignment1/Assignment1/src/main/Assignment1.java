package main;

import java.util.Scanner;

public class Assignment1 {
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in); // gets input
		System.out.println ("Please enter a string with numbers.");
		String numbers = scanner.nextLine(); // goes to the next line
		while (numbers != ".") {
			scanString(numbers);
	}
	}
	
	public static void processInput() {
		F
	
	}
	
	public static void scanString(String numbers) {
		int initialSum = 0;
		int initialProduct = 1;
		int sum = 0;
		int nextInt = 0;
		int product = nextInt;
		while (nextInt < 0) {
			sum = initialSum + nextInt;
			product = initialProduct * nextInt;
			indexOf(numbers, ' ', 0);
		}
		System.out.println(sum);
		System.out.println(product);
	}
	
	public static int indexOf(String numbers, char ch, int fromIndex) {
		int index = fromIndex;
		while (index < numbers.length()) { // loops through the indices unless there is a space
			if (numbers.charAt(index) == ch) {
				return 1;
			}
			index++;	
		}
		return -1;
	}
}