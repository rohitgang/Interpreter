//class to evaluate a expression
public class NodeFactExpr extends NodeFact {

    private NodeExpr expr;

    /**
     * constructor to initialize the variables
     * @param expr
     */
    public NodeFactExpr(NodeExpr expr) {
	this.expr=expr;
    }

    /**
     * method takes in an environment object
     * it calls the eval method of the NodeExpr class
     * @param env
     * @return double value
     * @throws EvalException
     */
    public double eval(Environment env) throws EvalException {
	return expr.eval(env);
    }

}
