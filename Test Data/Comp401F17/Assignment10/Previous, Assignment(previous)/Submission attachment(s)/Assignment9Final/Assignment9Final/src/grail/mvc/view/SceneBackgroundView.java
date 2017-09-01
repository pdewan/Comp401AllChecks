package grail.mvc.view;

import java.awt.Graphics2D;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import grail.interfaces.BridgeSceneInterface;
import grail.interfaces.mvc.PaintListener;
import grail.interfaces.mvc.PaintingViewMaster;
import util.annotations.Tags;

@Tags({"PaintListener"})
public class SceneBackgroundView implements PaintListener{
	BridgeSceneInterface scene;
	PaintingViewMaster painter;
	
	public SceneBackgroundView(BridgeSceneInterface scene, PaintingViewMaster painter){
		this.scene = scene;
		this.painter = painter;
		
		// Register for gorge
		registerAsListenerOfBackground(scene, this);
	}
	
	public static void registerAsListenerOfBackground(BridgeSceneInterface scene, PropertyChangeListener listener){	
		
		// Register for gorge
		scene.getGorge().getBridge().addPropertyChangeListener(listener);
		scene.getGorge().getLeftSide().addPropertyChangeListener(listener);
		scene.getGorge().getRightSide().addPropertyChangeListener(listener);
		
		scene.getGuardArea().addPropertyChangeListener(listener);
		scene.getKnightArea().addPropertyChangeListener(listener);
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		painter.repaint();
	}

	@Override
	public void paint(Graphics2D g) {
		PaintingSupport.paintLine(g, scene.getGorge().getLeftSide());
		PaintingSupport.paintLine(g, scene.getGorge().getRightSide());
		PaintingSupport.paintRectangle(g, scene.getGorge().getBridge());
		PaintingSupport.paintOval(g, scene.getGuardArea());
		PaintingSupport.paintOval(g, scene.getKnightArea());
	}
	
	
}
