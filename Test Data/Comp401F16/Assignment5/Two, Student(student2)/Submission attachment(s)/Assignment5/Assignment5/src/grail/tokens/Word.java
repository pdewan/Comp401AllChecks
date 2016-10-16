package grail.tokens;
import grail.interfaces.Token;
import grail.interfaces.WordToken;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;

@Tags({"Word"})
@StructurePattern(StructurePatternNames.BEAN_PATTERN)
@PropertyNames({"Input", "Value"})
@EditablePropertyNames({"Input"})

public class Word implements Token, WordToken {
	
	private String Input;
	private String Value;
	
	public String getInput () {
		return Input;
	}
	
	public String getValue () {
		return Value;
	}
	
	public void setInput (String newInput) {
		Input = newInput;
		Value = newInput.toLowerCase();
	}
	
	public Word (String newInput) {
		setInput(newInput);
	}
}
