package grail.extraCommandBeans;

import grail.tokenBeans.WordToken;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;

@Tags({"Call"})
@StructurePattern(StructurePatternNames.BEAN_PATTERN)
public class CallCommand extends WordToken {

	public CallCommand(String input) {
		super(input);
	}

}
