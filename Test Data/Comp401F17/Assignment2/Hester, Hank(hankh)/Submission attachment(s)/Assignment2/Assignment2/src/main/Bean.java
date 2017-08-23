package main;

import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;

@Tags({"ScannerBean"})
@StructurePattern(StructurePatternNames.BEAN_PATTERN)
@PropertyNames({"ScannedString"})
@EditablePropertyNames({"ScannedString"})

public class Bean {
	private String _scannedString;
	
	public String getScannedString() {
		return _scannedString;
	}
	
	public void setScannedString(String s) {
		_scannedString = s;
		scanString(s);
	}
	
	public static void scanString(String s) {
//		s = removeExtraSpaces(s);
		boolean inQuotes = false;
		String illegalChars = "";
		String currentType = getCharType(s.charAt(0));
		if (!currentType.equals("illegal character: ")) {
			System.out.print(getCharType(s.charAt(0)));
		}
		
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			
			if (inQuotes && ch != '"') {
				System.out.print(ch);
				continue;
			}
			if (ch == '"') {
				if (inQuotes) {
					inQuotes = false;
				} else {
					inQuotes = true;
					System.out.println();
					System.out.print("quoted string: ");
				}
			} else if (inQuotes) {
				System.out.print(ch);
			} else if (Character.isLetter(ch) && currentType.equals("word: ")) {
				System.out.print(ch);
			} else if (Character.isDigit(ch) && currentType.equals("number: ")) {
				System.out.print(ch);
			} else if ((ch == '+' || ch == '-') && currentType.equals("sign: ")) {
				System.out.print(ch);
			} else if (Character.isLetter(ch) && !currentType.equals("word: ")) {
				System.out.println();
				currentType = getCharType(ch);
				System.out.print(currentType);
				System.out.print(ch);
			} else if (Character.isDigit(ch) && !currentType.equals("number: ")) {
				System.out.println();
				currentType = getCharType(ch);
				System.out.print(currentType);
				System.out.print(ch);
			} else if ((ch == '+' || ch == '-') && !currentType.equals("sign: ")) {
				System.out.println();
				currentType = getCharType(ch);
				System.out.print(currentType);
				System.out.print(ch);
			} else if (ch == ' ') {
				currentType = "";
			} else {
				illegalChars += ch;
			}
		}
		if (inQuotes) {
			System.out.println();
			System.out.print("error: did not close quoted string.");
		}
		if (illegalChars.length() > 0) {
			System.out.println();
			System.out.print("removed illegal characters: " + illegalChars);
		}
	}
	
	public static int indexOf(String s, char ch, int fromIndex) {
		for (int i = fromIndex; i < s.length(); i++) {
			if (s.charAt(i) == ch) {
				return i;
			}
		}
		return -1;
	}
	
	public static int indexOfNot(String s, char ch, int fromIndex) {
		for (int i = fromIndex; i < s.length(); i++) {
			if (s.charAt(i) != ch) {
				return i;
			}
		}
		return -1;
	}
	
	 static String removeExtraSpaces(String s) {
		String key = "";
		String cleanedString = "";
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == ' ') {
				key += "1";
			} else {
				key += "0";
			}
		}
		for (int i = 0; i < key.length(); i++) {
			if (i == 0) {
				cleanedString += s.charAt(i);
			} else if (key.charAt(i) == '1' && key.charAt(i - 1) == '1') {
				// skip
			} else {
				cleanedString += s.charAt(i);
			}
		}
		s = cleanedString;
		
		if (s.charAt(0) == ' ') {
			s = s.substring(1);
		}
		if (s.charAt(s.length() - 1) != ' ') {
			s += ' ';
		}
		return s;
	}
	
	public static String getCharType(char ch) {
		if (Character.isDigit(ch)) {
			return "number: ";
		} else if (Character.isLetter(ch)) {
			return "word: ";
		} else if (ch == '"') {
			return "quoted string: ";
		} else if (ch == '+' || ch == '-') {
			return "sign: ";
		} else {
			return "illegal character: ";
		}
	}
}
