//class to evaluate a id
public class NodeFactId extends NodeFact {

    private String id;
    /**
     * constructor to initialize variables
     */
    constructor to initialize variables
    public NodeFactId(int pos, String id) {
	this.pos=pos;
	this.id=id;
    }

    /**
     * method takes in an environment object
     * its gets the value for the provided key
     * @param env
     * @return double value
     * @throws EvalException
     */
    public double eval(Environment env) throws EvalException {
	return env.get(pos,id);
    }

}
