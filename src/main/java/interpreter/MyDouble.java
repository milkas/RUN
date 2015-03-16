package interpreter;

import java.util.*;

public class MyDouble extends MyInstance {

    private final Double value;
    private final Map<String, MyFunction> methods = new HashMap<>();

    public MyDouble(Double value) {
        super(new Scope());
        this.value = value;
        methods.put("+", new PlusFunction());
        methods.put("-", new MinusFunction());
        methods.put("/", new DivideFunction());
        methods.put("*", new MultipleFunction());
        methods.put("==", new EqualsFunction());
        methods.put(">", new MoreFunction());
        methods.put("<", new LessFunction());

    }

    @Override
    public boolean isDouble() {
        return true;
    }

    @Override
    public void setSelfReference(Integer reference) {
        selfRef = reference;
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

    @Override
    public Integer invoke(List<Integer> args, Scope invokeScope, Memory memory) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Integer constructInstance(List<Integer> args, Scope invokeScope, Memory memory) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private class PlusFunction extends MyFunction {

        public PlusFunction() {
            super("+", null, null);
        }

        @Override
        public Integer invoke(List<Integer> args, Scope invokeScope, Memory memory) {
            MyObject arg = memory.getMyObject(args.get(0));
            if (arg.isDouble()) {
                return memory.setMyObject(new MyDouble(value + ((MyDouble) arg).value));
            }
            throw new ThrowError("object is not double");
        }

    }

    private class MinusFunction extends MyFunction {

        public MinusFunction() {
            super("-", null, null);
        }

        @Override
        public Integer invoke(List<Integer> args, Scope invokeScope, Memory memory) {
            MyObject arg = memory.getMyObject(args.get(0));
            if (arg.isDouble()) {
                return memory.setMyObject(new MyDouble(value - ((MyDouble) arg).value));
            }
            throw new ThrowError("object is not double");
        }

    }

    private class DivideFunction extends MyFunction {

        public DivideFunction() {
            super("/", null, null);
        }

        @Override
        public Integer invoke(List<Integer> args, Scope invokeScope, Memory memory) {
            MyObject arg = memory.getMyObject(args.get(0));
            if (arg.isDouble()) {
                return memory.setMyObject(new MyDouble(value / ((MyDouble) arg).value));
            }
            throw new ThrowError("object is not double");
        }

    }

    private class MultipleFunction extends MyFunction {

        public MultipleFunction() {
            super("*", null, null);
        }

        @Override
        public Integer invoke(List<Integer> args, Scope invokeScope, Memory memory) {
            MyObject arg = memory.getMyObject(args.get(0));
            if (arg.isDouble()) {
                return memory.setMyObject(new MyDouble(value * ((MyDouble) arg).value));
            }
            throw new ThrowError("object is not double");
        }

    }

    private class EqualsFunction extends MyFunction {

        public EqualsFunction() {
            super("==", null, null);
        }

        @Override
        public Integer invoke(List<Integer> args, Scope invokeScope, Memory memory) {
            MyObject other = memory.getMyObject(args.get(0));
            if (other.isDouble()) {
                return memory.setMyObject(new MyBoolean(value.equals(other.value())));
            }
            throw new ThrowError("Cant't % non double object.");
        }
    }

    private class MoreFunction extends MyFunction {

        public MoreFunction() {
            super(">", null, null);
        }

        @Override
        public Integer invoke(List<Integer> args, Scope invokeScope, Memory memory) {
            MyObject other = memory.getMyObject(args.get(0));
            if (other.isDouble()) {
                return memory.setMyObject(new MyBoolean(value > ((MyDouble) other).value));
            }
            throw new ThrowError("Cant't % non double object.");
        }

    }

    private class LessFunction extends MyFunction {

        public LessFunction() {
            super("<", Arrays.asList("other"), null, null);
        }

        @Override
        public Integer invoke(List<Integer> args, Scope invokeScope, Memory memory) {
            MyObject other = memory.getMyObject(args.get(0));
            if (other.isDouble()) {
                return memory.setMyObject(new MyBoolean(value < ((MyDouble) other).value));
            }
            throw new ThrowError("Cant't % non double object.");
        }

    }

}
