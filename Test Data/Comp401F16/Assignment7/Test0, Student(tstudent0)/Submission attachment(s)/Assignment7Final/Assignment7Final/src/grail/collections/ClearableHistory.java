package grail.collections;

import grail.interfaces.ClearableHistoryInterface;
import grail.interfaces.Token;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;

@StructurePattern(StructurePatternNames.VECTOR_PATTERN)
@Tags({"ClearableHistory"})
public class ClearableHistory extends ABaseHistory implements ClearableHistoryInterface {

	@Override
	public void clear(){
		size = 0;
		contents = new Token[MAX_SIZE];
	}
}
