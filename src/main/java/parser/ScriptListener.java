// Generated from Script.g4 by ANTLR 4.1
package parser;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ScriptParser}.
 */
public interface ScriptListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ScriptParser#arrayAssignment}.
	 * @param ctx the parse tree
	 */
	void enterArrayAssignment(@NotNull ScriptParser.ArrayAssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScriptParser#arrayAssignment}.
	 * @param ctx the parse tree
	 */
	void exitArrayAssignment(@NotNull ScriptParser.ArrayAssignmentContext ctx);

	/**
	 * Enter a parse tree produced by {@link ScriptParser#anonymousFunctionExpression}.
	 * @param ctx the parse tree
	 */
	void enterAnonymousFunctionExpression(@NotNull ScriptParser.AnonymousFunctionExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScriptParser#anonymousFunctionExpression}.
	 * @param ctx the parse tree
	 */
	void exitAnonymousFunctionExpression(@NotNull ScriptParser.AnonymousFunctionExpressionContext ctx);

	/**
	 * Enter a parse tree produced by {@link ScriptParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void enterFunctionCall(@NotNull ScriptParser.FunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScriptParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void exitFunctionCall(@NotNull ScriptParser.FunctionCallContext ctx);

	/**
	 * Enter a parse tree produced by {@link ScriptParser#callParam}.
	 * @param ctx the parse tree
	 */
	void enterCallParam(@NotNull ScriptParser.CallParamContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScriptParser#callParam}.
	 * @param ctx the parse tree
	 */
	void exitCallParam(@NotNull ScriptParser.CallParamContext ctx);

	/**
	 * Enter a parse tree produced by {@link ScriptParser#thisExpressionExpression}.
	 * @param ctx the parse tree
	 */
	void enterThisExpressionExpression(@NotNull ScriptParser.ThisExpressionExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScriptParser#thisExpressionExpression}.
	 * @param ctx the parse tree
	 */
	void exitThisExpressionExpression(@NotNull ScriptParser.ThisExpressionExpressionContext ctx);

	/**
	 * Enter a parse tree produced by {@link ScriptParser#arrayAccessExpression}.
	 * @param ctx the parse tree
	 */
	void enterArrayAccessExpression(@NotNull ScriptParser.ArrayAccessExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScriptParser#arrayAccessExpression}.
	 * @param ctx the parse tree
	 */
	void exitArrayAccessExpression(@NotNull ScriptParser.ArrayAccessExpressionContext ctx);

	/**
	 * Enter a parse tree produced by {@link ScriptParser#file}.
	 * @param ctx the parse tree
	 */
	void enterFile(@NotNull ScriptParser.FileContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScriptParser#file}.
	 * @param ctx the parse tree
	 */
	void exitFile(@NotNull ScriptParser.FileContext ctx);

	/**
	 * Enter a parse tree produced by {@link ScriptParser#getPropertyOnInstance}.
	 * @param ctx the parse tree
	 */
	void enterGetPropertyOnInstance(@NotNull ScriptParser.GetPropertyOnInstanceContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScriptParser#getPropertyOnInstance}.
	 * @param ctx the parse tree
	 */
	void exitGetPropertyOnInstance(@NotNull ScriptParser.GetPropertyOnInstanceContext ctx);

	/**
	 * Enter a parse tree produced by {@link ScriptParser#false}.
	 * @param ctx the parse tree
	 */
	void enterFalse(@NotNull ScriptParser.FalseContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScriptParser#false}.
	 * @param ctx the parse tree
	 */
	void exitFalse(@NotNull ScriptParser.FalseContext ctx);

	/**
	 * Enter a parse tree produced by {@link ScriptParser#assignmentExpressionExpression}.
	 * @param ctx the parse tree
	 */
	void enterAssignmentExpressionExpression(@NotNull ScriptParser.AssignmentExpressionExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScriptParser#assignmentExpressionExpression}.
	 * @param ctx the parse tree
	 */
	void exitAssignmentExpressionExpression(@NotNull ScriptParser.AssignmentExpressionExpressionContext ctx);

	/**
	 * Enter a parse tree produced by {@link ScriptParser#functionParameters}.
	 * @param ctx the parse tree
	 */
	void enterFunctionParameters(@NotNull ScriptParser.FunctionParametersContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScriptParser#functionParameters}.
	 * @param ctx the parse tree
	 */
	void exitFunctionParameters(@NotNull ScriptParser.FunctionParametersContext ctx);

	/**
	 * Enter a parse tree produced by {@link ScriptParser#setPropertyOnInstance}.
	 * @param ctx the parse tree
	 */
	void enterSetPropertyOnInstance(@NotNull ScriptParser.SetPropertyOnInstanceContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScriptParser#setPropertyOnInstance}.
	 * @param ctx the parse tree
	 */
	void exitSetPropertyOnInstance(@NotNull ScriptParser.SetPropertyOnInstanceContext ctx);

	/**
	 * Enter a parse tree produced by {@link ScriptParser#int}.
	 * @param ctx the parse tree
	 */
	void enterInt(@NotNull ScriptParser.IntContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScriptParser#int}.
	 * @param ctx the parse tree
	 */
	void exitInt(@NotNull ScriptParser.IntContext ctx);

	/**
	 * Enter a parse tree produced by {@link ScriptParser#ifExpression}.
	 * @param ctx the parse tree
	 */
	void enterIfExpression(@NotNull ScriptParser.IfExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScriptParser#ifExpression}.
	 * @param ctx the parse tree
	 */
	void exitIfExpression(@NotNull ScriptParser.IfExpressionContext ctx);

	/**
	 * Enter a parse tree produced by {@link ScriptParser#mulExpression}.
	 * @param ctx the parse tree
	 */
	void enterMulExpression(@NotNull ScriptParser.MulExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScriptParser#mulExpression}.
	 * @param ctx the parse tree
	 */
	void exitMulExpression(@NotNull ScriptParser.MulExpressionContext ctx);

	/**
	 * Enter a parse tree produced by {@link ScriptParser#notExpression}.
	 * @param ctx the parse tree
	 */
	void enterNotExpression(@NotNull ScriptParser.NotExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScriptParser#notExpression}.
	 * @param ctx the parse tree
	 */
	void exitNotExpression(@NotNull ScriptParser.NotExpressionContext ctx);

	/**
	 * Enter a parse tree produced by {@link ScriptParser#double}.
	 * @param ctx the parse tree
	 */
	void enterDouble(@NotNull ScriptParser.DoubleContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScriptParser#double}.
	 * @param ctx the parse tree
	 */
	void exitDouble(@NotNull ScriptParser.DoubleContext ctx);

	/**
	 * Enter a parse tree produced by {@link ScriptParser#createInstance}.
	 * @param ctx the parse tree
	 */
	void enterCreateInstance(@NotNull ScriptParser.CreateInstanceContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScriptParser#createInstance}.
	 * @param ctx the parse tree
	 */
	void exitCreateInstance(@NotNull ScriptParser.CreateInstanceContext ctx);

	/**
	 * Enter a parse tree produced by {@link ScriptParser#arrayAccess}.
	 * @param ctx the parse tree
	 */
	void enterArrayAccess(@NotNull ScriptParser.ArrayAccessContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScriptParser#arrayAccess}.
	 * @param ctx the parse tree
	 */
	void exitArrayAccess(@NotNull ScriptParser.ArrayAccessContext ctx);

	/**
	 * Enter a parse tree produced by {@link ScriptParser#divExpression}.
	 * @param ctx the parse tree
	 */
	void enterDivExpression(@NotNull ScriptParser.DivExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScriptParser#divExpression}.
	 * @param ctx the parse tree
	 */
	void exitDivExpression(@NotNull ScriptParser.DivExpressionContext ctx);

	/**
	 * Enter a parse tree produced by {@link ScriptParser#createArray}.
	 * @param ctx the parse tree
	 */
	void enterCreateArray(@NotNull ScriptParser.CreateArrayContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScriptParser#createArray}.
	 * @param ctx the parse tree
	 */
	void exitCreateArray(@NotNull ScriptParser.CreateArrayContext ctx);

	/**
	 * Enter a parse tree produced by {@link ScriptParser#functionCallExpression}.
	 * @param ctx the parse tree
	 */
	void enterFunctionCallExpression(@NotNull ScriptParser.FunctionCallExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScriptParser#functionCallExpression}.
	 * @param ctx the parse tree
	 */
	void exitFunctionCallExpression(@NotNull ScriptParser.FunctionCallExpressionContext ctx);

	/**
	 * Enter a parse tree produced by {@link ScriptParser#functionName}.
	 * @param ctx the parse tree
	 */
	void enterFunctionName(@NotNull ScriptParser.FunctionNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScriptParser#functionName}.
	 * @param ctx the parse tree
	 */
	void exitFunctionName(@NotNull ScriptParser.FunctionNameContext ctx);

	/**
	 * Enter a parse tree produced by {@link ScriptParser#modExpression}.
	 * @param ctx the parse tree
	 */
	void enterModExpression(@NotNull ScriptParser.ModExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScriptParser#modExpression}.
	 * @param ctx the parse tree
	 */
	void exitModExpression(@NotNull ScriptParser.ModExpressionContext ctx);

	/**
	 * Enter a parse tree produced by {@link ScriptParser#array}.
	 * @param ctx the parse tree
	 */
	void enterArray(@NotNull ScriptParser.ArrayContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScriptParser#array}.
	 * @param ctx the parse tree
	 */
	void exitArray(@NotNull ScriptParser.ArrayContext ctx);

	/**
	 * Enter a parse tree produced by {@link ScriptParser#arrayAssignmentExpression}.
	 * @param ctx the parse tree
	 */
	void enterArrayAssignmentExpression(@NotNull ScriptParser.ArrayAssignmentExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScriptParser#arrayAssignmentExpression}.
	 * @param ctx the parse tree
	 */
	void exitArrayAssignmentExpression(@NotNull ScriptParser.ArrayAssignmentExpressionContext ctx);

	/**
	 * Enter a parse tree produced by {@link ScriptParser#varAssignment}.
	 * @param ctx the parse tree
	 */
	void enterVarAssignment(@NotNull ScriptParser.VarAssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScriptParser#varAssignment}.
	 * @param ctx the parse tree
	 */
	void exitVarAssignment(@NotNull ScriptParser.VarAssignmentContext ctx);

	/**
	 * Enter a parse tree produced by {@link ScriptParser#compareExpression}.
	 * @param ctx the parse tree
	 */
	void enterCompareExpression(@NotNull ScriptParser.CompareExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScriptParser#compareExpression}.
	 * @param ctx the parse tree
	 */
	void exitCompareExpression(@NotNull ScriptParser.CompareExpressionContext ctx);

	/**
	 * Enter a parse tree produced by {@link ScriptParser#prototypeAssignment}.
	 * @param ctx the parse tree
	 */
	void enterPrototypeAssignment(@NotNull ScriptParser.PrototypeAssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScriptParser#prototypeAssignment}.
	 * @param ctx the parse tree
	 */
	void exitPrototypeAssignment(@NotNull ScriptParser.PrototypeAssignmentContext ctx);

	/**
	 * Enter a parse tree produced by {@link ScriptParser#thisSetterExpression}.
	 * @param ctx the parse tree
	 */
	void enterThisSetterExpression(@NotNull ScriptParser.ThisSetterExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScriptParser#thisSetterExpression}.
	 * @param ctx the parse tree
	 */
	void exitThisSetterExpression(@NotNull ScriptParser.ThisSetterExpressionContext ctx);

	/**
	 * Enter a parse tree produced by {@link ScriptParser#parenthesesExpression}.
	 * @param ctx the parse tree
	 */
	void enterParenthesesExpression(@NotNull ScriptParser.ParenthesesExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScriptParser#parenthesesExpression}.
	 * @param ctx the parse tree
	 */
	void exitParenthesesExpression(@NotNull ScriptParser.ParenthesesExpressionContext ctx);

	/**
	 * Enter a parse tree produced by {@link ScriptParser#messageToInstanceExpression}.
	 * @param ctx the parse tree
	 */
	void enterMessageToInstanceExpression(@NotNull ScriptParser.MessageToInstanceExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScriptParser#messageToInstanceExpression}.
	 * @param ctx the parse tree
	 */
	void exitMessageToInstanceExpression(@NotNull ScriptParser.MessageToInstanceExpressionContext ctx);

	/**
	 * Enter a parse tree produced by {@link ScriptParser#orExpression}.
	 * @param ctx the parse tree
	 */
	void enterOrExpression(@NotNull ScriptParser.OrExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScriptParser#orExpression}.
	 * @param ctx the parse tree
	 */
	void exitOrExpression(@NotNull ScriptParser.OrExpressionContext ctx);

	/**
	 * Enter a parse tree produced by {@link ScriptParser#prototypeAssignmentExpressionExpression}.
	 * @param ctx the parse tree
	 */
	void enterPrototypeAssignmentExpressionExpression(@NotNull ScriptParser.PrototypeAssignmentExpressionExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScriptParser#prototypeAssignmentExpressionExpression}.
	 * @param ctx the parse tree
	 */
	void exitPrototypeAssignmentExpressionExpression(@NotNull ScriptParser.PrototypeAssignmentExpressionExpressionContext ctx);

	/**
	 * Enter a parse tree produced by {@link ScriptParser#id}.
	 * @param ctx the parse tree
	 */
	void enterId(@NotNull ScriptParser.IdContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScriptParser#id}.
	 * @param ctx the parse tree
	 */
	void exitId(@NotNull ScriptParser.IdContext ctx);

	/**
	 * Enter a parse tree produced by {@link ScriptParser#andExpression}.
	 * @param ctx the parse tree
	 */
	void enterAndExpression(@NotNull ScriptParser.AndExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScriptParser#andExpression}.
	 * @param ctx the parse tree
	 */
	void exitAndExpression(@NotNull ScriptParser.AndExpressionContext ctx);

	/**
	 * Enter a parse tree produced by {@link ScriptParser#createInstanceExpression}.
	 * @param ctx the parse tree
	 */
	void enterCreateInstanceExpression(@NotNull ScriptParser.CreateInstanceExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScriptParser#createInstanceExpression}.
	 * @param ctx the parse tree
	 */
	void exitCreateInstanceExpression(@NotNull ScriptParser.CreateInstanceExpressionContext ctx);

	/**
	 * Enter a parse tree produced by {@link ScriptParser#equalsExpression}.
	 * @param ctx the parse tree
	 */
	void enterEqualsExpression(@NotNull ScriptParser.EqualsExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScriptParser#equalsExpression}.
	 * @param ctx the parse tree
	 */
	void exitEqualsExpression(@NotNull ScriptParser.EqualsExpressionContext ctx);

	/**
	 * Enter a parse tree produced by {@link ScriptParser#thisGetterExpression}.
	 * @param ctx the parse tree
	 */
	void enterThisGetterExpression(@NotNull ScriptParser.ThisGetterExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScriptParser#thisGetterExpression}.
	 * @param ctx the parse tree
	 */
	void exitThisGetterExpression(@NotNull ScriptParser.ThisGetterExpressionContext ctx);

	/**
	 * Enter a parse tree produced by {@link ScriptParser#anonymousFunction}.
	 * @param ctx the parse tree
	 */
	void enterAnonymousFunction(@NotNull ScriptParser.AnonymousFunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScriptParser#anonymousFunction}.
	 * @param ctx the parse tree
	 */
	void exitAnonymousFunction(@NotNull ScriptParser.AnonymousFunctionContext ctx);

	/**
	 * Enter a parse tree produced by {@link ScriptParser#callParams}.
	 * @param ctx the parse tree
	 */
	void enterCallParams(@NotNull ScriptParser.CallParamsContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScriptParser#callParams}.
	 * @param ctx the parse tree
	 */
	void exitCallParams(@NotNull ScriptParser.CallParamsContext ctx);

	/**
	 * Enter a parse tree produced by {@link ScriptParser#plusExpression}.
	 * @param ctx the parse tree
	 */
	void enterPlusExpression(@NotNull ScriptParser.PlusExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScriptParser#plusExpression}.
	 * @param ctx the parse tree
	 */
	void exitPlusExpression(@NotNull ScriptParser.PlusExpressionContext ctx);

	/**
	 * Enter a parse tree produced by {@link ScriptParser#whileExpression}.
	 * @param ctx the parse tree
	 */
	void enterWhileExpression(@NotNull ScriptParser.WhileExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScriptParser#whileExpression}.
	 * @param ctx the parse tree
	 */
	void exitWhileExpression(@NotNull ScriptParser.WhileExpressionContext ctx);

	/**
	 * Enter a parse tree produced by {@link ScriptParser#varDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterVarDeclaration(@NotNull ScriptParser.VarDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScriptParser#varDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitVarDeclaration(@NotNull ScriptParser.VarDeclarationContext ctx);

	/**
	 * Enter a parse tree produced by {@link ScriptParser#minusExpression}.
	 * @param ctx the parse tree
	 */
	void enterMinusExpression(@NotNull ScriptParser.MinusExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScriptParser#minusExpression}.
	 * @param ctx the parse tree
	 */
	void exitMinusExpression(@NotNull ScriptParser.MinusExpressionContext ctx);

	/**
	 * Enter a parse tree produced by {@link ScriptParser#true}.
	 * @param ctx the parse tree
	 */
	void enterTrue(@NotNull ScriptParser.TrueContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScriptParser#true}.
	 * @param ctx the parse tree
	 */
	void exitTrue(@NotNull ScriptParser.TrueContext ctx);

	/**
	 * Enter a parse tree produced by {@link ScriptParser#functionBody}.
	 * @param ctx the parse tree
	 */
	void enterFunctionBody(@NotNull ScriptParser.FunctionBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScriptParser#functionBody}.
	 * @param ctx the parse tree
	 */
	void exitFunctionBody(@NotNull ScriptParser.FunctionBodyContext ctx);

	/**
	 * Enter a parse tree produced by {@link ScriptParser#callMethodOnInstance}.
	 * @param ctx the parse tree
	 */
	void enterCallMethodOnInstance(@NotNull ScriptParser.CallMethodOnInstanceContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScriptParser#callMethodOnInstance}.
	 * @param ctx the parse tree
	 */
	void exitCallMethodOnInstance(@NotNull ScriptParser.CallMethodOnInstanceContext ctx);

	/**
	 * Enter a parse tree produced by {@link ScriptParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void enterIfStatement(@NotNull ScriptParser.IfStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScriptParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void exitIfStatement(@NotNull ScriptParser.IfStatementContext ctx);

	/**
	 * Enter a parse tree produced by {@link ScriptParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(@NotNull ScriptParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScriptParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(@NotNull ScriptParser.AssignmentContext ctx);

	/**
	 * Enter a parse tree produced by {@link ScriptParser#whileStatement}.
	 * @param ctx the parse tree
	 */
	void enterWhileStatement(@NotNull ScriptParser.WhileStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScriptParser#whileStatement}.
	 * @param ctx the parse tree
	 */
	void exitWhileStatement(@NotNull ScriptParser.WhileStatementContext ctx);

	/**
	 * Enter a parse tree produced by {@link ScriptParser#unaryMinusExpression}.
	 * @param ctx the parse tree
	 */
	void enterUnaryMinusExpression(@NotNull ScriptParser.UnaryMinusExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScriptParser#unaryMinusExpression}.
	 * @param ctx the parse tree
	 */
	void exitUnaryMinusExpression(@NotNull ScriptParser.UnaryMinusExpressionContext ctx);

	/**
	 * Enter a parse tree produced by {@link ScriptParser#string}.
	 * @param ctx the parse tree
	 */
	void enterString(@NotNull ScriptParser.StringContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScriptParser#string}.
	 * @param ctx the parse tree
	 */
	void exitString(@NotNull ScriptParser.StringContext ctx);

	/**
	 * Enter a parse tree produced by {@link ScriptParser#thisCallMethod}.
	 * @param ctx the parse tree
	 */
	void enterThisCallMethod(@NotNull ScriptParser.ThisCallMethodContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScriptParser#thisCallMethod}.
	 * @param ctx the parse tree
	 */
	void exitThisCallMethod(@NotNull ScriptParser.ThisCallMethodContext ctx);

	/**
	 * Enter a parse tree produced by {@link ScriptParser#functionDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterFunctionDeclaration(@NotNull ScriptParser.FunctionDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScriptParser#functionDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitFunctionDeclaration(@NotNull ScriptParser.FunctionDeclarationContext ctx);

	/**
	 * Enter a parse tree produced by {@link ScriptParser#functionParameter}.
	 * @param ctx the parse tree
	 */
	void enterFunctionParameter(@NotNull ScriptParser.FunctionParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScriptParser#functionParameter}.
	 * @param ctx the parse tree
	 */
	void exitFunctionParameter(@NotNull ScriptParser.FunctionParameterContext ctx);
}