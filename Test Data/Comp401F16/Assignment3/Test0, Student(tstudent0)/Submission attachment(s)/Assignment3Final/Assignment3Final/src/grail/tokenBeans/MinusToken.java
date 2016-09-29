package grail.tokenBeans;

import grail.interfaces.Minus;
import util.annotations.EditablePropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;

@Tags({"Minus"})
@StructurePattern(StructurePatternNames.BEAN_PATTERN)
@EditablePropertyNames({"Input"})
public class MinusToken implements Minus {

	private String input;
	
	public MinusToken(String input){
		setInput(input);
	}
	
	@Override
	public void setInput(String newString) {
		input = newString;
	}

	@Override
	public String getInput() {
		return input;
	}

}
