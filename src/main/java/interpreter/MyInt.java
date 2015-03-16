package interpreter;

import java.util.*;

public class MyInt extends MyInstance {

    private final Integer value;
    private final Map<String, MyFunction> methods = new HashMap<>();

    public MyInt(Integer value) {
        super(new Scope());
        this.value = value;
        methods.put("+", new PlusFunction());
        methods.put("-", new MinusFunction());
        methods.put("/", new DivideFunction());
        methods.put("*", new MultipleFunction());
        methods.put("==", new EqualsFunction());
        methods.put(">", new MoreFunction());
        methods.put("<", new LessFunction());
        methods.put("%", new ModFunction());
        methods.put("||", new OrFunction());

    }

    @Override
    public boolean isInt() {
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
            if (arg.isInt()) {
                return memory.setMyObject(new MyInt(value + ((MyInt) arg).value));
            }
            throw new ThrowError("object is not int");
        }

    }

    private class MinusFunction extends MyFunction {

        public MinusFunction() {
            super("-", null, null);
        }

        @Override
        public Integer invoke(List<Integer> args, Scope invokeScope, Memory memory) {
            MyObject arg = memory.getMyObject(args.get(0));
            if (arg.isInt()) {
                return memory.setMyObject(new MyInt(value - ((MyInt) arg).value));
            }
            throw new ThrowError("object is not int");
        }

    }

    private class DivideFunction extends MyFunction {

        public DivideFunction() {
            super("/", null, null);
        }

        @Override
        public Integer invoke(List<Integer> args, Scope invokeScope, Memory memory) {
            MyObject arg = memory.getMyObject(args.get(0));
            if (arg.isInt()) {
                return memory.setMyObject(new MyInt(value / ((MyInt) arg).value));
            }
            throw new ThrowError("object is not int");
        }

    }

    private class MultipleFunction extends MyFunction {

        public MultipleFunction() {
            super("*", null, null);
        }

        @Override
        public Integer invoke(List<Integer> args, Scope invokeScope, Memory memory) {
            MyObject arg = memory.getMyObject(args.get(0));
            if (arg.isInt()) {
                return memory.setMyObject(new MyInt(value * ((MyInt) arg).value));
            }
            throw new ThrowError("object is not int");
        }

    }

    private class EqualsFunction extends MyFunction {

        public EqualsFunction() {
            super("==", null, null);
        }

        @Override
        public Integer invoke(List<Integer> args, Scope invokeScope, Memory memory) {
            MyObject other = memory.getMyObject(args.get(0));
            if (other.isInt()) {
                return memory.setMyObject(new MyBoolean(value.equals(other.value())));
            }
            throw new ThrowError("Cant't % non Int object.");
        }
    }

    private class MoreFunction extends MyFunction {

        public MoreFunction() {
            super(">", null, null);
        }

        @Override
        public Integer invoke(List<Integer> args, Scope invokeScope, Memory memory) {
            MyObject other = memory.getMyObject(args.get(0));
            if (other.isInt()) {
                return memory.setMyObject(new MyBoolean(value > ((MyInt) other).value));
            }
            throw new ThrowError("Cant't % non Int object.");
        }

    }

    private class LessFunction extends MyFunction {

        public LessFunction() {
            super("<", Arrays.asList("other"), null, null);
        }

        @Override
        public Integer invoke(List<Integer> args, Scope invokeScope, Memory memory) {
            MyObject other = memory.getMyObject(args.get(0));

            if (other.isInt()) {
                return memory.setMyObject(new MyBoolean(value < ((MyInt) other).value));
            }
            String string = (String) other.value();
            int value2 = Integer.parseInt(string);
            return memory.setMyObject(new MyBoolean(value < value2));
        }

    }

        private class ModFunction extends MyFunction {

        public ModFunction() {
            super("%", Arrays.asList("other"), null, null);
        }

        @Override
        public Integer invoke(List<Integer> args, Scope invokeScope, Memory memory) {
            MyObject other = memory.getMyObject(args.get(0));
            if (other.isInt()) {
                return memory.setMyObject(new MyInt(value % ((MyInt) other).value));
            }
            throw new ThrowError("Cant't % non Int object.");
        }

    }
        
    private class OrFunction extends MyFunction {

        public OrFunction() {
            super("||", null, null);
        }

        @Override
        public Integer invoke(List<Integer> args, Scope invokeScope, Memory memory) {
            MyObject other = memory.getMyObject(args.get(0));
            if (other.isInt()) {
                boolean value1 = (value == 1);
                boolean value2 = ((((MyInt) other).value) == 1);
                return memory.setMyObject(new MyBoolean(value1 || value2));
            }
            throw new ThrowError("Object is not boolean.");
        }
    }

}
