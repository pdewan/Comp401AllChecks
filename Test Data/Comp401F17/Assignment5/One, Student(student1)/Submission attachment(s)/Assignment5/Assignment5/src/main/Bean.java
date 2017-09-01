package main;

import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;
import util.annotations.Visible;

@Tags({ "ScannerBean" })
@StructurePattern(StructurePatternNames.BEAN_PATTERN)
@PropertyNames({ "ScannedString" })
@EditablePropertyNames({ "ScannedString" })

public class Bean {

  private String ScannedString;
  static Token[] largeArray = new Token[100];
  static Token[] globalVariable;

  @Visible(false)
  public String getScannedString() {
    return ScannedString;
  }

  public void setScannedString(String scannedString) {
    this.ScannedString = scannedString;
    scanString(scannedString);
    setTokens();
    getTokens();

  }

  public static void scanString(String scannedString) {
    char ch = ' ';
    int fromIndex = 0;
    indexOf(scannedString, ch, fromIndex);

  }

  @Visible(false)
  public static Token[] getTokens() {
    return globalVariable;
  }

  public static void setTokens() {
    int counter = 0;
    Token[] compactArray;
    for (int b = 0; b < largeArray.length; b++) {
      if (largeArray[b] != null) {
        counter++;
      }
    }
    compactArray = new Token[counter];
    for (int u = 0; compactArray.length > u; u++) {
      compactArray[u] = largeArray[u];
    }
    globalVariable = compactArray;
  }

  public static int indexOf(String s, char ch, int fromIndex) {

    int i = 0;
    int positionInArray = 0;
    int beginIndex = 0;
    int endIndex = 0;
    while (i < s.length()) {

      if (Character.isDigit(s.charAt(i))) { // digits
        beginIndex = i;
        while (i < s.length() && Character.isDigit(s.charAt(i))) {
          i++;
        }
        endIndex = i;
        NumberInterface printedNumber = new NumberToken();
        largeArray[positionInArray] = (Token) printedNumber;
        positionInArray++;
        ((Token) printedNumber).setInput(s.substring(beginIndex, endIndex));
        // System.out.println(s.substring(beginIndex, endIndex));
        System.out.println(printedNumber.getValue());
        printedNumber.getValue();
      }

      else if (Character.isLetter(s.charAt(i)) && s.charAt(i) != '"') { // words
        beginIndex = i;
        while (i < s.length() && Character.isLetter(s.charAt(i)) && s.charAt(i) != '"') {
          i++;
        }
        endIndex = i;
        WordInterface printedWord = new WordToken();
        largeArray[positionInArray] = (Token) printedWord;
        positionInArray++;
        ((Token) printedWord).setInput(s.substring(beginIndex, endIndex));
        // System.out.println(s.substring(beginIndex, endIndex));
        System.out.println(printedWord.getValue());
        printedWord.getValue();

        if (s.substring(beginIndex, endIndex).equalsIgnoreCase("move")) {
          Token newMoveToken = new MoveToken();
          largeArray[positionInArray] = newMoveToken;
          positionInArray++;
          newMoveToken.getInput();
        }
        if (s.substring(beginIndex, endIndex).equalsIgnoreCase("say")) {
          Token newSayToken = new SayToken();
          largeArray[positionInArray] = newSayToken;
          positionInArray++;
          newSayToken.getInput();

        }
        if (s.substring(beginIndex, endIndex).equalsIgnoreCase("approach")) {
          Token newApproachToken = new ApproachToken();
          largeArray[positionInArray] = newApproachToken;
          positionInArray++;
          newApproachToken.getInput();
        }
        if (s.substring(beginIndex, endIndex).equalsIgnoreCase("pass")) {
          Token newPassToken = new PassToken();
          largeArray[positionInArray] = newPassToken;
          positionInArray++;
          newPassToken.getInput();
        }
        if (s.substring(beginIndex, endIndex).equalsIgnoreCase("fail")) {
          Token newFailToken = new FailToken();
          largeArray[positionInArray] = newFailToken;
          positionInArray++;
          newFailToken.getInput();
        }

      }

      else if (s.charAt(i) == ch) { // spaces
        beginIndex = i + 1;
      }

      else if (s.charAt(i) == '"') { // quotes
        beginIndex = i;
        i++;
        while (s.charAt(i) != '"') {
          endIndex = i + 1;
          i++;
        }
        Token printedQuotedString = new QuotedStringToken();
        largeArray[positionInArray] = (Token) printedQuotedString;
        positionInArray++;
        printedQuotedString.setInput(s.substring(beginIndex, endIndex + 1));
        // System.out.println(s.substring(beginIndex, endIndex + 1));
        printedQuotedString.getInput();
        System.out.println(printedQuotedString.getInput());
        beginIndex = i + 1;
      }

      else if (s.charAt(i) == '.') {
        System.out.println("Goodbye");
        System.exit(0);

      }

      else if (s.charAt(i) == '{') {
        beginIndex = i;
        endIndex = i + 1;
        Token startToken = new StartClass();
        largeArray[positionInArray] = startToken;
        positionInArray++;
        startToken.getInput();

      } else if (s.charAt(i) == '}') {
        beginIndex = i;
        endIndex = i + 1;
        Token endToken = new EndClass();
        largeArray[positionInArray] = endToken;
        positionInArray++;
        endToken.getInput();
      }
      i++;

    }

    return i;

  }

}
