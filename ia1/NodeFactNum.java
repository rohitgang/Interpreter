//class to handle the numbers
public class NodeFactNum extends NodeFact {

    private String num;

    /**
     * constructor to initialize the variables
     * @param num
     */
    public NodeFactNum(String num) {
	this.num=num;
    }

    /**
     * takes in an environment object
     * returns the num string as a double
     * @param env
     * @return num
     * @throws EvalException
     */
    public double eval(Environment env) throws EvalException {
	return Double.parseDouble(num);
    }

}
