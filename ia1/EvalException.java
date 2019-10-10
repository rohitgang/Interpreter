//class which is called when there is an eval error
public class EvalException extends Exception {

    private int pos;
    private String msg;

    /**
     * constructor to initialize the variables
     * @param pos
     * @param msg
     */
    public EvalException(int pos, String msg) {
	this.pos=pos;
	this.msg=msg;
    }

    /**
     * returns the error as a string
     * @return string
     */
    public String toString() {
	return "eval error"
	    +", pos="+pos
	    +", "+msg;
    }

}
