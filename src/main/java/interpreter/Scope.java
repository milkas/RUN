package interpreter;

import java.util.*;

public class Scope {

    Scope parent;
    private Map<String, Integer> scope;

    public Scope() {
        parent = null;
        scope = new HashMap<>();
    }

    public Scope(Scope parent) {
        this();
        this.parent = parent;
    }

    public Scope(Scope definitionScope, Scope parentScope) {
        this();
        if (this.parent == null) {
            this.parent = parentScope;
        } else {
            this.parent = definitionScope.parent;
        }

        for (String name : definitionScope.scope.keySet()) {
            define(name);
        }
    }

    //nadefinuje promennou ve scopu
    public void define(String name) {
        scope.put(name, null);
    }

    //nastavi novou referenci pro dany jmeno
    public void set(String name, Integer reference) {
        boolean inParentsScope = false;
        if (scope.containsKey(name)) { //pokud je dana reference ve scopu tak ji updatuje
            scope.put(name, reference);
        } else if (parent != null) { //pokud neni v danym scopu a scope ma rodice zkusi ji najit v dalsich
            inParentsScope = parent.setParent(name, reference); //updatuje ref v parent scopech  a vraci true poku je reference definovana v parent scopech
        } else if (inParentsScope == false) { // pokud neni reference definovana v zadnym scopu vytvori ji v aktualnim
            scope.put(name, reference);
        }
    }

    //prohleda parent scopy a kdyz najde referenci tak ji updatuje, a vrati true jinak false
    private boolean setParent(String name, Integer reference) {
        if (scope.containsKey(name)) {
            scope.put(name, reference);
            return true;
        } else if (parent != null) {
            parent.set(name, reference);
        }
        return false;
    }

    //vrati referenci na objekt podle nazvu promenny
    public Integer get(String name) {
        if (scope.containsKey(name)) {
            return scope.get(name);
        } else if (parent != null) {
            return parent.get(name);
        } else {
            throw new ThrowError("Error in Scope");
        }
    }

    //vrati vsechny reference ve scopua rekurzivne v parentscopech    
    public List<Integer> getAllReferences() {
        final List<Integer> references = new ArrayList<>(scope.size());
        for (Integer ref : scope.values()) {
            if (ref != null) {
                references.add(ref);
            }
        }
        if (parent != null) {
            references.addAll(parent.getAllReferences());
        }
        return references;
    }
}
