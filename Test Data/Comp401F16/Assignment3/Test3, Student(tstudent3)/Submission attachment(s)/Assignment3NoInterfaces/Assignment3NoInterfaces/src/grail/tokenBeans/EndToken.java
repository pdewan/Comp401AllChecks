package grail.tokenBeans;

import util.annotations.EditablePropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;

@Tags({"End"})
@StructurePattern(StructurePatternNames.BEAN_PATTERN)
@EditablePropertyNames({"Input"})
public class EndToken {

	private String input;
	
	public EndToken(String input){
		setInput(input);
	}
	
	public void setInput(String newString) {
		input = newString;
	}

	public String getInput() {
		return input;
	}

}
