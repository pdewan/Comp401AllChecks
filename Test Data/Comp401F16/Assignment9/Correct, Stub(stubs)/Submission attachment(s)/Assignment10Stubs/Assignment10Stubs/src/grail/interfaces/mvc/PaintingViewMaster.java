package grail.interfaces.mvc;

import java.awt.Graphics;
import util.annotations.Tags;

@Tags({"ObservableBridgeScenePainter"})
public interface PaintingViewMaster {
	public void addPaintListener(PaintListener listener);
	public void repaint();
}
