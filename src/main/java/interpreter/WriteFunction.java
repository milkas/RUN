package interpreter;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class WriteFunction extends MyFunction {

    private final PrintStream printStream;

    public WriteFunction(PrintStream printStream) {
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

        PrintWriter writer = null;
        try {
            writer = new PrintWriter(new FileWriter("output.txt", true));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(WriteFunction.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(WriteFunction.class.getName()).log(Level.SEVERE, null, ex);
        }
writer.println(MyObject.value());
writer.close();
        return null;
    }

                @Override
    public List<Integer> getAllReferences() {
        return Collections.emptyList();
    }

}