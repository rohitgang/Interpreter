//class that handles the statements
public class NodeStmt extends Node {

    private NodeAssn assn;

    /**
     * constructor to initialize the variables
     * @param assn
     */
    public NodeStmt(NodeAssn assn) {
	this.assn=assn;
    }

    /**
     * method takes in a environemnt object
     * it calls the eval method of the NodeAssn class
     * @param env
     * @return double values
     * @throws EvalException
     */
    public double eval(Environment env) throws EvalException {
	return assn.eval(env);
    }

}
