package interpreter;

import Runy.Run;
import java.util.*;

public class Memory {

    private final int MAX_SIZE = 1000000;
    private final List<Integer> REFERENCES  = new LinkedList<>();  //list vsech referencí, tedy cisel od 0 do max velikosti
    private final MyObject[] memory = new MyObject[MAX_SIZE];      //pamet - pole objektu MyObject       
    private final Queue<Integer> freeReferences = new LinkedList<>();    //List co drzi volne reference k pouziti 
    private final Run run;


    public Memory(Run run) {
        for (int i = 0; i < MAX_SIZE; i++) { //naplni pole referenci ppostupne cislama, reference je pouze integer
            REFERENCES.add(i);
            
        }
        freeReferences.addAll(REFERENCES); //vsechny reference se hodi i do poolu referenci k pouziti
        this.run = run;
    }
    
    //vraci objekt na dane pozici v pameti podle reference
    public MyObject getMyObject(Integer reference) {
        final MyObject value = memory[reference];
        if (value != null)
            return value;
        else
            throw new ThrowError("Error in memory");
    }

    //ulozi objekt do pameti na první volnou referenci co je ne freereferences a vrati danou referenci
    public Integer setMyObject(MyObject object) {
        if  (freeReferences.isEmpty()) { //pokud uz nejsou volne reference pustí GC
            run.gc();

            if(freeReferences.isEmpty()) // pokud probehl GC a stale je pamet plna, vyhodi chybu 
                throw new ThrowError("full memory");
            }
        int ref = freeReferences.poll(); //odebere aktualni pouzitou referenci s poolu
        memory[ref] = object;
        object.setSelfReference(ref); //ulozi do objektu referenci na sebe, co kdyby
        return ref;
    }
    
    
    //spustí GC, jako argument dostane list referenci na objekty ze scopu
    public void gc(List<Integer> roots) {
        for (Integer root : roots)
            mark(root); //vsechny objekty na ktery je reference (rekurzivne) ve scopu oznaci aby se nesmazali
        clean();  //smaze neoznaceny  
    }

    //znaci rekurzivne objekty ktery jsou pouzivany aby se nemazali
    private void mark(Integer ref) {
        final MyObject object = getMyObject(ref);
        if (object.isMark()) 
            return;
        object.mark();  
        for (Integer reference : object.getAllReferences()) { //pokud objekt ma reference na jiny objekty rekurzivne se oznaci 
            mark(reference);
        }
    }
    
    //smaze neoznaceny reference z pameti a zaroven zbyle odznaci
    private void clean() {
        for (Integer reference : REFERENCES) {
            final MyObject object = memory[reference];
            if (object != null && object.isMark()) { //pokud je oznaceny, oznaceni smaze pro pristi GC
                object.unmark();
            } else { //smaze a prida volnou referenci
                memory[reference] = null;
                freeReferences.add(reference);
            }
        }
    }

}
