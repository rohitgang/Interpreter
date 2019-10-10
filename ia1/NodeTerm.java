//class that handles the terms
public class NodeTerm extends Node {

    private NodeFact fact;
    private NodeMulop mulop;
    private NodeTerm term;

	/**
	 * constructor to initialize the variables
	 * @param fact
	 * @param mulop
	 * @param term
	 */
    public NodeTerm(NodeFact fact, NodeMulop mulop, NodeTerm term) {
	this.fact=fact;
	this.mulop=mulop;
	this.term=term;
    }

	/**
	 * method takes in a NodeTerm object
	 * it overwrites the instance variables if term is null,
	 * else it appends the term to term
	 * @param term
	 */
    public void append(NodeTerm term) {
	if (this.term==null) {
	    this.mulop=term.mulop;
	    this.term=term;
	    term.mulop=null;
	} else
	    this.term.append(term);
    }

	/**
	 * method takes in an environment object
	 * it calls fact.eval if null, else it performs multiplication operation
	 * @param env
	 * @return
	 * @throws EvalException
	 */
    public double eval(Environment env) throws EvalException {
	return term==null
	    ? fact.eval(env)
	    : mulop.op(term.eval(env),fact.eval(env));
    }

}
