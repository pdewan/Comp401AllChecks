package grail.scanner;

import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;

import java.util.Iterator;

import grail.collections.ClearableHistory;
import grail.interfaces.ClearableHistoryInterface;
import grail.interfaces.ScannerBeanInterface;
import grail.interfaces.Token;
import grail.tokenBeans.EndToken;
import grail.tokenBeans.MinusToken;
import grail.tokenBeans.NumberToken;
import grail.tokenBeans.PlusToken;
import grail.tokenBeans.QuoteToken;
import grail.tokenBeans.StartToken;
import grail.tokenBeans.WordToken;
import grail.tokenBeans.commandBeans.ApproachCommandToken;
import grail.tokenBeans.commandBeans.FailCommandToken;
import grail.tokenBeans.commandBeans.MoveCommandToken;
import grail.tokenBeans.commandBeans.PassCommandToken;
import grail.tokenBeans.commandBeans.RepeatCommandToken;
import grail.tokenBeans.commandBeans.SayCommandToken;
import grail.tokenBeans.extraCommandBeans.CallCommandToken;
import grail.tokenBeans.extraCommandBeans.DefineCommandToken;
import grail.tokenBeans.extraCommandBeans.ProceedAllCommandToken;
import grail.tokenBeans.extraCommandBeans.RedoCommandToken;
import grail.tokenBeans.extraCommandBeans.RotateLeftArmCommandToken;
import grail.tokenBeans.extraCommandBeans.RotateRightArmCommandToken;
import grail.tokenBeans.extraCommandBeans.SleepCommandToken;
import grail.tokenBeans.extraCommandBeans.ThreadCommandToken;
import grail.tokenBeans.extraCommandBeans.UndoCommandToken;
import grail.tokenBeans.extraCommandBeans.WaitCommandToken;


/**
 * A "Bean" object whose setter for scannedString prints the tokens and their types.
 * @author Semion
 *
 */
@Tags({"ScannerBean"})
@StructurePattern(StructurePatternNames.BEAN_PATTERN)
@PropertyNames({"ScannedString", "Tokens", "Errors", "TokenList"})
@EditablePropertyNames({"ScannedString"})
public class ScannerBean implements ScannerBeanInterface{

	private String scannedString = "";
	
	private ClearableHistoryInterface tokenList = new ClearableHistory();
	
	private Token[] tokenStorage = new Token[100];
	private Token[] tokens = {};
	private int numTokens = 0;
	
	private String[] errorStorage = new String[100];
	private String[] errors = {};
	private int numErrors = 0;
	
	@Override
	public String getScannedString(){
		return scannedString;
	};
	
	@Override
	public void setScannedString(String s){
		scanString(s);
		scannedString = s;
	};
	
	@Override	
	public Token[] getTokens(){
		return tokens;
	}
	
	@Override
	public String[] getErrors(){
		return errors;
	}
	
	@Override
	public ClearableHistoryInterface getTokenList(){
		return tokenList;
	}
	
	/**
	 * Produces output from each string
	 */
	private void scanString(String s){
		
		// Reset arrays
		numTokens = 0;
		numErrors = 0;
		tokenList.clear();
		
		Iterator<String> iterator = new ScanningIterator(s);
		
		Token tokenObject = null;	// used to grab each token
		
		// Take each space-delimited token
		while (iterator.hasNext()){
			String tokenString = iterator.next();

			boolean valid = true; // will be used to mark invalid tokens
			
			// Check for number
			if (Character.isDigit(tokenString.charAt(0))){
				valid = isValidNumber(tokenString);
				if (valid){
					tokenList.addElement(new NumberToken(tokenString));
					tokenObject = new NumberToken(tokenString);
				}
				
			// Check for word
			} else if (Character.isLetter(tokenString.charAt(0))){
				valid = isValidWord(tokenString);
				if (valid){
					tokenObject = constructCommandOrWord(tokenString);
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

					tokenList.addElement(new QuoteToken(tokenString));
					tokenObject = new QuoteToken(tokenString);
				}
			
			// Check for plus token
			} else if ("+".equals(tokenString)){
				tokenList.addElement(new PlusToken(tokenString));
				tokenObject = new PlusToken(tokenString);
			
			// Check for minus token
			} else if ("-".equals(tokenString)){
				tokenList.addElement(new MinusToken(tokenString));
				tokenObject = new MinusToken(tokenString);
			
			// Check for "start" token
			} else if ("{".equals(tokenString)){
				tokenList.addElement(new StartToken(tokenString));
				tokenObject = new StartToken(tokenString);
				
			// Check for "end" token
			} else if ("}".equals(tokenString)){
				tokenList.addElement(new EndToken(tokenString));
				tokenObject = new EndToken(tokenString);
				
			// Otherwise invalid
			} else{
				valid = false;
			}
			
			if (valid){
				tokenStorage[numTokens] = tokenObject;
				++numTokens;
			} else {
				errorStorage[numErrors] = tokenString;
				++numErrors;
			}
		}//end grabbing tokens
		
		// Compress arrays
		tokens = new Token[numTokens];
		for (int i = 0; i < numTokens; ++i){
			tokens[i] = tokenStorage[i];
		}
		
		errors = new String[numErrors];
		for (int i = 0; i < numErrors; ++i){
			errors[i] = errorStorage[i];
		}
	}//end scanString()
	
	/**
	 * Constructs proper command from word, or just a word if no command matches.
	 * Assumes that word is non-empty and valid.
	 * From A6 onward, also stores a copy of the token in tokenList.
	 * 
	 * @param tokenString
	 * @return proper command object, or word object otherwise
	 */
	private Token constructCommandOrWord(String tokenString) {
		
		if ("approach".equalsIgnoreCase(tokenString)){
			tokenList.addElement(new ApproachCommandToken(tokenString));
			return new ApproachCommandToken(tokenString);
			
		}else if ("fail".equalsIgnoreCase(tokenString)){

			tokenList.addElement(new FailCommandToken(tokenString));
			return new FailCommandToken(tokenString);
			
		}else if ("move".equalsIgnoreCase(tokenString)){

			tokenList.addElement(new MoveCommandToken(tokenString));
			return new MoveCommandToken(tokenString);
			
		}else if ("pass".equalsIgnoreCase(tokenString)){

			tokenList.addElement(new PassCommandToken(tokenString));
			return new PassCommandToken(tokenString);
			
		}else if ("repeat".equalsIgnoreCase(tokenString)){
			tokenList.addElement(new RepeatCommandToken(tokenString));
			return new RepeatCommandToken(tokenString);
			
		}else if ("say".equalsIgnoreCase(tokenString)){
			tokenList.addElement(new SayCommandToken(tokenString));
			return new SayCommandToken(tokenString);
			
		}else if ("call".equalsIgnoreCase(tokenString)){
			tokenList.addElement(new CallCommandToken(tokenString));
			return new CallCommandToken(tokenString);
			
		}else if ("define".equalsIgnoreCase(tokenString)){
			tokenList.addElement(new DefineCommandToken(tokenString));
			return new DefineCommandToken(tokenString);
			
		}else if ("proceedall".equalsIgnoreCase(tokenString)){
			tokenList.addElement(new ProceedAllCommandToken(tokenString));
			return new ProceedAllCommandToken(tokenString);
			
		}else if ("redo".equalsIgnoreCase(tokenString)){
			tokenList.addElement(new RedoCommandToken(tokenString));
			return new RedoCommandToken(tokenString);
			
		}else if ("rotateleftarm".equalsIgnoreCase(tokenString)){
			tokenList.addElement(new RotateLeftArmCommandToken(tokenString));
			return new RotateLeftArmCommandToken(tokenString);
			
		}else if ("rotaterightarm".equalsIgnoreCase(tokenString)){
			tokenList.addElement(new RotateRightArmCommandToken(tokenString));
			return new RotateRightArmCommandToken(tokenString);
			
		}else if ("sleep".equalsIgnoreCase(tokenString)){
			tokenList.addElement(new SleepCommandToken(tokenString));
			return new SleepCommandToken(tokenString);
			
		}else if ("thread".equalsIgnoreCase(tokenString)){
			tokenList.addElement(new ThreadCommandToken(tokenString));
			return new ThreadCommandToken(tokenString);
			
		}else if ("undo".equalsIgnoreCase(tokenString)){
			tokenList.addElement(new UndoCommandToken(tokenString));
			return new UndoCommandToken(tokenString);
			
		}else if ("wait".equalsIgnoreCase(tokenString)){
			tokenList.addElement(new WaitCommandToken(tokenString));
			return new WaitCommandToken(tokenString);
		}
		
		// If none matched, return generic word
		tokenList.addElement(new WordToken(tokenString));
		return new WordToken(tokenString);
	}

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
