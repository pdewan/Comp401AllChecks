package grail.interfaces;

import util.annotations.Tags;

@Tags({"Table"})
public interface Table {

	void put(String key, Object val);

	Object get(String key);

}