package grail.scanner;
import grail.command.Approach;
import grail.command.Call;
import grail.command.Define;
import grail.command.Fail;
import grail.command.Move;
import grail.command.Pass;
import grail.command.ProceedAll;
import grail.command.Repeat;
import grail.command.RotateLeftArm;
import grail.command.RotateRightArm;
import grail.command.Say;
import grail.command.Sleep;
import grail.command.Thread;
import grail.command.Undo;
import grail.command.Wait;
import grail.interfaces.InputScanner;
import grail.interfaces.Token;
import grail.tokens.End;
import grail.tokens.Minus;
import grail.tokens.Number;
import grail.tokens.Plus;
import grail.tokens.Quote;
import grail.tokens.Start;
import grail.tokens.Word;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;


@Tags({"ScannerBean"})
@StructurePattern(StructurePatternNames.BEAN_PATTERN)
@PropertyNames({"ScannedString", "Tokens", "errors"})
@EditablePropertyNames({"ScannedString"})
public class StringScanner implements InputScanner {
	private String scannedString = "";
	private Token Tokens[] = {};
	private String errors = "";
	
	Token[] tokenArray = new Token[100];
	
	public String getScannedString() {
		return scannedString;
	}
	
	public void setScannedString(String newLine) {
		scannedString = newLine;
		scanString(scannedString);
	}
	
	public Token[] getTokens() {
		return Tokens;
	}
	
	public String getErrors() {
		return errors;
	}
	
	public void scanString(String textLine) {
		//method parses a line of text and separates it into tokens using indexOf to locate spaces and
		//indexOfNot to locate nonspaces
		int nextNonSpace = 0;
		int nextSpace = 0;
		int tokenNumber = 0;
		if ((textLine.charAt(textLine.length() - 1)) != ' ') {
			textLine = textLine + ' ';
		}
		while (nextSpace < textLine.length() - 1) {		//run the loop as long as we haven't reached the end of the line
			nextNonSpace = indexOfNot(textLine, ' ', nextSpace);	//find the next nonspace in the line
			if (nextNonSpace != -1) {
				if (textLine.charAt(nextNonSpace) == '"') {				//check if we're at a quoted string
					int endQuoteIndex = indexOf(textLine, '"', nextNonSpace + 1);		//find the closing quotation mark
					if (endQuoteIndex == -1) {
						errors += "Error - missing end quotation mark";
						String token = textLine.substring(nextNonSpace + 1);
						nextSpace = textLine.length();
						tokenArray[tokenNumber] = new Quote(token);
					} else {
						nextSpace = indexOf(textLine, ' ', endQuoteIndex);
						String token = textLine.substring(nextNonSpace + 1, endQuoteIndex);			//grab the quote (sans quotation marks)
						tokenArray[tokenNumber] = new Quote(token);
					}
				} else if (Character.isLetter(textLine.charAt(nextNonSpace))) { //check if we're at a word
					nextSpace = indexOf(textLine, ' ', nextNonSpace);
					String token = textLine.substring(nextNonSpace, nextSpace);
					if ((token.toLowerCase()).equals("move")) {
						tokenArray[tokenNumber] = new Move(token);
					} else if ((token.toLowerCase()).equals("say")) {
						tokenArray[tokenNumber] = new Say(token);
					} else if ((token.toLowerCase()).equals("repeat")) {
						tokenArray[tokenNumber] = new Repeat(token);
					} else if ((token.toLowerCase()).equals("approach")) {
						tokenArray[tokenNumber] = new Approach(token);
					} else if ((token.toLowerCase()).equals("pass")) {
						tokenArray[tokenNumber] = new Pass(token);
					} else if ((token.toLowerCase()).equals("fail")) {
						tokenArray[tokenNumber] = new Fail(token);
					} else if ((token.toLowerCase()).equals("rotaterightarm")) {
						tokenArray[tokenNumber] = new RotateRightArm(token);
					} else if ((token.toLowerCase()).equals("rotateleftarm")) {
						tokenArray[tokenNumber] = new RotateLeftArm(token);
					} else if ((token.toLowerCase()).equals("define")) {
						tokenArray[tokenNumber] = new Define(token);
					} else if ((token.toLowerCase()).equals("call")) {
						tokenArray[tokenNumber] = new Call(token);
					} else if ((token.toLowerCase()).equals("thread")) {
						tokenArray[tokenNumber] = new Thread(token);
					} else if ((token.toLowerCase()).equals("wait")) {
						tokenArray[tokenNumber] = new Wait(token);
					} else if ((token.toLowerCase()).equals("proceedall")) {
						tokenArray[tokenNumber] = new ProceedAll(token);
					} else if ((token.toLowerCase()).equals("sleep")) {
						tokenArray[tokenNumber] = new Sleep(token);
					} else if ((token.toLowerCase()).equals("undo")) {
						tokenArray[tokenNumber] = new Undo(token);
					} else {
						tokenArray[tokenNumber] = new Word(token);
					}
				} else if (Character.isDigit(textLine.charAt(nextNonSpace))) {	//check if we're at a number
					nextSpace = indexOf(textLine, ' ', nextNonSpace);
					String token = textLine.substring(nextNonSpace, nextSpace);
					tokenArray[tokenNumber] = new Number(token);
				} else if (textLine.charAt(nextNonSpace) == '+') {
					nextSpace = indexOf(textLine, ' ', nextNonSpace);
					String token = textLine.substring(nextNonSpace, nextNonSpace + 1);
					tokenArray[tokenNumber] = new Plus(token);
				} else if (textLine.charAt(nextNonSpace) == '-') { 
					nextSpace = indexOf(textLine, ' ', nextNonSpace);
					String token = textLine.substring(nextNonSpace, nextNonSpace + 1);
					tokenArray[tokenNumber] = new Minus(token);
				} else if (textLine.charAt(nextNonSpace) == '{') {
					nextSpace = indexOf(textLine, ' ', nextNonSpace);
					String token = textLine.substring(nextNonSpace, nextNonSpace + 1);
					tokenArray[tokenNumber] = new Start(token);
				} else if (textLine.charAt(nextNonSpace) == '}') {
					nextSpace = indexOf(textLine, ' ', nextNonSpace);
					String token = textLine.substring(nextNonSpace, nextNonSpace + 1);
					tokenArray[tokenNumber] = new End(token);
				} else {
				nextSpace = textLine.length();		//ends the loop because we discovered no more nonspaces
				}
				tokenNumber++;
			}
		}
		Tokens = new Token[tokenNumber];
		for (int i = 0; i < tokenNumber; i++) {
			Tokens[i] = tokenArray[i];
		}
	}
	
	public int indexOf(String s, char ch, int fromIndex) {
		//method takes a string, a character, and an index and finds the first instance of the character
		//in the string at or after the supplied index
		int stringLength = s.length();
		int index = fromIndex;
		while (index < stringLength) {
			if (s.charAt(index) == ch) {
				return index;
			}
			index++;
		}
		return -1;
	}
	
	public int indexOfNot(String s, char ch, int fromIndex) {
		int stringLength = s.length();
		int index = fromIndex;
		while (index < stringLength) {
			if (s.charAt(index) == ch) {
				index++;
			} else {
				return index;
			}
		}
		return -1;
	}	
	
}
