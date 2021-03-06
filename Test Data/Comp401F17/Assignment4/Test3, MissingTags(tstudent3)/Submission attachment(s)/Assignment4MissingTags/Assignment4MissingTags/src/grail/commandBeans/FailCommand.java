package grail.commandBeans;

import grail.tokenBeans.WordToken;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;

@Tags({"Fail"})
@PropertyNames({"Input", "Value"})
@EditablePropertyNames({"Input"})
public class FailCommand extends WordToken {

	public FailCommand(String input) {
		super(input);
	}

}
