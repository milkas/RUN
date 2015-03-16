package interpreter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyString extends MyInstance {
    private final String text;
    private final Map<String, MyFunction> methods = new HashMap<>();
    
    public MyString(String text){
        super(new Scope());
        this.text = text;
        methods.put("split", new SplitFunction());     
    }
    
    @Override
    public boolean isString(){
        return true;
    }
    
    @Override
    public Object value(){
        return text;
    }

    @Override
    public Integer invoke(String function, List<Integer> args, Scope invokeScope, Memory memory) {
        final MyFunction myFunction = methods.get(function);
            return myFunction.invoke(args, invokeScope, memory);
    }

    @Override
    public Integer invoke(List<Integer> args, Scope invokeScope, Memory memory) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Integer constructInstance(List<Integer> args, Scope invokeScope, Memory memory) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private class SplitFunction extends MyFunction {

        public SplitFunction() {
            super("split", Arrays.asList("separator"), null, null);
        }

        @Override
        public Integer invoke(List<Integer> args, Scope invokeScope, Memory memory) {
            MyObject regexp = memory.getMyObject(args.get(0));
            final String[] strings = text.split((String) regexp.value());
            List<Integer> splits = new ArrayList<>(strings.length);
            for (String split : strings) {
                splits.add(memory.setMyObject(new MyString(split)));
            }
            return memory.setMyObject(new MyArray(splits));
        }

    }
    
}
