package grail.tokenBeans;

import grail.interfaces.Start;
import util.annotations.EditablePropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;

@Tags({"Start"})
@StructurePattern(StructurePatternNames.BEAN_PATTERN)
@EditablePropertyNames({"Input"})
public class StartToken implements Start{

	private String input;
	
	@Override
	public void setInput(String newString) {
		input = newString;
	}

	@Override
	public String getInput() {
		return input;
	}

}
