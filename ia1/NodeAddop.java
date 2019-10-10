//class to perform the add operation
public class NodeAddop extends Node {

    private String addop;

	/**
	 * constructor to initialize the variables
	 * @param pos
	 * @param addop
	 */
    public NodeAddop(int pos, String addop) {
	this.pos=pos;
	this.addop=addop;
    }

	/**
	 * method to perform the addition or subtraction operation
	 * based on the addop String. If addop is not a '+' or '-',
	 * method throws an EvalException
	 * @param o1
	 * @param o2
	 * @return addition or subtraction
	 * @throws EvalException
	 */
    public double op(double o1, double o2) throws EvalException {
	if (addop.equals("+"))
	    return o1+o2;
	if (addop.equals("-"))
	    return o1-o2;
	throw new EvalException(pos,"bogus addop: "+addop);
    }

}
