package grail.tokenBeans;

import util.annotations.EditablePropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;

@Tags({"Plus"})
@StructurePattern(StructurePatternNames.BEAN_PATTERN)
@EditablePropertyNames({"Input"})
public class PlusToken {

	private String input;
	
	public PlusToken(String input){
		setInput(input);
	}
	
	public void setInput(String newString) {
		input = newString;
	}
	public String getInput() {
		return input;
	}

}
