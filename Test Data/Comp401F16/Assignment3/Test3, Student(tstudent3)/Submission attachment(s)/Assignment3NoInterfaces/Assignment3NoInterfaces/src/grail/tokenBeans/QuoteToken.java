package grail.tokenBeans;

import util.annotations.EditablePropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;

@Tags({"Quote"})
@StructurePattern(StructurePatternNames.BEAN_PATTERN)
@EditablePropertyNames({"Input"})
public class QuoteToken {

	private String input;
	
	public QuoteToken(String input){
		setInput(input);
	}
	
	public void setInput(String newString) {
		input = newString;
	}

	public String getInput() {
		return input;
	}

}
