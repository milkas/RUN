package interpreter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.RuleNode;
import org.antlr.v4.runtime.tree.TerminalNode;
import parser.ScriptParser;
import parser.ScriptVisitor;


public class InterpreterVisitor implements ScriptVisitor {

    private final Memory memory;
    private final Scope scope;
    private final Scope thisScope;

    public InterpreterVisitor(Memory memory, Scope scope, Scope thisScope) {
        this.memory = memory;
        this.scope = scope;
        this.thisScope = thisScope;
    }

    @Override
    public Object visitArrayAssignment(ScriptParser.ArrayAssignmentContext ctx) {
        String name = resolveSymbolName(ctx.ID().accept(this));   //jmeno promenny
        MyObject array = resolveSymbolToMyObject(ctx.ID().accept(this));
        List<Integer> refs = (List) ctx.callParams().accept(this);
        final MyObject index = memory.getMyObject(refs.get(0));
        if (array.isArray()) {

            int x = (Integer) ctx.expression().accept(this);
            int ref;

            MyObject object = memory.getMyObject(x);
            if (object.isSymbol()) {
                MyObject sym = memory.getMyObject((scope.get((String) object.value())));
                if (sym.isArray()) {
                    refs = (List) sym.getAllReferences();

                    List<Integer> arrayRefs = new ArrayList<>(refs.size());
                    for (Integer re : refs) {
                        final MyObject myObject = memory.getMyObject(re);
                        if (myObject.isSymbol()) {
                            arrayRefs.add(scope.get((String) myObject.value()));
                        } else {
                            arrayRefs.add(re);
                        }
                    }

                    ref = memory.setMyObject(new MyArray(arrayRefs));
                } else {

                    ref = memory.setMyObject(sym);

                }
            } else {
                ref = x;
            }

            if (index.isSymbol()) {
                final MyObject obj = memory.getMyObject((scope.get((String) index.value())));
                ((MyArray) array).set((Integer) obj.value(), ref);
            } else {
                ((MyArray) array).set((Integer) index.value(), ref);
            }

            return null;
        }
        throw new ThrowError(name + " is not array.");
    }

    @Override
    public Object visitAnonymousFunctionExpression(ScriptParser.AnonymousFunctionExpressionContext ctx) {
        return ctx.anonymousFunction().accept(new CollectingVisitor(memory, scope));
    }

    @Override
    public Object visitFunctionCall(ScriptParser.FunctionCallContext ctx) {

        MyObject function = resolveSymbolToMyObject(ctx.ID().accept(this));
        List<Integer> paramRefs = null;

        if (ctx.callParams() == null) {
            paramRefs = Collections.emptyList();
        } else {
            paramRefs = (List<Integer>) ctx.callParams().accept(this);
        }

        return function.invoke(paramRefs, scope, memory);
    }

    @Override
    public Object visitCallParam(ScriptParser.CallParamContext ctx) {
        if (ctx.ID() != null) {
            return ctx.ID().accept(this);
        } else if (ctx.INT() != null) {
            return ctx.INT().accept(this);
        } else if (ctx.STRING() != null) {
            return ctx.STRING().accept(this);
        } else {
            return null;
        }
    }

    @Override
    public Object visitThisExpressionExpression(ScriptParser.ThisExpressionExpressionContext ctx) {
        return ctx.thisExpression().accept(this);
    }

    @Override
    public Object visitArrayAccessExpression(ScriptParser.ArrayAccessExpressionContext ctx) {
        return ctx.arrayAccess().accept(this);
    }

    @Override
    public Object visitFile(ScriptParser.FileContext ctx) {
        Object result = null;
        for (ScriptParser.ExpressionContext expressionContext : ctx.expression()) {
            result = expressionContext.accept(this);
        }
        return result;
    }

    @Override
    public Object visitGetPropertyOnInstance(ScriptParser.GetPropertyOnInstanceContext ctx) {
        MyObject instance = resolveSymbolToMyObject(ctx.ID(0).accept(this));
        String methodName = resolveSymbolName(ctx.ID(1).accept(this));
        return instance.invoke(methodName, null, scope, memory);
    }

    @Override
    public Object visitFalse(ScriptParser.FalseContext ctx) {
        return ctx.FALSE().accept(this);
    }

    @Override
    public Object visitAssignmentExpressionExpression(ScriptParser.AssignmentExpressionExpressionContext ctx) {
        ctx.assignmentExpression().accept(this);
        return null;
    }

    @Override
    public Object visitFunctionParameters(ScriptParser.FunctionParametersContext ctx) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitSetPropertyOnInstance(ScriptParser.SetPropertyOnInstanceContext ctx) {
        MyObject instance = resolveSymbolToMyObject(ctx.ID(0).accept(this));
        String methodName = resolveSymbolName(ctx.ID(1).accept(this));
        List<Integer> paramRefs = Arrays.asList((Integer) ctx.expression().accept(this));
        return instance.invoke(methodName, paramRefs, scope, memory);
    }

    @Override
    public Object visitInt(ScriptParser.IntContext ctx) {
        return ctx.INT().accept(this);
    }

    @Override
    public Object visitIfExpression(ScriptParser.IfExpressionContext ctx) {
        return ctx.ifStatement().accept(this);
    }

    @Override
    public Object visitMulExpression(ScriptParser.MulExpressionContext ctx) {
        int first = (int) ctx.expression(0).accept(this);
        int second = (int) ctx.expression(1).accept(this);
        return invokeBinaryOperation(first, second, "*");
    }

    @Override
    public Object visitNotExpression(ScriptParser.NotExpressionContext ctx) {
        MyObject first = ensureObject(ctx.expression().accept(this));
        return first.invoke("!", Collections.<Integer>emptyList(), scope, memory);
    }

    @Override
    public Object visitCreateInstance(ScriptParser.CreateInstanceContext ctx) {
        final MyObject myObject = resolveSymbolToMyObject(ctx.ID().accept(this));
        if (myObject.isFunction()) {
            MyFunction constructor = (MyFunction) myObject;
            List<Integer> paramRefs = ctx.callParams() == null
                    ? Collections.<Integer>emptyList()
                    : (List<Integer>) ctx.callParams().accept(this);
            return constructor.constructInstance(paramRefs, scope, memory);
        }
        throw new ThrowError(resolveSymbolName(ctx.ID().accept(this)) + " is not function");
    }

    @Override
    public Object visitArrayAccess(ScriptParser.ArrayAccessContext ctx) {
        String name = resolveSymbolName(ctx.ID().accept(this));
        MyObject array = resolveSymbolToMyObject(ctx.ID().accept(this));
        List<Integer> refs = (List) ctx.callParams().accept(this);
        final MyObject index = memory.getMyObject(refs.get(0));

        if (array.isArray()) {
            if (index.isSymbol()) {
                final MyObject obj = memory.getMyObject((scope.get((String) index.value())));
                return ((MyArray) array).get((Integer) obj.value());
            } else {
                return ((MyArray) array).get((Integer) index.value());
            }

        }

        throw new ThrowError(name + " is not array.");
    }

    @Override
    public Object visitDivExpression(ScriptParser.DivExpressionContext ctx) {
        Integer firstRef = (Integer) ctx.expression(0).accept(this);
        Integer secondRef = (Integer) ctx.expression(1).accept(this);
        return invokeBinaryOperation(firstRef, secondRef, "/");
    }

    @Override
    public Object visitCreateArray(ScriptParser.CreateArrayContext ctx) {
        List<Integer> refs = (List) ctx.callParams().accept(this);
        //pokud je pri vytvareni pole pouze jeden parametr vezme se hodnota toho parametru a vytvori se tak velké pole
        if (refs.size() == 1) {
            final MyObject myObject = memory.getMyObject(refs.get(0)); //nacte prvni a jediny parametr coz by mela byt velikost budouciho pole
            int size;
            if (myObject.isSymbol()) { //pokud se jedna o symbol, musi se pres scope dotahnout jeho hodnota
                int ref = (int) (scope.get((String) myObject.value()));
                MyObject value = memory.getMyObject(ref);
                size = (int) value.value(); // velikost pole je tedy hodnota promenne pod danym symbolem
            } else {
                size = (int) myObject.value(); //pokud je jako parametr rovnou cislo tak se pouzije
            }

            List<Integer> arrayRefs = new ArrayList<>(size); //vytvori se dane pole
            for (int i = 0; i < size; i++) { // a naplni se nulama
                arrayRefs.add(0);
            }
            return memory.setMyObject(new MyArray(arrayRefs)); // vytvori se novy pole
        } else {
            List<Integer> arrayRefs = new ArrayList<>(refs.size());
            for (Integer ref : refs) {
                final MyObject myObject = memory.getMyObject(ref);
                if (myObject.isSymbol()) {
                    arrayRefs.add(scope.get((String) myObject.value()));
                } else {
                    arrayRefs.add(ref);
                }
            }
            return memory.setMyObject(new MyArray(arrayRefs));
        }
    }

    @Override
    public Object visitFunctionCallExpression(ScriptParser.FunctionCallExpressionContext ctx) {
        return ctx.functionCall().accept(this);
    }

    @Override
    public Object visitFunctionName(ScriptParser.FunctionNameContext ctx) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitModExpression(ScriptParser.ModExpressionContext ctx) {
        Integer firstRef = (Integer) ctx.expression(0).accept(this);
        Integer secondRef = (Integer) ctx.expression(1).accept(this);
        return invokeBinaryOperation(firstRef, secondRef, "%");
    }

    @Override
    public Object visitArray(ScriptParser.ArrayContext ctx) {
        return ctx.createArray().accept(this);
    }

    @Override
    public Object visitArrayAssignmentExpression(ScriptParser.ArrayAssignmentExpressionContext ctx) {
        return ctx.arrayAssignment().accept(this);
    }

    @Override
    public Object visitCompareExpression(ScriptParser.CompareExpressionContext ctx) {
        Integer firstRef = (Integer) ctx.expression(0).accept(this);
        Integer secondRef = (Integer) ctx.expression(1).accept(this);
        return invokeBinaryOperation(firstRef, secondRef, ctx.COMPARE_OPERATORS().getText());
    }

    @Override
    public Object visitPrototypeAssignment(ScriptParser.PrototypeAssignmentContext ctx) {
        final MyObject jsObject = resolveSymbolToMyObject(ctx.ID().accept(this));
        jsObject.setPrototype((Integer) ctx.expression().accept(this));
        return null;   
    }

    @Override
    public Object visitVarAssignment(ScriptParser.VarAssignmentContext ctx) {
        String name = resolveSymbolName(ctx.ID().accept(this));
        Integer resultRef = getReference(ctx.expression().accept(this));
        scope.set(name, resultRef);
        return null;
    }

    private Integer getReference(Object ref) {
        Integer resultRef = (Integer) ref;
        if (resultRef != null && memory.getMyObject(resultRef).isSymbol()) {
            resultRef = scope.get((String) memory.getMyObject(resultRef).value());
        }
        return resultRef;
    }

    @Override
    public Object visitThisSetterExpression(ScriptParser.ThisSetterExpressionContext ctx) {
        String propertyName = resolveSymbolName(ctx.ID().accept(this));
        Integer resultRef = getReference(ctx.expression().accept(this));
        thisScope.define(propertyName);
        thisScope.set(propertyName, resultRef);
        return null;
    }

    @Override
    public Object visitParenthesesExpression(ScriptParser.ParenthesesExpressionContext ctx) {
        return ctx.expression().accept(this);
    }

    @Override
    public Object visitMessageToInstanceExpression(ScriptParser.MessageToInstanceExpressionContext ctx) {
        return ctx.messageToInstance().accept(this);
    }

    @Override
    public Object visitOrExpression(ScriptParser.OrExpressionContext ctx) {
        Integer firstRef = (Integer) ctx.expression(0).accept(this);
        Integer secondRef = (Integer) ctx.expression(1).accept(this);
        return invokeBinaryOperation(firstRef, secondRef, "||");
    }

    @Override
    public Object visitPrototypeAssignmentExpressionExpression(ScriptParser.PrototypeAssignmentExpressionExpressionContext ctx) {
         ctx.prototypeAssignmentExpression().accept(this);
         return null;
    }

    @Override
    public Object visitId(ScriptParser.IdContext ctx) {
        return ctx.ID().accept(this);
    }

    @Override
    public Object visitAndExpression(ScriptParser.AndExpressionContext ctx) {
        Integer firstRef = (Integer) ctx.expression(0).accept(this);
        Integer secondRef = (Integer) ctx.expression(1).accept(this);
        return invokeBinaryOperation(firstRef, secondRef, "&&");
    }

    @Override
    public Object visitCreateInstanceExpression(ScriptParser.CreateInstanceExpressionContext ctx) {
        return ctx.createInstance().accept(this);
    }

    @Override
    public Object visitEqualsExpression(ScriptParser.EqualsExpressionContext ctx) {
        Integer firstRef = (Integer) ctx.expression(0).accept(this);
        Integer secondRef = (Integer) ctx.expression(1).accept(this);
        return invokeBinaryOperation(firstRef, secondRef, "==");
    }

    @Override
    public Object visitThisGetterExpression(ScriptParser.ThisGetterExpressionContext ctx) {
        return thisScope.get(resolveSymbolName(ctx.ID().accept(this)));
    }

    @Override
    public Object visitAnonymousFunction(ScriptParser.AnonymousFunctionContext ctx) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitCallParams(ScriptParser.CallParamsContext ctx) {
        List<Integer> params = new ArrayList<>();
        for (ScriptParser.CallParamContext callParamContext : ctx.callParam()) {
            params.add((Integer) callParamContext.accept(this));
        }
        return params;
    }

    @Override
    public Object visitPlusExpression(ScriptParser.PlusExpressionContext ctx) {
        int first = (int) ctx.expression(0).accept(this);
        int second = (int) ctx.expression(1).accept(this);
        return invokeBinaryOperation(first, second, "+");
    }

    @Override
    public Object visitWhileExpression(ScriptParser.WhileExpressionContext ctx) {
        return ctx.whileStatement().accept(this);
    }

    @Override
    public Object visitVarDeclaration(ScriptParser.VarDeclarationContext ctx) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitMinusExpression(ScriptParser.MinusExpressionContext ctx) {
        Integer firstRef = (Integer) ctx.expression(0).accept(this);
        Integer secondRef = (Integer) ctx.expression(1).accept(this);
        return invokeBinaryOperation(firstRef, secondRef, "-");
    }

    @Override
    public Object visitTrue(ScriptParser.TrueContext ctx) {
        return ctx.TRUE().accept(this);
    }

    @Override
    public Object visitFunctionBody(ScriptParser.FunctionBodyContext ctx) {
        Object returnValue = null;
        for (ScriptParser.ExpressionContext expressionContext : ctx.expression()) {
            returnValue = expressionContext.accept(this);
        }
        return returnValue;
    }

    @Override
    public Object visitCallMethodOnInstance(ScriptParser.CallMethodOnInstanceContext ctx) {
        final MyObject instance = resolveSymbolToMyObject(ctx.ID(0).accept(this));
        final String methodName = resolveSymbolName(ctx.ID(1).accept(this));
        final List<Integer> paramRefs = ctx.callParams() == null
                ? Collections.<Integer>emptyList()
                : (List<Integer>) ctx.callParams().accept(this);
        return instance.invoke(methodName, paramRefs, scope, memory);
    }

    @Override
    public Object visitIfStatement(ScriptParser.IfStatementContext ctx) {
        MyObject condition = ensureObject(ctx.expression().accept(this));
        if (!condition.isBoolean()) {
            throw new ThrowError("Not boolean expression");
        }
        if ((Boolean) condition.value()) {
            ctx.functionBody(0).accept(this);
        } else {
            ctx.functionBody(1).accept(this);
        }
        return null;
    }

    @Override
    public Object visitAssignment(ScriptParser.AssignmentContext ctx) {
        String name = resolveSymbolName(ctx.ID().accept(this));
        Integer resultRef = getReference(ctx.expression().accept(this));
        scope.set(name, resultRef);
        return null;
    }

    @Override
    public Object visitWhileStatement(ScriptParser.WhileStatementContext ctx) {
        MyObject condition = ensureObject(ctx.expression().accept(this));
        if (!condition.isBoolean()) {
            throw new ThrowError("Not boolean expression");
        }
        while ((Boolean) condition.value()) {
            ctx.functionBody().accept(this);
            condition = ensureObject(ctx.expression().accept(this));
            if (!condition.isBoolean()) {
                throw new ThrowError("Not boolean expression");
            }
        }
        return null;
    }

    @Override
    public Object visitUnaryMinusExpression(ScriptParser.UnaryMinusExpressionContext ctx) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitString(ScriptParser.StringContext ctx) {
        return ctx.STRING().accept(this);
    }

    @Override
    public Object visitThisCallMethod(ScriptParser.ThisCallMethodContext ctx) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitFunctionDeclaration(ScriptParser.FunctionDeclarationContext ctx) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitFunctionParameter(ScriptParser.FunctionParameterContext ctx) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visit(ParseTree pt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitChildren(RuleNode rn) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitTerminal(TerminalNode tn) {
        MyObject terminal = null;
        switch (tn.getSymbol().getType()) {
            case ScriptParser.INT:
                terminal = new MyInt(Integer.parseInt(tn.getText()));
                break;
            case ScriptParser.ID:
                terminal = new MySymbol(tn.getText());
                break;
            case ScriptParser.STRING:
                terminal = new MyString(tn.getText().replace("\"", ""));
                break;
            case ScriptParser.TRUE:
                terminal = new MyBoolean(Boolean.TRUE);
                break;
            case ScriptParser.FALSE:
                terminal = new MyBoolean(Boolean.FALSE);
                break;
            case ScriptParser.DOUBLE:
                String string = tn.getText();
                String[] parts = string.split(",");
                string = parts[0] + "." + parts[1];
                terminal = new MyDouble(Double.parseDouble(string));
                break;
            default:
                throw new IllegalStateException("Unknown terminal node");
        }
        return memory.setMyObject(terminal);
    }

    @Override
    public Object visitErrorNode(ErrorNode en) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private Object invokeBinaryOperation(int first, int second, String operation) {
        MyObject firstObject = ensureObject(first);
        MyObject secondObject = memory.getMyObject(second);

        if (secondObject.isSymbol()) {
            second = scope.get((String) secondObject.value());
        }
        return firstObject.invoke(operation, Arrays.asList(second), scope, memory);
    }

    private MyObject ensureObject(Object ref) {
        MyObject object = memory.getMyObject((Integer) ref);
        if (object.isSymbol()) {
            object = memory.getMyObject(scope.get((String) object.value()));
        }
        return object;
    }

    private MyObject resolveSymbolToMyObjectFromThisScope(Object id) {
        return resolveSymbolToMyObjectFromScope(id, thisScope);
    }

    private MyObject resolveSymbolToMyObject(Object id) {
        return resolveSymbolToMyObjectFromScope(id, scope);
    }

    private MyObject resolveSymbolToMyObjectFromScope(Object id, Scope scopeToUse) {
        final String symbol = resolveSymbolName(id);
        final int instanceRed = scopeToUse.get(symbol);
        return memory.getMyObject(instanceRed);
    }

    private String resolveSymbolName(Object nameRef) {
        final MySymbol instanceName = (MySymbol) memory.getMyObject((Integer) nameRef);
        return (String) instanceName.value();
    }

    @Override
    public Object visitDouble(ScriptParser.DoubleContext ctx) {
        return ctx.DOUBLE().accept(this);
    }

}
