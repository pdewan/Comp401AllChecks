package grail.tokenBeans.extraCommandBeans;

import grail.tokenBeans.WordToken;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;

@Tags({"RotateLeftArm"})
@StructurePattern(StructurePatternNames.BEAN_PATTERN)
@PropertyNames({"Input", "Value"})
@EditablePropertyNames({"Input"})
public class RotateLeftArmCommandToken extends WordToken {

	public RotateLeftArmCommandToken(String input) {
		super(input);
	}

}
