package grail.tokens;
import grail.interfaces.Token;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;

@Tags({"Quote"})
@StructurePattern(StructurePatternNames.BEAN_PATTERN)
@PropertyNames({"Input"})
@EditablePropertyNames({"Input"})

public class Quote implements Token {
	private String Input;
	
	public String getInput () {
		return Input;
	}
	
	public void setInput (String newInput) {
		Input = newInput;
	}

	public Quote (String initialInput) {
		setInput(initialInput);
	}
	
}
