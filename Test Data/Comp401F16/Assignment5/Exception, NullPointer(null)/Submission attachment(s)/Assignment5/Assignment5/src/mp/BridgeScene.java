package mp;
import util.annotations.Tags;
import grail.AHeadImage;
import grail.AStringShape;
import grail.Angle;
import grail.RotatingLine;
import util.annotations.StructurePattern;

@StructurePattern("Bean Pattern")
@Tags({"BridgeScene"})
public class BridgeScene {
	private Avatar arthur, lancelot, robin, galahad, guard;
	
	public BridgeScene(){
		arthur = new Avatar("arthur.jpg", 100, 100, 75, 20, "Arthur is my name.", 75, 75);
		lancelot = new Avatar("lancelot.jpg", 100, 400, 75, 20, "Lancelot is my name.", 75, 75);
		robin = new Avatar("robin.jpg", 300, 100, 75, 20, "Robin is my name.", 75, 75);
		galahad = new Avatar("galahad.jpg", 300, 400, 75, 20, "Galahad is my name.", 75, 75);
		guard = new Avatar("guard.jpg", 500, 250, 75, 20, "I am a guard", 75, 75);
	}
	
	public Avatar getArthur(){
		return arthur;
	}
	public Avatar getLancelot(){
		return lancelot;
	}
	public Avatar getRobin(){
		return robin;
	}
	public Avatar getGalahad(){
		return galahad;
	}
	public Avatar getGuard(){
		return guard;
	}
}
