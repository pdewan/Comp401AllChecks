package grail.scanner;

import java.util.Iterator;

public class ScanningIterator implements Iterator<String>{

	private String stringData;
	private int position = 0;
	
	/**
	 * Constructor
	 * @param s string to iterate over
	 */
	public ScanningIterator(String s){
		stringData = s;
	}

	/**
	 * Checks whether there is another token to be had
	 */
	@Override
	public boolean hasNext() {
		
		// Consume spaces
		position = indexOfNot(stringData, ' ', position);
		if (position == -1){
			position = stringData.length();
		}
		return (position < stringData.length());
	}

	/**
	 * Gets the next token
	 */
	@Override
	public String next() {
		
		// Consume spaces
		position = indexOfNot(stringData, ' ', position);
		if (position == -1){
			
			// Rest of string was spaces
			position = stringData.length();
			return "";
		}
		
		// Get token
		int tokenStart = position;
		int tokenEnd = position;
		
		// Treat quoted strings differently
		if (stringData.charAt(tokenStart) == '\"'){
			
			// Look for the closing quote after this quote
			tokenEnd = indexOf(stringData, '\"', tokenStart + 1);
			
			if (tokenEnd == -1){
				System.out.println("ERROR: No closing quote found. Assumed line end to be closing quote.");
				tokenEnd = stringData.length();
				position = tokenEnd;
				return stringData.substring(tokenStart, tokenEnd)+ "\"";
			
			// If closing quote exists, make sure it is grabbed
			} else {
				++tokenEnd;
			}
			
		// If not a quoted string, end of token is a space or line end	
		} else {
			tokenEnd = indexOf(stringData, ' ', tokenStart);
		}
			
		if (tokenEnd == -1){
			tokenEnd = stringData.length();
		}
		
		position = tokenEnd;
		
		return stringData.substring(tokenStart, tokenEnd);
	}
	
	/**
	 * Returns index of first character equal to ch
	 * @param s
	 * @param ch
	 * @param fromIndex index at which to start search
	 * @return index of first ocurrence of ch after fromIndex, or -1 if not found
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
	 * @param fromIndex index at which to start search
	 * @return index of first character that is not ch after fromIndex, or -1 if no non-ch characters found
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
