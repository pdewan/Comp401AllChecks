package grail.interfaces;

import util.annotations.Tags;

@Tags({"CommandInterpreter", "SignedMoveCommandInterpreter", "ErrorResilientCommandInterpreter"})
public interface CommandInterpreterInterface {

	public String getCommand();
	public void setCommand(String command);

	public String getErrors();
}