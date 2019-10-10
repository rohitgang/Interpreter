//class to perform the assignment operation
public class NodeAssn extends Node {

    private String id;
    private NodeExpr expr;

    /**
     * constructor to initialize variables
     * @param id
     * @param expr
     */
    public NodeAssn(String id, NodeExpr expr) {
	this.id=id;
	this.expr=expr;
    }

    /**
     * puts the id and the expr in the hashmap of environment class
     * @param env
     * @return value
     * @throws EvalException
     */
    public double eval(Environment env) throws EvalException {
	return env.put(id,expr.eval(env));
    }

}
