package wdp.regularexpressions.model;

/**
 * Created with IntelliJ IDEA.
 * User: nazaria
 * Date: 7/24/13
 * Time: 12:26 PM
 * To change this template use File | Settings | File Templates.
 */
public class Literal extends RE{
    private String literal;

    public Literal(String literal) {
        this.literal = literal;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        if (literal.length() > 1 && quantifier != null ) sb.append("(");
        sb.append(literal);
        if (literal.length() > 1 && quantifier != null ) sb.append(")");
        if (quantifier != null){
            sb.append(quantifier.toString());
        }
        return sb.toString();
    }
}
