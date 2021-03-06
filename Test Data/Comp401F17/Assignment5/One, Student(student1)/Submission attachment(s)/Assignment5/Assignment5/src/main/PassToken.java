package main;

import util.annotations.Tags;

@Tags({ "Pass" })
public class PassToken implements WordInterface, Token {
  private String Input;
  private String Value;

  public PassToken() {
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
