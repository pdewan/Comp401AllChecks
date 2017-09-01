package grail.scanner.commands;

import grail.interfaces.CommandThread;
import util.annotations.Tags;

@Tags({"RepeatCommand"})
public class RepeatCommand implements CommandThread{

	private int count;
	private CommandThread command;
	
	public RepeatCommand(int count, CommandThread command){
		this.count = count;
		this.command = command;
	}
	
	@Override
	public void run() {
		for (int i = 0; i < count; ++i){
			command.run();
		}
	}

}
