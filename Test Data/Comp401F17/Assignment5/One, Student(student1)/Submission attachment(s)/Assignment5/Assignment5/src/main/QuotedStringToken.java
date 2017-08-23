package main;

import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;

@Tags({ "Quote" })
@StructurePattern(StructurePatternNames.BEAN_PATTERN)
@PropertyNames({ "ScannedString" })
@EditablePropertyNames({ "ScannedString" })

public class QuotedStringToken implements Token {
  private String Input;

  public QuotedStringToken() {
    Input = "";
  }

  public void setInput(String scannedString) {
    Input = scannedString;
  }

  public String getInput() {
    return Input;
  }

}
