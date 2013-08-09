package wdp.regularexpressions.model;

/**
 * Created with IntelliJ IDEA.
 * User: nazaria
 * Date: 7/24/13
 * Time: 12:34 PM
 * To change this template use File | Settings | File Templates.
 */
public abstract class CharacterSet extends RE{

    public enum OPERATOR{
        NONE,
        NOT,
        AND,
        OR

    }
    OPERATOR operator = OPERATOR.NONE;
    CharacterSet otherSet;//relevant only with AND and OR operators.


    public OPERATOR getOperator() {
        return operator;
    }

    public void setOperator(OPERATOR operator) {
        this.operator = operator;
    }
}
