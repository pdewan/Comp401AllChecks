package grail.tokenBeans;

import grail.interfaces.End;
import util.annotations.EditablePropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;

@Tags({"End"})
@StructurePattern(StructurePatternNames.BEAN_PATTERN)
@EditablePropertyNames({"Input"})
public class EndToken implements End {

	private String input;
	
	public EndToken(String input){
		this.input = input;
	}

	@Override
	public String getInput() {
		return input;
	}

}
