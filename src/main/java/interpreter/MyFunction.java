package interpreter;

import java.util.ArrayList;
import java.util.List;
import parser.ScriptParser;

public class MyFunction extends MyObject {

    private String name;
    private List<String> params;
    private Scope scope;
    private ScriptParser.FunctionBodyContext body;

    public MyFunction(String name, Scope scope, ScriptParser.FunctionBodyContext body) {
        this.name = name;
        this.params = new ArrayList<>();
        this.scope = scope;
        this.body = body;
    }

    public MyFunction(String name, List<String> args, Scope scope, ScriptParser.FunctionBodyContext body) {
        this.name = name;
        this.params = args;
        this.scope = scope;
        this.body = body;
    }

    @Override
    public Object value() {
        return body;
    }

    @Override
    public boolean isFunction() {
        return true;
    }

    @Override
    public Integer invoke(String function, List<Integer> args, Scope invokeScope, Memory memory) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Integer invoke(List<Integer> args, Scope invokeScope, Memory memory) {
        Scope callScope = new Scope(scope, invokeScope);
        for (int i = 0; i < args.size(); i++) {
            callScope.set(this.params.get(i), args.get(i));
        }
        if (name != null) {
            callScope.define(name);
            callScope.set(name, selfRef);
        }

        Integer resultRef = (Integer) body.accept(new InterpreterVisitor(memory, callScope, invokeScope));
        if (resultRef != null && memory.getMyObject(resultRef).isSymbol()) {
            resultRef = callScope.get((String) memory.getMyObject(resultRef).value());
        }
        return resultRef;
    }

    @Override
    public Integer constructInstance(List<Integer> args, Scope invokeScope, Memory memory) {
        Scope callScope = getCallScope(args, invokeScope);
        Scope thisScope;
        if (prototype != null) {
            final MyObject prototypeObject = memory.getMyObject(prototype);
            thisScope = new Scope(prototypeObject.getScope());
        } else {
            thisScope = new Scope();
        }
        body.accept(new InterpreterVisitor(memory, callScope, thisScope));
        MyObject instance = new MyInstance(thisScope);
        return memory.setMyObject(instance);
    }

    private Scope getCallScope(List<Integer> args, Scope invokeScope) {
        Scope callScope = new Scope(scope, invokeScope);
        for (int i = 0; i < args.size(); i++) {
            callScope.set(params.get(i), args.get(i));
        }
        if (name != null) {
            callScope.define(name);
            callScope.set(name, selfRef);
        }
        return callScope;
    }

    public List<String> getParams() {
        return params;
    }

    public ScriptParser.FunctionBodyContext getBody() {
        return body;
    }
    
    @Override
    public List<Integer> getAllReferences() {
        return scope.getAllReferences();
    }

}
