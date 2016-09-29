package grail.tokenBeans;

import grail.interfaces.Quote;
import util.annotations.EditablePropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;

@Tags({"Quote"})
@StructurePattern(StructurePatternNames.BEAN_PATTERN)
@EditablePropertyNames({"Input"})
public class QuoteToken implements Quote{

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
