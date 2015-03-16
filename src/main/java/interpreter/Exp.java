/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interpreter;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Mira
 */
public class Exp extends MyFunction {

    public Exp() {
        super("exp", Arrays.asList("text"), null, null);

    }

    @Override
    public Integer invoke(List<Integer> args, Scope invokeScope, Memory memory) {
        MyObject object = memory.getMyObject(args.get(0));
        if (object.isSymbol()) {
            final Integer reference = invokeScope.get((String) object.value());
            object = memory.getMyObject(reference);
        }
        double value = (double) object.value();
        double expvalue = Math.exp(value);

        return memory.setMyObject(new MyDouble(expvalue));

    }
    
                @Override
    public List<Integer> getAllReferences() {
        return Collections.emptyList();
    }


}

