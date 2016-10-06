package grail.extraCommandBeans;

import grail.tokenBeans.WordToken;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;

@Tags({"Sleep"})
@StructurePattern("beans")
@PropertyNames({"Input", "Value"})
@EditablePropertyNames({"Input"})
public class SleepCommand extends WordToken {

	public SleepCommand(String input) {
		super(input);
	}

}
