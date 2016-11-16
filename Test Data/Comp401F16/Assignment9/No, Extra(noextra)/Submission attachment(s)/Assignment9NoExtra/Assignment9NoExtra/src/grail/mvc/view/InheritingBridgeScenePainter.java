package grail.mvc.view;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import grail.SingletonsCreator;
import grail.interfaces.BridgeSceneInterface;

public class InheritingBridgeScenePainter extends Component implements PropertyChangeListener {
	
	BridgeSceneInterface scene;
	
	public InheritingBridgeScenePainter(){
		scene = SingletonsCreator.bridgeSceneFactoryMethod();
		
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
		
		setFocusable(true);
	}
	
	@Override
	public void paint(Graphics g){
		super.paint(g);
		
		PaintingSupport.paintAvatar((Graphics2D)g, scene.getArthur());
		PaintingSupport.paintAvatar((Graphics2D)g, scene.getGalahad());
		PaintingSupport.paintAvatar((Graphics2D)g, scene.getGuard());
		PaintingSupport.paintAvatar((Graphics2D)g, scene.getLancelot());
		PaintingSupport.paintAvatar((Graphics2D)g, scene.getRobin());
			
		PaintingSupport.paintRectangle((Graphics2D)g, scene.getGorge().getBridge());
		PaintingSupport.paintLine((Graphics2D)g, scene.getGorge().getLeftSide());
		PaintingSupport.paintLine((Graphics2D)g, scene.getGorge().getRightSide());
		
		PaintingSupport.paintOval((Graphics2D)g, scene.getGuardArea());
		PaintingSupport.paintOval((Graphics2D)g, scene.getKnightArea());
	}
	
	@Override
	public void propertyChange(PropertyChangeEvent arg0) {
		repaint();
	}

}
