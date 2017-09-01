package grail.tokenBeans;

import util.annotations.EditablePropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;

@Tags({"Start"})
@StructurePattern(StructurePatternNames.BEAN_PATTERN)
@EditablePropertyNames({"Input"})
public class StartToken {

	private String input;
	
	public StartToken(String input){
		setInput(input);
	}
	
	public void setInput(String newString) {
		input = newString;
	}

	public String getInput() {
		return input;
	}

}
