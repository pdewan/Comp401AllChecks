package grail.graphics;

import grail.interfaces.AvatarInterface;
import grail.interfaces.ImageInterface;
import grail.interfaces.RotatingLineInterface;
import grail.interfaces.StringShapeInterface;
import grail.interfaces.VShapeInterface;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;
import util.annotations.Visible;

@StructurePattern(StructurePatternNames.BEAN_PATTERN)
@Tags({"Avatar"})
@PropertyNames({"X", "Y","Head", "Legs", "Arms", "Torso", "StringShape"})
@EditablePropertyNames({"X", "Y"})
public class Avatar implements AvatarInterface {

	private static final double TORSO_LENGTH = 80;
	private static final double ARMS_LENGTH = 80;
	private static final double LEGS_LENGTH = 80;
	private static final double TORSO_ANGLE = Math.PI/2;
	
	// The anchor is at the center of the torso
	private int x;
	private int y;
	
	private ImageInterface head;
	private VShapeInterface legs;
	private VShapeInterface arms;
	private RotatingLineInterface torso;
	private 	StringShapeInterface stringShape;
	
	public Avatar(ImageInterface head){
		this.head = head;
		
		// Construct other parts
		torso = new RotatingLine(0, 0, TORSO_LENGTH, TORSO_ANGLE);
		arms = new VShape(0, 0, ARMS_LENGTH);
		legs = new VShape(0, 0, LEGS_LENGTH);
		stringShape = new StringShape(0, 0, "");
		
		// Figure out the postion of the avatar anchor
		int xPos = head.getX() + (head.getWidth()/2);
		int yPos = (int)(head.getY() + head.getHeight() + (torso.getRadius()/2));
		
		// Use setters to build character
		setX(xPos);
		setY(yPos);
	}
	
	public Avatar(int xPos, int yPos, String imageFileName){
		// Construct parts
		head = new Image(0, 0, imageFileName);
		torso = new RotatingLine(0, 0, TORSO_LENGTH, TORSO_ANGLE);
		arms = new VShape(0, 0, ARMS_LENGTH);
		legs = new VShape(0, 0, LEGS_LENGTH);
		stringShape = new StringShape(0, 0, "");
		
		// Use setters to build character
		setX(xPos);
		setY(yPos);
	}
	
	@Visible(false)
	@Override
	public void setX(int newX) {
		
		x = newX;
		
		// Place the character:
		// Since character is upright, everything is already
		// centered except the head and utterance
		legs.setX(newX);
		torso.setX(newX);
		arms.setX(newX);
		
		head.setX(newX-(head.getWidth())/2);
		stringShape.setX(head.getX() + head.getWidth());
	}

	@Visible(false)
	@Override
	public int getX() {
		return x;
	}
	
	@Visible(false)
	@Override
	public void setY(int newY) {
		
		y = newY;
		
		// Place the character:
		// Start with torso
		int torsoTop = (int)(newY-(torso.getRadius()/2));
		torso.setY(torsoTop);
		int torsoBottom = (int)(torso.getY() + torso.getRadius());
		
		// set other shapes accordingly
		arms.setY(torsoTop);
		legs.setY(torsoBottom);
		
		// Head anchor is at its top, so adjust
		head.setY(torsoTop - head.getHeight());
		
		stringShape.setY(head.getY());
	}

	@Visible(false)
	@Override
	public int getY() {
		return y;
	}

	@Override
	public StringShapeInterface getStringShape() {
		return stringShape;
	}

	@Override
	public ImageInterface getHead() {
		return head;
	}

	@Override
	public VShapeInterface getArms() {
		return arms;
	}

	@Override
	public VShapeInterface getLegs() {
		return legs;
	}

	@Override
	public RotatingLineInterface getTorso() {
		return torso;
	}

	@Tags({"move"})
	@Override
	public void move(int changeInX, int changeInY) {
		setX(x+changeInX);
		setY(y+changeInY);
	}

	@Tags({"scale"})
	@Override
	public void scale(double scalar) {
		
		// Ceiling necessary because otherwise small changes are not visible
		head.setHeight((int)Math.ceil(head.getHeight() * scalar));
		head.setWidth((int)Math.ceil(head.getWidth()*scalar));
			
		legs.setLinesLength(legs.getLinesLength() * scalar);
		arms.setLinesLength(arms.getLinesLength() * scalar);
		torso.setRadius(torso.getRadius() * scalar);
		
		// adjust position of components using the setX and setY methods
		// (setX is actually unnecessary in this case since head is not
		// being scaled)
		setX(x);
		setY(y);
	}
}
