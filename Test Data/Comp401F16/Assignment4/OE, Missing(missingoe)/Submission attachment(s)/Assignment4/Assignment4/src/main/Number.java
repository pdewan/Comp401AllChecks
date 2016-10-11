package main;

import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;

@Tags({ "Number" })
@StructurePattern(StructurePatternNames.BEAN_PATTERN)
@PropertyNames({ "Input", "Value" })
@EditablePropertyNames({ "Input" })

public class Number implements Token, TokenNumber {

	private String scannedString;

	public Number(String token) {
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
	public int getValue() {
		int result = 0;
		result = Integer.parseInt(scannedString);
		return result;
	}
}
