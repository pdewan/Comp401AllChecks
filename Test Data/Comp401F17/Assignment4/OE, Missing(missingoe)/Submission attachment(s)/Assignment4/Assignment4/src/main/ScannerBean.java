package main;

public class ScannerBean implements Token {

	private String scannedString = "";
	private Token[] Tokens;

	@Override
	public void setInput(String myString) {
		scanString(myString);
	}

	@Override
	public String getInput() {
		return scannedString;
	}

	public Token[] getTokens() {
		return Tokens;
	}

	public void scanString(String myString) {
		int start = 0;
		int counter = 0;
		Token[] largeArray = new Token[100];

		System.out.println(largeArray);

		while (start < myString.length()) {
			if (Character.isDigit(myString.charAt(start))) {
				int end = indexOf(myString, ' ', start);
				String token = myString.substring(start, end);
				Number scannedNumber = new Number(token);
				start = end + 1;
				largeArray[counter] = scannedNumber;
				counter++;

			} else if (Character.isLetter(myString.charAt(start))) {
				int end = indexOf(myString, ' ', start);
				String token = myString.substring(start, end);

				if (token.equalsIgnoreCase("move")) {
					Move scannedMove = new Move(token);
					start = end + 1;
					largeArray[counter] = scannedMove;
					counter++;

				} else if (token.equalsIgnoreCase("say")) {
					Say scannedSay = new Say(token);
					start = end + 1;
					largeArray[counter] = scannedSay;
					counter++;

				} else if (token.equalsIgnoreCase("repeat")) {
					Repeat scannedRepeat = new Repeat(token);
					start = end + 1;
					largeArray[counter] = scannedRepeat;
					counter++;

				} else if (token.equalsIgnoreCase("approach")) {
					Approach scannedApproach = new Approach(token);
					start = end + 1;
					largeArray[counter] = scannedApproach;
					counter++;

				} else if (token.equalsIgnoreCase("pass")) {
					Pass scannedPass = new Pass(token);
					start = end + 1;
					largeArray[counter] = scannedPass;
					counter++;

				} else if (token.equalsIgnoreCase("fail")) {
					Fail scannedFail = new Fail(token);
					start = end + 1;
					largeArray[counter] = scannedFail;
					counter++;

				} else {
					Word scannedWord = new Word(token);
					start = end + 1;
					largeArray[counter] = scannedWord;
					counter++;
				}

			} else if (myString.charAt(start) == '"') {
				int subStart = start + 1;
				int subEnd = indexOf(myString, '"', subStart);
				int end = indexOf(myString, ' ', subEnd);
				String token = myString.substring(subStart, subEnd);
				Quote scannedQuote = new Quote(token);
				start = end + 1;
				largeArray[counter] = scannedQuote;
				counter++;

			} else if (myString.charAt(start) == '+') {
				int end = indexOf(myString, ' ', start);
				String token = myString.substring(start, end);
				Plus scannedPlus = new Plus(token);
				start = end + 1;
				largeArray[counter] = scannedPlus;
				counter++;

			} else if (myString.charAt(start) == '-') {
				int end = indexOf(myString, ' ', start);
				String token = myString.substring(start, end);
				Minus scannedMinus = new Minus(token);
				start = end + 1;
				largeArray[counter] = scannedMinus;
				counter++;

			} else if (myString.charAt(start) == '}') {
				int end = indexOf(myString, ' ', start);
				String token = myString.substring(start, end);
				End scannedEnd = new End(token);
				start = end + 1;
				largeArray[counter] = scannedEnd;
				counter++;

			} else if (myString.charAt(start) == '{') {
				int end = indexOf(myString, ' ', start);
				String token = myString.substring(start, end);
				Start scannedStart = new Start(token);
				start = end + 1;
				largeArray[counter] = scannedStart;
				counter++;

			} else {
				start++;
			}

		}
		Tokens = new Token[counter];
		for (int i = 0; i < counter; i++) {
			Tokens[i] = largeArray[i];

		}
		System.out.println("String?");
	}

	public static int indexOf(String s, char ch, int fromIndex) {
		for (; fromIndex < s.length(); fromIndex++) {
			if (s.charAt(fromIndex) == ch) {
				return fromIndex;

			}
		}
		return fromIndex;
	}

} // end