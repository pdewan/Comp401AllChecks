package grail.tokenBeans;

import grail.interfaces.Word;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;

@Tags({"Word"})
@StructurePattern(StructurePatternNames.BEAN_PATTERN)
@PropertyNames({"Input", "Value"})
@EditablePropertyNames({"Input"})
public class WordToken implements Word{

	private String input;
	private String value;
	
	public WordToken(String input){
		setInput(input);
	}
	
	@Override
	public void setInput(String newString) {
		input = newString;
		value = newString.toLowerCase();
	}

	@Override
	public String getInput() {
		return input;
	}

	@Override
	public String getValue() {
		return value;
	}

}
