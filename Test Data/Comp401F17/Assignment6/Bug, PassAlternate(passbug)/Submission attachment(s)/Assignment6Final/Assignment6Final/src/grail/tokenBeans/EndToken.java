package grail.tokenBeans;

import util.annotations.EditablePropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;

@Tags({"End"})
@StructurePattern(StructurePatternNames.BEAN_PATTERN)
@EditablePropertyNames({"Input"})
public class EndToken extends GenericToken {

	public EndToken(String input){
		super(input);
	}
	
}
