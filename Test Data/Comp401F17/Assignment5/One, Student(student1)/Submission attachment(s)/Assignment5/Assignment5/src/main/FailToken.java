package main;

import util.annotations.Tags;

@Tags({ "Fail" })
public class FailToken implements WordInterface, Token {
  private String Input;
  private String Value;

  public FailToken() {
    Input = "fail";
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
