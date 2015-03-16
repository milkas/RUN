package interpreter;

import java.util.*;

public class MyBoolean extends MyInstance {

    private final boolean value;
    private final Map<String, MyFunction> methods = new HashMap<>();

    public MyBoolean(boolean value) {
        super(new Scope());
        this.value = value;

        methods.put("&&", new AndFunction());
        methods.put("||", new OrFunction());
        methods.put("==", new EqualsFunction());
        methods.put("!", new NotFunction());
    }

    @Override
    public boolean isBoolean() {
        return true;
    }

    @Override
    public Object value() {
        return value;
    }

    @Override
    public Integer invoke(String function, List<Integer> args, Scope invokeScope, Memory memory) {
        final MyFunction myFunction = methods.get(function);
        return myFunction.invoke(args, invokeScope, memory);
    }

    private class AndFunction extends MyFunction {

        public AndFunction() {
            super("&&", null, null);
        }

        @Override
        public Integer invoke(List<Integer> args, Scope invokeScope, Memory memory) {
            MyObject other = memory.getMyObject(args.get(0));
            if (other.isBoolean()) {
                return memory.setMyObject(new MyBoolean(value && ((MyBoolean) other).value));
            }
            throw new ThrowError("Object is not boolean.");
        }
    }

    private class OrFunction extends MyFunction {

        public OrFunction() {
            super("||", null, null);
        }

        @Override
        public Integer invoke(List<Integer> args, Scope invokeScope, Memory memory) {
            MyObject other = memory.getMyObject(args.get(0));
            if (other.isBoolean()) {
                return memory.setMyObject(new MyBoolean(value || ((MyBoolean) other).value));
            }
            throw new ThrowError("Object is not boolean.");
        }
    }

    private class NotFunction extends MyFunction {

        public NotFunction() {
            super("!", null, null);
        }

        @Override
        public Integer invoke(List<Integer> args, Scope invokeScope, Memory memory) {
            return memory.setMyObject(new MyBoolean(!value));
        }
    }

    private class EqualsFunction extends MyFunction {

        public EqualsFunction() {
            super("==", null, null);
        }

        @Override
        public Integer invoke(List<Integer> args, Scope invokeScope, Memory memory) {
            MyObject other = memory.getMyObject(args.get(0));
            if (other.isBoolean()) {
                return memory.setMyObject(new MyBoolean(value == ((MyBoolean) other).value));
            }
            throw new ThrowError("Object is not boolean.");
        }
    }
}
