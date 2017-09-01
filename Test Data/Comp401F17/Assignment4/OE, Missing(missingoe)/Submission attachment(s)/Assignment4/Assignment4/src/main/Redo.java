package main;

import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;

@Tags({ "Redo" })
@StructurePattern(StructurePatternNames.BEAN_PATTERN)
@PropertyNames({ "Input", "Value" })
@EditablePropertyNames({ "Input" })

public class Redo implements Token, TokenWord {

	private String scannedString;

	public Redo(String token) {
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

	@Override
	public String getValue() {
		String result = "";
		result = scannedString.toLowerCase();
		return result;
	}

}
