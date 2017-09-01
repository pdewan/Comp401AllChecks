package grail.interfaces.mvc;

import util.annotations.Tags;

@Tags({"ObservableBridgeScenePainter"})
public interface PaintingViewMaster {
	public void addPaintListener(PaintListener listener);
	public void repaint();
}
