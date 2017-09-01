package grail.shapes;
import grail.interfaces.*;
import util.annotations.Tags;

@Tags({"Avatar"})
public class AnAvatar implements Avatar {
	private HeadImage Head;
	private DisplayString StringShape; 
	private Angle Arms;
	private Angle Legs;
	private RotatingLine Body;
	private RotatingLine Neck;
	
	private final String DEFAULT_HEAD_FILENAME = "robin.jpg";
	private final int DEFAULT_HEAD_POSITION_X = 250;
	private final int DEFAULT_HEAD_POSITION_Y = 250;
	
	private final int CONSTRUCTION_LOCATION = 0;
	
	private final String DEFAULT_STRINGSHAPE = "Brave, brave Sir Robin!";
	
	private final int DEFAULT_ARMS_HEIGHT = 50;
	private final int DEFAULT_ARMS_WIDTH = 30;
	
	private final int DEFAULT_LEGS_HEIGHT = 40;
	private final int DEFAULT_LEGS_WIDTH = 40;
	
	private final int DEFAULT_BODY_LENGTH = 100;
	private final int DEFAULT_BODY_WIDTH = 0;
	
	private final int DEFAULT_NECK_LENGTH = 20;
	private final int DEFAULT_NECK_WIDTH = 0;
	
	@Tags({"scale"})
	public void scaleAvatar (double scale) {
		Head.setHeight((int) (Head.getHeight() * scale));
		Head.setWidth((int) (Head.getWidth() * scale));
		Neck.setHeight((int) (Neck.getHeight() * scale));
		Arms.getLeftLine().setRadius(Arms.getLeftLine().getRadius() * scale);
		Arms.getRightLine().setRadius(Arms.getRightLine().getRadius() * scale);
		Legs.getLeftLine().setRadius(Legs.getLeftLine().getRadius() * scale);
		Legs.getRightLine().setRadius(Legs.getRightLine().getRadius() * scale);
		Body.setHeight((int) (Body.getHeight() * scale));
		connectAvatar(Head.getX(), Head.getY());
	}
	
	@Tags({"move"})
	public void moveAll (int dX, int dY) {
		Head.moveHead(dX, dY);
		connectAvatar(Head.getX(), Head.getY());
	}
	
	@Tags({"connect"})
	public void connectAvatar(int xLoc, int yLoc) {
		//Icon headIcon = new ImageIcon(Head.getImageFileName());
		int imageHeight = Head.getHeight();
		int imageWidth = Head.getWidth();
		int avatarCenter = xLoc + (imageWidth/2);
		Head.setX(xLoc);
		Head.setY(yLoc);
		Neck.setX(avatarCenter);
		Neck.setY(yLoc + imageHeight);
		Arms.getLeftLine().setX(avatarCenter);
		Arms.getLeftLine().setY(yLoc + imageHeight + Neck.getHeight());
		Arms.getRightLine().setX(avatarCenter);
		Arms.getRightLine().setY(yLoc + imageHeight + Neck.getHeight());
		Body.setX(avatarCenter);
		Body.setY(yLoc + imageHeight + Neck.getHeight());
		Legs.getLeftLine().setX(avatarCenter);
		Legs.getLeftLine().setY(yLoc + imageHeight + Neck.getHeight() + Body.getHeight());
		Legs.getRightLine().setX(avatarCenter);
		Legs.getRightLine().setY(yLoc + imageHeight + Neck.getHeight() + Body.getHeight());
		StringShape.setX(xLoc + imageWidth);
		StringShape.setY(yLoc);
	}
	
	
	public HeadImage getHead() {
		return Head;
	}
	public DisplayString getStringShape() {
		return StringShape;
	}
	public Angle getArms() {
		return Arms;
	}
	public Angle getLegs() {
		return Legs;
	}
	public RotatingLine getBody() {
		return Body;
	}
	public RotatingLine getNeck() {
		return Neck;
	}
	
	public AnAvatar(HeadImage initHead) {
		Head = initHead;
		StringShape = new ADisplayString(DEFAULT_STRINGSHAPE, CONSTRUCTION_LOCATION, CONSTRUCTION_LOCATION);
		Arms = new AnAngle(CONSTRUCTION_LOCATION, CONSTRUCTION_LOCATION, DEFAULT_ARMS_HEIGHT, DEFAULT_ARMS_WIDTH);
		Legs = new AnAngle(CONSTRUCTION_LOCATION, CONSTRUCTION_LOCATION, DEFAULT_LEGS_HEIGHT, DEFAULT_LEGS_WIDTH);
		Neck = new ARotatingLine(CONSTRUCTION_LOCATION, CONSTRUCTION_LOCATION, DEFAULT_NECK_LENGTH, DEFAULT_NECK_WIDTH);
		Body = new ARotatingLine(CONSTRUCTION_LOCATION, CONSTRUCTION_LOCATION, DEFAULT_BODY_LENGTH, DEFAULT_BODY_WIDTH);
		connectAvatar(Head.getX(), Head.getY());
	}
	
	public AnAvatar() {
		Head = new AHeadImage(DEFAULT_HEAD_FILENAME, DEFAULT_HEAD_POSITION_X, DEFAULT_HEAD_POSITION_Y);
		StringShape = new ADisplayString(DEFAULT_STRINGSHAPE, CONSTRUCTION_LOCATION, CONSTRUCTION_LOCATION);
		Arms = new AnAngle(CONSTRUCTION_LOCATION, CONSTRUCTION_LOCATION, DEFAULT_ARMS_HEIGHT, DEFAULT_ARMS_WIDTH);
		Legs = new AnAngle(CONSTRUCTION_LOCATION, CONSTRUCTION_LOCATION, DEFAULT_LEGS_HEIGHT, DEFAULT_LEGS_WIDTH);
		Neck = new ARotatingLine(CONSTRUCTION_LOCATION, CONSTRUCTION_LOCATION, DEFAULT_NECK_LENGTH, DEFAULT_NECK_WIDTH);
		Body = new ARotatingLine(CONSTRUCTION_LOCATION, CONSTRUCTION_LOCATION, DEFAULT_BODY_LENGTH, DEFAULT_BODY_WIDTH);
		connectAvatar(Head.getX(), Head.getY());
	}
}
