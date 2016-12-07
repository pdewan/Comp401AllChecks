package grail.interfaces.mvc;

import java.awt.Graphics2D;
import java.beans.PropertyChangeListener;

import util.annotations.Tags;

@Tags({"PaintListener"})
public interface PaintListener extends PropertyChangeListener{
	void paint(Graphics2D g);
}
