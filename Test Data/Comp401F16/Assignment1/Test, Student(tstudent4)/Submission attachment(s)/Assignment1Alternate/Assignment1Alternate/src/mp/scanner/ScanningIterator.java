package mp.scanner;

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

	@Override
	/**
	 * Gets the next token
	 */
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
		int tokenEnd = indexOf(stringData, ' ', tokenStart);
		if (tokenEnd == -1){
			
			// Rest of string is digits
			tokenEnd = stringData.length();
		}
		position = tokenEnd;
		
		return stringData.substring(tokenStart, tokenEnd);
	}
	
	/**
	 * Returns index of first character equal to ch
	 * @param s
	 * @param ch
	 * @param fromIndex
	 * @return
	 */
	public static int indexOf(String s, char ch, int fromIndex){
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
	public static int indexOfNot(String s, char ch, int fromIndex){
		for (int i=fromIndex; i < s.length(); ++i){
			if (s.charAt(i)!=ch){
				return i;
			}
		}
		return -1;
	}

}
