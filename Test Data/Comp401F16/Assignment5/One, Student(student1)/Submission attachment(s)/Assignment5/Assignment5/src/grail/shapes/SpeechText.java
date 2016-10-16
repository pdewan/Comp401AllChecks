package grail.shapes;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;
@StructurePattern(StructurePatternNames.STRING_PATTERN)
@Tags({"String"})

public class SpeechText {

    String text;
    int x = 100, y = 100;

    public SpeechText(String initText, int initX, int initY) {
      text = initText;
      x = initX;
      y = initY;
    }
    public int getX() {
      return x;
    }
    
    public void setX(int newX) {
      x = newX;
    }
    
    public int getY() {
      return y;
    }
    
    public void setY(int newY) {
      y = newY;
    }
    
    public String getText() {
      return text;
    }
    
    public void setText(String newVal) {
      text = newVal;
    }

  
}
