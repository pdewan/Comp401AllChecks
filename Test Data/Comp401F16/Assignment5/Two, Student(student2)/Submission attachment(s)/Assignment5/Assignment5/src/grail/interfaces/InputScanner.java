package grail.interfaces;
import util.annotations.Tags;

@Tags({"InputScanner"})
public interface InputScanner {
	public String getScannedString();
	public void setScannedString(String newLine);
	public Token[] getTokens();
	public String getErrors();
	public void scanString(String textLine);
	public int indexOf(String s, char ch, int fromIndex);
	public int indexOfNot(String s, char ch, int fromIndex);
	
}
