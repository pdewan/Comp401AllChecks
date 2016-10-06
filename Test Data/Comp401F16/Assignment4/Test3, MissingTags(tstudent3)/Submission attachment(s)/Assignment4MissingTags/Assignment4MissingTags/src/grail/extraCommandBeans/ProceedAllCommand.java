package grail.extraCommandBeans;

import grail.tokenBeans.WordToken;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;

@PropertyNames({"Input", "Value"})
@EditablePropertyNames({"Input"})
public class ProceedAllCommand extends WordToken {

	public ProceedAllCommand(String input) {
		super(input);
	}

}
