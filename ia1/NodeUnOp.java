public class NodeUnOp extends Node {

    private String unOp;

    public NodeUnOp(int pos, String unOp) {
        this.pos=pos;
        this.unOp=unOp;
    }

    public int op(int o1) throws EvalException {
        if (unOp.equals("--"))
            return o1 - 1;

        throw new EvalException(pos,"bogus unop: "+unOp);
    }

}
