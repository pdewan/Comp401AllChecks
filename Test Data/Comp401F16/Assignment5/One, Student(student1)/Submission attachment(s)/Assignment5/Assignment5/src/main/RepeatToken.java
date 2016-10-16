package main;

import util.annotations.Tags;

@Tags({ "Repeat" })

public class RepeatToken implements WordInterface, Token {
  private String Input;
  private String Value;

  public RepeatToken() {
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
