package grail.extraCommandBeans;

import grail.tokenBeans.WordToken;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;

@PropertyNames({"Input", "Value"})
public class RotateRightArmCommand extends WordToken {

	public RotateRightArmCommand(String input) {
		super(input);
	}

}
