package grail.extraCommandBeans;

import grail.tokenBeans.WordToken;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;

@Tags({"ScannerBean"})
@StructurePattern("Thread")
@PropertyNames({"Input", "Value"})
@EditablePropertyNames({"Input"})
public class ThreadCommand extends WordToken {

	public ThreadCommand(String input) {
		super(input);
	}

}
