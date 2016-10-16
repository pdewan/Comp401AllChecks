package main;

import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;

@Tags({ "Start" })
@StructurePattern(StructurePatternNames.BEAN_PATTERN)
@PropertyNames({ "ScannedString" })
@EditablePropertyNames({ "ScannedString" })

public class StartClass implements Token {
  private String Input;

  public StartClass() {
    Input = "{";
  }

  public void setInput(String scannedString) {
    Input = scannedString;
  }

  public String getInput() {
    return Input;
  }
}
