package grail.tokens;
import grail.interfaces.NumberToken;
import grail.interfaces.Token;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;

@Tags({"Number"})
@StructurePattern(StructurePatternNames.BEAN_PATTERN)
@PropertyNames({"Input", "Value"})
@EditablePropertyNames({"Input"})

public class Number implements Token, NumberToken {
	private String Input;
	private int Value;
	
	public String getInput() {
		return Input;
	}
	
	public int getValue() {
		return Value;
	}
	
	public void setInput(String newInput) {
		Input = newInput;
		Value = Integer.parseInt(Input);
	}
	
	public Number (String initialInput) {
		setInput(initialInput);
	}
}
