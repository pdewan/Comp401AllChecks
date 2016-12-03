package grail.mvc.view;

import java.awt.Graphics2D;
import java.beans.PropertyChangeEvent;

import grail.interfaces.AvatarInterface;
import grail.interfaces.mvc.PaintListener;
import grail.interfaces.mvc.PaintingViewMaster;
import util.annotations.Tags;

@Tags({"PaintListener"})
public class AvatarView implements PaintListener{
	
	PaintingViewMaster painter;
	AvatarInterface avatar;
	
	public AvatarView(AvatarInterface avatar, PaintingViewMaster painter){
		this.painter = painter;
		this.avatar = avatar;
		
		avatar.addPropertyChangeListenerToAtomics(this);
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		painter.repaint();
	}
	
	@Override
	public void paint(Graphics2D g){
		PaintingSupport.paintAvatar(g, avatar);
	}
}
