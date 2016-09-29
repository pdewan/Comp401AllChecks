package grail.tokenBeans;

import util.annotations.EditablePropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;

@Tags({"Minus"})
@StructurePattern(StructurePatternNames.BEAN_PATTERN)
@EditablePropertyNames({"Input"})
public class MinusToken {

	private String input;
	
	public MinusToken(String input){
		setInput(input);
	}
	
	public void setInput(String newString) {
		input = newString;
	}

	public String getInput() {
		return input;
	}

}
