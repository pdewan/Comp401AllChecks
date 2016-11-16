package grail.mvc.controller;

import java.awt.Component;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeListener;

import grail.SingletonsCreator;
import grail.interfaces.AvatarInterface;
import grail.interfaces.BridgeSceneInterface;
import grail.interfaces.mvc.BridgeSceneControllerInterface;
import util.annotations.Tags;

@Tags({"BridgeSceneController"})
public class BridgeSceneController implements BridgeSceneControllerInterface{
	
	PropertyChangeListener painter;
	BridgeSceneInterface scene;
	
	private int lastClickX;
	private int lastClickY;
	private boolean clicked = false;	// to only respond to keys after click
	
	public BridgeSceneController(PropertyChangeListener painter){
		this.painter = painter;
		scene = SingletonsCreator.bridgeSceneFactoryMethod();
		((Component)painter).addKeyListener(this);
		((Component)painter).setFocusable(true);
		((Component)painter).addMouseListener(this);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		clicked = true;
		lastClickX = e.getX();
		lastClickY = e.getY();
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		// Do nothing if haven't clicked
		if (!clicked){
			return;
		}
		
		AvatarInterface knightToMove = null;
		switch (e.getKeyChar()){
		case 'a':
			knightToMove = scene.getArthur();
			break;
		case 'g':
			knightToMove = scene.getGalahad();
			break;
		case 'l':
			knightToMove = scene.getLancelot();
			break;
		case 'r':
			knightToMove = scene.getRobin();
			break;
		}
		
		if (knightToMove != null){
			knightToMove.setX(lastClickX);
			knightToMove.setY(lastClickY);
		}
	}
	
	
	
	/* Unused: */
	
	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}

	@Override
	public void mousePressed(MouseEvent e) {}

	@Override
	public void mouseReleased(MouseEvent e) {}

	@Override
	public void keyPressed(KeyEvent e) {}

	@Override
	public void keyReleased(KeyEvent e) {}
}
