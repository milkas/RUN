package interpreter;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ToDoubleFunction extends MyFunction {

    public ToDoubleFunction() {
        super("todouble", Arrays.asList("text"), null, null);

    }

    @Override
    public Integer invoke(List<Integer> args, Scope invokeScope, Memory memory) {
        MyObject object = memory.getMyObject(args.get(0));
        if (object.isSymbol()) {
            final Integer reference = invokeScope.get((String) object.value());
            object = memory.getMyObject(reference);
        }
        int value = (int) object.value();
        double value2 = (double) value ;
        return memory.setMyObject(new MyDouble(value2));
    }

    @Override
    public List<Integer> getAllReferences() {
        return Collections.emptyList();
    }

}