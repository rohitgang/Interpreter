// This class is a recursive-descent parser,
// modeled after the programming language's grammar.
// It constructs and has-a Scanner for the program
// being parsed.

import java.util.*;

public class Parser {
	//Object for the scanner class
    private Scanner scanner;
	/**
	 * match takes in a string and calls the scanner.match() method
	 * It creates a Token object from the string when sending to scanner.match
	 * @param s: one character from the command line arguments
	 * @throws SyntaxException
	 */
    private void match(String s) throws SyntaxException {
	scanner.match(new Token(s));
    }

	/**
	 * curr calls the scanner.curr() method
	 * @return a token object
	 * @throws SyntaxException
	 */
    private Token curr() throws SyntaxException {
	return scanner.curr();
    }

	/**
	 * pos calls the scanner.pos() method
	 * @return pos of the current character
	 */
    private int pos() {
	return scanner.pos();
    }

	/**
	 * parseMulop checks if the current token is a "*"
	 * if it is , we return a NodeMulop object with the position of token and the "*" string
	 * parseMulop checks if the current token is a "/"
	 * if it is, we return a NodeMulop object with the position of the token and the "/" string
	 * if neither is found, return null
	 * @return NodeMulop object or null
	 * @throws SyntaxException
	 */
    private NodeMulop parseMulop() throws SyntaxException {
		if (curr().equals(new Token("*"))) {
			match("*");
			return new NodeMulop(pos(),"*");
		}
		if (curr().equals(new Token("/"))) {
			match("/");
			return new NodeMulop(pos(),"/");
		}
		return null;
    }

	/**
	 * parseAddop checks if the current token is "+"
	 * if it is, we return a NodeAddop object with the current position and the "+" string
	 * parseAddop also checks if the current token is "-",
	 * if it is, we return a NodeAddop object with the current position and the "-" string
	 * if neither is found, return null
	 * @return NodeAddop object or null
	 * @throws SyntaxException
	 */
	private NodeAddop parseAddop() throws SyntaxException {
		if (curr().equals(new Token("+"))) {
			match("+");
			return new NodeAddop(pos(),"+");
		}
		if (curr().equals(new Token("-"))) {
			match("-");
			return new NodeAddop(pos(),"-");
		}
		return null;
    }

	/**
	 *  parseFact checks if the current token is "-"
	 *  if it is, we return a NodeFactUnary object with the a NodeFact Object
	 *  parseFact checks if the current token is "("
	 *  if it is, we return a NodeFactExpr object with a NodeExpr object
	 *  parseFact checks if the current token is "id"
	 *  if it is, we return a NodeFactId object with the position of the current token and the token's lexemme
	 *  if none of the is above is returned, we return a NodeFactNum object with the lexemme of token num
	 * @return NodeFactUnary object || NodeFactExpr object || NodeFactId object || NodeFactNum object
	 * @throws SyntaxException
	 */
	private NodeFact parseFact() throws SyntaxException {
		if (curr().equals(new Token("-"))){
			match("-");
			NodeFact fact= parseFact();
			return new NodeFactUnary(fact);
		}
    	if (curr().equals(new Token("("))) {
			match("(");
			NodeExpr expr=parseExpr();
			match(")");
			return new NodeFactExpr(expr);
		}
		if (curr().equals(new Token("id"))) {
			Token id=curr();
			match("id");
			return new NodeFactId(pos(),id.lex());
		}
		Token num=curr();
		match("num");
		return new NodeFactNum(num.lex());
    }

	/**
	 * parseTerm calls the parseFact method and it stores the NodeFact object returned in a variable, fact
	 * parseTerm calls the parseMulop method and it stores the NodeMulop object returned in a variable, mulop
	 * if mulop is null, it returns a NodeTerm object with fact as the parameter and null, null
	 * if mulop is not null, we call the parseTerm method and stores the NodeFact object returned in a variable, term
	 * we use the append function of the NodeTerm class and append a NodeTerm object with fact as the parameter and null,null
	 * and we return term
	 * @return NodeTerm object or term
	 * @throws SyntaxException
	 */
	private NodeTerm parseTerm() throws SyntaxException {
		NodeFact fact=parseFact();
		NodeMulop mulop=parseMulop();
		if (mulop==null)
			return new NodeTerm(fact,null,null);
		NodeTerm term=parseTerm();
		term.append(new NodeTerm(fact,mulop,null));
		return term;
    }

	/**
	 * parseExpr calls the parseTerm method and it stores the NodeTerm object returned in a variable, term
	 * parseExpr calls the parseAddop method and it stores the NodeAddop object returned in a variable, addop
	 * if addop is null, it returns a NodeExpr object with term as a parameter and null, null
	 * if addop is not null, it calls the parseExpr method and stores the NodeExpr object returned in a variable, expr
	 * we use the append function of the NodeExpr class and append a NodeExpr object with term as the parameter and null, null
	 * and it returns expr
	 * @return NodeExpr object or expr
	 * @throws SyntaxException
	 */
    private NodeExpr parseExpr() throws SyntaxException {
		NodeTerm term=parseTerm();
		NodeAddop addop=parseAddop();
		if (addop==null)
			return new NodeExpr(term,null,null);
		NodeExpr expr=parseExpr();
		expr.append(new NodeExpr(term,addop,null));
		return expr;
    }

	/**
	 * parseAssn creates a token, id by calling the curr() function, it calls the match
	 * function on "id" and "=". It stores the NodeExpr object returned by parseExpr in expr.
	 * It creates a new NodeAssn object and stores it in assn and returns assn
	 * @return assn
	 * @throws SyntaxException
	 */
    private NodeAssn parseAssn() throws SyntaxException {
		Token id=curr();
		match("id");
		match("=");
		NodeExpr expr=parseExpr();
		NodeAssn assn=new NodeAssn(id.lex(),expr);
		return assn;
    }

	/**
	 * parseStmt creates a NodeAssn object by calling the parseAssn object
	 * It calls the match function on ";". It creates a NodeStmt object and stores it
	 * in stmt and returns stmt
	 * @return stmt
	 * @throws SyntaxException
	 */
	private NodeStmt parseStmt() throws SyntaxException {
		NodeAssn assn=parseAssn();
		match(";");
		NodeStmt stmt=new NodeStmt(assn);
		return stmt;
    }

	/**
	 * Creates a scanner object by passing in the program string. Gets the next
	 * element in program and stores the NodeStmt object returned by parseStmt in
	 * stmt. It calls the match function and passes in "EOF" and returns stmt
	 * @param program
	 * @return stmt
	 * @throws SyntaxException
	 */
	public Node parse(String program) throws SyntaxException {
		scanner=new Scanner(program);
		scanner.next();
		NodeStmt stmt=parseStmt();
		match("EOF");
		return stmt;
    }

}
