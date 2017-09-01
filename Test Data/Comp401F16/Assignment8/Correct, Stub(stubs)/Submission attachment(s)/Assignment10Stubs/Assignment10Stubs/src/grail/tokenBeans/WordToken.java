package grail.tokenBeans;

import grail.interfaces.Word;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;

@Tags({"Word"})
@StructurePattern(StructurePatternNames.BEAN_PATTERN)
@PropertyNames({"Input", "Value"})
@EditablePropertyNames({"Input"})
public class WordToken extends GenericToken implements Word{

	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
