package grail.tokenBeans;

import grail.interfaces.Token;
import util.annotations.EditablePropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;

@Tags({"Quote"})
@StructurePattern(StructurePatternNames.BEAN_PATTERN)
@EditablePropertyNames({"Input"})
public class QuoteToken extends GenericToken{

	public QuoteToken(String input){
		super(input);
	}
	
}
