public class NodeFactUnary extends NodeFact {

    private NodeFact fact;

    public NodeFactUnary(NodeFact fact) {
        this.fact= fact;
    }

    public int eval(Environment env) throws EvalException {
        return -1*fact.eval(env);
    }

}
