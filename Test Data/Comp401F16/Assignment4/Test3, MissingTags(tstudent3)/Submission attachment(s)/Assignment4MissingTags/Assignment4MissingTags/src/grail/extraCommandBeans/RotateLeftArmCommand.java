package grail.extraCommandBeans;

import grail.tokenBeans.WordToken;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;

@Tags({"RotateLeftArm"})
public class RotateLeftArmCommand extends WordToken {

	public RotateLeftArmCommand(String input) {
		super(input);
	}

}
