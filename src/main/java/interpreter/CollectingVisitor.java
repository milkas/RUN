package interpreter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.RuleNode;
import org.antlr.v4.runtime.tree.TerminalNode;
import parser.ScriptParser;
import parser.ScriptVisitor;

/**
 *
 * @author mira
 */
public class CollectingVisitor implements ScriptVisitor {

    private final Memory memory;
    private final Scope scope;

    public CollectingVisitor(Memory memory, Scope scope) {
        this.memory = memory;
        this.scope = scope;
    }

    @Override
    public Object visitArrayAssignment(ScriptParser.ArrayAssignmentContext ctx) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitAnonymousFunctionExpression(ScriptParser.AnonymousFunctionExpressionContext ctx) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitFunctionCall(ScriptParser.FunctionCallContext ctx) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitCallParam(ScriptParser.CallParamContext ctx) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitThisExpressionExpression(ScriptParser.ThisExpressionExpressionContext ctx) {
        return null;
    }

    @Override
    public Object visitArrayAccessExpression(ScriptParser.ArrayAccessExpressionContext ctx) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitFile(ScriptParser.FileContext ctx) {
        for (ScriptParser.FunctionDeclarationContext functionDeclarationContext : ctx.functionDeclaration()) {
            functionDeclarationContext.accept(this);
        }
        for (ScriptParser.VarDeclarationContext varDeclarationContext : ctx.varDeclaration()) {
            varDeclarationContext.accept(this);
        }
        for (ScriptParser.ExpressionContext expressionContext : ctx.expression()) {
            expressionContext.accept(this);
        }
        return null;
    }

    @Override
    public Object visitGetPropertyOnInstance(ScriptParser.GetPropertyOnInstanceContext ctx) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitFalse(ScriptParser.FalseContext ctx) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitAssignmentExpressionExpression(ScriptParser.AssignmentExpressionExpressionContext ctx) {
        ctx.assignmentExpression().accept(this);
        return null;
    }

    @Override
    public Object visitFunctionParameters(ScriptParser.FunctionParametersContext ctx) {
        for (Iterator<ScriptParser.FunctionParameterContext> it = ctx.functionParameter().iterator(); it.hasNext();) {
            ScriptParser.FunctionParameterContext functionParameter = it.next();
            functionParameter.accept(this);
        }
        return null;
    }

    @Override
    public Object visitSetPropertyOnInstance(ScriptParser.SetPropertyOnInstanceContext ctx) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitInt(ScriptParser.IntContext ctx) {
        return null;
    }

    @Override
    public Object visitIfExpression(ScriptParser.IfExpressionContext ctx) {
        return null;
    }

    @Override
    public Object visitMulExpression(ScriptParser.MulExpressionContext ctx) {
        return null;
    }

    @Override
    public Object visitNotExpression(ScriptParser.NotExpressionContext ctx) {
        return null;
    }

    @Override
    public Object visitCreateInstance(ScriptParser.CreateInstanceContext ctx) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitArrayAccess(ScriptParser.ArrayAccessContext ctx) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitDivExpression(ScriptParser.DivExpressionContext ctx) {
        return null;
    }

    @Override
    public Object visitCreateArray(ScriptParser.CreateArrayContext ctx) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitFunctionCallExpression(ScriptParser.FunctionCallExpressionContext ctx) {
        return null;
    }

    @Override
    public Object visitFunctionName(ScriptParser.FunctionNameContext ctx) {
        scope.define((String) ctx.ID().accept(this));
        return ctx.ID().accept(this);
    }

    @Override
    public Object visitModExpression(ScriptParser.ModExpressionContext ctx) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitArray(ScriptParser.ArrayContext ctx) {
        return null;
    }

    @Override
    public Object visitArrayAssignmentExpression(ScriptParser.ArrayAssignmentExpressionContext ctx) {
        return null;
    }

    @Override
    public Object visitCompareExpression(ScriptParser.CompareExpressionContext ctx) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitPrototypeAssignment(ScriptParser.PrototypeAssignmentContext ctx) {
            final String nameRef = (String) ctx.ID().accept(this);
        final Integer objectRef = scope.get(nameRef);
        final MyObject MyObject = memory.getMyObject(objectRef);
        MyObject.setPrototype((Integer) ctx.expression().accept(this));
        return null;
    }

    @Override
    public Object visitVarAssignment(ScriptParser.VarAssignmentContext ctx) {
        scope.define((String) ctx.ID().accept(this));
        return null;
    }

    @Override
    public Object visitThisSetterExpression(ScriptParser.ThisSetterExpressionContext ctx) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitParenthesesExpression(ScriptParser.ParenthesesExpressionContext ctx) {
        return null;
    }

    @Override
    public Object visitMessageToInstanceExpression(ScriptParser.MessageToInstanceExpressionContext ctx) {
        return null;
    }

    @Override
    public Object visitOrExpression(ScriptParser.OrExpressionContext ctx) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitCreateInstanceExpression(ScriptParser.CreateInstanceExpressionContext ctx) {
    return null;    
    }

    @Override
    public Object visitEqualsExpression(ScriptParser.EqualsExpressionContext ctx) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitThisGetterExpression(ScriptParser.ThisGetterExpressionContext ctx) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitAnonymousFunction(ScriptParser.AnonymousFunctionContext ctx) {
        Scope innerScope = new Scope(scope);
        if (ctx.functionParameters() != null) {
            ctx.functionParameters().accept(new CollectingVisitor(memory, innerScope));
        }
        ctx.functionBody().accept(new CollectingVisitor(memory, innerScope));
        final MyFunction function = new MyFunction(null, getFunctionParams(ctx.functionParameters()), innerScope , ctx.functionBody());
        return memory.setMyObject(function);
    }

    @Override
    public Object visitCallParams(ScriptParser.CallParamsContext ctx) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitPlusExpression(ScriptParser.PlusExpressionContext ctx) {
        return null;
    }

    @Override
    public Object visitWhileExpression(ScriptParser.WhileExpressionContext ctx) {
        return null;
    }

    @Override
    public Object visitVarDeclaration(ScriptParser.VarDeclarationContext ctx) {
        scope.define((String) ctx.ID().accept(this));
        return null;
    }

    @Override
    public Object visitMinusExpression(ScriptParser.MinusExpressionContext ctx) {
        return null;
    }

    @Override
    public Object visitTrue(ScriptParser.TrueContext ctx) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitFunctionBody(ScriptParser.FunctionBodyContext ctx) {
        for (ScriptParser.FunctionDeclarationContext functionDeclarationContext : ctx.functionDeclaration()) {
            functionDeclarationContext.accept(this);
        }
        for (ScriptParser.VarDeclarationContext varDeclarationContext : ctx.varDeclaration()) {
            varDeclarationContext.accept(this);
        }
        for (ScriptParser.ExpressionContext expressionContext : ctx.expression()) {
            expressionContext.accept(this);
        }
        return null;
    }

    @Override
    public Object visitCallMethodOnInstance(ScriptParser.CallMethodOnInstanceContext ctx) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitIfStatement(ScriptParser.IfStatementContext ctx) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitAssignment(ScriptParser.AssignmentContext ctx) {
        return null;
    }

    @Override
    public Object visitWhileStatement(ScriptParser.WhileStatementContext ctx) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitUnaryMinusExpression(ScriptParser.UnaryMinusExpressionContext ctx) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitString(ScriptParser.StringContext ctx) {
        return null;
    }

    @Override
    public Object visitThisCallMethod(ScriptParser.ThisCallMethodContext ctx) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitFunctionDeclaration(ScriptParser.FunctionDeclarationContext ctx) {
        String name = (String) ctx.functionName().accept(this);
        Scope innerScope = new Scope();
        if (ctx.functionParameters() != null) {
            ctx.functionParameters().accept(new CollectingVisitor(memory, innerScope));
        }
        ctx.functionBody().accept(new CollectingVisitor(memory, innerScope));
        final MyFunction function = new MyFunction(name, getFunctionParams(ctx.functionParameters()), innerScope, ctx.functionBody());
        final Integer reference = memory.setMyObject(function);
        scope.set(name, reference);
        return null;
    }

    private List<String> getFunctionParams(ScriptParser.FunctionParametersContext ctx) {
        List<String> params = new ArrayList<String>();
        if (ctx != null) {
            for (ScriptParser.FunctionParameterContext functionParameter : ctx.functionParameter()) {
                params.add((String) functionParameter.ID().accept(this));
            }
        }
        return params;
    }

    @Override
    public Object visitFunctionParameter(ScriptParser.FunctionParameterContext ctx) {
        scope.define((String) ctx.ID().accept(this));
        return null;
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
        switch (tn.getSymbol().getType()) {
            case ScriptParser.INT:
                return Integer.parseInt(tn.getText());
            case ScriptParser.ID:
                return tn.getText();
            default:
                return null;
        }
    }

    @Override
    public Object visitErrorNode(ErrorNode en) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitDouble(ScriptParser.DoubleContext ctx) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
