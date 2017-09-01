package main;

import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;

@Tags({ "Start" })
@StructurePattern(StructurePatternNames.BEAN_PATTERN)
@PropertyNames({ "Input", "Value" })
@EditablePropertyNames({ "Input" })

public class Start implements Token {

	private String scannedString;

	public Start(String token) {
		scannedString = token;
	}

	@Override
	public void setInput(String scannedString) {
		this.scannedString = scannedString;

	}

	@Override
	public String getInput() {
		return scannedString;
	}

}
