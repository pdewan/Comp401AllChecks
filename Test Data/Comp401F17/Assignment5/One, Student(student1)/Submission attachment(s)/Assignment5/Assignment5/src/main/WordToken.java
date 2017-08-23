package main;

import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;

@Tags({ "Word" })
@StructurePattern(StructurePatternNames.BEAN_PATTERN)
@PropertyNames({ "ScannedString" })
@EditablePropertyNames({ "ScannedString" })

public class WordToken implements WordInterface, Token {
  private String Input;
  private String Value;

  public WordToken() {
    Input = "";
  }

  public void setInput(String scannedString) {
    Input = scannedString;
  }

  public String getInput() {
    return Input;
  }

  public String getValue() {
    Value = Input.toLowerCase();
    return Value;
  }

}
