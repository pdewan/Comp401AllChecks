package grail.tokens;
import grail.interfaces.Token;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;

@Tags({"Start"})
@StructurePattern(StructurePatternNames.BEAN_PATTERN)
@PropertyNames({"Input"})
@EditablePropertyNames({"Input"})

public class Start implements Token {
	
	private String Input;
	
	public String getInput () {
		return Input;
	}
	
	public void setInput (String newInput) {
		Input = newInput;
	}
	
	public Start (String initialInput) {
		setInput(initialInput);
	}
}
