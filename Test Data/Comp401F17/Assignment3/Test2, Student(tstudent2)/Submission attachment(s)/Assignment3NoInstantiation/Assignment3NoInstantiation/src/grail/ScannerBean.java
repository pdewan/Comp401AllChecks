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

					System.out.println("@Number");
					System.out.println(tokenString);
					System.out.println(Integer.parseInt(tokenString));
				}
				
			// Check for word
			} else if (Character.isLetter(tokenString.charAt(0))){
				valid = isValidWord(tokenString);
				if (valid){
					System.out.println("@Word");
					System.out.println(tokenString);
					System.out.println(tokenString.toLowerCase());
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
					System.out.println("@Quote");
					System.out.println(tokenString);
				}
			
			// Check for sign (these comparisons would be simpler if we were allowed to use .equals())
			} else if (tokenString.length() == 1 && (tokenString.charAt(0) == '+')){
				System.out.println("@Plus");
				System.out.println(tokenString);
				
			} else if (tokenString.length() == 1 && (tokenString.charAt(0) == '-')){
				System.out.println("@Minus");
				System.out.println(tokenString);
			
			// Check for "start" token
			} else if (tokenString.length() == 1 && tokenString.charAt(0) == '{'){
				System.out.println("@Start");
				System.out.println(tokenString);
				
			// Check for "end" token
			} else if (tokenString.length() == 1 && tokenString.charAt(0) == '}'){
				System.out.println("@End");
				System.out.println(tokenString);
				
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
