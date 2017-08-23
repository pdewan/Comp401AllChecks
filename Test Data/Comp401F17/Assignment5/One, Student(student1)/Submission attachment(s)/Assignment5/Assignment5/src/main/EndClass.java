package main;

import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;

@Tags({ "End" })

@StructurePattern(StructurePatternNames.BEAN_PATTERN)
@PropertyNames({ "Input" })
@EditablePropertyNames({ "Input" })

public class EndClass implements Token {
  private String Input;

  public EndClass() {
    Input = "}";
  }

  public void setInput(String scannedString) {
    Input = scannedString;
  }

  public String getInput() {
    return Input;
  }

}
