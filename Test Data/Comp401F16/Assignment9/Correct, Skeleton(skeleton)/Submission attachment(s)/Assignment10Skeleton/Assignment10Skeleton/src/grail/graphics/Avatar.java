package grail.graphics;

import java.beans.PropertyChangeListener;

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
	
}
