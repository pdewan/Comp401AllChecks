package grail.interfaces.mvc;

import java.awt.Graphics2D;

import util.annotations.Tags;

@Tags({"PaintListener"})
public interface PaintingViewModule extends PaintListener{
	public void paint(Graphics2D g);
}
