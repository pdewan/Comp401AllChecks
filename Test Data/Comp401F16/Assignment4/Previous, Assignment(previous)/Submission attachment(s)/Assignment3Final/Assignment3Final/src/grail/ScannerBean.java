package grail;

import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;

import java.util.Iterator;

import grail.interfaces.Number;
import grail.interfaces.ScannerBeanInterface;
import grail.interfaces.Token;
import grail.interfaces.Word;
import grail.tokenBeans.EndToken;
import grail.tokenBeans.MinusToken;
import grail.tokenBeans.NumberToken;
import grail.tokenBeans.PlusToken;
import grail.tokenBeans.QuoteToken;
import grail.tokenBeans.StartToken;
import grail.tokenBeans.WordToken;
import mp.scanner.ScanningIterator;


/**
 * A "Bean" object whose setter for scannedString prints the tokens and their types.
 * @author Semion
 *
 */
@Tags({"ScannerBean"})
@StructurePattern(StructurePatternNames.BEAN_PATTERN)
@PropertyNames({"ScannedString"})
@EditablePropertyNames({"ScannedString"})
public class ScannerBean implements ScannerBeanInterface {

	String scannedString;
	
	@Override
	public String getScannedString(){
		return scannedString;
	};
	
	@Override
	public void setScannedString(String s){
		scanString(s);
		scannedString = s;
	};
	
	/**
	 * Produces output from each string
	 */
	private static void scanString(String s){
		
		Iterator<String> iterator = new ScanningIterator(s);
		Token tokenObject;
		
		System.out.println("Tokens:");
		
		while (iterator.hasNext()){
			String tokenString = iterator.next();

			boolean valid = true; // will be used to mark invalid tokens
			
			// Check for number
			if (Character.isDigit(tokenString.charAt(0))){
				valid = isValidNumber(tokenString);
				if (valid){
					tokenObject = new NumberToken(tokenString);
					System.out.println(tokenObject);
					System.out.println(tokenObject.getInput());
					System.out.println(((Number)tokenObject).getValue());
				}
				
			// Check for word
			} else if (Character.isLetter(tokenString.charAt(0))){
				valid = isValidWord(tokenString);
				if (valid){
					tokenObject = new WordToken(tokenString);
					System.out.println(tokenObject);
					System.out.println(tokenObject.getInput());
					System.out.println(((Word)tokenObject).getValue());
				}
			
			// Check for quoted string
			} else if (tokenString.charAt(0) == '\"'){
				
				// The only invalid token would be an empty quoted string
				if (tokenString.length() <= "\"\"".length()){
					valid = false;
				}
				
				if (valid){
					
					// Trim quotation marks off the ends of the token
					tokenString = tokenString.substring(1, tokenString.length()-1);
					
					tokenObject = new QuoteToken(tokenString);
					System.out.println(tokenObject);
					System.out.println(tokenObject.getInput());
				}
			
			// Check for sign (these comparisons would be simpler if we were allowed to use .equals())
			} else if (tokenString.length() == 1 && (tokenString.charAt(0) == '+')){
				tokenObject = new PlusToken(tokenString);
				System.out.println(tokenObject);
				System.out.println(tokenObject.getInput());
				
			} else if (tokenString.length() == 1 && (tokenString.charAt(0) == '-')){
				tokenObject = new MinusToken(tokenString);
				System.out.println(tokenObject);
				System.out.println(tokenObject.getInput());
			
			// Check for "start" token
			} else if (tokenString.length() == 1 && tokenString.charAt(0) == '{'){
				tokenObject = new StartToken(tokenString);
				System.out.println(tokenObject);
				System.out.println(tokenObject.getInput());
				
			// Check for "end" token
			} else if (tokenString.length() == 1 && tokenString.charAt(0) == '}'){
				tokenObject = new EndToken(tokenString);
				System.out.println(tokenObject);
				System.out.println(tokenObject.getInput());
				
			// Otherwise invalid
			} else{
				valid = false;
			}
			
			if (!valid){
				System.out.print("INVALID TOKEN: ");
				System.out.println(tokenString);
			}
			
		}//end printing tokens
	}//end scanString()
	
	private static boolean isValidWord(String s){
		
		// Assume correct to begin with
		boolean validity = true;
		
		// Go through and stop at any invalid character
		for (int i = 0; i < s.length(); ++i){
			if (!Character.isLetter(s.charAt(i))){
				validity = false;
				break;
			}
		}
		return validity;
	}
	
	private static boolean isValidNumber(String s){
		
		// Assume correct to begin with
		boolean validity = true;
		
		// Go through and stop at any invalid character
		for (int i = 0; i < s.length(); ++i){
			if (!Character.isDigit(s.charAt(i))){
				validity = false;
				break;
			}
		}
		return validity;
	}
}//end class
