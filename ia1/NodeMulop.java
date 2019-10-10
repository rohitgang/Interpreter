//class to handle multiplication/division operations
public class NodeMulop extends Node {

    private String mulop;

	/**
	 * constructor to initialize the variables
	 * @param pos
	 * @param mulop
	 */
    public NodeMulop(int pos, String mulop) {
	this.pos=pos;
	this.mulop=mulop;
    }

	/**
	 * method to perform the multiplication or division operation
	 * based on the mulop String. If mulop is not a '*' or '/',
	 * method throws an EvalException
	 * @param o1
	 * @param o2
	 * @return multiplication or division
	 * @throws EvalException
	 */
    public double op(double o1, double o2) throws EvalException {
	if (mulop.equals("*"))
	    return o1*o2;
	if (mulop.equals("/"))
	    return o1/o2;
	throw new EvalException(pos,"bogus mulop: "+mulop);
    }

}
