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
public class Avatar extends LocatableObject implements AvatarInterface {

	// The anchor is between the feet
	
	private static final double TORSO_LENGTH = 80;
	private static final double ARMS_LENGTH = 80;
	private static final double LEGS_LENGTH = 80;
	private static final double TORSO_ANGLE = Math.PI/2;
	
	private ImageInterface head;
	private VShapeInterface legs;
	private VShapeInterface arms;
	private RotatingLineInterface torso;
	private StringShapeInterface stringShape;
	
	public Avatar(ImageInterface head){
		this.head = head;
		
		// Construct other parts
		torso = new RotatingLine(0, 0, TORSO_LENGTH, TORSO_ANGLE);
		arms = new VShape(0, 0, ARMS_LENGTH);
		legs = new VShape(0, 0, LEGS_LENGTH);
		stringShape = new StringShape(0, 0, "");
		
		// Figure out the postion of the avatar anchor
		int xPos = head.getX() + (head.getWidth()/2);
		int yPos = (int)(head.getY() + head.getHeight()
						+ torso.getRadius() 
						+ legs.getRightLine().getHeight());	
		
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
		
		super.setX(newX);
		
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
	public void setY(int newY) {
		
		super.setY(newY);
		
		// Place the character:
		legs.setY(newY-legs.getRightLine().getHeight());
		
		int torsoTop = legs.getY()-torso.getHeight();
		torso.setY(torsoTop);
		arms.setY(torsoTop);
		
		// Head anchor is at its top, so adjust
		head.setY(torsoTop - head.getHeight());
		
		stringShape.setY(head.getY());
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
		setX(getX()+changeInX);
		setY(getY()+changeInY);
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
		
		// Use setters to reconstruct body
		setX(getX());
		setY(getY());
	}
}
