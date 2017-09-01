package grail.shapes;
import grail.interfaces.*;
import util.annotations.Tags;
import grail.shapes.*;

@Tags({"BridgeScene"})
public class ABridgeScene implements BridgeScene {
	private Avatar Robin;
	private Avatar Galahad;
	private Avatar Arthur;
	private Avatar Guard;
	private Avatar Lancelot;
	
	HeadImage DEFAULT_ROBIN_HEAD = new AHeadImage("robin.jpg", 150, 200);
	HeadImage DEFAULT_GALAHAD_HEAD = new AHeadImage("galahad.jpg", 250, 220);
	HeadImage DEFAULT_ARTHUR_HEAD = new AHeadImage("arthur.jpg", 350, 240);
	HeadImage DEFAULT_GUARD_HEAD = new AHeadImage("guard.jpg", 450, 260);
	HeadImage DEFAULT_LANCELOT_HEAD = new AHeadImage("lancelot.jpg", 550, 280);
	
	public Avatar getRobin() {
		return Robin;
	}
	public Avatar getGalahad() {
		return Galahad;
	}
	public Avatar getArthur() {
		return Arthur;
	}
	public Avatar getGuard() {
		return Guard;
	}
	public Avatar getLancelot() {
		return Lancelot;
	}
	
	public ABridgeScene() {
		Robin = new AnAvatar(DEFAULT_ROBIN_HEAD);
		Galahad = new AnAvatar(DEFAULT_GALAHAD_HEAD);
		Arthur = new AnAvatar(DEFAULT_ARTHUR_HEAD);
		Guard = new AnAvatar(DEFAULT_GUARD_HEAD);
		Lancelot = new AnAvatar(DEFAULT_LANCELOT_HEAD);
	}
	
	public ABridgeScene(Avatar initRobin, Avatar initGalahad, Avatar initArthur, Avatar initGuard, Avatar initLancelot) {
		Robin = initRobin;
		Galahad = initGalahad;
		Arthur = initArthur;
		Guard = initArthur;
		Lancelot = initLancelot;
	}
	
	public ABridgeScene(HeadImage robinHead, HeadImage galahadHead, HeadImage arthurHead, HeadImage guardHead, HeadImage lancelotHead) {
		Robin = new AnAvatar(robinHead);
		Galahad = new AnAvatar(galahadHead);
		Arthur = new AnAvatar(arthurHead);
		Guard = new AnAvatar(guardHead);
		Lancelot = new AnAvatar(lancelotHead);
	}
}
