package grail.tokenBeans;

import grail.interfaces.Plus;
import util.annotations.EditablePropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;

@Tags({"Plus"})
@StructurePattern(StructurePatternNames.BEAN_PATTERN)
@EditablePropertyNames({"Input"})
public class PlusToken implements Plus {

	private String input;
	
	public PlusToken(String input){
		this.input = input;
	}

	@Override
	public String getInput() {
		return input;
	}

}
