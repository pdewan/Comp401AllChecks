package grail.mvc.view;

import grail.SingletonsCreator;
import grail.interfaces.BridgeSceneInterface;
import grail.interfaces.mvc.DelegatingBridgeSceneViewInterface;
import grail.interfaces.mvc.PaintingViewMaster;
import util.annotations.Tags;

@Tags({"DelegatingBridgeSceneView"})
public class DelegatingBridgeSceneView implements DelegatingBridgeSceneViewInterface{
	
	public DelegatingBridgeSceneView(BridgeSceneInterface scene){
		PaintingViewMaster painter = SingletonsCreator.observableBridgeScenePainterFactoryMethod();
		
		painter.addPaintListener(new AvatarView(scene.getArthur(), painter));
		painter.addPaintListener(new AvatarView(scene.getGalahad(), painter));
		painter.addPaintListener(new AvatarView(scene.getGuard(), painter));
		painter.addPaintListener(new AvatarView(scene.getLancelot(), painter));
		painter.addPaintListener(new AvatarView(scene.getRobin(), painter));
		
		painter.addPaintListener(new SceneBackgroundView(scene, painter));
	}
	
}
