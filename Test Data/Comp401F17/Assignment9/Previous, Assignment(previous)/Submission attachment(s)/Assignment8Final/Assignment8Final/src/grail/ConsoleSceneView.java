package grail;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import grail.graphics.Avatar;
import grail.interfaces.AvatarInterface;
import grail.interfaces.BridgeSceneInterface;
import grail.interfaces.VShapeInterface;
import util.annotations.Tags;

@Tags({"ConsoleSceneView"})
public class ConsoleSceneView implements PropertyChangeListener{

	/**
	 * Constructor automatically registers this class as an observer of BridgeSceneInterface
	 */
	public ConsoleSceneView(){
		
		BridgeSceneInterface scene = SingletonsCreator.bridgeSceneFactoryMethod();
		
		// Register as listener of knights
		registerAsListenerOf(scene.getArthur());
		registerAsListenerOf(scene.getGalahad());
		registerAsListenerOf(scene.getGuard());
		registerAsListenerOf(scene.getLancelot());
		registerAsListenerOf(scene.getRobin());
		
		// Register for gorge
		scene.getGorge().getBridge().addPropertyChangeListener(this);
		scene.getGorge().getLeftSide().addPropertyChangeListener(this);
		scene.getGorge().getRightSide().addPropertyChangeListener(this);
		
		scene.getGuardArea().addPropertyChangeListener(this);
		scene.getKnightArea().addPropertyChangeListener(this);
	}
	
	private void registerAsListenerOf(AvatarInterface avatar){
		registerAsListenerOf(avatar.getArms());
		registerAsListenerOf(avatar.getLegs());
		avatar.getHead().addPropertyChangeListener(this);
		avatar.getStringShape().addPropertyChangeListener(this);
		avatar.getTorso().addPropertyChangeListener(this);
	}
	
	private void registerAsListenerOf(VShapeInterface vShape){
		vShape.getLeftLine().addPropertyChangeListener(this);
		vShape.getRightLine().addPropertyChangeListener(this);
	}
	
	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		System.out.println(evt);
	}
	
}
