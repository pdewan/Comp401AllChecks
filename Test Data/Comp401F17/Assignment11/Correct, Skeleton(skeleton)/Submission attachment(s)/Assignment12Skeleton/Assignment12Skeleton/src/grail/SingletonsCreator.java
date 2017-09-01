package grail;

import java.beans.PropertyChangeListener;

import grail.animations.fromJavaTeaching.ABroadcastingClearanceManager;
import grail.animations.fromJavaTeaching.BroadcastingClearanceManager;
import grail.collections.MoveCommandUndoer;
import grail.collections.MyTable;
import grail.graphics.BridgeScene;
import grail.interfaces.AvatarInterface;
import grail.interfaces.BridgeSceneInterface;
import grail.interfaces.CommandInterpreterInterface;
import grail.interfaces.ParserInterface;
import grail.interfaces.ScannerBeanInterface;
import grail.interfaces.Table;
import grail.interfaces.Undoer;
import grail.interfaces.mvc.BridgeSceneControllerInterface;
import grail.interfaces.mvc.CommandInterpreterControllerInterface;
import grail.interfaces.mvc.CommandInterpreterViewInterface;
import grail.interfaces.mvc.DelegatingBridgeSceneViewInterface;
import grail.interfaces.mvc.PaintingViewMaster;
import grail.mvc.controller.BridgeSceneController;
import grail.mvc.controller.CommandInterpreterController;
import grail.mvc.view.CommandInterpreterView;
import grail.mvc.view.ConsoleSceneView;
import grail.mvc.view.DelegatingBridgeSceneView;
import grail.mvc.view.ObservableBridgeScenePainter;
import grail.scanner.CommandInterpreter;
import grail.scanner.Parser;
import grail.scanner.ScannerBean;
import util.annotations.Tags;

@Tags({"SingletonsCreator"})
public class SingletonsCreator {
	
}
