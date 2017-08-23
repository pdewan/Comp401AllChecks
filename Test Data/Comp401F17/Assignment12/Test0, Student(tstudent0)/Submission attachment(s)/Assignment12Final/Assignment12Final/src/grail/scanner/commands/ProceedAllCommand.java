package grail.scanner.commands;

import grail.SingletonsCreator;
import grail.animations.fromJavaTeaching.BroadcastingClearanceManager;
import grail.interfaces.BridgeSceneInterface;
import grail.interfaces.CommandThread;
import util.annotations.Tags;
import util.misc.ThreadSupport;

@Tags({"ProceedAllCommand"})
public class ProceedAllCommand implements CommandThread{

	private BroadcastingClearanceManager clearanceManager;
	
	public ProceedAllCommand(BroadcastingClearanceManager clearanceManager){
		this.clearanceManager = SingletonsCreator.broadcastingClearanceManagerMethod();;
	}
	public ProceedAllCommand(){
		this.clearanceManager = SingletonsCreator.broadcastingClearanceManagerMethod();
	}
	
	@Override
	public void run() {
		clearanceManager.proceedAll();
	}

}
