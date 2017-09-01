package grail.interfaces;

import util.annotations.Tags;

@Tags({"Table"})
public interface Table<KeyType> {

	public void put(String key, KeyType val);
	public KeyType get(String key);

}