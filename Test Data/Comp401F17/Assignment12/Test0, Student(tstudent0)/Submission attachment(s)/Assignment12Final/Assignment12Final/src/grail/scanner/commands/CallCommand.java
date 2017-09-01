package grail.scanner.commands;

import grail.SingletonsCreator;
import grail.interfaces.BridgeSceneInterface;
import grail.interfaces.CommandThread;
import grail.interfaces.Table;
import util.annotations.Tags;
import util.misc.ThreadSupport;

@Tags({"CallCommand"})
public class CallCommand implements CommandThread{

	private String name;
	private Table<CommandThread> environment;
	
	public CallCommand(String name){
		this.name = name;
		this.environment = SingletonsCreator.environmentFactoryMethod();
	}
	
	@Override
	public void run() {
		CommandThread command = environment.get(name);
		command.run();
	}

}
