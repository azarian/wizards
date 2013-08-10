package wdp.regularexpressions.model;

/**
 * Created with IntelliJ IDEA.
 * Date: 10/08/13
 * Time: 23:56
 */
public class SimpleContent extends CharacterSetContent {
    private String characters;
    private boolean negation;

    public SimpleContent(String characters, boolean negation) {
        this.characters = characters;
        this.negation = negation;
    }
    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        if (negation){
            str.append("^");
        }
        str.append(characters);
        return str.toString();
    }
}
