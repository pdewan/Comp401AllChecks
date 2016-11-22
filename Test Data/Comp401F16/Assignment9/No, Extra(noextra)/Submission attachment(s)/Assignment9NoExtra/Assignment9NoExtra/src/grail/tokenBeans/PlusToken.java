package grail.tokenBeans;

import grail.interfaces.Token;
import util.annotations.EditablePropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;

@Tags({"Plus"})
@StructurePattern(StructurePatternNames.BEAN_PATTERN)
@EditablePropertyNames({"Input"})
public class PlusToken extends GenericToken {

	public PlusToken(String input){
		super(input);
	}
	
}
