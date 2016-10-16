package grail.interfaces;
import util.annotations.Tags;

@Tags({"Word"})
public interface WordToken {
	public String getInput();
	public void setInput(String newInput);
	public String getValue();
}
