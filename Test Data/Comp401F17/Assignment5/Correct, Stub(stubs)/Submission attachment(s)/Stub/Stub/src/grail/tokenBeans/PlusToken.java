package grail.tokenBeans;

import grail.interfaces.Token;
import util.annotations.EditablePropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;

@Tags({"Plus"})
@StructurePattern(StructurePatternNames.BEAN_PATTERN)
@EditablePropertyNames({"Input"})
public class PlusToken implements Token {

	@Override
	public void setInput(String newString) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getInput() {
		// TODO Auto-generated method stub
		return null;
	}


}
