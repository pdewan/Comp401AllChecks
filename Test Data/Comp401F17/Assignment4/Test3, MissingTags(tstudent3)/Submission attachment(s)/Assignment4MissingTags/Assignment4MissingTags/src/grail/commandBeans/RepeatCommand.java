package grail.commandBeans;

import grail.tokenBeans.WordToken;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;


@EditablePropertyNames({"Input"})
public class RepeatCommand extends WordToken {

	public RepeatCommand(String input) {
		super(input);
	}

}
