package grail.tokenBeans;

import grail.interfaces.Token;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;


@Tags({"Token"})
@StructurePattern(StructurePatternNames.BEAN_PATTERN)
@PropertyNames({"Input"})
@EditablePropertyNames({"Input"})
public class GenericToken implements Token{

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
