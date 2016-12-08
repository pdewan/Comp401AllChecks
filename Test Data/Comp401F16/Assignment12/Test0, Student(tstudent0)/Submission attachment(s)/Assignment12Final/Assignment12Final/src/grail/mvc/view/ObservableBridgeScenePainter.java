package grail.mvc.view;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

import grail.interfaces.mvc.PaintListener;
import grail.interfaces.mvc.PaintingViewMaster;
import util.annotations.Tags;

@Tags({"ObservableBridgeScenePainter"})
public class ObservableBridgeScenePainter extends Component implements PaintingViewMaster{
	
	List<PaintListener> listeners;
	
	public ObservableBridgeScenePainter() {
		listeners = new ArrayList<PaintListener>();
		setFocusable(true);
	}
	
	@Override
	@Tags({"addPaintListener"})
	public void addPaintListener(PaintListener listener){
		listeners.add(listener);
	}
	
	@Override
	public void paint(Graphics g){
		super.paint(g);
		
		for (PaintListener listener : listeners){
			listener.paint((Graphics2D) g);
		}
	}
}
