package grail.interfaces;
import util.annotations.Tags;

@Tags({"Number"})
public interface NumberToken {
	public String getInput();
	public void setInput(String newInput);
	public int getValue();
}
