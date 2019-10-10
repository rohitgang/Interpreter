// class to evaluate expressions
public class NodeExpr extends Node {

    private NodeTerm term;
    private NodeAddop addop;
    private NodeExpr expr;

	/**
	 * constructor initializes the variables
	 * @param term
	 * @param addop
	 * @param expr
	 */
    public NodeExpr(NodeTerm term, NodeAddop addop, NodeExpr expr) {
	this.term=term;
	this.addop=addop;
	this.expr=expr;
    }

	/**
	 * overwrites the addop and expr variables with the variable passed in
	 * if this.expr is null, else it appends the variable passed in to expr
	 * @param expr
	 */
    public void append(NodeExpr expr) {
	if (this.expr==null) {
	    this.addop=expr.addop;
	    this.expr=expr;
	    expr.addop=null;
	} else
	    this.expr.append(expr);
    }

	/**
	 * method takes in a environment object.
	 * It checks if expr is null, if it is then it calls the eval method of Node
	 * Term class and if it false it does addition
	 * @param env
	 * @return addition or subtraction
	 * @throws EvalException
	 */
    public double eval(Environment env) throws EvalException {
	return expr==null
	    ? term.eval(env)
	    : addop.op(expr.eval(env),term.eval(env));
    }

}
