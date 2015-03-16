package interpreter;

import java.util.List;

public class MyInstance extends MyObject {
    
    protected Scope scope;

    public MyInstance(Scope scope) {
        this.scope = scope;
    }
    
    @Override
    public Object value() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Integer invoke(String function, List<Integer> args, Scope invokeScope, Memory memory) {
        final MyObject jsObject = memory.getMyObject(scope.get(function));
        if (jsObject != null && jsObject.isFunction()) {
            MyFunction jsFunction = (MyFunction) jsObject;
            return jsFunction.invoke(args, scope, memory);
        } else if (args == null) {
            return scope.get(function);
        } else {
            scope.set(function, args.get(0));
            return null;
        }
    }

    @Override
    public Integer invoke(List<Integer> args, Scope invokeScope, Memory memory) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Integer constructInstance(List<Integer> args, Scope invokeScope, Memory memory) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public List<Integer> getAllReferences() {
        return scope.getAllReferences();
    }
    
}
