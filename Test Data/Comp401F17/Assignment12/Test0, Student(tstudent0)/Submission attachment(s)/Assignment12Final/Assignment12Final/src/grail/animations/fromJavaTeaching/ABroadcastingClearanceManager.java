package grail.animations.fromJavaTeaching;

/**
 * Copied from JavaTeaching, as required from assignment
 */

import util.annotations.ComponentWidth;
import util.annotations.Row;

public class ABroadcastingClearanceManager extends AClearanceManager 
					implements BroadcastingClearanceManager {

	@Row(1)
	@ComponentWidth(100)
	public synchronized void proceedAll() {
		System.out.println( Thread.currentThread() + ": before notifyAll");

		notifyAll(); // not notify, hover over the method and see Java's explanation for it		
		System.out.println( Thread.currentThread() + ": after notifyAll");

	}
}
