package grail;

import grail.collections.MyTable;
import grail.graphics.BridgeScene;
import grail.interfaces.BridgeSceneInterface;
import grail.interfaces.CommandInterpreterInterface;
import grail.interfaces.ScannerBeanInterface;
import grail.interfaces.Table;
import grail.scanner.CommandInterpreter;
import grail.scanner.ScannerBean;
import util.annotations.Tags;

@Tags({"SingletonsCreator"})
public class SingletonsCreator {

	@Tags({"scannerFactoryMethod"})
	public static ScannerBeanInterface scannerFactoryMethod(){
		return null;
	}
	
	@Tags({"bridgeSceneFactoryMethod"})
	public static BridgeSceneInterface bridgeSceneFactoryMethod(){
	
		return null;
	}
	
	@Tags({"avatarTableFactoryMethod"})
	public static Table avatarTableFactoryMethod(){
		
		return null;
	}
	
	@Tags({"commandInterpreterFactoryMethod"})
	public static CommandInterpreterInterface commandInterpreterFactoryMethod(){
		
		return null;
	}
}
