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
public abstract class GenericToken implements Token{
	public void setInput(String newString){
		
	};
	public String getInput(){
		return null;
	};
}
