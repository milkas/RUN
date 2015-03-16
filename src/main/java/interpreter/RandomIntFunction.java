
package interpreter;

import java.util.Collections;
import java.util.List;

public class RandomIntFunction extends MyFunction {

    public RandomIntFunction() {
        super("randint", null, null, null);

    }

    @Override
    public Integer invoke(List<Integer> args, Scope invokeScope, Memory memory) {

        double random = Math.random()*11;
        return memory.setMyObject(new MyInt((int)random));

    }

    @Override
    public List<Integer> getAllReferences() {
        return Collections.emptyList();
    }

}