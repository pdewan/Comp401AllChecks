package grail.tokenBeans;

import grail.interfaces.Number;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;

@Tags({"Number"})
@StructurePattern(StructurePatternNames.BEAN_PATTERN)
@PropertyNames({"Input", "Value"})
@EditablePropertyNames({"Input"})
public class NumberToken extends GenericToken implements Number{

	@Override
	public int getValue() {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
