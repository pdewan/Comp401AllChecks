package main;

import java.util.Scanner;

import mp.scanner.ScanningIterator;

public class Assignment1 {
	
	public static void main(String[] args) {
		processInput();
		System.out.println("Goodbye!");
	}
	
	/**
	 * 
	 */
	private static void processInput(){

		Scanner in = new Scanner(System.in);
		System.out.println("String?");
		String line = in.nextLine();
		while (line.charAt(0) != '.'){
			scanString(line);
			line = in.nextLine();
		}
	}
	
	/**
	 * Produces output from each string
	 */
	private static void scanString(String s){
		
		int product = 0;
		boolean firstToken = true; // used for adjusting product starting value
		int sum = 0;
		
		// Gather tokens
		ScanningIterator iterator = new ScanningIterator(s);
		System.out.println("Tokens:");
		while (iterator.hasNext()){
		
			String token = iterator.next();
			
			// Check if invalid
			boolean valid = true;
			for (int i = 0; i < token.length(); ++i){
				if (!Character.isDigit(token.charAt(i))){
					valid = false;
					break;
				}
			}
			if (!valid){
				System.out.println("Invalid token: " + token);
				continue;
			}
			
			System.out.println(token);
			
			// Update counts. Product needs to be set to 1 if this is the first token
			// so that things can be multiplied into it.
			if (firstToken){
				product = 1;
				firstToken = false;
			}
			product *= Integer.parseInt(token);
			sum += Integer.parseInt(token);
			
		}//end gathering tokens
		
		System.out.println("Sum: " + sum);
		System.out.println("Product: " + product);
	}
	
}
