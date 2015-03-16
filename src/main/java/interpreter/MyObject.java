package interpreter;

import java.util.Collections;
import java.util.List;

public abstract class MyObject {

    Integer selfRef;
    Integer prototype;
    boolean withoutRef = false;

    public abstract Object value();

    public void setSelfReference(Integer reference) {
        selfRef = reference;
    }

    public boolean isSymbol() {
        return false;
    }

    public boolean isInt() {
        return false;
    }

    public boolean isArray() {
        return false;
    }

    public boolean isBoolean() {
        return false;
    }

    public boolean isFunction() {
        return false;
    }

    public boolean isString() {
        return false;
    }
    
    public boolean isDouble() {
        return false;
    }

    public boolean isMark() {
        return withoutRef;
    }

    public void mark() {
        withoutRef = true;
    }
    
    public void unmark() {
        withoutRef = false;
    }

    public abstract Integer invoke(String function, List<Integer> args, Scope invokeScope, Memory memory);

    public abstract Integer invoke(List<Integer> args, Scope invokeScope, Memory memory);

    public abstract Integer constructInstance(List<Integer> args, Scope invokeScope, Memory memory);

    public Scope getScope() {
        return new Scope();
    }

    public List<Integer> getAllReferences() {
        return Collections.emptyList();
    }
    
        public Integer getPrototype() {
        return prototype;
    }

    public void setPrototype(Integer prototype) {
        this.prototype = prototype;
    }

}
