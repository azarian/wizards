package wdp.regularexpressions.model;

/**
 * Created with IntelliJ IDEA.
 * User: nazaria
 * Date: 7/30/13
 * Time: 10:09 AM
 */
public class SimpleCharacterSet extends CharacterSet {
    private String characters;

    public SimpleCharacterSet(String characters) {
        this.characters = characters;
    }
    public SimpleCharacterSet(String characters,boolean negation) {
        this.characters = characters;
        if (negation){
            this.operator = OPERATOR.NOT;
        }
    }


    @Override
    public String toString() {
        StringBuffer str = new StringBuffer();
        str.append("[");
        if (operator == OPERATOR.NOT){
            str.append("^");
        }
        str.append(characters);
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
