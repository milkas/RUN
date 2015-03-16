package interpreter;

import java.util.List;


public class MyArray extends MyInstance {
    
    private final List<Integer> array;

    public MyArray(List<Integer> arrayRefs) {
        super(new Scope());
        this.array = arrayRefs;
    }
    
    @Override
    public boolean isArray() {
        return true;
    }
    
    public Integer get(int index) {
        return array.get(index);
    }

    public void set(int index, Integer ref) {
        array.set(index, ref);
    }

    @Override
    public Object value() {
        return array;
    }

    @Override
    public Integer invoke(String function, List<Integer> args, Scope invokeScope, Memory memory) {
        if ("length".equals(function))
            return memory.setMyObject(new MyInt(array.size()));
        else
            return null;
    }

     @Override
    public List<Integer> getAllReferences() {
        return array;
    }
    
}
