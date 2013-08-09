package wdp.regularexpressions.model;

/**
 * Created with IntelliJ IDEA.
 * User: nazaria
 * Date: 7/24/13
 * Time: 12:35 PM
 * To change this template use File | Settings | File Templates.
 */
public class RangeCharacterSet extends CharacterSet {
    private String from,until;

    public RangeCharacterSet(String from, String until, boolean negation) {
        if (negation){
            this.operator = OPERATOR.NOT;
        }
        this.from = from;
        this.until = until;
    }

    @Override
    public String toString() {
        StringBuffer str = new StringBuffer();
        str.append("[");
        if (operator == OPERATOR.NOT){
            str.append("^");
        }
        str.append(from + "-" + until);
        if (operator == OPERATOR.AND){
            str.append("&&");
            str.append(otherSet.toString());
        }
        if (operator == OPERATOR.OR){
            str.append(otherSet.toString());
        }
        str.append("]");
        if (quantifier != null){
            str.append(quantifier.toString());
        }
        return str.toString();
    }
}
