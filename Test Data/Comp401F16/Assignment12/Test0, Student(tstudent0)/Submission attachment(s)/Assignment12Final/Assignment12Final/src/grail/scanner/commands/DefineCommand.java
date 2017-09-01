package grail.scanner.commands;

import grail.SingletonsCreator;
import grail.interfaces.BridgeSceneInterface;
import grail.interfaces.CommandThread;
import grail.interfaces.Table;
import util.annotations.Tags;
import util.misc.ThreadSupport;

@Tags({"DefineCommand"})
public class DefineCommand implements CommandThread{

	private String name;
	private CommandThread body;
	private Table<CommandThread> environment;
	
	public DefineCommand(String name, CommandThread body){
		this.name = name;
		this.body = body;
		this.environment = SingletonsCreator.environmentFactoryMethod();
	}
	
	@Override
	public void run() {
		environment.put(name, body);
	}

}
