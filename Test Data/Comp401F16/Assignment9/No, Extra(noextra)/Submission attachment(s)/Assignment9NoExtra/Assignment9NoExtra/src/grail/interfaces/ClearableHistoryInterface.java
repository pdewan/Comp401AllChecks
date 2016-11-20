package grail.interfaces;

import util.annotations.Tags;

@Tags({"ClearableHistory"})
public interface ClearableHistoryInterface extends BaseHistory {
	public void clear();
}
