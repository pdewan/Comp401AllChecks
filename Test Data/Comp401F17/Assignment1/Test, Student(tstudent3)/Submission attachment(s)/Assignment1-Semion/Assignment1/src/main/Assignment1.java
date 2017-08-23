package main;

import java.util.Scanner;

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
		System.out.println("Tokens:");
		int scanPosition = 0;
		while (scanPosition < s.length()){
		
			// Get the next token
			int tokenStart = indexOfNot(s, ' ', scanPosition);
			if (tokenStart == -1){
				
				// Rest of string was spaces
				break;
			}
			
			int tokenEnd = indexOf(s, ' ', tokenStart);
			if (tokenEnd == -1){
				
				// Rest of string is digits
				tokenEnd = s.length();
			}
			
			String token = s.substring(tokenStart, tokenEnd);
			System.out.println(token);
			
			// Update counts. Product needs to be set to 1 if this is the first token
			// so that things can be multiplied into it.
			if (firstToken){
				product = 1;
				firstToken = false;
			}
			product *= Integer.parseInt(token);
			sum += Integer.parseInt(token);
			
			// Don't forget to advance scanner position.
			scanPosition = tokenEnd;
		}//end gathering tokens
		
		// To do it with error recovery, I would do the following (comment out the
		// previous while statement and uncomment this one):
//		while (scanPosition < s.length()){
//			
//			// skip spaces
//			if (s.charAt(scanPosition) == ' '){
//				++scanPosition;
//				continue;	// This goes to the start of the loop
//			}
//			
//			// Print legal tokens
//			else if (Character.isDigit(s.charAt(scanPosition))){
//				
//				int tokenStart = scanPosition;
//				
//				// Go to end of valid token
//				while (scanPosition < s.length()
//						&& Character.isDigit(s.charAt(scanPosition))){
//					++scanPosition;
//				}
//				
//				// Print token as before
//				String token = s.substring(tokenStart, scanPosition);
//				System.out.println(token);
//				
//				// Update counts. Product needs to be set to 1 if this is the first token
//				// so that things can be multiplied into it.
//				if (firstToken){
//					product = 1;
//					firstToken = false;
//				}
//				product *= Integer.parseInt(token);
//				sum += Integer.parseInt(token);
//			
//				continue;
//			}//end valid token handling
//			
//			// Print invalid tokens
//			else {
//				int tokenStart = scanPosition;
//				
//				// Go to end of invalid token
//				while (scanPosition < s.length()
//						&& !Character.isDigit(s.charAt(scanPosition))
//						&& !(s.charAt(scanPosition) == ' ')){
//					++scanPosition;
//				}
//				
//				String token = s.substring(tokenStart, scanPosition);
//				System.out.println("Invalid token: " + token);
//				
//				continue;
//			}
//		}//end scanning with error recovery
		
		System.out.println("Sum: " + sum);
		System.out.println("Product: " + product);
	}
	
	/**
	 * Returns index of first character equal to ch
	 * @param s
	 * @param ch
	 * @param fromIndex
	 * @return
	 */
	private static int indexOf(String s, char ch, int fromIndex){
		for (int i=fromIndex; i < s.length(); ++i){
			if (s.charAt(i)==ch){
				return i;
			}
		}
		return -1;
	}
	
	/**
	 * Returns index of first character not equal to ch
	 * 
	 * @param s
	 * @param ch
	 * @param fromIndex
	 * @return
	 */
	private static int indexOfNot(String s, char ch, int fromIndex){
		for (int i=fromIndex; i < s.length(); ++i){
			if (s.charAt(i)!=ch){
				return i;
			}
		}
		return -1;
	}
}
