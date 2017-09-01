package main;

import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.Tags;

@StructurePattern("Bean Pattern")
@PropertyNames({ "Input", "Value" })
@EditablePropertyNames({ "InputString" })
@Tags({ "Token", "Number", "End", "Minus", "Plus", "QuotedString", "Start", "Word", "Approach", "Call", "Define",
		"Fail", "Move", "Pass", "ProceedAll", "Redo", "Repeat", "Say", "Sleep", "Thread", "Under", "Wait", })

public interface Token {

	public void setInput(String scannedString);

	public String getInput();

}
