package grail;

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
	
	private static ScannerBeanInterface scannerBean = null;
	private static BridgeSceneInterface bridgeScene = null;
	private static Table avatarTable = null;
	private static CommandInterpreterInterface commandInterpreter = null;
	private static PropertyChangeListener consoleSceneView = null;
	private static PaintingViewMaster painter = null;
	private static DelegatingBridgeSceneViewInterface view = null;
	private static BridgeSceneControllerInterface mainControl = null;
	private static CommandInterpreterControllerInterface interpreterController = null;
	private static CommandInterpreterViewInterface interpreterView = null;
	
	
	@Tags({"commandInterpreterViewFactoryMethod"})
	public static CommandInterpreterViewInterface commandInterpreterViewFactoryMethod(){
		if (null == interpreterView){
			interpreterView = new CommandInterpreterView();
		}
		return interpreterView;
	}
	
	@Tags({"commandInterpreterControllerFactoryMethod"})
	public static CommandInterpreterControllerInterface commandInterpreterControllerFactoryMethod(){
		if (null == interpreterController){
			interpreterController = new CommandInterpreterController(commandInterpreterViewFactoryMethod());
		}
		return interpreterController;
	}
	
	@Tags({"bridgeSceneControllerFactoryMethod"})
	public static BridgeSceneControllerInterface bridgeSceneControllerFactoryMethod(){
		if (null == mainControl){
			mainControl = new BridgeSceneController(observableBridgeScenePainterFactoryMethod());
		}
		return mainControl;
	}
	
	@Tags({"observableBridgeScenePainterFactoryMethod"})
	public static PaintingViewMaster observableBridgeScenePainterFactoryMethod(){
		if (null == painter){
			painter = new ObservableBridgeScenePainter();
		}
		return painter;
	}
	
	@Tags({"delegatingBridgeSceneViewFactoryMethod"})
	public static DelegatingBridgeSceneViewInterface delegatingBridgeSceneViewFactoryMethod(){
		if (null == view){
			view = new DelegatingBridgeSceneView(bridgeSceneFactoryMethod());
		}
		return view;
	}
	
	@Tags({"scannerFactoryMethod"})
	public static ScannerBeanInterface scannerFactoryMethod(){
		if (null == scannerBean){
			scannerBean = new ScannerBean();
		}
		return scannerBean;
	}
	
	@Tags({"bridgeSceneFactoryMethod"})
	public static BridgeSceneInterface bridgeSceneFactoryMethod(){
		if (null == bridgeScene){
			bridgeScene = new BridgeScene();
		}
		return bridgeScene;
	}
	
	// Side effect: creates a BridgeScene
	@Tags({"avatarTableFactoryMethod"})
	public static Table avatarTableFactoryMethod(){
		if (null == avatarTable){
			avatarTable = new MyTable();
			
			// Create a scene if needed
			bridgeSceneFactoryMethod();	//return value not needed
			
			// Populate table
			avatarTable.put("arthur", bridgeScene.getArthur());
			avatarTable.put("galahad", bridgeScene.getGalahad());
			avatarTable.put("lancelot", bridgeScene.getLancelot());
			avatarTable.put("robin", bridgeScene.getRobin());
			avatarTable.put("guard", bridgeScene.getGuard());
		}
		return avatarTable;
	}
	
	// Side effect: creates a BridgeScene and ScannerBean
	@Tags({"commandInterpreterFactoryMethod"})
	public static CommandInterpreterInterface commandInterpreterFactoryMethod(){
		if (null == commandInterpreter){
			bridgeSceneFactoryMethod();
			scannerFactoryMethod();
			
			commandInterpreter = new CommandInterpreter(bridgeScene, scannerBean);
		}
		return commandInterpreter;
	}
	
	@Tags({"consoleSceneViewFactoryMethod"})
	public static PropertyChangeListener consoleSceneViewFactoryMethod(){
		if (null == consoleSceneView){
			consoleSceneView = new ConsoleSceneView();
		}
		return consoleSceneView;
	}
}
