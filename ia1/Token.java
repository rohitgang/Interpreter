// This class models a token, which has two parts:
// 1) the token itself (e.g., "id" or "+")
// 2) the token's lexeme (e.g., "foo")

public class Token {

    private String token;
    private String lexeme;

    /**
     * constructor to initialize variables when token and lexemme are passed ih
     * @param token
     * @param lexeme
     */
    public Token(String token, String lexeme) {
	this.token=token;
	this.lexeme=lexeme;
    }

    /**
     * constructor to initialize variables when token is passed in
     * @param token
     */
    public Token(String token) {
	this(token,token);
    }

    /**
     * returns token
     * @return
     */
    public String tok() { return token; }

    /**
     * returns lexemme
     * @return
     */
    public String lex() { return lexeme; }

    /**
     * checks if the token passed in is equal to the token variable
     * @param t
     * @return true or false
     */
    public boolean equals(Token t) {
	return token.equals(t.token);
    }

    /**
     * returns error msg as string
     * @return string
     */
    public String toString() {
	return "<"+tok()+","+lex()+">";
    }

}
