package grail.interfaces;
import util.annotations.Tags;

@Tags({"Token"})
public interface Token {
	public String getInput();
	public void setInput(String newInput);
}
