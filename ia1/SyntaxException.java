//calss that handles syntax exception
public class SyntaxException extends Exception {

    private int pos;
    private Token expected;
    private Token found;

    /**
     * constructor to initialize the variables
     * @param pos
     * @param expected
     * @param found
     */
    public SyntaxException(int pos, Token expected, Token found) {
	this.pos=pos;
	this.expected=expected;
	this.found=found;
    }

    /**
     * method to convert the error msg to string
     * @return string
     */
    public String toString() {
	return "syntax error"
	    +", pos="+pos
	    +", expected="+expected
	    +", found="+found;
    }

}
