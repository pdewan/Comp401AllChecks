package grail.shapes;

import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;

@StructurePattern(StructurePatternNames.BEAN_PATTERN)
@Tags({"BridgeScene"})


public class AllFiveGuys implements AllFiveGuysInterface{
  AvatarClass guard, arthur, lancelot, robin, galahad;
    
  public AllFiveGuys(){
      guard = new AvatarClass("guard.jpg");
      arthur = new AvatarClass("arthur.jpg");
      lancelot = new AvatarClass("lancelot.jpg");
      robin = new AvatarClass("robin.jpg");
      galahad = new AvatarClass("galahad.jpg");
      
      arthur.moveBody(null, 200,0);
      lancelot.moveBody(null, -200, 0);
      robin.moveBody(null, 400, 0);
      galahad.moveBody(null, 600, 0);

     
    }
  
  public AvatarClass getGuard(){
    return guard;
  }
  public AvatarClass getArthur(){
    return arthur;
  }
  public AvatarClass getLancelot(){
    return lancelot;
  }
  public AvatarClass getRobin() {
    return robin;
  }
  public AvatarClass getGalahad(){
    return galahad;
  }
}
