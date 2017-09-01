package grail.scanner.commands;

import java.util.ArrayList;
import java.util.List;

import grail.interfaces.CompositeCommandThread;
import util.annotations.Tags;

@Tags({"CommandList"})
public class CommandList implements CompositeCommandThread{

	private List<Runnable> commands = new ArrayList<Runnable>();
	
	//Empty constructor
	public CommandList(){}

	@Override
	public void add(Runnable r) {
		commands.add(r);
	}
	
	@Override
	public void run() {
		for (Runnable command : commands){
			command.run();
		}
	}

}
