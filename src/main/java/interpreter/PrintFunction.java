package interpreter;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PrintFunction extends MyFunction {

    private final PrintStream printStream;

    public PrintFunction(PrintStream printStream) {
        super("print", Arrays.asList("text"), null, null);
        this.printStream = printStream;
    }

    @Override
    public Integer invoke(List<Integer> args, Scope invokeScope, Memory memory) {
        MyObject MyObject = memory.getMyObject(args.get(0));
        if (MyObject.isSymbol()) {
            final Integer reference = invokeScope.get((String) MyObject.value());
            MyObject = memory.getMyObject(reference);
        }
        printStream.println(MyObject.value());
        return null;
    }

    @Override
    public List<Integer> getAllReferences() {
        return Collections.emptyList();
    }

}
