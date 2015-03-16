package interpreter;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ToBooleanFunction extends MyFunction {

    public ToBooleanFunction() {
        super("tobool", Arrays.asList("text"), null, null);

    }

    @Override
    public Integer invoke(List<Integer> args, Scope invokeScope, Memory memory) {
        MyObject object = memory.getMyObject(args.get(0));
        if (object.isSymbol()) {
            final Integer reference = invokeScope.get((String) object.value());
            object = memory.getMyObject(reference);
        }
        int value = (int) object.value();
        Boolean boolValue = (value == 1);
        return memory.setMyObject(new MyBoolean(boolValue));
    }

    @Override
    public List<Integer> getAllReferences() {
        return Collections.emptyList();
    }

}
