package grail.interfaces;

import util.annotations.Tags;

@Tags({"Token", "Number", "Word", "Quote", "Plus", "Minus", "Start", "End"})
public interface Token {
	
	public void setInput(String newString);
	public String getInput();

}
