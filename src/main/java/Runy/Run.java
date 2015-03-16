package Runy;

import interpreter.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import parser.ScriptLexer;
import parser.ScriptParser;

public class Run {

    private final Memory memory = new Memory(this); //vytvori pamet
    private final Scope scope = new Scope();        //vytvori hlavni scope

    public void Execute(String[] args) {
        //nacte argumenty z prikazovy radky vytvori z nich pole a ulozi je na prvni mista do pameti
        String file = args[0]; //soubor s kodem je prvni vstupni argument
        args = Arrays.copyOfRange(args, 1, args.length); //ostatni argumenty se ulozej do pameti do pole pod promennou args
        List<Integer> argRefs = new ArrayList<>(args.length);
        for (String arg : args) {
            argRefs.add(memory.setMyObject(new MyString(arg)));
        }
        Integer argsRef = memory.setMyObject(new MyArray(argRefs));
        scope.set("args", argsRef);

        //vytvori a prida reference na preddefinovane funkce
        addPrintFunction();
        addReadFunction();
        addWriteFunction();
        addStringToIntFunction();  //ze cisla ve stringu vrati int, dobre pro parsovani souboru kdy je soubor naparsovanej jako pole stringu
        addToBooleanFunction();    //z integeru 0/1 udela boolean, taky potreba pri parsovani
        addToDoubleFunction();
        addExpFunction();          //exponencialni fnkce
        addRandomFunction();       // random fukce, vraci double 0 az 1
        addRandomIntFunction();       // random fukce, vraci double 0 az 1
        
        //načte, naparsuje, uloží nadefinovane promenne a interpretuje vstupni soubor
        interpret(collect(parse(loadFile(file))));
    }
    
    //nacte vstupni soubor a vrati ho jako string
    public String loadFile(String file) {
        InputStream inputStream;

        try {
            inputStream = new FileInputStream(new File(file));
            java.util.Scanner s = new java.util.Scanner(inputStream).useDelimiter("\\A");
            return s.hasNext() ? s.next() : "";
        } catch (IOException ex) {
            System.err.println("Error while reading the file.");
        }
        return "";
    }

    //naparsuje vstupni soubor ve stringu
    public ScriptParser.FileContext parse(String code) {
        CharStream charStream = new ANTLRInputStream(code);
        ScriptLexer lex = new ScriptLexer(charStream);
        CommonTokenStream tokens = new CommonTokenStream(lex);
        tokens.fill();
        ScriptParser parser = new ScriptParser(tokens);
        parser.setBuildParseTree(true);
        return parser.file();
    }

    //projde file a ulozi do scopu nadefinovany promenny
    private ScriptParser.FileContext collect(ScriptParser.FileContext file) {
        CollectingVisitor defVisitor = new CollectingVisitor(memory, scope);
        file.accept(defVisitor);
        return file;
    }

    // interpretuje kod
    private ScriptParser.FileContext interpret(ScriptParser.FileContext file) {
        InterpreterVisitor ScriptVisitor = new InterpreterVisitor(memory, scope, scope);
        file.accept(ScriptVisitor);
        return file;
    }


    //Garbage Collector, pusti se v pripade, kdy uz nejsou zadne volne reference na pamet
    public void gc() {
        memory.gc(scope.getAllReferences());
    }

    // prida printfunkci na vypis do konzole
    private void addPrintFunction() {
        Integer print = memory.setMyObject(new PrintFunction(System.out));
        scope.set("print", print);
    }
    
    //prida funkci na nactení souboru
    private void addReadFunction() {
        Integer read = memory.setMyObject(new ReadFunction());
        scope.set("read", read);
    }

    //prida funkci na zapis do souboru
    private void addWriteFunction() {
        Integer write = memory.setMyObject(new WriteFunction(System.out));
        scope.set("write", write);
    }

    //funkce na prevod stringu na Integer
    private void addStringToIntFunction() {
        Integer toint = memory.setMyObject(new ToInteger());
        scope.set("toint", toint);
    }

    //prida exponencialni funkci
    private void addExpFunction() {
        Integer exp = memory.setMyObject(new Exp());
        scope.set("exp", exp);
    }

    //prida random funkci
    private void addRandomFunction() {
        Integer rand = memory.setMyObject(new RandomFunction());
        scope.set("rand", rand);
    }
    
        //prida random funkci
    private void addRandomIntFunction() {
        Integer rand = memory.setMyObject(new RandomIntFunction());
        scope.set("randint", rand);
    }

    //prda funkci na prevo integeru na boolean
    private void addToBooleanFunction() {
        Integer tobool = memory.setMyObject(new ToBooleanFunction());
        scope.set("tobool", tobool);
    }
    
    private void addToDoubleFunction() {
        Integer tobool = memory.setMyObject(new ToDoubleFunction());
        scope.set("todouble", tobool);
    }

}
