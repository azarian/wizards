package wdp.regularexpressions.model;

/**
 * User: nazaria
 * Date: 7/24/13
 * Time: 12:34 PM
 */
public class CharacterSet extends RE{
    CharacterSetContent content;

    public CharacterSet(CharacterSetContent content) {
        this.content = content;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("[");
        str.append(content);
        str.append("]");
        if (quantifier != null){
            str.append(quantifier);
        }
        return str.toString();
    }
}
