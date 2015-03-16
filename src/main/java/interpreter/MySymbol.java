package interpreter;

import java.util.List;

public class MySymbol extends MyObject{
    
    private final String text;
    
    public MySymbol(String text){
        this.text = text;        
    }
    
    @Override
    public boolean isSymbol(){
        return true;
    }
    
    @Override
    public Object value(){
        return text;
    }

    @Override
    public Integer invoke(String function, List<Integer> args, Scope invokeScope, Memory memory) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Integer invoke(List<Integer> args, Scope invokeScope, Memory memory) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Integer constructInstance(List<Integer> args, Scope invokeScope, Memory memory) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
