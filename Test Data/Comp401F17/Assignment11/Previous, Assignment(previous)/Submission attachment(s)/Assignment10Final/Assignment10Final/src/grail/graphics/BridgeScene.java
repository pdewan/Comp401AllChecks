package grail.graphics;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

import grail.interfaces.AvatarInterface;
import grail.interfaces.BoundedShapeInterface;
import grail.interfaces.BridgeSceneInterface;
import grail.interfaces.GorgeWithBridgeInterface;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;

@StructurePattern(StructurePatternNames.BEAN_PATTERN)
@Tags({"BridgeScene"})
@PropertyNames({"Guard", "Arthur", "Lancelot","Robin", "Galahad",
	"Gorge", "GuardArea", "KnightArea", "Occupied", "KnightTurn"})
public class BridgeScene implements BridgeSceneInterface {

	private static final String EMPTY_STRING = "";
	
	private static final int ARTHUR_LOCATION_X = 100;
	private static final int ARTHUR_LOCATION_Y = 300;
	private static final int LANCELOT_LOCATION_X = 200;
	private static final int LANCELOT_LOCATION_Y = 300;
	private static final int ROBIN_LOCATION_X = 300;
	private static final int ROBIN_LOCATION_Y = 300;
	private static final int GALAHAD_LOCATION_X = 400;
	private static final int GALAHAD_LOCATION_Y = 300;
	private static final int GUARD_LOCATION_X = 750;
	private static final int GUARD_LOCATION_Y = 300;
	
	private static final int GORGE_LEFT_X = 850;
	private static final int GORGE_RIGHT_X = 1050;
	private static final int BRIDGE_WIDTH = 50;
	private static final int BRIDGE_Y = 275;
	
	private static final int KNIGHT_AREA_X = 500;
	private static final int KNIGHT_AREA_Y = 250;
	private static final int GUARD_AREA_X = 700;
	private static final int GUARD_AREA_Y = 250;
	
	private static final int AREA_DIAMETERS = 100;
	
	private static final int PASS_DESTINATION_X = GORGE_RIGHT_X + 100;
	private static final int FAIL_DESTINATION_X = (GORGE_LEFT_X + GORGE_RIGHT_X)/2;
	private static final int FAIL_DESTINATION_Y = BRIDGE_Y + 300;
	
	private static final String ARTHUR_FILE_LOCATION = "images/arthur.jpg";
	private static final String LANCELOT_FILE_LOCATION = "images/lancelot.jpg";
	private static final String ROBIN_FILE_LOCATION = "images/robin.jpg";
	private static final String GALAHAD_FILE_LOCATION = "images/galahad.jpg";
	private static final String GUARD_FILE_LOCATION = "images/guard.jpg";
	
	private static final String PRECONDITION_PROPERTY = "this";
	private static final String APPROACH_METHOD_TAG = "approach";
	private static final String SAY_METHOD_TAG = "say";
	private static final String PASSED_METHOD_TAG = "passed";
	private static final String FAILED_METHOD_TAG = "failed";
	
	private AvatarInterface arthur;
	private AvatarInterface lancelot;
	private AvatarInterface robin;
	private AvatarInterface galahad;
	private AvatarInterface guard;
	
	private AvatarInterface occupyingKnight;
	
	private GorgeWithBridgeInterface gorge;
	private BoundedShapeInterface knightArea;
	private BoundedShapeInterface guardArea;
	
	private boolean occupied;
	private boolean knightTurn;
	
	private List<PropertyChangeListener> listeners = new ArrayList<PropertyChangeListener>();
	
	public BridgeScene(){
		arthur = new Avatar(ARTHUR_LOCATION_X, ARTHUR_LOCATION_Y, ARTHUR_FILE_LOCATION);
		lancelot = new Avatar(LANCELOT_LOCATION_X, LANCELOT_LOCATION_Y, LANCELOT_FILE_LOCATION);
		robin = new Avatar(ROBIN_LOCATION_X, ROBIN_LOCATION_Y, ROBIN_FILE_LOCATION);
		galahad = new Avatar(GALAHAD_LOCATION_X, GALAHAD_LOCATION_Y, GALAHAD_FILE_LOCATION);
		guard = new Avatar(GUARD_LOCATION_X,GUARD_LOCATION_Y, GUARD_FILE_LOCATION);
		
		gorge = new GorgeWithBridge(GORGE_LEFT_X, GORGE_RIGHT_X, BRIDGE_Y, BRIDGE_WIDTH);
		knightArea = new Oval(KNIGHT_AREA_X, KNIGHT_AREA_Y, AREA_DIAMETERS, AREA_DIAMETERS);
		guardArea = new Oval(GUARD_AREA_X, GUARD_AREA_Y, AREA_DIAMETERS, AREA_DIAMETERS);
		
		occupied = false;
		knightTurn = false;
	}
	
	@Override
	@Tags({"approach"})
	public void approach(AvatarInterface knight){
		assert preApproach();	//cannot be occupied
		
		// Place knight in middle of proper area
		knight.setX(knightArea.getX() + knightArea.getWidth()/2);
		knight.setY(knightArea.getY() + knightArea.getHeight()/2);
		occupied = true;
		knightTurn = false;
		occupyingKnight = knight;
		
		// Can now say, pass, or fail, but not approach
		notifyAllListeners(new PropertyChangeEvent(this, PRECONDITION_PROPERTY, APPROACH_METHOD_TAG, false));
		notifyAllListeners(new PropertyChangeEvent(this, PRECONDITION_PROPERTY, SAY_METHOD_TAG, true));
		notifyAllListeners(new PropertyChangeEvent(this, PRECONDITION_PROPERTY, PASSED_METHOD_TAG, true));
		notifyAllListeners(new PropertyChangeEvent(this, PRECONDITION_PROPERTY, FAILED_METHOD_TAG, true));
	}
	
	@Override
	public boolean preApproach(){
		return !getOccupied();
	}
	
	@Override
	@Tags({"say"})
	public void say(String string){
		assert getOccupied();
		
		if (getKnightTurn()){
			occupyingKnight.getStringShape().setText(string);
			getGuard().getStringShape().setText(EMPTY_STRING);
			knightTurn = false;
		}else{
			getGuard().getStringShape().setText(string);
			occupyingKnight.getStringShape().setText(EMPTY_STRING);
			knightTurn = true;
		}
		
		// Pass alternates between being allowed and not allowed
		notifyAllListeners(new PropertyChangeEvent(this, PRECONDITION_PROPERTY, PASSED_METHOD_TAG, prePassed()));
	}
	
	@Override
	public boolean preSay(){
		return getOccupied();
	}
	
	@Override
	@Tags({"passed"})
	public void passed(){
		assert prePassed();	// has to be occupied, has to be guard's turn
		
		occupyingKnight.setX(PASS_DESTINATION_X);
		
		// Reset challenge area
		occupyingKnight.getStringShape().setText(EMPTY_STRING);
		getGuard().getStringShape().setText(EMPTY_STRING);
		occupied = false;
		occupyingKnight = null;

		// Can now approach, but not say, pass, or fail
		notifyAllListeners(new PropertyChangeEvent(this, PRECONDITION_PROPERTY, APPROACH_METHOD_TAG, true));
		notifyAllListeners(new PropertyChangeEvent(this, PRECONDITION_PROPERTY, SAY_METHOD_TAG, false));
		notifyAllListeners(new PropertyChangeEvent(this, PRECONDITION_PROPERTY, PASSED_METHOD_TAG, false));
		notifyAllListeners(new PropertyChangeEvent(this, PRECONDITION_PROPERTY, FAILED_METHOD_TAG, false));
	}
	
	@Override
	public boolean prePassed(){
		return (getOccupied() && !getKnightTurn());
	}
	
	@Override
	@Tags({"failed"})
	public void failed(){
		assert preFailed();	//has to be occupied
		
		// if knight's turn, then guard falls
		if (getKnightTurn()){
			getGuard().getStringShape().setText(EMPTY_STRING);
			getGuard().setX(FAIL_DESTINATION_X);
			getGuard().setY(FAIL_DESTINATION_Y);
			
			// All preconditions stay the same
		}else{
			occupyingKnight.setX(FAIL_DESTINATION_X);
			occupyingKnight.setY(FAIL_DESTINATION_Y);
			occupyingKnight.getStringShape().setText(EMPTY_STRING);
			occupied = false;
			occupyingKnight = null;

			// Can now approach, but not say, pass, or fail
			notifyAllListeners(new PropertyChangeEvent(this, PRECONDITION_PROPERTY, APPROACH_METHOD_TAG, true));
			notifyAllListeners(new PropertyChangeEvent(this, PRECONDITION_PROPERTY, SAY_METHOD_TAG, false));
			notifyAllListeners(new PropertyChangeEvent(this, PRECONDITION_PROPERTY, PASSED_METHOD_TAG, false));
			notifyAllListeners(new PropertyChangeEvent(this, PRECONDITION_PROPERTY, FAILED_METHOD_TAG, false));
		}
	}
	
	@Override
	public boolean preFailed(){
		return getOccupied();
	}
	
	@Override
	@Tags({"scroll"})
	public void scroll(int scrollX, int scrollY) {
		arthur.move(-scrollX, -scrollY);
		lancelot.move(-scrollX, -scrollY);
		robin.move(-scrollX, -scrollY);
		galahad.move(-scrollX, -scrollY);
		guard.move(-scrollX, -scrollY);
		
		gorge.move(-scrollX, -scrollY);
		knightArea.move(-scrollX, -scrollY);
		guardArea.move(-scrollX, -scrollY);
	}
	
	@Override
	public boolean getOccupied(){
		return occupied;
	}
	
	@Override
	public boolean getKnightTurn(){
		return knightTurn;
	}
	
	@Override
	public GorgeWithBridgeInterface getGorge(){
		return gorge;
	}
	
	@Override
	public BoundedShapeInterface getKnightArea(){
		return knightArea;
	}
	
	@Override
	public BoundedShapeInterface getGuardArea(){
		return guardArea;
	}
	
	@Override
	public AvatarInterface getArthur() {
		return arthur;
	}

	@Override
	public AvatarInterface getLancelot() {
		return lancelot;
	}

	@Override
	public AvatarInterface getRobin() {
		return robin;
	}

	@Override
	public AvatarInterface getGalahad() {
		return galahad;
	}

	@Override
	public AvatarInterface getGuard() {
		return guard;
	}

	@Override
	public void addPropertyChangeListener(PropertyChangeListener listener) {
		listeners.add(listener);
	}
	
	protected void notifyAllListeners(PropertyChangeEvent e){
		for (PropertyChangeListener listener : listeners){
			listener.propertyChange(e);
		}
	}
}
