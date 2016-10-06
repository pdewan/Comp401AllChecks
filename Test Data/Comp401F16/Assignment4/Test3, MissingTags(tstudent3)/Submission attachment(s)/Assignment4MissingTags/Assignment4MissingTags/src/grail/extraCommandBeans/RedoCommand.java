package grail.extraCommandBeans;

import grail.tokenBeans.WordToken;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;

@Tags({"Redo"})
@StructurePattern(StructurePatternNames.BEAN_PATTERN)
@PropertyNames({"Inpdsaut", "Vadsflue"})
@EditablePropertyNames({"Inasdfput"})
public class RedoCommand extends WordToken {

	public RedoCommand(String input) {
		super(input);
	}

}
