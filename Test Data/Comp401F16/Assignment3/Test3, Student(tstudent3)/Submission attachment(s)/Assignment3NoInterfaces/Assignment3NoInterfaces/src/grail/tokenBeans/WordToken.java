package grail.tokenBeans;

import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;

@Tags({"Word"})
@StructurePattern(StructurePatternNames.BEAN_PATTERN)
@PropertyNames({"Input", "Value"})
@EditablePropertyNames({"Input"})
public class WordToken {

	private String input;
	private String value;
	
	public WordToken(String input){
		setInput(input);
	}
	
	public void setInput(String newString) {
		input = newString;
		value = newString.toLowerCase();
	}

	public String getInput() {
		return input;
	}

	public String getValue() {
		return value;
	}

}
