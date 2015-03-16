// Generated from Script.g4 by ANTLR 4.1
package parser;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link ScriptParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface ScriptVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link ScriptParser#arrayAssignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayAssignment(@NotNull ScriptParser.ArrayAssignmentContext ctx);

	/**
	 * Visit a parse tree produced by {@link ScriptParser#anonymousFunctionExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnonymousFunctionExpression(@NotNull ScriptParser.AnonymousFunctionExpressionContext ctx);

	/**
	 * Visit a parse tree produced by {@link ScriptParser#functionCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionCall(@NotNull ScriptParser.FunctionCallContext ctx);

	/**
	 * Visit a parse tree produced by {@link ScriptParser#callParam}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCallParam(@NotNull ScriptParser.CallParamContext ctx);

	/**
	 * Visit a parse tree produced by {@link ScriptParser#thisExpressionExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitThisExpressionExpression(@NotNull ScriptParser.ThisExpressionExpressionContext ctx);

	/**
	 * Visit a parse tree produced by {@link ScriptParser#arrayAccessExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayAccessExpression(@NotNull ScriptParser.ArrayAccessExpressionContext ctx);

	/**
	 * Visit a parse tree produced by {@link ScriptParser#file}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFile(@NotNull ScriptParser.FileContext ctx);

	/**
	 * Visit a parse tree produced by {@link ScriptParser#getPropertyOnInstance}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGetPropertyOnInstance(@NotNull ScriptParser.GetPropertyOnInstanceContext ctx);

	/**
	 * Visit a parse tree produced by {@link ScriptParser#false}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFalse(@NotNull ScriptParser.FalseContext ctx);

	/**
	 * Visit a parse tree produced by {@link ScriptParser#assignmentExpressionExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignmentExpressionExpression(@NotNull ScriptParser.AssignmentExpressionExpressionContext ctx);

	/**
	 * Visit a parse tree produced by {@link ScriptParser#functionParameters}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionParameters(@NotNull ScriptParser.FunctionParametersContext ctx);

	/**
	 * Visit a parse tree produced by {@link ScriptParser#setPropertyOnInstance}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetPropertyOnInstance(@NotNull ScriptParser.SetPropertyOnInstanceContext ctx);

	/**
	 * Visit a parse tree produced by {@link ScriptParser#int}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInt(@NotNull ScriptParser.IntContext ctx);

	/**
	 * Visit a parse tree produced by {@link ScriptParser#ifExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfExpression(@NotNull ScriptParser.IfExpressionContext ctx);

	/**
	 * Visit a parse tree produced by {@link ScriptParser#mulExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMulExpression(@NotNull ScriptParser.MulExpressionContext ctx);

	/**
	 * Visit a parse tree produced by {@link ScriptParser#notExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotExpression(@NotNull ScriptParser.NotExpressionContext ctx);

	/**
	 * Visit a parse tree produced by {@link ScriptParser#double}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDouble(@NotNull ScriptParser.DoubleContext ctx);

	/**
	 * Visit a parse tree produced by {@link ScriptParser#createInstance}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateInstance(@NotNull ScriptParser.CreateInstanceContext ctx);

	/**
	 * Visit a parse tree produced by {@link ScriptParser#arrayAccess}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayAccess(@NotNull ScriptParser.ArrayAccessContext ctx);

	/**
	 * Visit a parse tree produced by {@link ScriptParser#divExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDivExpression(@NotNull ScriptParser.DivExpressionContext ctx);

	/**
	 * Visit a parse tree produced by {@link ScriptParser#createArray}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateArray(@NotNull ScriptParser.CreateArrayContext ctx);

	/**
	 * Visit a parse tree produced by {@link ScriptParser#functionCallExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionCallExpression(@NotNull ScriptParser.FunctionCallExpressionContext ctx);

	/**
	 * Visit a parse tree produced by {@link ScriptParser#functionName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionName(@NotNull ScriptParser.FunctionNameContext ctx);

	/**
	 * Visit a parse tree produced by {@link ScriptParser#modExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModExpression(@NotNull ScriptParser.ModExpressionContext ctx);

	/**
	 * Visit a parse tree produced by {@link ScriptParser#array}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArray(@NotNull ScriptParser.ArrayContext ctx);

	/**
	 * Visit a parse tree produced by {@link ScriptParser#arrayAssignmentExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayAssignmentExpression(@NotNull ScriptParser.ArrayAssignmentExpressionContext ctx);

	/**
	 * Visit a parse tree produced by {@link ScriptParser#varAssignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarAssignment(@NotNull ScriptParser.VarAssignmentContext ctx);

	/**
	 * Visit a parse tree produced by {@link ScriptParser#compareExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompareExpression(@NotNull ScriptParser.CompareExpressionContext ctx);

	/**
	 * Visit a parse tree produced by {@link ScriptParser#prototypeAssignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrototypeAssignment(@NotNull ScriptParser.PrototypeAssignmentContext ctx);

	/**
	 * Visit a parse tree produced by {@link ScriptParser#thisSetterExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitThisSetterExpression(@NotNull ScriptParser.ThisSetterExpressionContext ctx);

	/**
	 * Visit a parse tree produced by {@link ScriptParser#parenthesesExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenthesesExpression(@NotNull ScriptParser.ParenthesesExpressionContext ctx);

	/**
	 * Visit a parse tree produced by {@link ScriptParser#messageToInstanceExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMessageToInstanceExpression(@NotNull ScriptParser.MessageToInstanceExpressionContext ctx);

	/**
	 * Visit a parse tree produced by {@link ScriptParser#orExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrExpression(@NotNull ScriptParser.OrExpressionContext ctx);

	/**
	 * Visit a parse tree produced by {@link ScriptParser#prototypeAssignmentExpressionExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrototypeAssignmentExpressionExpression(@NotNull ScriptParser.PrototypeAssignmentExpressionExpressionContext ctx);

	/**
	 * Visit a parse tree produced by {@link ScriptParser#id}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitId(@NotNull ScriptParser.IdContext ctx);

	/**
	 * Visit a parse tree produced by {@link ScriptParser#andExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAndExpression(@NotNull ScriptParser.AndExpressionContext ctx);

	/**
	 * Visit a parse tree produced by {@link ScriptParser#createInstanceExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateInstanceExpression(@NotNull ScriptParser.CreateInstanceExpressionContext ctx);

	/**
	 * Visit a parse tree produced by {@link ScriptParser#equalsExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqualsExpression(@NotNull ScriptParser.EqualsExpressionContext ctx);

	/**
	 * Visit a parse tree produced by {@link ScriptParser#thisGetterExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitThisGetterExpression(@NotNull ScriptParser.ThisGetterExpressionContext ctx);

	/**
	 * Visit a parse tree produced by {@link ScriptParser#anonymousFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnonymousFunction(@NotNull ScriptParser.AnonymousFunctionContext ctx);

	/**
	 * Visit a parse tree produced by {@link ScriptParser#callParams}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCallParams(@NotNull ScriptParser.CallParamsContext ctx);

	/**
	 * Visit a parse tree produced by {@link ScriptParser#plusExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPlusExpression(@NotNull ScriptParser.PlusExpressionContext ctx);

	/**
	 * Visit a parse tree produced by {@link ScriptParser#whileExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileExpression(@NotNull ScriptParser.WhileExpressionContext ctx);

	/**
	 * Visit a parse tree produced by {@link ScriptParser#varDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDeclaration(@NotNull ScriptParser.VarDeclarationContext ctx);

	/**
	 * Visit a parse tree produced by {@link ScriptParser#minusExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMinusExpression(@NotNull ScriptParser.MinusExpressionContext ctx);

	/**
	 * Visit a parse tree produced by {@link ScriptParser#true}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTrue(@NotNull ScriptParser.TrueContext ctx);

	/**
	 * Visit a parse tree produced by {@link ScriptParser#functionBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionBody(@NotNull ScriptParser.FunctionBodyContext ctx);

	/**
	 * Visit a parse tree produced by {@link ScriptParser#callMethodOnInstance}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCallMethodOnInstance(@NotNull ScriptParser.CallMethodOnInstanceContext ctx);

	/**
	 * Visit a parse tree produced by {@link ScriptParser#ifStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStatement(@NotNull ScriptParser.IfStatementContext ctx);

	/**
	 * Visit a parse tree produced by {@link ScriptParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(@NotNull ScriptParser.AssignmentContext ctx);

	/**
	 * Visit a parse tree produced by {@link ScriptParser#whileStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStatement(@NotNull ScriptParser.WhileStatementContext ctx);

	/**
	 * Visit a parse tree produced by {@link ScriptParser#unaryMinusExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryMinusExpression(@NotNull ScriptParser.UnaryMinusExpressionContext ctx);

	/**
	 * Visit a parse tree produced by {@link ScriptParser#string}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitString(@NotNull ScriptParser.StringContext ctx);

	/**
	 * Visit a parse tree produced by {@link ScriptParser#thisCallMethod}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitThisCallMethod(@NotNull ScriptParser.ThisCallMethodContext ctx);

	/**
	 * Visit a parse tree produced by {@link ScriptParser#functionDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionDeclaration(@NotNull ScriptParser.FunctionDeclarationContext ctx);

	/**
	 * Visit a parse tree produced by {@link ScriptParser#functionParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionParameter(@NotNull ScriptParser.FunctionParameterContext ctx);
}