package main;

import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;

@Tags({ "Number" })
@StructurePattern(StructurePatternNames.BEAN_PATTERN)
@PropertyNames({ "ScannedString" })
@EditablePropertyNames({ "ScannedString" })

public class NumberToken implements NumberInterface, Token {
  private String Input;
  private int    Value;

  public NumberToken() {
    Input = "0";
  }

  public void setInput(String scannedString) {
    Input = scannedString;
  }

  public String getInput() {
    return Input;
  }

  public int getValue() {
    Value = Integer.parseInt(Input);
    return Value;
  }

}
