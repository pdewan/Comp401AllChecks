package grail;

import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;

import grail.collections.MyTable;
import grail.graphics.BridgeScene;
import grail.interfaces.BridgeSceneInterface;
import grail.interfaces.CommandInterpreterInterface;
import grail.interfaces.ScannerBeanInterface;
import grail.interfaces.Table;
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
import grail.scanner.ScannerBean;
import util.annotations.Tags;

@Tags({"SingletonsCreator"})
public class SingletonsCreator {
	
}
