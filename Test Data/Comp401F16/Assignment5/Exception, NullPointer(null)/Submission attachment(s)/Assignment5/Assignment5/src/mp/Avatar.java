package mp;

import util.annotations.Tags;
import grail.AHeadImage;
import grail.AStringShape;
import grail.Angle;
import grail.RotatingLine;
import util.annotations.StructurePattern;

@StructurePattern("Bean Pattern")
@Tags({"Avatar"})
public class Avatar {
	AHeadImage head;
	Angle arms, legs;
	RotatingLine neck, torso;
	AStringShape text;
	private int neckY, bodyX, bodyY, textX, textY, legY, torsoLength, neckLength, armLength, legLength;
	private int x, y;
	String filename, newText;
	
	public Avatar(String aFilename, int newX, int newY, int aTorsoLength, int aNeckLength, String aText, int aArmLength, int aLegLength){
		x = newX;
		y = newY;
		filename = aFilename;
		newText = aText;
		torsoLength = aTorsoLength;
		neckLength = aNeckLength;
		armLength = aArmLength;
		legLength = aLegLength;
		head = new AHeadImage(filename, x, y);
		neckY = y + head.getHeight();
		bodyX = x + head.getWidth()/2;
		bodyY = y + neckLength + head.getHeight();
		textX = x + head.getWidth();
		textY = y;
		neck = new RotatingLine(neckLength, 90*Math.PI/180);
		neck.setUpperLeftCorner(bodyX, neckY);
		arms = new Angle(bodyX, bodyY, armLength);
		torso = new RotatingLine(torsoLength, 90*Math.PI/180);
		torso.setUpperLeftCorner(bodyX, bodyY);
		legY = bodyY + torsoLength;
		legs = new Angle(bodyX, legY, legLength);
		text = new AStringShape(newText, textX, textY);
	}
	
	public AHeadImage getHead(){
		return head;
	}
	public Angle getArms(){
		return arms;
	}
	public RotatingLine getTorso(){
		return torso;
	}
	public RotatingLine getNeck(){
		return neck;
	}
	public Angle getLegs(){
		return legs;
	}
	public AStringShape getText(){
		return text;
	}
	@Tags({"move"})
	public void move(int moveX, int moveY){

		x = x + moveX;
		y = y + moveY;
		head = new AHeadImage(filename, x, y);
		neckY = y + head.getHeight();
		bodyX = x + head.getWidth()/2;
		bodyY = y + neckLength + head.getHeight();
		textX = x + head.getWidth();
		textY = y;
		neck = new RotatingLine(neckLength, 90*Math.PI/180);
		neck.setUpperLeftCorner(bodyX, neckY);
		arms = new Angle(bodyX, bodyY, armLength);
		torso = new RotatingLine(torsoLength, 90*Math.PI/180);
		torso.setUpperLeftCorner(bodyX, bodyY);
		legY = bodyY + torsoLength;
		legs = new Angle(bodyX, legY, legLength);
		text = new AStringShape(newText, textX, textY);
	}
	@Tags({"scale"})
	public void scale(double newScale){

		torsoLength *= newScale;
		neckLength *= newScale;
		armLength *= newScale;
		legLength *= newScale;
		head = new AHeadImage(filename, x, y);
		neckY = y + head.getHeight();
		bodyX = x + head.getWidth()/2;
		bodyY = y + neckLength + head.getHeight();
		textX = x + head.getWidth();
		textY = y;
		neck = new RotatingLine(neckLength, 90*Math.PI/180);
		neck.setUpperLeftCorner(bodyX, neckY);
		arms = new Angle(bodyX, bodyY, armLength);
		torso = new RotatingLine(torsoLength, 90*Math.PI/180);
		torso.setUpperLeftCorner(bodyX, bodyY);
		legY = bodyY + torsoLength;
		legs = new Angle(bodyX, legY, legLength);
		text = new AStringShape(newText, textX, textY);
	}
}
