//class to handle the unary operation
public class NodeFactUnary extends NodeFact {

    private NodeFact fact;

    /**
     * constructor to initialize the variables
     * @param fact
     */
    public NodeFactUnary(NodeFact fact) {
        this.fact= fact;
    }

    /**
     * takes in a environemnt object
     * returns - 1 times the return of the fact
     * @param env
     * @return double value
     * @throws EvalException
     */
    public double eval(Environment env) throws EvalException {
        return -1*fact.eval(env);
    }

}
