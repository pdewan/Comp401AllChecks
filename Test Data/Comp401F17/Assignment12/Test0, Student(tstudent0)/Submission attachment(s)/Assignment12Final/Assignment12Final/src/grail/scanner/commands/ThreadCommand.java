package grail.scanner.commands;

import grail.SingletonsCreator;
import grail.interfaces.BridgeSceneInterface;
import grail.interfaces.CommandThread;
import grail.interfaces.Table;
import util.annotations.Tags;
import util.misc.ThreadSupport;

/**
 * Does not call command if such a command does not exist
 *
 */
@Tags({"ThreadCommand"})
public class ThreadCommand implements CommandThread{

	private String name;
	private Table<CommandThread> environment;
	
	public ThreadCommand(String name){
		this.name = name;
		this.environment = SingletonsCreator.environmentFactoryMethod();
	}
	
	@Override
	public void run() {
		CommandThread command = environment.get(name);
		Thread thread = new Thread(command);
		thread.start();
	}

}
