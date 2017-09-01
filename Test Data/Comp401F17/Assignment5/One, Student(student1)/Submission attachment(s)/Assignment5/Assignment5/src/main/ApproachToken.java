package main;

import util.annotations.Tags;

@Tags({ "Approach" })
public class ApproachToken implements WordInterface, Token {
  private String Input;
  private String Value;

  public ApproachToken() {
    Input = "approach";
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
