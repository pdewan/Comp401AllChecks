package grail.tokenBeans;

import util.annotations.EditablePropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;

@Tags({"Minus"})
@StructurePattern(StructurePatternNames.BEAN_PATTERN)
@EditablePropertyNames({"Input"})
public class MinusToken extends GenericToken {

	public MinusToken(String input){
		super(input);
	}
	
}
