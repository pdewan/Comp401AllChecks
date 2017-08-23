package grail.interfaces;

import util.annotations.Tags;

@Tags({"Parser"})
public interface ParserInterface {

	public String getCommandText();
	public void setCommandText(String string);
	public CommandThread getCommandObject();
	public String getErrors();

}