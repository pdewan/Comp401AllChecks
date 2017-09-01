package grail.scanner.commands;

import grail.interfaces.BridgeSceneInterface;
import grail.interfaces.CommandThread;
import util.annotations.Tags;
import util.misc.ThreadSupport;

@Tags({"SleepCommand"})
public class SleepCommand implements CommandThread{

	private long sleepTime;
	
	public SleepCommand(long sleepMilliseconds){
		this.sleepTime = sleepMilliseconds;
	}
	
	@Override
	public void run() {
		ThreadSupport.sleep(sleepTime);
	}

}
