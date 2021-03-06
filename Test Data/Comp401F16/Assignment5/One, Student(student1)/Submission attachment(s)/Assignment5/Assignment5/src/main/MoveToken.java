package main;

import util.annotations.Tags;

@Tags({ "Move" })
public class MoveToken implements WordInterface, Token {

  private String Input;
  private String Value;

  public MoveToken() {
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
