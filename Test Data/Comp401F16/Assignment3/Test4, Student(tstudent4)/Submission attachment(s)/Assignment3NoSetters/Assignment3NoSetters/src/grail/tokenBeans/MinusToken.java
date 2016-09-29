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
		this.input = input;
	}

	@Override
	public String getInput() {
		return input;
	}

}
