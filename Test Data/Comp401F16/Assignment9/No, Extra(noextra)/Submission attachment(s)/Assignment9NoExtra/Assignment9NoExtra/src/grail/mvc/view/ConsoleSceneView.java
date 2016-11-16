package grail.mvc.view;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import grail.SingletonsCreator;
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
		scene.getArthur().addPropertyChangeListenerToAtomics(this);
		scene.getGalahad().addPropertyChangeListenerToAtomics(this);
		scene.getGuard().addPropertyChangeListenerToAtomics(this);
		scene.getLancelot().addPropertyChangeListenerToAtomics(this);
		scene.getRobin().addPropertyChangeListenerToAtomics(this);
			
		scene.getGorge().getBridge().addPropertyChangeListener(this);
		scene.getGorge().getLeftSide().addPropertyChangeListener(this);
		scene.getGorge().getRightSide().addPropertyChangeListener(this);
		
		scene.getGuardArea().addPropertyChangeListener(this);
		scene.getKnightArea().addPropertyChangeListener(this);
	}
	
	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		System.out.println(evt);
	}
	
}
