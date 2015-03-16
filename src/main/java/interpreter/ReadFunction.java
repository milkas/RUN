package interpreter;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ReadFunction extends MyFunction {

    public ReadFunction() {
        super("read", Arrays.asList("uri"), null, null);
    }

    @Override
    public Integer invoke(List<Integer> args, Scope invokeScope, Memory memory) {
        MyObject object = memory.getMyObject(args.get(0));
        if (object.isSymbol()) {
            final Integer reference = invokeScope.get((String) object.value());
            object = memory.getMyObject(reference);
        }
        String uri = (String) object.value();
        String text = loadFile(uri);
        text = text.replaceAll("\n", "");
        return memory.setMyObject(new MyString(text));
    }

    private String loadFile(String file) {
        InputStream inputStream;

        try {
            inputStream = new FileInputStream(new File(file));
            return convertStreamToString(inputStream);
        } catch (IOException ex) {
            System.err.println("Error while loading the file.");
        }
        return "";
    }

    static String convertStreamToString(java.io.InputStream is) {
        java.util.Scanner s = new java.util.Scanner(is).useDelimiter("\\A");
        return s.hasNext() ? s.next() : "";
    }

    @Override
    public List<Integer> getAllReferences() {
        return Collections.emptyList();
    }
}
