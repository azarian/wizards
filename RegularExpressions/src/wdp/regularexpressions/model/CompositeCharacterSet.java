package wdp.regularexpressions.model;

/**
 * User: azaria
 * Date: 10/08/13
 * Time: 21:54
 */
public class CompositeCharacterSet extends RE{
    public enum OPERATOR{
        AND,
        OR

    }
    OPERATOR operator;
    CharacterSetContent content1,content2;


    public CompositeCharacterSet(OPERATOR operator, CharacterSetContent content1, CharacterSetContent content2) {
        this.operator = operator;
        this.content1 = content1;
        this.content2 = content2;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("[");
        str.append(content1);
        if (operator == OPERATOR.AND){
            str.append("&&");

        }
        str.append("[");
        str.append(content2);
        str.append("]]");
        if (quantifier != null){
            str.append(quantifier);
        }
        return str.toString();

    }
}
