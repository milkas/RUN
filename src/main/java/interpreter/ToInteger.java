package interpreter;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ToInteger extends MyFunction {

    public ToInteger() {
        super("toint", Arrays.asList("text"), null, null);
    }

    @Override
    public Integer invoke(List<Integer> args, Scope invokeScope, Memory memory) {
        MyObject object = memory.getMyObject(args.get(0));
        if (object.isSymbol()) {
            final Integer reference = invokeScope.get((String) object.value());
            object = memory.getMyObject(reference);
        }
        String value = (String) object.value();
        int intValue = Integer.parseInt(value);
        return memory.setMyObject(new MyInt(intValue));
    }

    @Override
    public List<Integer> getAllReferences() {
        return Collections.emptyList();
    }

}
