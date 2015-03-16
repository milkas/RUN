
package interpreter;

import java.util.Collections;
import java.util.List;

public class RandomFunction extends MyFunction {

    public RandomFunction() {
        super("rand", null, null, null);

    }

    @Override
    public Integer invoke(List<Integer> args, Scope invokeScope, Memory memory) {

        double random = Math.random();
        return memory.setMyObject(new MyDouble(random));

    }

    @Override
    public List<Integer> getAllReferences() {
        return Collections.emptyList();
    }

}
