package grail.commandBeans;

import grail.tokenBeans.WordToken;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;

@Tags({"Pass"})
@StructurePattern(StructurePatternNames.BEAN_PATTERN)
@PropertyNames({"Input", "Value"})
@EditablePropertyNames({"Input"})
public class PassCommand extends WordToken {

	public PassCommand(String input) {
		super(input);
	}

}
