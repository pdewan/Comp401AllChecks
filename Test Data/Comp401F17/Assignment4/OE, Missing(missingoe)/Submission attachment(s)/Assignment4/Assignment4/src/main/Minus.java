package main;

import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;

@Tags({ "Minus" })
@StructurePattern(StructurePatternNames.BEAN_PATTERN)
@PropertyNames({ "Input" })
@EditablePropertyNames({ "Input" })

public class Minus implements Token {

	private String scannedString;

	public Minus(String token) {
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
