package main;

import util.annotations.Tags;

@Tags({ "Say" })

public class SayToken implements WordInterface, Token {
  private String Input;
  private String Value;

  public SayToken() {
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
